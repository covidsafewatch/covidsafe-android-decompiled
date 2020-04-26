package au.gov.health.covidsafe.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "", "()V", "ContinueLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PagerChildFragment.kt */
public abstract class UploadButtonLayout {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "buttonText", "", "buttonListener", "Lkotlin/Function0;", "", "(ILkotlin/jvm/functions/Function0;)V", "getButtonListener", "()Lkotlin/jvm/functions/Function0;", "getButtonText", "()I", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PagerChildFragment.kt */
    public static final class ContinueLayout extends UploadButtonLayout {
        private final Function0<Unit> buttonListener;
        private final int buttonText;

        public ContinueLayout(int i, Function0<Unit> function0) {
            super((DefaultConstructorMarker) null);
            this.buttonText = i;
            this.buttonListener = function0;
        }

        public final Function0<Unit> getButtonListener() {
            return this.buttonListener;
        }

        public final int getButtonText() {
            return this.buttonText;
        }
    }

    private UploadButtonLayout() {
    }

    public /* synthetic */ UploadButtonLayout(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
