package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

abstract class ServiceMethod<T> {
    /* access modifiers changed from: package-private */
    @Nullable
    public abstract T invoke(Object[] objArr);

    ServiceMethod() {
    }

    static <T> ServiceMethod<T> parseAnnotations(Retrofit retrofit, Method method) {
        RequestFactory parseAnnotations = RequestFactory.parseAnnotations(retrofit, method);
        Type genericReturnType = method.getGenericReturnType();
        if (Utils.hasUnresolvableType(genericReturnType)) {
            throw Utils.methodError(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        } else if (genericReturnType != Void.TYPE) {
            return HttpServiceMethod.parseAnnotations(retrofit, method, parseAnnotations);
        } else {
            throw Utils.methodError(method, "Service methods cannot return void.", new Object[0]);
        }
    }
}
