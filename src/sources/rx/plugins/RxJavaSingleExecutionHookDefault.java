package rx.plugins;

final class RxJavaSingleExecutionHookDefault extends RxJavaSingleExecutionHook {
    private static final RxJavaSingleExecutionHookDefault INSTANCE = new RxJavaSingleExecutionHookDefault();

    private RxJavaSingleExecutionHookDefault() {
    }

    public static RxJavaSingleExecutionHook getInstance() {
        return INSTANCE;
    }
}
