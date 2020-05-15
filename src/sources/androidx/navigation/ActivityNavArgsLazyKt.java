package androidx.navigation;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u0004H\b¨\u0006\u0005"}, d2 = {"navArgs", "Landroidx/navigation/NavArgsLazy;", "Args", "Landroidx/navigation/NavArgs;", "Landroid/app/Activity;", "navigation-runtime-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: ActivityNavArgsLazy.kt */
public final class ActivityNavArgsLazyKt {
    public static final /* synthetic */ <Args extends NavArgs> NavArgsLazy<Args> navArgs(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "$this$navArgs");
        Intrinsics.reifiedOperationMarker(4, "Args");
        return new NavArgsLazy<>(Reflection.getOrCreateKotlinClass(NavArgs.class), new ActivityNavArgsLazyKt$navArgs$1(activity));
    }
}
