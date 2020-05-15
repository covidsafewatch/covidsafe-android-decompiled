package kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: Regex.kt */
final class MatcherMatchResult implements MatchResult {
    private List<String> groupValues_;
    private final MatchGroupCollection groups = new MatcherMatchResult$groups$1(this);
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher matcher2, CharSequence charSequence) {
        Intrinsics.checkParameterIsNotNull(matcher2, "matcher");
        Intrinsics.checkParameterIsNotNull(charSequence, "input");
        this.matcher = matcher2;
        this.input = charSequence;
    }

    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    /* access modifiers changed from: private */
    public final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    public IntRange getRange() {
        return RegexKt.range(getMatchResult());
    }

    public String getValue() {
        String group = getMatchResult().group();
        Intrinsics.checkExpressionValueIsNotNull(group, "matchResult.group()");
        return group;
    }

    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new MatcherMatchResult$groupValues$1(this);
        }
        List<String> list = this.groupValues_;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        return list;
    }

    public MatchResult next() {
        int end = getMatchResult().end() + (getMatchResult().end() == getMatchResult().start() ? 1 : 0);
        if (end > this.input.length()) {
            return null;
        }
        Matcher matcher2 = this.matcher.pattern().matcher(this.input);
        Intrinsics.checkExpressionValueIsNotNull(matcher2, "matcher.pattern().matcher(input)");
        return RegexKt.findNext(matcher2, end, this.input);
    }
}
