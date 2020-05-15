package com.github.razir.progressbutton;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J2\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/github/razir/progressbutton/AllCapsSpannedTransformationMethod;", "Landroid/text/method/TransformationMethod;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "locale", "Ljava/util/Locale;", "getTransformation", "", "source", "view", "Landroid/view/View;", "onFocusChanged", "", "sourceText", "focused", "", "direction", "", "previouslyFocusedRect", "Landroid/graphics/Rect;", "progressbutton_release"}, k = 1, mv = {1, 1, 16})
/* compiled from: AllCapsSpannedTransformationMethod.kt */
public final class AllCapsSpannedTransformationMethod implements TransformationMethod {
    private final Locale locale;

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        Intrinsics.checkParameterIsNotNull(charSequence, "sourceText");
    }

    public AllCapsSpannedTransformationMethod(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        this.locale = resources.getConfiguration().locale;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        Intrinsics.checkParameterIsNotNull(view, "view");
        if (charSequence == null) {
            return null;
        }
        String obj = charSequence.toString();
        Locale locale2 = this.locale;
        if (locale2 == null) {
            locale2 = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.getDefault()");
        }
        if (obj != null) {
            String upperCase = obj.toUpperCase(locale2);
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            if (!(charSequence instanceof Spanned)) {
                return upperCase;
            }
            SpannableString spannableString = new SpannableString(upperCase);
            TextUtils.copySpansFrom((Spanned) charSequence, 0, charSequence.length(), (Class) null, spannableString, 0);
            return spannableString;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
}
