package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.coroutines.Continuation;
import okhttp3.Call;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Utils;

abstract class HttpServiceMethod<ResponseT, ReturnT> extends ServiceMethod<ReturnT> {
    private final Call.Factory callFactory;
    private final RequestFactory requestFactory;
    private final Converter<ResponseBody, ResponseT> responseConverter;

    /* access modifiers changed from: protected */
    @Nullable
    public abstract ReturnT adapt(Call<ResponseT> call, Object[] objArr);

    static <ResponseT, ReturnT> HttpServiceMethod<ResponseT, ReturnT> parseAnnotations(Retrofit retrofit, Method method, RequestFactory requestFactory2) {
        Type type;
        boolean z;
        boolean z2 = requestFactory2.isKotlinSuspendFunction;
        Annotation[] annotations = method.getAnnotations();
        if (z2) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type parameterLowerBound = Utils.getParameterLowerBound(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (Utils.getRawType(parameterLowerBound) != Response.class || !(parameterLowerBound instanceof ParameterizedType)) {
                z = false;
            } else {
                parameterLowerBound = Utils.getParameterUpperBound(0, (ParameterizedType) parameterLowerBound);
                z = true;
            }
            type = new Utils.ParameterizedTypeImpl((Type) null, Call.class, parameterLowerBound);
            annotations = SkipCallbackExecutorImpl.ensurePresent(annotations);
        } else {
            type = method.getGenericReturnType();
            z = false;
        }
        CallAdapter createCallAdapter = createCallAdapter(retrofit, method, type, annotations);
        Type responseType = createCallAdapter.responseType();
        if (responseType == Response.class) {
            throw Utils.methodError(method, "'" + Utils.getRawType(responseType).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        } else if (responseType == Response.class) {
            throw Utils.methodError(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        } else if (!requestFactory2.httpMethod.equals("HEAD") || Void.class.equals(responseType)) {
            Converter createResponseConverter = createResponseConverter(retrofit, method, responseType);
            Call.Factory factory = retrofit.callFactory;
            if (!z2) {
                return new CallAdapted(requestFactory2, factory, createResponseConverter, createCallAdapter);
            }
            if (z) {
                return new SuspendForResponse(requestFactory2, factory, createResponseConverter, createCallAdapter);
            }
            return new SuspendForBody(requestFactory2, factory, createResponseConverter, createCallAdapter, false);
        } else {
            throw Utils.methodError(method, "HEAD method must use Void as response type.", new Object[0]);
        }
    }

    private static <ResponseT, ReturnT> CallAdapter<ResponseT, ReturnT> createCallAdapter(Retrofit retrofit, Method method, Type type, Annotation[] annotationArr) {
        try {
            return retrofit.callAdapter(type, annotationArr);
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create call adapter for %s", type);
        }
    }

    private static <ResponseT> Converter<ResponseBody, ResponseT> createResponseConverter(Retrofit retrofit, Method method, Type type) {
        try {
            return retrofit.responseBodyConverter(type, method.getAnnotations());
        } catch (RuntimeException e) {
            throw Utils.methodError(method, e, "Unable to create converter for %s", type);
        }
    }

    HttpServiceMethod(RequestFactory requestFactory2, Call.Factory factory, Converter<ResponseBody, ResponseT> converter) {
        this.requestFactory = requestFactory2;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final ReturnT invoke(Object[] objArr) {
        return adapt(new OkHttpCall(this.requestFactory, objArr, this.callFactory, this.responseConverter), objArr);
    }

    static final class CallAdapted<ResponseT, ReturnT> extends HttpServiceMethod<ResponseT, ReturnT> {
        private final CallAdapter<ResponseT, ReturnT> callAdapter;

        CallAdapted(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, ReturnT> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        /* JADX WARNING: type inference failed for: r1v0, types: [retrofit2.Call, retrofit2.Call<ResponseT>] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ReturnT adapt(retrofit2.Call<ResponseT> r1, java.lang.Object[] r2) {
            /*
                r0 = this;
                retrofit2.CallAdapter<ResponseT, ReturnT> r2 = r0.callAdapter
                java.lang.Object r1 = r2.adapt(r1)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: retrofit2.HttpServiceMethod.CallAdapted.adapt(retrofit2.Call, java.lang.Object[]):java.lang.Object");
        }
    }

    static final class SuspendForResponse<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;

        SuspendForResponse(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
        }

        /* access modifiers changed from: protected */
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            Continuation continuation = objArr[objArr.length - 1];
            try {
                return KotlinExtensions.awaitResponse(call2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.yieldAndThrow(e, continuation);
            }
        }
    }

    static final class SuspendForBody<ResponseT> extends HttpServiceMethod<ResponseT, Object> {
        private final CallAdapter<ResponseT, Call<ResponseT>> callAdapter;
        private final boolean isNullable;

        SuspendForBody(RequestFactory requestFactory, Call.Factory factory, Converter<ResponseBody, ResponseT> converter, CallAdapter<ResponseT, Call<ResponseT>> callAdapter2, boolean z) {
            super(requestFactory, factory, converter);
            this.callAdapter = callAdapter2;
            this.isNullable = z;
        }

        /* access modifiers changed from: protected */
        public Object adapt(Call<ResponseT> call, Object[] objArr) {
            Call call2 = (Call) this.callAdapter.adapt(call);
            Continuation continuation = objArr[objArr.length - 1];
            try {
                if (this.isNullable) {
                    return KotlinExtensions.awaitNullable(call2, continuation);
                }
                return KotlinExtensions.await(call2, continuation);
            } catch (Exception e) {
                return KotlinExtensions.yieldAndThrow(e, continuation);
            }
        }
    }
}
