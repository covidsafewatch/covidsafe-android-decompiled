package androidx.navigation;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class NavDeepLink {
    private static final Pattern SCHEME_PATTERN = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");
    private final ArrayList<String> mArguments = new ArrayList<>();
    private final boolean mExactDeepLink;
    private final boolean mIsParameterizedQuery;
    private final Map<String, ParamQuery> mParamArgMap = new HashMap();
    private final Pattern mPattern;

    private static class ParamQuery {
        private ArrayList<String> mArguments = new ArrayList<>();
        private String mParamRegex;

        ParamQuery() {
        }

        /* access modifiers changed from: 0000 */
        public void setParamRegex(String str) {
            this.mParamRegex = str;
        }

        /* access modifiers changed from: 0000 */
        public String getParamRegex() {
            return this.mParamRegex;
        }

        /* access modifiers changed from: 0000 */
        public void addArgumentName(String str) {
            this.mArguments.add(str);
        }

        /* access modifiers changed from: 0000 */
        public String getArgumentName(int i) {
            return (String) this.mArguments.get(i);
        }

        public int size() {
            return this.mArguments.size();
        }
    }

    NavDeepLink(String str) {
        Uri parse = Uri.parse(str);
        this.mIsParameterizedQuery = parse.getQuery() != null;
        StringBuilder sb = new StringBuilder("^");
        if (!SCHEME_PATTERN.matcher(str).find()) {
            sb.append("http[s]?://");
        }
        Pattern compile = Pattern.compile("\\{(.+?)\\}");
        String str2 = "\\E.*\\Q";
        String str3 = ".*";
        if (this.mIsParameterizedQuery) {
            Matcher matcher = Pattern.compile("(\\?)").matcher(str);
            if (matcher.find()) {
                buildPathRegex(str.substring(0, matcher.start()), sb, compile);
            }
            this.mExactDeepLink = false;
            for (String str4 : parse.getQueryParameterNames()) {
                StringBuilder sb2 = new StringBuilder();
                String queryParameter = parse.getQueryParameter(str4);
                Matcher matcher2 = compile.matcher(queryParameter);
                ParamQuery paramQuery = new ParamQuery();
                int i = 0;
                while (matcher2.find()) {
                    paramQuery.addArgumentName(matcher2.group(1));
                    sb2.append(Pattern.quote(queryParameter.substring(i, matcher2.start())));
                    sb2.append("(.+?)?");
                    i = matcher2.end();
                }
                if (i < queryParameter.length()) {
                    sb2.append(Pattern.quote(queryParameter.substring(i)));
                }
                paramQuery.setParamRegex(sb2.toString().replace(str3, str2));
                this.mParamArgMap.put(str4, paramQuery);
            }
        } else {
            this.mExactDeepLink = buildPathRegex(str, sb, compile);
        }
        this.mPattern = Pattern.compile(sb.toString().replace(str3, str2));
    }

    private boolean buildPathRegex(String str, StringBuilder sb, Pattern pattern) {
        Matcher matcher = pattern.matcher(str);
        boolean z = !str.contains(".*");
        int i = 0;
        while (matcher.find()) {
            this.mArguments.add(matcher.group(1));
            sb.append(Pattern.quote(str.substring(i, matcher.start())));
            sb.append("(.+?)");
            i = matcher.end();
            z = false;
        }
        if (i < str.length()) {
            sb.append(Pattern.quote(str.substring(i)));
        }
        sb.append("($|(\\?(.)*))");
        return z;
    }

    /* access modifiers changed from: 0000 */
    public boolean matches(Uri uri) {
        return this.mPattern.matcher(uri.toString()).matches();
    }

    /* access modifiers changed from: 0000 */
    public boolean isExactDeepLink() {
        return this.mExactDeepLink;
    }

    /* access modifiers changed from: 0000 */
    public Bundle getMatchingArguments(Uri uri, Map<String, NavArgument> map) {
        Matcher matcher;
        Matcher matcher2 = this.mPattern.matcher(uri.toString());
        if (!matcher2.matches()) {
            return null;
        }
        Bundle bundle = new Bundle();
        int size = this.mArguments.size();
        int i = 0;
        while (i < size) {
            String str = (String) this.mArguments.get(i);
            i++;
            if (parseArgument(bundle, str, Uri.decode(matcher2.group(i)), (NavArgument) map.get(str))) {
                return null;
            }
        }
        if (this.mIsParameterizedQuery) {
            for (String str2 : this.mParamArgMap.keySet()) {
                ParamQuery paramQuery = (ParamQuery) this.mParamArgMap.get(str2);
                String queryParameter = uri.getQueryParameter(str2);
                if (queryParameter != null) {
                    matcher = Pattern.compile(paramQuery.getParamRegex()).matcher(queryParameter);
                    if (!matcher.matches()) {
                        return null;
                    }
                } else {
                    matcher = null;
                }
                int i2 = 0;
                while (true) {
                    if (i2 < paramQuery.size()) {
                        String decode = matcher != null ? Uri.decode(matcher.group(i2 + 1)) : null;
                        String argumentName = paramQuery.getArgumentName(i2);
                        NavArgument navArgument = (NavArgument) map.get(argumentName);
                        if (navArgument != null && (decode == null || decode.replaceAll("[{}]", "").equals(argumentName))) {
                            if (navArgument.getDefaultValue() != null) {
                                decode = navArgument.getDefaultValue().toString();
                            } else if (navArgument.isNullable()) {
                                decode = null;
                            }
                        }
                        if (parseArgument(bundle, argumentName, decode, navArgument)) {
                            return null;
                        }
                        i2++;
                    }
                }
            }
        }
        return bundle;
    }

    private boolean parseArgument(Bundle bundle, String str, String str2, NavArgument navArgument) {
        if (navArgument != null) {
            try {
                navArgument.getType().parseAndPut(bundle, str, str2);
            } catch (IllegalArgumentException unused) {
                return true;
            }
        } else {
            bundle.putString(str, str2);
        }
        return false;
    }
}
