package au.gov.health.covidsafe.ui.home.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import au.gov.health.covidsafe.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lau/gov/health/covidsafe/ui/home/view/ExternalLinkCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: ExternalLinkCard.kt */
public final class ExternalLinkCard extends ConstraintLayout {
    private HashMap _$_findViewCache;

    public ExternalLinkCard(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public ExternalLinkCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

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
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExternalLinkCard(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExternalLinkCard(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_card_external_link_card, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExternalLinkCard);
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "context.obtainStyledAttr…yleable.ExternalLinkCard)");
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        String string = obtainStyledAttributes.getString(3);
        String string2 = obtainStyledAttributes.getString(0);
        int resourceId = obtainStyledAttributes.getResourceId(2, R.color.transparent);
        ((ImageView) _$_findCachedViewById(R.id.external_link_round_image)).setImageDrawable(drawable);
        ((ImageView) _$_findCachedViewById(R.id.external_link_round_image)).setBackgroundResource(resourceId);
        TextView textView = (TextView) _$_findCachedViewById(R.id.external_link_headline);
        Intrinsics.checkExpressionValueIsNotNull(textView, "external_link_headline");
        textView.setText(string);
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.external_link_content);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "external_link_content");
        textView2.setText(string2);
        obtainStyledAttributes.recycle();
    }
}
