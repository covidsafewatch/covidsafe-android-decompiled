package au.gov.health.covidsafe.ui.onboarding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import au.gov.health.covidsafe.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B>\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\t¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R)\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lau/gov/health/covidsafe/ui/onboarding/CountryInitialLetterRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lau/gov/health/covidsafe/ui/onboarding/CountryInitialLetterHolder;", "context", "Landroid/content/Context;", "initialLetters", "", "", "onLetterClicked", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "letter", "", "(Landroid/content/Context;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: CountryInitialLetterRecyclerView.kt */
public final class CountryInitialLetterRecyclerViewAdapter extends RecyclerView.Adapter<CountryInitialLetterHolder> {
    private final Context context;
    private final List<String> initialLetters;
    private final Function1<String, Unit> onLetterClicked;

    public CountryInitialLetterRecyclerViewAdapter(Context context2, List<String> list, Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        Intrinsics.checkParameterIsNotNull(list, "initialLetters");
        Intrinsics.checkParameterIsNotNull(function1, "onLetterClicked");
        this.context = context2;
        this.initialLetters = list;
        this.onLetterClicked = function1;
    }

    public CountryInitialLetterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.view_list_item_country_initial_letter, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "LayoutInflater.from(cont…      false\n            )");
        return new CountryInitialLetterHolder(inflate, this.onLetterClicked);
    }

    public int getItemCount() {
        return this.initialLetters.size();
    }

    public void onBindViewHolder(CountryInitialLetterHolder countryInitialLetterHolder, int i) {
        Intrinsics.checkParameterIsNotNull(countryInitialLetterHolder, "holder");
        countryInitialLetterHolder.setLetter(this.initialLetters.get(i));
    }
}
