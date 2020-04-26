package retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    public static Invocation of(Method method2, List<?> list) {
        Utils.checkNotNull(method2, "method == null");
        Utils.checkNotNull(list, "arguments == null");
        return new Invocation(method2, new ArrayList(list));
    }

    Invocation(Method method2, List<?> list) {
        this.method = method2;
        this.arguments = Collections.unmodifiableList(list);
    }

    public Method method() {
        return this.method;
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments});
    }
}
