package au.gov.health.covidsafe.ui.onboarding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J&\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tR\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/CountryListItemHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "onCountryClicked", "Lkotlin/Function0;", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "callingCode", "", "countryNameResId", "flagResID", "setCountryListItem", "countryName", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryListRecyclerView.kt */
public final class CountryListItemHolder extends RecyclerView.ViewHolder {
    private int callingCode;
    private int countryNameResId;
    private int flagResID;
    /* access modifiers changed from: private */
    public final Function0<Unit> onCountryClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryListItemHolder(View view, Function0<Unit> function0) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "itemView");
        Intrinsics.checkParameterIsNotNull(function0, "onCountryClicked");
        this.onCountryClicked = function0;
    }

    public final void setCountryListItem(int i, String str, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(str, "countryName");
        this.countryNameResId = i;
        this.callingCode = i2;
        this.flagResID = i3;
        View findViewById = this.itemView.findViewById(R.id.country_list_name);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById<Te…>(R.id.country_list_name)");
        ((TextView) findViewById).setText(str);
        View findViewById2 = this.itemView.findViewById(R.id.country_list_calling_code);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "itemView.findViewById<Te…ountry_list_calling_code)");
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        sb.append(i2);
        ((TextView) findViewById2).setText(sb.toString());
        ((ImageView) this.itemView.findViewById(R.id.country_list_flag)).setImageResource(i3);
        this.itemView.findViewById(R.id.country_list_item).setOnClickListener(new CountryListItemHolder$setCountryListItem$1(this, i, i2, i3));
    }
}
