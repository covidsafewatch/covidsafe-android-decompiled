package au.gov.health.covidsafe.ui.onboarding.fragment.personal;

import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0003"}, d2 = {"POST_CODE_REGEX", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "app_release"}, k = 2, mv = {1, 1, 16})
/* compiled from: PersonalDetailsFragment.kt */
public final class PersonalDetailsFragmentKt {
    /* access modifiers changed from: private */
    public static final Pattern POST_CODE_REGEX = Pattern.compile("^(?:(?:[2-8]\\d|9[0-7]|0?[28]|0?9(?=09))(?:\\d{2}))$");
}
