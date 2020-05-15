package okhttp3.internal.platform;

import androidx.core.os.EnvironmentCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0015\u0016B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J(\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0016R\u0012\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "putMethod", "Ljava/lang/reflect/Method;", "getMethod", "removeMethod", "clientProviderClass", "Ljava/lang/Class;", "serverProviderClass", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "AlpnProvider", "Companion", "okhttp"}, k = 1, mv = {1, 1, 16})
/* compiled from: Jdk8WithJettyBootPlatform.kt */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        Intrinsics.checkParameterIsNotNull(method, "putMethod");
        Intrinsics.checkParameterIsNotNull(method2, "getMethod");
        Intrinsics.checkParameterIsNotNull(method3, "removeMethod");
        Intrinsics.checkParameterIsNotNull(cls, "clientProviderClass");
        Intrinsics.checkParameterIsNotNull(cls2, "serverProviderClass");
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = cls;
        this.serverProviderClass = cls2;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<? extends Protocol> list) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        Intrinsics.checkParameterIsNotNull(list, "protocols");
        List<String> alpnProtocolNames = Platform.Companion.alpnProtocolNames(list);
        try {
            Object newProxyInstance = Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(alpnProtocolNames));
            this.putMethod.invoke((Object) null, new Object[]{sSLSocket, newProxyInstance});
        } catch (InvocationTargetException e) {
            throw new AssertionError("failed to set ALPN", e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to set ALPN", e2);
        }
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        try {
            this.removeMethod.invoke((Object) null, new Object[]{sSLSocket});
        } catch (IllegalAccessException e) {
            throw new AssertionError("failed to remove ALPN", e);
        } catch (InvocationTargetException e2) {
            throw new AssertionError("failed to remove ALPN", e2);
        }
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Intrinsics.checkParameterIsNotNull(sSLSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke((Object) null, new Object[]{sSLSocket}));
            if (invocationHandler != null) {
                AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
                if (!alpnProvider.getUnsupported$okhttp() && alpnProvider.getSelected$okhttp() == null) {
                    Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, (Throwable) null, 6, (Object) null);
                    return null;
                } else if (alpnProvider.getUnsupported$okhttp()) {
                    return null;
                } else {
                    return alpnProvider.getSelected$okhttp();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
        } catch (InvocationTargetException e) {
            throw new AssertionError("failed to get ALPN selected protocol", e);
        } catch (IllegalAccessException e2) {
            throw new AssertionError("failed to get ALPN selected protocol", e2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J0\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "protocols", "", "", "(Ljava/util/List;)V", "selected", "getSelected$okhttp", "()Ljava/lang/String;", "setSelected$okhttp", "(Ljava/lang/String;)V", "unsupported", "", "getUnsupported$okhttp", "()Z", "setUnsupported$okhttp", "(Z)V", "invoke", "", "proxy", "method", "Ljava/lang/reflect/Method;", "args", "", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    private static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> list) {
            Intrinsics.checkParameterIsNotNull(list, "protocols");
            this.protocols = list;
        }

        public final boolean getUnsupported$okhttp() {
            return this.unsupported;
        }

        public final void setUnsupported$okhttp(boolean z) {
            this.unsupported = z;
        }

        public final String getSelected$okhttp() {
            return this.selected;
        }

        public final void setSelected$okhttp(String str) {
            this.selected = str;
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            Intrinsics.checkParameterIsNotNull(obj, "proxy");
            Intrinsics.checkParameterIsNotNull(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (Intrinsics.areEqual((Object) name, (Object) "supports") && Intrinsics.areEqual((Object) Boolean.TYPE, (Object) returnType)) {
                return true;
            }
            if (!Intrinsics.areEqual((Object) name, (Object) "unsupported") || !Intrinsics.areEqual((Object) Void.TYPE, (Object) returnType)) {
                if (Intrinsics.areEqual((Object) name, (Object) "protocols")) {
                    if (objArr.length == 0) {
                        return this.protocols;
                    }
                }
                if ((Intrinsics.areEqual((Object) name, (Object) "selectProtocol") || Intrinsics.areEqual((Object) name, (Object) "select")) && Intrinsics.areEqual((Object) String.class, (Object) returnType) && objArr.length == 1 && (objArr[0] instanceof List)) {
                    Object obj2 = objArr[0];
                    if (obj2 != null) {
                        List list = (List) obj2;
                        int size = list.size();
                        if (size >= 0) {
                            int i = 0;
                            while (true) {
                                Object obj3 = list.get(i);
                                if (obj3 != null) {
                                    String str = (String) obj3;
                                    if (!this.protocols.contains(str)) {
                                        if (i == size) {
                                            break;
                                        }
                                        i++;
                                    } else {
                                        this.selected = str;
                                        return str;
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                                }
                            }
                        }
                        String str2 = this.protocols.get(0);
                        this.selected = str2;
                        return str2;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<*>");
                } else if ((!Intrinsics.areEqual((Object) name, (Object) "protocolSelected") && !Intrinsics.areEqual((Object) name, (Object) "selected")) || objArr.length != 1) {
                    return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
                } else {
                    Object obj4 = objArr[0];
                    if (obj4 != null) {
                        this.selected = (String) obj4;
                        return null;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                this.unsupported = true;
                return null;
            }
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¨\u0006\u0005"}, d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k = 1, mv = {1, 1, 16})
    /* compiled from: Jdk8WithJettyBootPlatform.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Platform buildIfSupported() {
            String property = System.getProperty("java.specification.version", EnvironmentCompat.MEDIA_UNKNOWN);
            try {
                Intrinsics.checkExpressionValueIsNotNull(property, "jvmVersion");
                if (Integer.parseInt(property) >= 9) {
                    return null;
                }
            } catch (NumberFormatException unused) {
            }
            try {
                Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, (ClassLoader) null);
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$Provider", true, (ClassLoader) null);
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ClientProvider", true, (ClassLoader) null);
                Class<?> cls4 = Class.forName("org.eclipse.jetty.alpn.ALPN" + "$ServerProvider", true, (ClassLoader) null);
                Method method = cls.getMethod("put", new Class[]{SSLSocket.class, cls2});
                Method method2 = cls.getMethod("get", new Class[]{SSLSocket.class});
                Method method3 = cls.getMethod("remove", new Class[]{SSLSocket.class});
                Intrinsics.checkExpressionValueIsNotNull(method, "putMethod");
                Intrinsics.checkExpressionValueIsNotNull(method2, "getMethod");
                Intrinsics.checkExpressionValueIsNotNull(method3, "removeMethod");
                Intrinsics.checkExpressionValueIsNotNull(cls3, "clientProviderClass");
                Intrinsics.checkExpressionValueIsNotNull(cls4, "serverProviderClass");
                return new Jdk8WithJettyBootPlatform(method, method2, method3, cls3, cls4);
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                return null;
            }
        }
    }
}
