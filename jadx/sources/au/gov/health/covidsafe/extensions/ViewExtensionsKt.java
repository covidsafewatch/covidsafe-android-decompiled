package au.gov.health.covidsafe.extensions;

import android.text.SpannableString;
import android.text.style.URLSpan;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import au.gov.health.covidsafe.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
    bv = {1, 0, 3},
    d1 =
        {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\u0007"},
    d2 = {"toHyperlink", "", "Landroid/widget/TextView;", "textToHyperLink", "",
          "onClick", "Lkotlin/Function0;", "app_release"},
    k = 2, mv = {1, 1, 16})
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
  public static /* synthetic */ void toHyperlink$default(TextView textView,
                                                         String str,
                                                         Function0 function0,
                                                         int i, Object obj) {
    if ((i & 1) != 0) {
      str = null;
    }
    toHyperlink(textView, str, function0);
  }

  public static final void toHyperlink(TextView textView, String str,
                                       Function0<Unit> function0) {
    int i;
    int i2;
    Intrinsics.checkParameterIsNotNull(textView, "$this$toHyperlink");
    Intrinsics.checkParameterIsNotNull(function0, "onClick");
    CharSequence text = textView.getText();
    SpannableString spannableString = new SpannableString(text);
    CharSequence charSequence = str;
    boolean z = true;
    if (charSequence == null || charSequence.length() == 0) {
      i = 0;
    } else {
      Intrinsics.checkExpressionValueIsNotNull(text, "text");
      i = StringsKt.indexOf$default(text, str, 0, false, 6, (Object)null);
    }
    if (!(charSequence == null || charSequence.length() == 0)) {
      z = false;
    }
    if (z) {
      i2 = spannableString.length();
    } else {
      Intrinsics.checkExpressionValueIsNotNull(text, "text");
      i2 = str.length() +
           StringsKt.indexOf$default(text, str, 0, false, 6, (Object)null);
    }
    spannableString.setSpan(new URLSpan(""), i, i2, 33);
    textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    textView.setLinkTextColor(
        ContextCompat.getColor(textView.getContext(), R.color.dark_green));
    textView.setOnClickListener(new ViewExtensionsKt$toHyperlink$1(function0));
  }
}
