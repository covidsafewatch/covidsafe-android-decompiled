package retrofit2;

import java.lang.annotation.Annotation;

final class SkipCallbackExecutorImpl implements SkipCallbackExecutor {
    private static final SkipCallbackExecutor INSTANCE = new SkipCallbackExecutorImpl();

    public int hashCode() {
        return 0;
    }

    SkipCallbackExecutorImpl() {
    }

    static Annotation[] ensurePresent(Annotation[] annotationArr) {
        if (Utils.isAnnotationPresent(annotationArr, SkipCallbackExecutor.class)) {
            return annotationArr;
        }
        Annotation[] annotationArr2 = new Annotation[(annotationArr.length + 1)];
        annotationArr2[0] = INSTANCE;
        System.arraycopy(annotationArr, 0, annotationArr2, 1, annotationArr.length);
        return annotationArr2;
    }

    public Class<? extends Annotation> annotationType() {
        return SkipCallbackExecutor.class;
    }

    public boolean equals(Object obj) {
        return obj instanceof SkipCallbackExecutor;
    }

    public String toString() {
        return "@" + SkipCallbackExecutor.class.getName() + "()";
    }
}
