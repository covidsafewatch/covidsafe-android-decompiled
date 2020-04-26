package au.gov.health.covidsafe.ui.view;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import au.gov.health.covidsafe.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u00101\u001a\u00020\u0015*\u00020\u000b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000bH\u0002J\u0018\u00103\u001a\u00020\u0015*\u00020\u000b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000bH\u0002R#\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0010\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b \u0010\u000f\u001a\u0004\b\u001f\u0010\u001cR\u001d\u0010!\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b\"\u0010\u001cR\u001d\u0010$\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b&\u0010\u000f\u001a\u0004\b%\u0010\u001cR\u001d\u0010'\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u000f\u001a\u0004\b(\u0010\u001cR\u001d\u0010*\u001a\u0004\u0018\u00010\u000b8BX\u0002¢\u0006\f\n\u0004\b,\u0010\u000f\u001a\u0004\b+\u0010\u001cR\u0011\u0010-\u001a\u00020.8F¢\u0006\u0006\u001a\u0004\b/\u00100¨\u00065"}, d2 = {"Lau/gov/health/covidsafe/ui/view/PinInputView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allInputs", "", "Landroid/widget/EditText;", "getAllInputs", "()Ljava/util/List;", "allInputs$delegate", "Lkotlin/Lazy;", "isIncomplete", "", "()Z", "onPinChanged", "Lkotlin/Function0;", "", "getOnPinChanged", "()Lkotlin/jvm/functions/Function0;", "setOnPinChanged", "(Lkotlin/jvm/functions/Function0;)V", "pinFive", "getPinFive", "()Landroid/widget/EditText;", "pinFive$delegate", "pinFour", "getPinFour", "pinFour$delegate", "pinOne", "getPinOne", "pinOne$delegate", "pinSix", "getPinSix", "pinSix$delegate", "pinThree", "getPinThree", "pinThree$delegate", "pinTwo", "getPinTwo", "pinTwo$delegate", "value", "", "getValue", "()Ljava/lang/String;", "onDeletePressed", "prev", "onDigitChanged", "next", "app_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: PinInputView.kt */
public final class PinInputView extends ConstraintLayout {
    private HashMap _$_findViewCache;
    private final Lazy allInputs$delegate;
    private Function0<Unit> onPinChanged;
    private final Lazy pinFive$delegate;
    private final Lazy pinFour$delegate;
    private final Lazy pinOne$delegate;
    private final Lazy pinSix$delegate;
    private final Lazy pinThree$delegate;
    private final Lazy pinTwo$delegate;

    public PinInputView(Context context) {
        this(context, null, 0, 6, null);
    }

    public PinInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    private final List<EditText> getAllInputs() {
        return (List) this.allInputs$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditText getPinFive() {
        return (EditText) this.pinFive$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditText getPinFour() {
        return (EditText) this.pinFour$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditText getPinOne() {
        return (EditText) this.pinOne$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditText getPinSix() {
        return (EditText) this.pinSix$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditText getPinThree() {
        return (EditText) this.pinThree$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final EditText getPinTwo() {
        return (EditText) this.pinTwo$delegate.getValue();
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

    public PinInputView(Context context, AttributeSet attributeSet, int i) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super(context, attributeSet, i);
        this.pinOne$delegate = LazyKt.lazy(new PinInputView$pinOne$2(this));
        this.pinTwo$delegate = LazyKt.lazy(new PinInputView$pinTwo$2(this));
        this.pinThree$delegate = LazyKt.lazy(new PinInputView$pinThree$2(this));
        this.pinFour$delegate = LazyKt.lazy(new PinInputView$pinFour$2(this));
        this.pinFive$delegate = LazyKt.lazy(new PinInputView$pinFive$2(this));
        this.pinSix$delegate = LazyKt.lazy(new PinInputView$pinSix$2(this));
        this.allInputs$delegate = LazyKt.lazy(new PinInputView$allInputs$2(this));
        LayoutInflater.from(context).inflate(R.layout.view_pin, this, true);
        EditText pinOne = getPinOne();
        if (pinOne != null) {
            onDigitChanged(pinOne, getPinTwo());
        }
        EditText pinOne2 = getPinOne();
        if (pinOne2 != null) {
            onDeletePressed(pinOne2, null);
        }
        EditText pinTwo = getPinTwo();
        if (pinTwo != null) {
            onDigitChanged(pinTwo, getPinThree());
        }
        EditText pinTwo2 = getPinTwo();
        if (pinTwo2 != null) {
            onDeletePressed(pinTwo2, getPinOne());
        }
        EditText pinThree = getPinThree();
        if (pinThree != null) {
            onDigitChanged(pinThree, getPinFour());
        }
        EditText pinThree2 = getPinThree();
        if (pinThree2 != null) {
            onDeletePressed(pinThree2, getPinTwo());
        }
        EditText pinFour = getPinFour();
        if (pinFour != null) {
            onDigitChanged(pinFour, getPinFive());
        }
        EditText pinFour2 = getPinFour();
        if (pinFour2 != null) {
            onDeletePressed(pinFour2, getPinThree());
        }
        EditText pinFive = getPinFive();
        if (pinFive != null) {
            onDigitChanged(pinFive, getPinSix());
        }
        EditText pinFive2 = getPinFive();
        if (pinFive2 != null) {
            onDeletePressed(pinFive2, getPinFour());
        }
        EditText pinSix = getPinSix();
        if (pinSix != null) {
            onDigitChanged(pinSix, null);
        }
        EditText pinSix2 = getPinSix();
        if (pinSix2 != null) {
            onDeletePressed(pinSix2, getPinFive());
        }
    }

    public /* synthetic */ PinInputView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        this(context, attributeSet, i);
    }

    public final Function0<Unit> getOnPinChanged() {
        return this.onPinChanged;
    }

    public final void setOnPinChanged(Function0<Unit> function0) {
        this.onPinChanged = function0;
    }

    public final String getValue() {
        Editable editable;
        Iterable<EditText> allInputs = getAllInputs();
        Collection arrayList = new ArrayList();
        for (EditText editText : allInputs) {
            if (editText != null) {
                editable = editText.getText();
            } else {
                editable = null;
            }
            if (editable != null) {
                arrayList.add(editable);
            }
        }
        return CollectionsKt.joinToString$default((List) arrayList, "", null, null, 0, null, null, 62, null);
    }

    public final boolean isIncomplete() {
        boolean z;
        Iterable<EditText> allInputs = getAllInputs();
        if (!(allInputs instanceof Collection) || !((Collection) allInputs).isEmpty()) {
            for (EditText editText : allInputs) {
                CharSequence text = editText != null ? editText.getText() : null;
                if (text == null || text.length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    static /* synthetic */ void onDigitChanged$default(PinInputView pinInputView, EditText editText, EditText editText2, int i, Object obj) {
        if ((i & 1) != 0) {
            editText2 = null;
        }
        pinInputView.onDigitChanged(editText, editText2);
    }

    private final void onDigitChanged(EditText editText, EditText editText2) {
        editText.addTextChangedListener(new PinInputView$onDigitChanged$$inlined$doAfterTextChanged$1(this, editText2));
    }

    static /* synthetic */ void onDeletePressed$default(PinInputView pinInputView, EditText editText, EditText editText2, int i, Object obj) {
        if ((i & 1) != 0) {
            editText2 = null;
        }
        pinInputView.onDeletePressed(editText, editText2);
    }

    private final void onDeletePressed(EditText editText, EditText editText2) {
        editText.setOnKeyListener(new PinInputView$onDeletePressed$1(this, editText, editText2));
    }
}
