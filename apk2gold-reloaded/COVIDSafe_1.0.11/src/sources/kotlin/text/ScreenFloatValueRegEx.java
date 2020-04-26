package kotlin.text;

import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/text/ScreenFloatValueRegEx;", "", "()V", "value", "Lkotlin/text/Regex;", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: StringNumberConversionsJVM.kt */
final class ScreenFloatValueRegEx {
    public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
    public static final Regex value;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        String str = "(\\p{Digit}+)";
        sb.append(str);
        sb.append("(\\.)?(");
        sb.append(str);
        sb.append("?)(");
        String str2 = "[eE][+-]?(\\p{Digit}+)";
        sb.append(str2);
        String str3 = ")?)|";
        sb.append(str3);
        sb.append("(\\.(");
        sb.append(str);
        sb.append(")(");
        sb.append(str2);
        sb.append(str3);
        sb.append("((");
        sb.append("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))");
        sb.append(")[pP][+-]?");
        sb.append(str);
        sb.append(')');
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("[\\x00-\\x20]*[+-]?(NaN|Infinity|((");
        sb3.append(sb2);
        sb3.append(")[fFdD]?))[\\x00-\\x20]*");
        value = new Regex(sb3.toString());
    }

    private ScreenFloatValueRegEx() {
    }
}
