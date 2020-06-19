package au.gov.health.covidsafe.ui.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\rH\u0016J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/CountryListRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "context", "Landroid/content/Context;", "countryListItem", "", "Lau/gov/health/covidsafe/ui/onboarding/CountryListItemInterface;", "onCountryClicked", "Lkotlin/Function0;", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function0;)V", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryListRecyclerView.kt */
public final class CountryListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Context context;
    private final List<CountryListItemInterface> countryListItem;
    private final Function0<Unit> onCountryClicked;

    public CountryListRecyclerViewAdapter(Context context2, List<? extends CountryListItemInterface> list, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(list, "countryListItem");
        Intrinsics.checkParameterIsNotNull(function0, "onCountryClicked");
        this.context = context2;
        this.countryListItem = list;
        this.onCountryClicked = function0;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        if (i != 1) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.view_list_item_country, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…lse\n                    )");
            return new CountryListItemHolder(inflate, this.onCountryClicked);
        }
        View inflate2 = LayoutInflater.from(this.context).inflate(R.layout.view_list_item_group_title, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate2, "LayoutInflater.from(cont…lse\n                    )");
        return new CountryGroupTitleHolder(inflate2);
    }

    public int getItemViewType(int i) {
        return this.countryListItem.get(i) instanceof CountryGroupTitle ? 1 : 2;
    }

    public int getItemCount() {
        return this.countryListItem.size();
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        Intrinsics.checkParameterIsNotNull(viewHolder, "holder");
        if (viewHolder instanceof CountryGroupTitleHolder) {
            Context context2 = this.context;
            CountryListItemInterface countryListItemInterface = this.countryListItem.get(i);
            if (countryListItemInterface != null) {
                String string = context2.getString(((CountryGroupTitle) countryListItemInterface).getTitleResId());
                Intrinsics.checkExpressionValueIsNotNull(string, "context.getString((count…ryGroupTitle).titleResId)");
                ((CountryGroupTitleHolder) viewHolder).setCountryGroupTitle(string);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type au.gov.health.covidsafe.ui.onboarding.CountryGroupTitle");
        } else if (viewHolder instanceof CountryListItemHolder) {
            CountryListItemInterface countryListItemInterface2 = this.countryListItem.get(i);
            if (countryListItemInterface2 != null) {
                CountryListItem countryListItem2 = (CountryListItem) countryListItemInterface2;
                String string2 = this.context.getString(countryListItem2.getCountryNameResId());
                Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(countr…istItem.countryNameResId)");
                ((CountryListItemHolder) viewHolder).setCountryListItem(countryListItem2.getCountryNameResId(), string2, countryListItem2.getCallingCode(), countryListItem2.getFlagResID());
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type au.gov.health.covidsafe.ui.onboarding.CountryListItem");
        }
    }
}
