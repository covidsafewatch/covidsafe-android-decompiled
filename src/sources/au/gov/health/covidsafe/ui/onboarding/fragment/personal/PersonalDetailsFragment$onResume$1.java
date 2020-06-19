package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.NumberPicker;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"showAgePicker", "", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
final class PersonalDetailsFragment$onResume$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PersonalDetailsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalDetailsFragment$onResume$1(PersonalDetailsFragment personalDetailsFragment) {
        super(0);
        this.this$0 = personalDetailsFragment;
    }

    public final void invoke() {
        Object obj;
        FragmentActivity activity = this.this$0.getActivity();
        if (activity != null) {
            String[] stringArray = this.this$0.getResources().getStringArray(R.array.personal_details_age_array);
            Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…rsonal_details_age_array)");
            Collection arrayList = new ArrayList(stringArray.length);
            for (String str : stringArray) {
                Intrinsics.checkExpressionValueIsNotNull(str, "it");
                List split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
                arrayList.add(TuplesKt.to(Integer.valueOf(Integer.parseInt((String) split$default.get(0))), split$default.get(1)));
            }
            List list = (List) arrayList;
            Ref.IntRef intRef = new Ref.IntRef();
            Iterable<Pair> iterable = list;
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) (Pair) obj, (Object) this.this$0.ageSelected)) {
                    break;
                }
            }
            Pair pair = (Pair) obj;
            intRef.element = pair != null ? list.indexOf(pair) : 0;
            Context context = activity;
            this.this$0.picker = new NumberPicker(context);
            NumberPicker access$getPicker$p = this.this$0.picker;
            if (access$getPicker$p != null) {
                access$getPicker$p.setMinValue(0);
            }
            NumberPicker access$getPicker$p2 = this.this$0.picker;
            if (access$getPicker$p2 != null) {
                access$getPicker$p2.setMaxValue(list.size() - 1);
            }
            NumberPicker access$getPicker$p3 = this.this$0.picker;
            if (access$getPicker$p3 != null) {
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Pair second : iterable) {
                    arrayList2.add((String) second.getSecond());
                }
                Object[] array = ((List) arrayList2).toArray(new String[0]);
                if (array != null) {
                    access$getPicker$p3.setDisplayedValues((String[]) array);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            NumberPicker access$getPicker$p4 = this.this$0.picker;
            if (access$getPicker$p4 != null) {
                access$getPicker$p4.setOnValueChangedListener(new PersonalDetailsFragment$onResume$1$1$2(intRef));
            }
            NumberPicker access$getPicker$p5 = this.this$0.picker;
            if (access$getPicker$p5 != null) {
                access$getPicker$p5.setValue(intRef.element);
            }
            AlertDialog access$getAlertDialog$p = this.this$0.alertDialog;
            if (access$getAlertDialog$p != null) {
                access$getAlertDialog$p.dismiss();
            }
            this.this$0.alertDialog = new AlertDialog.Builder(context).setTitle((int) R.string.personal_details_age_dialog_title).setView((View) this.this$0.picker).setPositiveButton((int) R.string.personal_details_dialog_ok, (DialogInterface.OnClickListener) new PersonalDetailsFragment$onResume$1$showAgePicker$$inlined$let$lambda$1(list, intRef, this)).setNegativeButton(17039369, (DialogInterface.OnClickListener) null).show();
        }
    }
}
