package androidx.navigation.fragment;

import androidx.fragment.app.DialogFragment;
import androidx.navigation.NavDestinationBuilder;
import androidx.navigation.NavDestinationDsl;
import androidx.navigation.fragment.DialogFragmentNavigator.Destination;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/navigation/fragment/DialogFragmentNavigatorDestinationBuilder;", "Landroidx/navigation/NavDestinationBuilder;", "Landroidx/navigation/fragment/DialogFragmentNavigator$Destination;", "navigator", "Landroidx/navigation/fragment/DialogFragmentNavigator;", "id", "", "fragmentClass", "Lkotlin/reflect/KClass;", "Landroidx/fragment/app/DialogFragment;", "(Landroidx/navigation/fragment/DialogFragmentNavigator;ILkotlin/reflect/KClass;)V", "build", "navigation-fragment-ktx_release"}, k = 1, mv = {1, 1, 15})
@NavDestinationDsl
/* compiled from: DialogFragmentNavigatorDestinationBuilder.kt */
public final class DialogFragmentNavigatorDestinationBuilder extends NavDestinationBuilder<Destination> {
    private final KClass<? extends DialogFragment> fragmentClass;

    public DialogFragmentNavigatorDestinationBuilder(DialogFragmentNavigator dialogFragmentNavigator, int i, KClass<? extends DialogFragment> kClass) {
        Intrinsics.checkParameterIsNotNull(dialogFragmentNavigator, "navigator");
        Intrinsics.checkParameterIsNotNull(kClass, "fragmentClass");
        super(dialogFragmentNavigator, i);
        this.fragmentClass = kClass;
    }

    public Destination build() {
        Destination destination = (Destination) super.build();
        destination.setClassName(JvmClassMappingKt.getJavaClass(this.fragmentClass).getName());
        return destination;
    }
}
