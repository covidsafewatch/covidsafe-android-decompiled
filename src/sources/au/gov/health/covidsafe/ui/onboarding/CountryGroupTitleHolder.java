package au.gov.health.covidsafe.ui.onboarding;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/CountryGroupTitleHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "setCountryGroupTitle", "", "title", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryListRecyclerView.kt */
public final class CountryGroupTitleHolder extends RecyclerView.ViewHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountryGroupTitleHolder(View view) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "itemView");
    }

    public final void setCountryGroupTitle(String str) {
        Intrinsics.checkParameterIsNotNull(str, "title");
        View findViewById = this.itemView.findViewById(R.id.country_group_title);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "itemView.findViewById<Te…R.id.country_group_title)");
        ((TextView) findViewById).setText(str);
    }
}
