package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Args", "Landroidx/navigation/NavArgs;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: FragmentNavArgsLazy.kt */
public final class FragmentNavArgsLazyKt$navArgs$1 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ Fragment $this_navArgs;

    public FragmentNavArgsLazyKt$navArgs$1(Fragment fragment) {
        this.$this_navArgs = fragment;
        super(0);
    }

    public final Bundle invoke() {
        Bundle arguments = this.$this_navArgs.getArguments();
        if (arguments != null) {
            return arguments;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Fragment ");
        sb.append(this.$this_navArgs);
        sb.append(" has null arguments");
        throw new IllegalStateException(sb.toString());
    }
}
