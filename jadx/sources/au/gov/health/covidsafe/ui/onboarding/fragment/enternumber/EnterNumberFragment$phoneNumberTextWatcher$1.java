package au.gov.health.covidsafe.ui.onboarding.fragment.enternumber;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.widget.EditText;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.TracerApp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"au/gov/health/covidsafe/ui/onboarding/fragment/enternumber/EnterNumberFragment$phoneNumberTextWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: EnterNumberFragment.kt */
public final class EnterNumberFragment$phoneNumberTextWatcher$1 implements TextWatcher {
    final /* synthetic */ EnterNumberFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    EnterNumberFragment$phoneNumberTextWatcher$1(EnterNumberFragment enterNumberFragment) {
        this.this$0 = enterNumberFragment;
    }

    public void afterTextChanged(Editable editable) {
        String obj;
        int integer = TracerApp.Companion.getAppContext().getResources().getInteger(R.integer.australian_phone_number_length);
        EditText editText = (EditText) this.this$0._$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText, "enter_number_phone_number");
        InputFilter[] filters = editText.getFilters();
        if (!(editable == null || (obj = editable.toString()) == null || !StringsKt.startsWith$default(obj, "0", false, 2, (Object) null))) {
            integer++;
        }
        EditText editText2 = (EditText) this.this$0._$_findCachedViewById(R.id.enter_number_phone_number);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "enter_number_phone_number");
        Intrinsics.checkExpressionValueIsNotNull(filters, "filters");
        Collection arrayList = new ArrayList();
        for (InputFilter inputFilter : filters) {
            if (!(inputFilter instanceof InputFilter.LengthFilter)) {
                arrayList.add(inputFilter);
            }
        }
        Object[] array = ((List) arrayList).toArray(new InputFilter[0]);
        if (array != null) {
            editText2.setFilters((InputFilter[]) ArraysKt.plus((T[]) array, new InputFilter.LengthFilter(integer)));
            this.this$0.updateButtonState();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
