package androidx.navigation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Args", "Landroidx/navigation/NavArgs;", "invoke"}, k = 3, mv = {1, 1, 15})
/* compiled from: ActivityNavArgsLazy.kt */
public final class ActivityNavArgsLazyKt$navArgs$1 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ Activity $this_navArgs;

    public ActivityNavArgsLazyKt$navArgs$1(Activity activity) {
        this.$this_navArgs = activity;
        super(0);
    }

    public final Bundle invoke() {
        Intent intent = this.$this_navArgs.getIntent();
        String str = "Activity ";
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(this.$this_navArgs);
                sb.append(" has null extras in ");
                sb.append(intent);
                throw new IllegalStateException(sb.toString());
            } else if (extras != null) {
                return extras;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(this.$this_navArgs);
        sb2.append(" has a null Intent");
        throw new IllegalStateException(sb2.toString());
    }
}
