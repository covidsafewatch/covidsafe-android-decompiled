package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import au.gov.health.covidsafe.R;
import au.gov.health.covidsafe.ui.BaseFragment;
import au.gov.health.covidsafe.ui.PagerChildFragment;
import au.gov.health.covidsafe.ui.UploadButtonLayout;
import au.gov.health.covidsafe.ui.UploadButtonLayout.ContinueLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u001cJ\u000e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J\u0006\u0010,\u001a\u00020\u001cJ\b\u0010-\u001a\u00020\u001cH\u0002J\u0006\u0010.\u001a\u00020\u001cJ\u0006\u0010/\u001a\u00020\u001cJ\u0006\u00100\u001a\u00020\u001cJ\b\u00101\u001a\u00020\u001cH\u0016R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\u000bXD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u0016¨\u00062"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsFragment;", "Lau/gov/health/covidsafe/ui/PagerChildFragment;", "()V", "ageSelected", "Lkotlin/Pair;", "", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "nameTextWatcher", "Landroid/text/TextWatcher;", "navigationIcon", "", "getNavigationIcon", "()Ljava/lang/Integer;", "picker", "Landroid/widget/NumberPicker;", "postCodeTextWatcher", "presenter", "Lau/gov/health/covidsafe/ui/onboarding/fragment/personal/PersonalDetailsPresenter;", "stepProgress", "getStepProgress", "setStepProgress", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMidAgeToSend", "getUploadButtonLayout", "Lau/gov/health/covidsafe/ui/UploadButtonLayout;", "hideAgeError", "", "hideNameError", "hidePostcodeError", "navigateToNextPage", "minor", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "showAgeError", "showAgePicker", "showGenericError", "showNameError", "showPostcodeError", "updateButtonState", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
public final class PersonalDetailsFragment extends PagerChildFragment {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public Pair<String, String> ageSelected;
    private AlertDialog alertDialog;
    private final TextWatcher nameTextWatcher = new PersonalDetailsFragment$nameTextWatcher$1(this);
    private final int navigationIcon = R.drawable.ic_up;
    private NumberPicker picker;
    private final TextWatcher postCodeTextWatcher = new PersonalDetailsFragment$postCodeTextWatcher$1(this);
    /* access modifiers changed from: private */
    public final PersonalDetailsPresenter presenter = new PersonalDetailsPresenter(this);
    private Integer stepProgress = Integer.valueOf(1);

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view == null) {
            View view2 = getView();
            if (view2 == null) {
                return null;
            }
            view = view2.findViewById(i);
            this._$_findViewCache.put(Integer.valueOf(i), view);
        }
        return view;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public Integer getStepProgress() {
        return this.stepProgress;
    }

    public void setStepProgress(Integer num) {
        this.stepProgress = num;
    }

    public Integer getNavigationIcon() {
        return Integer.valueOf(this.navigationIcon);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.fragment_personal_details, viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        ((EditText) _$_findCachedViewById(R.id.personal_details_name)).addTextChangedListener(this.nameTextWatcher);
        ((EditText) _$_findCachedViewById(R.id.personal_details_post_code)).addTextChangedListener(this.postCodeTextWatcher);
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.personal_details_disclaimer);
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "personal_details_disclaimer");
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) _$_findCachedViewById(R.id.personal_details_age)).setOnClickListener(new PersonalDetailsFragment$onResume$1(this));
        TextView textView = (TextView) _$_findCachedViewById(R.id.personal_details_age);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_age");
        Pair<String, String> pair = this.ageSelected;
        textView.setText(pair != null ? (String) pair.getSecond() : null);
    }

    public void onPause() {
        super.onPause();
        ((EditText) _$_findCachedViewById(R.id.personal_details_name)).removeTextChangedListener(this.nameTextWatcher);
        ((EditText) _$_findCachedViewById(R.id.personal_details_post_code)).removeTextChangedListener(this.postCodeTextWatcher);
        ((TextView) _$_findCachedViewById(R.id.personal_details_age)).setOnClickListener(null);
        AlertDialog alertDialog2 = this.alertDialog;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
    }

    public UploadButtonLayout getUploadButtonLayout() {
        return new ContinueLayout(R.string.personal_details_button, new PersonalDetailsFragment$getUploadButtonLayout$1(this));
    }

    public void updateButtonState() {
        PersonalDetailsPresenter personalDetailsPresenter = this.presenter;
        EditText editText = (EditText) _$_findCachedViewById(R.id.personal_details_name);
        Intrinsics.checkExpressionValueIsNotNull(editText, "personal_details_name");
        String obj = editText.getText().toString();
        EditText editText2 = (EditText) _$_findCachedViewById(R.id.personal_details_post_code);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "personal_details_post_code");
        if (personalDetailsPresenter.validateInputsForButtonUpdate(obj, editText2.getText().toString(), getMidAgeToSend())) {
            enableContinueButton();
        } else {
            disableContinueButton();
        }
    }

    public final void showGenericError() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            this.alertDialog = new Builder(activity).setMessage((int) R.string.generic_error).setIcon(17301543).setPositiveButton(17039379, (OnClickListener) null).show();
        }
    }

    public final void navigateToNextPage(boolean z) {
        if (z) {
            BaseFragment.navigateTo$default(this, PersonalDetailsFragmentDirections.Companion.actionPersonalDetailsToUnderSixteenFragment().getActionId(), null, null, 6, null);
            return;
        }
        BaseFragment.navigateTo$default(this, PersonalDetailsFragmentDirections.Companion.actionPersonalDetailsToEnterNumberFragment().getActionId(), BundleKt.bundleOf(TuplesKt.to("destination_id", Integer.valueOf(R.id.action_otpFragment_to_permissionFragment)), TuplesKt.to("progress", Integer.valueOf(2))), null, 4, null);
    }

    public final void showPostcodeError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.personal_details_post_code_error);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_post_code_error");
        textView.setVisibility(0);
    }

    public final void hidePostcodeError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.personal_details_post_code_error);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_post_code_error");
        textView.setVisibility(8);
    }

    public final void showNameError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.personal_details_name_error);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_name_error");
        textView.setVisibility(0);
    }

    public final void hideNameError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.personal_details_name_error);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_name_error");
        textView.setVisibility(8);
    }

    public final void showAgeError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.personal_details_age_error);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_age_error");
        textView.setVisibility(0);
    }

    public final void hideAgeError() {
        TextView textView = (TextView) _$_findCachedViewById(R.id.personal_details_age_error);
        Intrinsics.checkExpressionValueIsNotNull(textView, "personal_details_age_error");
        textView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showAgePicker() {
        Object obj;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            String[] stringArray = getResources().getStringArray(R.array.personal_details_age_array);
            Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…rsonal_details_age_array)");
            Collection arrayList = new ArrayList(stringArray.length);
            for (String str : stringArray) {
                Intrinsics.checkExpressionValueIsNotNull(str, "it");
                List split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
                arrayList.add(TuplesKt.to(split$default.get(0), split$default.get(1)));
            }
            List list = (List) arrayList;
            IntRef intRef = new IntRef();
            Iterable<Pair> iterable = list;
            Iterator it = iterable.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) (Pair) obj, (Object) this.ageSelected)) {
                    break;
                }
            }
            Pair pair = (Pair) obj;
            intRef.element = pair != null ? list.indexOf(pair) : 0;
            Context context = activity;
            NumberPicker numberPicker = new NumberPicker(context);
            this.picker = numberPicker;
            if (numberPicker != null) {
                numberPicker.setMinValue(0);
            }
            NumberPicker numberPicker2 = this.picker;
            if (numberPicker2 != null) {
                numberPicker2.setMaxValue(list.size() - 1);
            }
            NumberPicker numberPicker3 = this.picker;
            if (numberPicker3 != null) {
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Pair second : iterable) {
                    arrayList2.add((String) second.getSecond());
                }
                Object[] array = ((List) arrayList2).toArray(new String[0]);
                if (array != null) {
                    numberPicker3.setDisplayedValues((String[]) array);
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            NumberPicker numberPicker4 = this.picker;
            if (numberPicker4 != null) {
                numberPicker4.setOnValueChangedListener(new PersonalDetailsFragment$showAgePicker$1$2(intRef));
            }
            NumberPicker numberPicker5 = this.picker;
            if (numberPicker5 != null) {
                numberPicker5.setValue(intRef.element);
            }
            AlertDialog alertDialog2 = this.alertDialog;
            if (alertDialog2 != null) {
                alertDialog2.dismiss();
            }
            this.alertDialog = new Builder(context).setTitle((int) R.string.personal_details_age_dialog_title).setView((View) this.picker).setPositiveButton((int) R.string.personal_details_dialog_ok, (OnClickListener) new PersonalDetailsFragment$showAgePicker$$inlined$let$lambda$1(list, intRef, this)).setNegativeButton(17039369, (OnClickListener) null).show();
        }
    }

    /* access modifiers changed from: private */
    public final String getMidAgeToSend() {
        Object obj;
        String[] stringArray = getResources().getStringArray(R.array.personal_details_age_array);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…rsonal_details_age_array)");
        Collection arrayList = new ArrayList(stringArray.length);
        for (String str : stringArray) {
            Intrinsics.checkExpressionValueIsNotNull(str, "it");
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{":"}, false, 0, 6, (Object) null);
            arrayList.add(TuplesKt.to(split$default.get(0), split$default.get(1)));
        }
        List list = (List) arrayList;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) (Pair) obj, (Object) this.ageSelected)) {
                break;
            }
        }
        Pair pair = (Pair) obj;
        Integer valueOf = pair != null ? Integer.valueOf(list.indexOf(pair)) : null;
        if (valueOf == null) {
            return null;
        }
        valueOf.intValue();
        return (String) ((Pair) list.get(valueOf.intValue())).getFirst();
    }
}
