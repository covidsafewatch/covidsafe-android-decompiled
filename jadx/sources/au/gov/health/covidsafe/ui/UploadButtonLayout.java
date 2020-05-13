package au.gov.health.covidsafe.ui;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "", "()V", "ContinueLayout", "QuestionLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$ContinueLayout;", "Lau/gov/health/covidsafe/ui/UploadButtonLayout$QuestionLayout;", "app_release"}, k = 1, mv = {1, 1, 16})
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

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lau/gov/health/covidsafe/ui/UploadButtonLayout$QuestionLayout;", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "buttonYesListener", "Lkotlin/Function0;", "", "buttonNoListener", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getButtonNoListener", "()Lkotlin/jvm/functions/Function0;", "getButtonYesListener", "app_release"}, k = 1, mv = {1, 1, 16})
    /* compiled from: PagerChildFragment.kt */
    public static final class QuestionLayout extends UploadButtonLayout {
        private final Function0<Unit> buttonNoListener;
        private final Function0<Unit> buttonYesListener;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public QuestionLayout(Function0<Unit> function0, Function0<Unit> function02) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkParameterIsNotNull(function0, "buttonYesListener");
            Intrinsics.checkParameterIsNotNull(function02, "buttonNoListener");
            this.buttonYesListener = function0;
            this.buttonNoListener = function02;
        }

        public final Function0<Unit> getButtonNoListener() {
            return this.buttonNoListener;
        }

        public final Function0<Unit> getButtonYesListener() {
            return this.buttonYesListener;
        }
    }
}
