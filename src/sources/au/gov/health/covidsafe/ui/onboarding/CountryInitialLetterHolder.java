package au.gov.health.covidsafe.ui.onboarding;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/CountryInitialLetterHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onLetterClicked", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "letter", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "setLetter", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryInitialLetterRecyclerView.kt */
public final class CountryInitialLetterHolder extends RecyclerView.ViewHolder {
    /* access modifiers changed from: private */
    public final Function1<String, Unit> onLetterClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryInitialLetterHolder(View view, Function1<? super String, Unit> function1) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(function1, "onLetterClicked");
        this.onLetterClicked = function1;
    }

    public final void setLetter(String str) {
        Intrinsics.checkParameterIsNotNull(str, "letter");
        TextView textView = (TextView) this.itemView.findViewById(R.id.country_initial_letter);
        Intrinsics.checkExpressionValueIsNotNull(textView, "letterTextView");
        textView.setText(str);
        textView.setOnClickListener(new CountryInitialLetterHolder$setLetter$1(this, str));
    }
}
