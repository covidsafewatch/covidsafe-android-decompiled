package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"get", "VM", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/ViewModelProvider;", "(Landroidx/lifecycle/ViewModelProvider;)Landroidx/lifecycle/ViewModel;", "lifecycle-viewmodel-ktx_release"}, k = 2, mv = {1, 1, 15})
/* compiled from: ViewModelProvider.kt */
public final class ViewModelProviderKt {
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        Intrinsics.checkParameterIsNotNull(viewModelProvider, "$this$get");
        Intrinsics.reifiedOperationMarker(4, "VM");
        VM vm = viewModelProvider.get(ViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(vm, "get(VM::class.java)");
        return vm;
    }
}
