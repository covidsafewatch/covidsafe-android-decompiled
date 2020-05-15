package androidx.room.util;

public class SneakyThrow {
    public static void reThrow(Exception exc) {
        sneakyThrow(exc);
    }

    private static <E extends Throwable> void sneakyThrow(Throwable th) throws Throwable {
        throw th;
    }

    private SneakyThrow() {
    }
}
