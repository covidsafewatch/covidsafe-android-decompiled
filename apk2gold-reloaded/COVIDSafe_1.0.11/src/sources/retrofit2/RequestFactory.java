package retrofit2;

import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import retrofit2.http.DELETE;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.OPTIONS;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;

final class RequestFactory {
    private final HttpUrl baseUrl;
    @Nullable
    private final MediaType contentType;
    private final boolean hasBody;
    @Nullable
    private final Headers headers;
    final String httpMethod;
    private final boolean isFormEncoded;
    final boolean isKotlinSuspendFunction;
    private final boolean isMultipart;
    private final Method method;
    private final ParameterHandler<?>[] parameterHandlers;
    @Nullable
    private final String relativeUrl;

    static final class Builder {
        private static final String PARAM = "[a-zA-Z][a-zA-Z0-9_-]*";
        private static final Pattern PARAM_NAME_REGEX = Pattern.compile(PARAM);
        private static final Pattern PARAM_URL_REGEX = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
        @Nullable
        MediaType contentType;
        boolean gotBody;
        boolean gotField;
        boolean gotPart;
        boolean gotPath;
        boolean gotQuery;
        boolean gotQueryMap;
        boolean gotQueryName;
        boolean gotUrl;
        boolean hasBody;
        @Nullable
        Headers headers;
        @Nullable
        String httpMethod;
        boolean isFormEncoded;
        boolean isKotlinSuspendFunction;
        boolean isMultipart;
        final Method method;
        final Annotation[] methodAnnotations;
        final Annotation[][] parameterAnnotationsArray;
        @Nullable
        ParameterHandler<?>[] parameterHandlers;
        final Type[] parameterTypes;
        @Nullable
        String relativeUrl;
        @Nullable
        Set<String> relativeUrlParamNames;
        final Retrofit retrofit;

        Builder(Retrofit retrofit3, Method method2) {
            this.retrofit = retrofit3;
            this.method = method2;
            this.methodAnnotations = method2.getAnnotations();
            this.parameterTypes = method2.getGenericParameterTypes();
            this.parameterAnnotationsArray = method2.getParameterAnnotations();
        }

