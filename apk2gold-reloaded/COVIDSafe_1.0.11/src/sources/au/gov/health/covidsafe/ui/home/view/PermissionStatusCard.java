package au.gov.health.covidsafe.ui.home.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import au.gov.health.covidsafe.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e¨\u0006\u000f"}, d2 = {"Lau/gov/health/covidsafe/ui/home/view/PermissionStatusCard;", "Landroidx/cardview/widget/CardView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "render", "", "text", "", "correct", "", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PermissionStatusCard.kt */
public final class PermissionStatusCard extends CardView {
    private HashMap _$_findViewCache;

    public PermissionStatusCard(Context context) {
        this(context, null, 0, 6, null);
    }

    public PermissionStatusCard(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
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

    public /* synthetic */ PermissionStatusCard(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        this(context, attributeSet, i);
    }

    public PermissionStatusCard(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(R.layout.view_card_permission_card, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PermissionStatusCard);
        Intrinsics.checkExpressionValueIsNotNull(obtainStyledAttributes, "context.obtainStyledAttr…ble.PermissionStatusCard)");
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.permission_title);
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "permission_title");
        appCompatTextView.setText(string);
        setLayoutParams(new LayoutParams(-1, context.getResources().getDimensionPixelSize(R.dimen.permission_height)));
        setCardBackgroundColor(ContextCompat.getColor(context, R.color.white));
        setContentPadding(0, 0, 0, 0);
        setRadius((float) context.getResources().getDimensionPixelSize(R.dimen.card_radius));
        setCardElevation((float) context.getResources().getDimensionPixelSize(R.dimen.card_elevation));
        setUseCompatPadding(true);
    }

    public final void render(String str, boolean z) {
        Intrinsics.checkParameterIsNotNull(str, "text");
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.permission_icon);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "permission_icon");
        imageView.setSelected(z);
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.permission_title);
        Intrinsics.checkExpressionValueIsNotNull(appCompatTextView, "permission_title");
        appCompatTextView.setText(str);
    }
}