        /* access modifiers changed from: 0000 */
        public RequestFactory build() {
            for (Annotation parseMethodAnnotation : this.methodAnnotations) {
                parseMethodAnnotation(parseMethodAnnotation);
            }
            if (this.httpMethod != null) {
                if (!this.hasBody) {
                    if (this.isMultipart) {
                        throw Utils.methodError(this.method, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    } else if (this.isFormEncoded) {
                        throw Utils.methodError(this.method, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                    }
                }
                int length = this.parameterAnnotationsArray.length;
                this.parameterHandlers = new ParameterHandler[length];
                int i = length - 1;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 >= length) {
                        break;
                    }
                    ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
                    Type type = this.parameterTypes[i2];
                    Annotation[] annotationArr = this.parameterAnnotationsArray[i2];
                    if (i2 != i) {
                        z = false;
                    }
                    parameterHandlerArr[i2] = parseParameter(i2, type, annotationArr, z);
                    i2++;
                }
                if (this.relativeUrl == null && !this.gotUrl) {
                    throw Utils.methodError(this.method, "Missing either @%s URL or @Url parameter.", this.httpMethod);
                } else if (!this.isFormEncoded && !this.isMultipart && !this.hasBody && this.gotBody) {
                    throw Utils.methodError(this.method, "Non-body HTTP method cannot contain @Body.", new Object[0]);
                } else if (this.isFormEncoded && !this.gotField) {
                    throw Utils.methodError(this.method, "Form-encoded method must contain at least one @Field.", new Object[0]);
                } else if (!this.isMultipart || this.gotPart) {
                    return new RequestFactory(this);
                } else {
                    throw Utils.methodError(this.method, "Multipart method must contain at least one @Part.", new Object[0]);
                }
            } else {
                throw Utils.methodError(this.method, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
        }

        private void parseMethodAnnotation(Annotation annotation) {
            if (annotation instanceof DELETE) {
                parseHttpMethodAndPath("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                parseHttpMethodAndPath("GET", ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                parseHttpMethodAndPath("HEAD", ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                parseHttpMethodAndPath("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                parseHttpMethodAndPath("POST", ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                parseHttpMethodAndPath("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                parseHttpMethodAndPath("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                parseHttpMethodAndPath(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof retrofit2.http.Headers) {
                String[] value = ((retrofit2.http.Headers) annotation).value();
                if (value.length != 0) {
                    this.headers = parseHeaders(value);
                } else {
                    throw Utils.methodError(this.method, "@Headers annotation is empty.", new Object[0]);
                }
            } else {
                String str = "Only one encoding annotation is allowed.";
                if (annotation instanceof Multipart) {
                    if (!this.isFormEncoded) {
                        this.isMultipart = true;
                        return;
                    }
                    throw Utils.methodError(this.method, str, new Object[0]);
                } else if (!(annotation instanceof FormUrlEncoded)) {
                } else {
                    if (!this.isMultipart) {
                        this.isFormEncoded = true;
                        return;
                    }
                    throw Utils.methodError(this.method, str, new Object[0]);
                }
            }
        }

        private void parseHttpMethodAndPath(String str, String str2, boolean z) {
            String str3 = this.httpMethod;
            if (str3 == null) {
                this.httpMethod = str;
                this.hasBody = z;
                if (!str2.isEmpty()) {
                    int indexOf = str2.indexOf(63);
                    if (indexOf != -1 && indexOf < str2.length() - 1) {
                        String substring = str2.substring(indexOf + 1);
                        if (PARAM_URL_REGEX.matcher(substring).find()) {
                            throw Utils.methodError(this.method, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                        }
                    }
                    this.relativeUrl = str2;
                    this.relativeUrlParamNames = parsePathParameters(str2);
                    return;
                }
                return;
            }
            throw Utils.methodError(this.method, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
        }

        private Headers parseHeaders(String[] strArr) {
            okhttp3.Headers.Builder builder = new okhttp3.Headers.Builder();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw Utils.methodError(this.method, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if (HttpHeaders.CONTENT_TYPE.equalsIgnoreCase(substring)) {
                    try {
                        this.contentType = MediaType.get(trim);
                    } catch (IllegalArgumentException e) {
                        throw Utils.methodError(this.method, e, "Malformed content type: %s", trim);
                    }
                } else {
                    builder.add(substring, trim);
                }
            }
            return builder.build();
        }

        @Nullable
        private ParameterHandler<?> parseParameter(int i, Type type, @Nullable Annotation[] annotationArr, boolean z) {
            ParameterHandler<?> parameterHandler;
            if (annotationArr != null) {
                parameterHandler = null;
                for (Annotation parseParameterAnnotation : annotationArr) {
                    ParameterHandler<?> parseParameterAnnotation2 = parseParameterAnnotation(i, type, annotationArr, parseParameterAnnotation);
                    if (parseParameterAnnotation2 != null) {
                        if (parameterHandler == null) {
                            parameterHandler = parseParameterAnnotation2;
                        } else {
                            throw Utils.parameterError(this.method, i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                    }
                }
            } else {
                parameterHandler = null;
            }
            if (parameterHandler != null) {
                return parameterHandler;
            }
            if (z) {
                try {
                    if (Utils.getRawType(type) == Continuation.class) {
                        this.isKotlinSuspendFunction = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw Utils.parameterError(this.method, i, "No Retrofit annotation found.", new Object[0]);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
            if ("android.net.Uri".equals(((java.lang.Class) r11).getName()) != false) goto L_0x004f;
         */
        @javax.annotation.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private retrofit2.ParameterHandler<?> parseParameterAnnotation(int r10, java.lang.reflect.Type r11, java.lang.annotation.Annotation[] r12, java.lang.annotation.Annotation r13) {
            /*
                r9 = this;
                boolean r0 = r13 instanceof retrofit2.http.Url
                java.lang.String r1 = "@Path parameters may not be used with @Url."
                r2 = 1
                r3 = 0
                if (r0 == 0) goto L_0x009b
                r9.validateResolvableType(r10, r11)
                boolean r12 = r9.gotUrl
                if (r12 != 0) goto L_0x0090
                boolean r12 = r9.gotPath
                if (r12 != 0) goto L_0x0087
                boolean r12 = r9.gotQuery
                if (r12 != 0) goto L_0x007c
                boolean r12 = r9.gotQueryName
                if (r12 != 0) goto L_0x0071
                boolean r12 = r9.gotQueryMap
                if (r12 != 0) goto L_0x0066
                java.lang.String r12 = r9.relativeUrl
                if (r12 != 0) goto L_0x0057
                r9.gotUrl = r2
                java.lang.Class<okhttp3.HttpUrl> r12 = okhttp3.HttpUrl.class
                if (r11 == r12) goto L_0x004f
                java.lang.Class<java.lang.String> r12 = java.lang.String.class
                if (r11 == r12) goto L_0x004f
                java.lang.Class<java.net.URI> r12 = java.net.URI.class
                if (r11 == r12) goto L_0x004f
                boolean r12 = r11 instanceof java.lang.Class
                if (r12 == 0) goto L_0x0044
                java.lang.Class r11 = (java.lang.Class) r11
                java.lang.String r11 = r11.getName()
                java.lang.String r12 = "android.net.Uri"
                boolean r11 = r12.equals(r11)
                if (r11 == 0) goto L_0x0044
                goto L_0x004f
            L_0x0044:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x004f:
                retrofit2.ParameterHandler$RelativeUrl r11 = new retrofit2.ParameterHandler$RelativeUrl
                java.lang.reflect.Method r12 = r9.method
                r11.<init>(r12, r10)
                return r11
            L_0x0057:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r2]
                java.lang.String r13 = r9.httpMethod
                r12[r3] = r13
                java.lang.String r13 = "@Url cannot be used with @%s URL"
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0066:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "A @Url parameter must not come after a @QueryMap."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0071:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "A @Url parameter must not come after a @QueryName."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x007c:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "A @Url parameter must not come after a @Query."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0087:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r1, r12)
                throw r10
            L_0x0090:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "Multiple @Url method annotations found."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x009b:
                boolean r0 = r13 instanceof retrofit2.http.Path
                if (r0 == 0) goto L_0x010e
                r9.validateResolvableType(r10, r11)
                boolean r0 = r9.gotQuery
                if (r0 != 0) goto L_0x0103
                boolean r0 = r9.gotQueryName
                if (r0 != 0) goto L_0x00f8
                boolean r0 = r9.gotQueryMap
                if (r0 != 0) goto L_0x00ed
                boolean r0 = r9.gotUrl
                if (r0 != 0) goto L_0x00e4
                java.lang.String r0 = r9.relativeUrl
                if (r0 == 0) goto L_0x00d5
                r9.gotPath = r2
                retrofit2.http.Path r13 = (retrofit2.http.Path) r13
                java.lang.String r3 = r13.value()
                r9.validatePathName(r10, r3)
                retrofit2.Retrofit r0 = r9.retrofit
                retrofit2.Converter r4 = r0.stringConverter(r11, r12)
                retrofit2.ParameterHandler$Path r11 = new retrofit2.ParameterHandler$Path
                java.lang.reflect.Method r1 = r9.method
                boolean r5 = r13.encoded()
                r0 = r11
                r2 = r10
                r0.<init>(r1, r2, r3, r4, r5)
                return r11
            L_0x00d5:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r2]
                java.lang.String r13 = r9.httpMethod
                r12[r3] = r13
                java.lang.String r13 = "@Path can only be used with relative url on @%s"
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x00e4:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r1, r12)
                throw r10
            L_0x00ed:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "A @Path parameter must not come after a @QueryMap."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x00f8:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "A @Path parameter must not come after a @QueryName."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0103:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "A @Path parameter must not come after a @Query."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x010e:
                boolean r0 = r13 instanceof retrofit2.http.Query
                java.lang.String r1 = "<String>)"
                java.lang.String r4 = " must include generic type (e.g., "
                if (r0 == 0) goto L_0x019b
                r9.validateResolvableType(r10, r11)
                retrofit2.http.Query r13 = (retrofit2.http.Query) r13
                java.lang.String r0 = r13.value()
                boolean r13 = r13.encoded()
                java.lang.Class r5 = retrofit2.Utils.getRawType(r11)
                r9.gotQuery = r2
                java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
                boolean r2 = r2.isAssignableFrom(r5)
                if (r2 == 0) goto L_0x0171
                boolean r2 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r2 == 0) goto L_0x014b
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r10 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$Query r11 = new retrofit2.ParameterHandler$Query
                r11.<init>(r0, r10, r13)
                retrofit2.ParameterHandler r10 = r11.iterable()
                return r10
            L_0x014b:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r5.getSimpleName()
                r12.append(r13)
                r12.append(r4)
                java.lang.String r13 = r5.getSimpleName()
                r12.append(r13)
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x0171:
                boolean r10 = r5.isArray()
                if (r10 == 0) goto L_0x018f
                java.lang.Class r10 = r5.getComponentType()
                java.lang.Class r10 = boxIfPrimitive(r10)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$Query r11 = new retrofit2.ParameterHandler$Query
                r11.<init>(r0, r10, r13)
                retrofit2.ParameterHandler r10 = r11.array()
                return r10
            L_0x018f:
                retrofit2.Retrofit r10 = r9.retrofit
                retrofit2.Converter r10 = r10.stringConverter(r11, r12)
                retrofit2.ParameterHandler$Query r11 = new retrofit2.ParameterHandler$Query
                r11.<init>(r0, r10, r13)
                return r11
            L_0x019b:
                boolean r0 = r13 instanceof retrofit2.http.QueryName
                if (r0 == 0) goto L_0x0220
                r9.validateResolvableType(r10, r11)
                retrofit2.http.QueryName r13 = (retrofit2.http.QueryName) r13
                boolean r13 = r13.encoded()
                java.lang.Class r0 = retrofit2.Utils.getRawType(r11)
                r9.gotQueryName = r2
                java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
                boolean r2 = r2.isAssignableFrom(r0)
                if (r2 == 0) goto L_0x01f6
                boolean r2 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r2 == 0) goto L_0x01d0
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r10 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$QueryName r11 = new retrofit2.ParameterHandler$QueryName
                r11.<init>(r10, r13)
                retrofit2.ParameterHandler r10 = r11.iterable()
                return r10
            L_0x01d0:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r4)
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x01f6:
                boolean r10 = r0.isArray()
                if (r10 == 0) goto L_0x0214
                java.lang.Class r10 = r0.getComponentType()
                java.lang.Class r10 = boxIfPrimitive(r10)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$QueryName r11 = new retrofit2.ParameterHandler$QueryName
                r11.<init>(r10, r13)
                retrofit2.ParameterHandler r10 = r11.array()
                return r10
            L_0x0214:
                retrofit2.Retrofit r10 = r9.retrofit
                retrofit2.Converter r10 = r10.stringConverter(r11, r12)
                retrofit2.ParameterHandler$QueryName r11 = new retrofit2.ParameterHandler$QueryName
                r11.<init>(r10, r13)
                return r11
            L_0x0220:
                boolean r0 = r13 instanceof retrofit2.http.QueryMap
                java.lang.String r5 = "Map must include generic types (e.g., Map<String, String>)"
                if (r0 == 0) goto L_0x0291
                r9.validateResolvableType(r10, r11)
                java.lang.Class r0 = retrofit2.Utils.getRawType(r11)
                r9.gotQueryMap = r2
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0286
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r11 = retrofit2.Utils.getSupertype(r11, r0, r1)
                boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r0 == 0) goto L_0x027d
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r0 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                java.lang.Class<java.lang.String> r1 = java.lang.String.class
                if (r1 != r0) goto L_0x0263
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r2, r11)
                retrofit2.Retrofit r0 = r9.retrofit
                retrofit2.Converter r11 = r0.stringConverter(r11, r12)
                retrofit2.ParameterHandler$QueryMap r12 = new retrofit2.ParameterHandler$QueryMap
                java.lang.reflect.Method r0 = r9.method
                retrofit2.http.QueryMap r13 = (retrofit2.http.QueryMap) r13
                boolean r13 = r13.encoded()
                r12.<init>(r0, r10, r11, r13)
                return r12
            L_0x0263:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "@QueryMap keys must be of type String: "
                r12.append(r13)
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x027d:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r5, r12)
                throw r10
            L_0x0286:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@QueryMap parameter type must be Map."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0291:
                boolean r0 = r13 instanceof retrofit2.http.Header
                if (r0 == 0) goto L_0x0314
                r9.validateResolvableType(r10, r11)
                retrofit2.http.Header r13 = (retrofit2.http.Header) r13
                java.lang.String r13 = r13.value()
                java.lang.Class r0 = retrofit2.Utils.getRawType(r11)
                java.lang.Class<java.lang.Iterable> r2 = java.lang.Iterable.class
                boolean r2 = r2.isAssignableFrom(r0)
                if (r2 == 0) goto L_0x02ea
                boolean r2 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r2 == 0) goto L_0x02c4
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r10 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$Header r11 = new retrofit2.ParameterHandler$Header
                r11.<init>(r13, r10)
                retrofit2.ParameterHandler r10 = r11.iterable()
                return r10
            L_0x02c4:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r4)
                java.lang.String r13 = r0.getSimpleName()
                r12.append(r13)
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x02ea:
                boolean r10 = r0.isArray()
                if (r10 == 0) goto L_0x0308
                java.lang.Class r10 = r0.getComponentType()
                java.lang.Class r10 = boxIfPrimitive(r10)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$Header r11 = new retrofit2.ParameterHandler$Header
                r11.<init>(r13, r10)
                retrofit2.ParameterHandler r10 = r11.array()
                return r10
            L_0x0308:
                retrofit2.Retrofit r10 = r9.retrofit
                retrofit2.Converter r10 = r10.stringConverter(r11, r12)
                retrofit2.ParameterHandler$Header r11 = new retrofit2.ParameterHandler$Header
                r11.<init>(r13, r10)
                return r11
            L_0x0314:
                boolean r0 = r13 instanceof retrofit2.http.HeaderMap
                if (r0 == 0) goto L_0x0387
                java.lang.Class<okhttp3.Headers> r13 = okhttp3.Headers.class
                if (r11 != r13) goto L_0x0324
                retrofit2.ParameterHandler$Headers r11 = new retrofit2.ParameterHandler$Headers
                java.lang.reflect.Method r12 = r9.method
                r11.<init>(r12, r10)
                return r11
            L_0x0324:
                r9.validateResolvableType(r10, r11)
                java.lang.Class r13 = retrofit2.Utils.getRawType(r11)
                java.lang.Class<java.util.Map> r0 = java.util.Map.class
                boolean r0 = r0.isAssignableFrom(r13)
                if (r0 == 0) goto L_0x037c
                java.lang.Class<java.util.Map> r0 = java.util.Map.class
                java.lang.reflect.Type r11 = retrofit2.Utils.getSupertype(r11, r13, r0)
                boolean r13 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r13 == 0) goto L_0x0373
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r13 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                java.lang.Class<java.lang.String> r0 = java.lang.String.class
                if (r0 != r13) goto L_0x0359
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r2, r11)
                retrofit2.Retrofit r13 = r9.retrofit
                retrofit2.Converter r11 = r13.stringConverter(r11, r12)
                retrofit2.ParameterHandler$HeaderMap r12 = new retrofit2.ParameterHandler$HeaderMap
                java.lang.reflect.Method r13 = r9.method
                r12.<init>(r13, r10, r11)
                return r12
            L_0x0359:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r0 = "@HeaderMap keys must be of type String: "
                r12.append(r0)
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x0373:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r5, r12)
                throw r10
            L_0x037c:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@HeaderMap parameter type must be Map."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0387:
                boolean r0 = r13 instanceof retrofit2.http.Field
                if (r0 == 0) goto L_0x041f
                r9.validateResolvableType(r10, r11)
                boolean r0 = r9.isFormEncoded
                if (r0 == 0) goto L_0x0414
                retrofit2.http.Field r13 = (retrofit2.http.Field) r13
                java.lang.String r0 = r13.value()
                boolean r13 = r13.encoded()
                r9.gotField = r2
                java.lang.Class r2 = retrofit2.Utils.getRawType(r11)
                java.lang.Class<java.lang.Iterable> r5 = java.lang.Iterable.class
                boolean r5 = r5.isAssignableFrom(r2)
                if (r5 == 0) goto L_0x03ea
                boolean r5 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r5 == 0) goto L_0x03c4
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r10 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$Field r11 = new retrofit2.ParameterHandler$Field
                r11.<init>(r0, r10, r13)
                retrofit2.ParameterHandler r10 = r11.iterable()
                return r10
            L_0x03c4:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r2.getSimpleName()
                r12.append(r13)
                r12.append(r4)
                java.lang.String r13 = r2.getSimpleName()
                r12.append(r13)
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x03ea:
                boolean r10 = r2.isArray()
                if (r10 == 0) goto L_0x0408
                java.lang.Class r10 = r2.getComponentType()
                java.lang.Class r10 = boxIfPrimitive(r10)
                retrofit2.Retrofit r11 = r9.retrofit
                retrofit2.Converter r10 = r11.stringConverter(r10, r12)
                retrofit2.ParameterHandler$Field r11 = new retrofit2.ParameterHandler$Field
                r11.<init>(r0, r10, r13)
                retrofit2.ParameterHandler r10 = r11.array()
                return r10
            L_0x0408:
                retrofit2.Retrofit r10 = r9.retrofit
                retrofit2.Converter r10 = r10.stringConverter(r11, r12)
                retrofit2.ParameterHandler$Field r11 = new retrofit2.ParameterHandler$Field
                r11.<init>(r0, r10, r13)
                return r11
            L_0x0414:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@Field parameters can only be used with form encoding."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x041f:
                boolean r0 = r13 instanceof retrofit2.http.FieldMap
                if (r0 == 0) goto L_0x049d
                r9.validateResolvableType(r10, r11)
                boolean r0 = r9.isFormEncoded
                if (r0 == 0) goto L_0x0492
                java.lang.Class r0 = retrofit2.Utils.getRawType(r11)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x0487
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r11 = retrofit2.Utils.getSupertype(r11, r0, r1)
                boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r0 == 0) goto L_0x047e
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r0 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                java.lang.Class<java.lang.String> r1 = java.lang.String.class
                if (r1 != r0) goto L_0x0464
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r2, r11)
                retrofit2.Retrofit r0 = r9.retrofit
                retrofit2.Converter r11 = r0.stringConverter(r11, r12)
                r9.gotField = r2
                retrofit2.ParameterHandler$FieldMap r12 = new retrofit2.ParameterHandler$FieldMap
                java.lang.reflect.Method r0 = r9.method
                retrofit2.http.FieldMap r13 = (retrofit2.http.FieldMap) r13
                boolean r13 = r13.encoded()
                r12.<init>(r0, r10, r11, r13)
                return r12
            L_0x0464:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "@FieldMap keys must be of type String: "
                r12.append(r13)
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x047e:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r5, r12)
                throw r10
            L_0x0487:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@FieldMap parameter type must be Map."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0492:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@FieldMap parameters can only be used with form encoding."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x049d:
                boolean r0 = r13 instanceof retrofit2.http.Part
                if (r0 == 0) goto L_0x0637
                r9.validateResolvableType(r10, r11)
                boolean r0 = r9.isMultipart
                if (r0 == 0) goto L_0x062c
                retrofit2.http.Part r13 = (retrofit2.http.Part) r13
                r9.gotPart = r2
                java.lang.String r0 = r13.value()
                java.lang.Class r5 = retrofit2.Utils.getRawType(r11)
                boolean r6 = r0.isEmpty()
                if (r6 == 0) goto L_0x0546
                java.lang.Class<java.lang.Iterable> r12 = java.lang.Iterable.class
                boolean r12 = r12.isAssignableFrom(r5)
                java.lang.String r13 = "@Part annotation must supply a name or use MultipartBody.Part parameter type."
                if (r12 == 0) goto L_0x0510
                boolean r12 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r12 == 0) goto L_0x04ea
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                java.lang.Class<okhttp3.MultipartBody$Part> r12 = okhttp3.MultipartBody.Part.class
                java.lang.Class r11 = retrofit2.Utils.getRawType(r11)
                boolean r11 = r12.isAssignableFrom(r11)
                if (r11 == 0) goto L_0x04e1
                retrofit2.ParameterHandler$RawPart r10 = retrofit2.ParameterHandler.RawPart.INSTANCE
                retrofit2.ParameterHandler r10 = r10.iterable()
                return r10
            L_0x04e1:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x04ea:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r5.getSimpleName()
                r12.append(r13)
                r12.append(r4)
                java.lang.String r13 = r5.getSimpleName()
                r12.append(r13)
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x0510:
                boolean r11 = r5.isArray()
                if (r11 == 0) goto L_0x0532
                java.lang.Class r11 = r5.getComponentType()
                java.lang.Class<okhttp3.MultipartBody$Part> r12 = okhttp3.MultipartBody.Part.class
                boolean r11 = r12.isAssignableFrom(r11)
                if (r11 == 0) goto L_0x0529
                retrofit2.ParameterHandler$RawPart r10 = retrofit2.ParameterHandler.RawPart.INSTANCE
                retrofit2.ParameterHandler r10 = r10.array()
                return r10
            L_0x0529:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0532:
                java.lang.Class<okhttp3.MultipartBody$Part> r11 = okhttp3.MultipartBody.Part.class
                boolean r11 = r11.isAssignableFrom(r5)
                if (r11 == 0) goto L_0x053d
                retrofit2.ParameterHandler$RawPart r10 = retrofit2.ParameterHandler.RawPart.INSTANCE
                return r10
            L_0x053d:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0546:
                r6 = 4
                java.lang.String[] r6 = new java.lang.String[r6]
                java.lang.String r7 = "Content-Disposition"
                r6[r3] = r7
                java.lang.StringBuilder r7 = new java.lang.StringBuilder
                r7.<init>()
                java.lang.String r8 = "form-data; name=\""
                r7.append(r8)
                r7.append(r0)
                java.lang.String r0 = "\""
                r7.append(r0)
                java.lang.String r0 = r7.toString()
                r6[r2] = r0
                r0 = 2
                java.lang.String r2 = "Content-Transfer-Encoding"
                r6[r0] = r2
                r0 = 3
                java.lang.String r13 = r13.encoding()
                r6[r0] = r13
                okhttp3.Headers r13 = okhttp3.Headers.of(r6)
                java.lang.Class<java.lang.Iterable> r0 = java.lang.Iterable.class
                boolean r0 = r0.isAssignableFrom(r5)
                java.lang.String r2 = "@Part parameters using the MultipartBody.Part must not include a part name in the annotation."
                if (r0 == 0) goto L_0x05d8
                boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r0 == 0) goto L_0x05b2
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                java.lang.Class<okhttp3.MultipartBody$Part> r0 = okhttp3.MultipartBody.Part.class
                java.lang.Class r1 = retrofit2.Utils.getRawType(r11)
                boolean r0 = r0.isAssignableFrom(r1)
                if (r0 != 0) goto L_0x05a9
                retrofit2.Retrofit r0 = r9.retrofit
                java.lang.annotation.Annotation[] r1 = r9.methodAnnotations
                retrofit2.Converter r11 = r0.requestBodyConverter(r11, r12, r1)
                retrofit2.ParameterHandler$Part r12 = new retrofit2.ParameterHandler$Part
                java.lang.reflect.Method r0 = r9.method
                r12.<init>(r0, r10, r13, r11)
                retrofit2.ParameterHandler r10 = r12.iterable()
                return r10
            L_0x05a9:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r2, r12)
                throw r10
            L_0x05b2:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = r5.getSimpleName()
                r12.append(r13)
                r12.append(r4)
                java.lang.String r13 = r5.getSimpleName()
                r12.append(r13)
                r12.append(r1)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x05d8:
                boolean r0 = r5.isArray()
                if (r0 == 0) goto L_0x060b
                java.lang.Class r11 = r5.getComponentType()
                java.lang.Class r11 = boxIfPrimitive(r11)
                java.lang.Class<okhttp3.MultipartBody$Part> r0 = okhttp3.MultipartBody.Part.class
                boolean r0 = r0.isAssignableFrom(r11)
                if (r0 != 0) goto L_0x0602
                retrofit2.Retrofit r0 = r9.retrofit
                java.lang.annotation.Annotation[] r1 = r9.methodAnnotations
                retrofit2.Converter r11 = r0.requestBodyConverter(r11, r12, r1)
                retrofit2.ParameterHandler$Part r12 = new retrofit2.ParameterHandler$Part
                java.lang.reflect.Method r0 = r9.method
                r12.<init>(r0, r10, r13, r11)
                retrofit2.ParameterHandler r10 = r12.array()
                return r10
            L_0x0602:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r2, r12)
                throw r10
            L_0x060b:
                java.lang.Class<okhttp3.MultipartBody$Part> r0 = okhttp3.MultipartBody.Part.class
                boolean r0 = r0.isAssignableFrom(r5)
                if (r0 != 0) goto L_0x0623
                retrofit2.Retrofit r0 = r9.retrofit
                java.lang.annotation.Annotation[] r1 = r9.methodAnnotations
                retrofit2.Converter r11 = r0.requestBodyConverter(r11, r12, r1)
                retrofit2.ParameterHandler$Part r12 = new retrofit2.ParameterHandler$Part
                java.lang.reflect.Method r0 = r9.method
                r12.<init>(r0, r10, r13, r11)
                return r12
            L_0x0623:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r2, r12)
                throw r10
            L_0x062c:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@Part parameters can only be used with multipart encoding."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0637:
                boolean r0 = r13 instanceof retrofit2.http.PartMap
                if (r0 == 0) goto L_0x06ce
                r9.validateResolvableType(r10, r11)
                boolean r0 = r9.isMultipart
                if (r0 == 0) goto L_0x06c3
                r9.gotPart = r2
                java.lang.Class r0 = retrofit2.Utils.getRawType(r11)
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                boolean r1 = r1.isAssignableFrom(r0)
                if (r1 == 0) goto L_0x06b8
                java.lang.Class<java.util.Map> r1 = java.util.Map.class
                java.lang.reflect.Type r11 = retrofit2.Utils.getSupertype(r11, r0, r1)
                boolean r0 = r11 instanceof java.lang.reflect.ParameterizedType
                if (r0 == 0) goto L_0x06af
                java.lang.reflect.ParameterizedType r11 = (java.lang.reflect.ParameterizedType) r11
                java.lang.reflect.Type r0 = retrofit2.Utils.getParameterUpperBound(r3, r11)
                java.lang.Class<java.lang.String> r1 = java.lang.String.class
                if (r1 != r0) goto L_0x0695
                java.lang.reflect.Type r11 = retrofit2.Utils.getParameterUpperBound(r2, r11)
                java.lang.Class<okhttp3.MultipartBody$Part> r0 = okhttp3.MultipartBody.Part.class
                java.lang.Class r1 = retrofit2.Utils.getRawType(r11)
                boolean r0 = r0.isAssignableFrom(r1)
                if (r0 != 0) goto L_0x068a
                retrofit2.Retrofit r0 = r9.retrofit
                java.lang.annotation.Annotation[] r1 = r9.methodAnnotations
                retrofit2.Converter r11 = r0.requestBodyConverter(r11, r12, r1)
                retrofit2.http.PartMap r13 = (retrofit2.http.PartMap) r13
                retrofit2.ParameterHandler$PartMap r12 = new retrofit2.ParameterHandler$PartMap
                java.lang.reflect.Method r0 = r9.method
                java.lang.String r13 = r13.encoding()
                r12.<init>(r0, r10, r11, r13)
                return r12
            L_0x068a:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0695:
                java.lang.reflect.Method r11 = r9.method
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "@PartMap keys must be of type String: "
                r12.append(r13)
                r12.append(r0)
                java.lang.String r12 = r12.toString()
                java.lang.Object[] r13 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r12, r13)
                throw r10
            L_0x06af:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r5, r12)
                throw r10
            L_0x06b8:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@PartMap parameter type must be Map."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x06c3:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@PartMap parameters can only be used with multipart encoding."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x06ce:
                boolean r0 = r13 instanceof retrofit2.http.Body
                if (r0 == 0) goto L_0x0717
                r9.validateResolvableType(r10, r11)
                boolean r13 = r9.isFormEncoded
                if (r13 != 0) goto L_0x070c
                boolean r13 = r9.isMultipart
                if (r13 != 0) goto L_0x070c
                boolean r13 = r9.gotBody
                if (r13 != 0) goto L_0x0701
                retrofit2.Retrofit r13 = r9.retrofit     // Catch:{ RuntimeException -> 0x06f3 }
                java.lang.annotation.Annotation[] r0 = r9.methodAnnotations     // Catch:{ RuntimeException -> 0x06f3 }
                retrofit2.Converter r11 = r13.requestBodyConverter(r11, r12, r0)     // Catch:{ RuntimeException -> 0x06f3 }
                r9.gotBody = r2
                retrofit2.ParameterHandler$Body r12 = new retrofit2.ParameterHandler$Body
                java.lang.reflect.Method r13 = r9.method
                r12.<init>(r13, r10, r11)
                return r12
            L_0x06f3:
                r12 = move-exception
                java.lang.reflect.Method r13 = r9.method
                java.lang.Object[] r0 = new java.lang.Object[r2]
                r0[r3] = r11
                java.lang.String r11 = "Unable to create @Body converter for %s"
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r13, r12, r10, r11, r0)
                throw r10
            L_0x0701:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "Multiple @Body method annotations found."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x070c:
                java.lang.reflect.Method r11 = r9.method
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.String r13 = "@Body parameters cannot be used with form or multi-part encoding."
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r11, r10, r13, r12)
                throw r10
            L_0x0717:
                boolean r12 = r13 instanceof retrofit2.http.Tag
                if (r12 == 0) goto L_0x076e
                r9.validateResolvableType(r10, r11)
                java.lang.Class r11 = retrofit2.Utils.getRawType(r11)
                int r12 = r10 + -1
            L_0x0724:
                if (r12 < 0) goto L_0x0768
                retrofit2.ParameterHandler<?>[] r13 = r9.parameterHandlers
                r13 = r13[r12]
                boolean r0 = r13 instanceof retrofit2.ParameterHandler.Tag
                if (r0 == 0) goto L_0x0765
                retrofit2.ParameterHandler$Tag r13 = (retrofit2.ParameterHandler.Tag) r13
                java.lang.Class<T> r13 = r13.cls
                boolean r13 = r13.equals(r11)
                if (r13 != 0) goto L_0x0739
                goto L_0x0765
            L_0x0739:
                java.lang.reflect.Method r13 = r9.method
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "@Tag type "
                r0.append(r1)
                java.lang.String r11 = r11.getName()
                r0.append(r11)
                java.lang.String r11 = " is duplicate of parameter #"
                r0.append(r11)
                int r12 = r12 + r2
                r0.append(r12)
                java.lang.String r11 = " and would always overwrite its value."
                r0.append(r11)
                java.lang.String r11 = r0.toString()
                java.lang.Object[] r12 = new java.lang.Object[r3]
                java.lang.RuntimeException r10 = retrofit2.Utils.parameterError(r13, r10, r11, r12)
                throw r10
            L_0x0765:
                int r12 = r12 + -1
                goto L_0x0724
            L_0x0768:
                retrofit2.ParameterHandler$Tag r10 = new retrofit2.ParameterHandler$Tag
                r10.<init>(r11)
                return r10
            L_0x076e:
                r10 = 0
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.RequestFactory.Builder.parseParameterAnnotation(int, java.lang.reflect.Type, java.lang.annotation.Annotation[], java.lang.annotation.Annotation):retrofit2.ParameterHandler");
        }

        private void validateResolvableType(int i, Type type) {
            if (Utils.hasUnresolvableType(type)) {
                throw Utils.parameterError(this.method, i, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }

        private void validatePathName(int i, String str) {
            if (!PARAM_NAME_REGEX.matcher(str).matches()) {
                throw Utils.parameterError(this.method, i, "@Path parameter name must match %s. Found: %s", PARAM_URL_REGEX.pattern(), str);
            } else if (!this.relativeUrlParamNames.contains(str)) {
                throw Utils.parameterError(this.method, i, "URL \"%s\" does not contain \"{%s}\".", this.relativeUrl, str);
            }
        }

        static Set<String> parsePathParameters(String str) {
            Matcher matcher = PARAM_URL_REGEX.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r1v0, types: [java.lang.Class<?>, java.lang.Class] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static java.lang.Class<?> boxIfPrimitive(java.lang.Class r1) {
            /*
                java.lang.Class r0 = java.lang.Boolean.TYPE
                if (r0 != r1) goto L_0x0007
                java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
                return r1
            L_0x0007:
                java.lang.Class r0 = java.lang.Byte.TYPE
                if (r0 != r1) goto L_0x000e
                java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
                return r1
            L_0x000e:
                java.lang.Class r0 = java.lang.Character.TYPE
                if (r0 != r1) goto L_0x0015
                java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
                return r1
            L_0x0015:
                java.lang.Class r0 = java.lang.Double.TYPE
                if (r0 != r1) goto L_0x001c
                java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
                return r1
            L_0x001c:
                java.lang.Class r0 = java.lang.Float.TYPE
                if (r0 != r1) goto L_0x0023
                java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
                return r1
            L_0x0023:
                java.lang.Class r0 = java.lang.Integer.TYPE
                if (r0 != r1) goto L_0x002a
                java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
                return r1
            L_0x002a:
                java.lang.Class r0 = java.lang.Long.TYPE
                if (r0 != r1) goto L_0x0031
                java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
                return r1
            L_0x0031:
                java.lang.Class r0 = java.lang.Short.TYPE
                if (r0 != r1) goto L_0x0037
                java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
            L_0x0037:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.RequestFactory.Builder.boxIfPrimitive(java.lang.Class):java.lang.Class");
        }
    }

    static RequestFactory parseAnnotations(Retrofit retrofit, Method method2) {
        return new Builder(retrofit, method2).build();
    }

    RequestFactory(Builder builder) {
        this.method = builder.method;
        this.baseUrl = builder.retrofit.baseUrl;
        this.httpMethod = builder.httpMethod;
        this.relativeUrl = builder.relativeUrl;
        this.headers = builder.headers;
        this.contentType = builder.contentType;
        this.hasBody = builder.hasBody;
        this.isFormEncoded = builder.isFormEncoded;
        this.isMultipart = builder.isMultipart;
        this.parameterHandlers = builder.parameterHandlers;
        this.isKotlinSuspendFunction = builder.isKotlinSuspendFunction;
    }

    /* access modifiers changed from: 0000 */
    public Request create(Object[] objArr) throws IOException {
        ParameterHandler<?>[] parameterHandlerArr = this.parameterHandlers;
        int length = objArr.length;
        if (length == parameterHandlerArr.length) {
            RequestBuilder requestBuilder = new RequestBuilder(this.httpMethod, this.baseUrl, this.relativeUrl, this.headers, this.contentType, this.hasBody, this.isFormEncoded, this.isMultipart);
            if (this.isKotlinSuspendFunction) {
                length--;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(objArr[i]);
                parameterHandlerArr[i].apply(requestBuilder, objArr[i]);
            }
            return requestBuilder.get().tag(Invocation.class, new Invocation(this.method, arrayList)).build();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Argument count (");
        sb.append(length);
        sb.append(") doesn't match expected count (");
        sb.append(parameterHandlerArr.length);
        sb.append(")");
        throw new IllegalArgumentException(sb.toString());
    }
}
