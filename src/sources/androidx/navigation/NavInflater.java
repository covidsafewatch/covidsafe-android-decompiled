package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.navigation.NavArgument;
import androidx.navigation.NavOptions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class NavInflater {
    static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private static final ThreadLocal<TypedValue> sTmpValue = new ThreadLocal<>();
    private Context mContext;
    private NavigatorProvider mNavigatorProvider;

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        this.mContext = context;
        this.mNavigatorProvider = navigatorProvider;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0049 A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b A[Catch:{ Exception -> 0x0053, all -> 0x0051 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.navigation.NavGraph inflate(int r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.mContext
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.XmlResourceParser r1 = r0.getXml(r7)
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r1)
        L_0x000e:
            int r3 = r1.next()     // Catch:{ Exception -> 0x0053 }
            r4 = 2
            if (r3 == r4) goto L_0x0019
            r5 = 1
            if (r3 == r5) goto L_0x0019
            goto L_0x000e
        L_0x0019:
            if (r3 != r4) goto L_0x0049
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x0053 }
            androidx.navigation.NavDestination r2 = r6.inflate(r0, r1, r2, r7)     // Catch:{ Exception -> 0x0053 }
            boolean r4 = r2 instanceof androidx.navigation.NavGraph     // Catch:{ Exception -> 0x0053 }
            if (r4 == 0) goto L_0x002d
            androidx.navigation.NavGraph r2 = (androidx.navigation.NavGraph) r2     // Catch:{ Exception -> 0x0053 }
            r1.close()
            return r2
        L_0x002d:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0053 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0053 }
            r4.<init>()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r5 = "Root element <"
            r4.append(r5)     // Catch:{ Exception -> 0x0053 }
            r4.append(r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "> did not inflate into a NavGraph"
            r4.append(r3)     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = r4.toString()     // Catch:{ Exception -> 0x0053 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            throw r2     // Catch:{ Exception -> 0x0053 }
        L_0x0049:
            org.xmlpull.v1.XmlPullParserException r2 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x0053 }
            java.lang.String r3 = "No start tag found"
            r2.<init>(r3)     // Catch:{ Exception -> 0x0053 }
            throw r2     // Catch:{ Exception -> 0x0053 }
        L_0x0051:
            r7 = move-exception
            goto L_0x007b
        L_0x0053:
            r2 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "Exception inflating "
            r4.append(r5)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r0.getResourceName(r7)     // Catch:{ all -> 0x0051 }
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = " line "
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            int r7 = r1.getLineNumber()     // Catch:{ all -> 0x0051 }
            r4.append(r7)     // Catch:{ all -> 0x0051 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0051 }
            r3.<init>(r7, r2)     // Catch:{ all -> 0x0051 }
            throw r3     // Catch:{ all -> 0x0051 }
        L_0x007b:
            r1.close()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.navigation.NavInflater.inflate(int):androidx.navigation.NavGraph");
    }

    private NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i) throws XmlPullParserException, IOException {
        int depth;
        NavDestination createDestination = this.mNavigatorProvider.getNavigator(xmlResourceParser.getName()).createDestination();
        createDestination.onInflate(this.mContext, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                return createDestination;
            }
            if (next == 2 && depth <= depth2) {
                String name = xmlResourceParser.getName();
                if (TAG_ARGUMENT.equals(name)) {
                    inflateArgumentForDestination(resources, createDestination, attributeSet, i);
                } else if (TAG_DEEP_LINK.equals(name)) {
                    inflateDeepLink(resources, createDestination, attributeSet);
                } else if (TAG_ACTION.equals(name)) {
                    inflateAction(resources, createDestination, attributeSet, xmlResourceParser, i);
                } else if (TAG_INCLUDE.equals(name) && (createDestination instanceof NavGraph)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavInclude);
                    ((NavGraph) createDestination).addDestination(inflate(obtainAttributes.getResourceId(R.styleable.NavInclude_graph, 0)));
                    obtainAttributes.recycle();
                } else if (createDestination instanceof NavGraph) {
                    ((NavGraph) createDestination).addDestination(inflate(resources, xmlResourceParser, attributeSet, i));
                }
            }
        }
        return createDestination;
    }

    private void inflateArgumentForDestination(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string != null) {
            navDestination.addArgument(string, inflateArgument(obtainAttributes, resources, i));
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private void inflateArgumentForBundle(Resources resources, Bundle bundle, AttributeSet attributeSet, int i) throws XmlPullParserException {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavArgument);
        String string = obtainAttributes.getString(R.styleable.NavArgument_android_name);
        if (string != null) {
            NavArgument inflateArgument = inflateArgument(obtainAttributes, resources, i);
            if (inflateArgument.isDefaultValuePresent()) {
                inflateArgument.putDefaultValue(string, bundle);
            }
            obtainAttributes.recycle();
            return;
        }
        throw new XmlPullParserException("Arguments must have a name");
    }

    private NavArgument inflateArgument(TypedArray typedArray, Resources resources, int i) throws XmlPullParserException {
        NavArgument.Builder builder = new NavArgument.Builder();
        boolean z = false;
        builder.setIsNullable(typedArray.getBoolean(R.styleable.NavArgument_nullable, false));
        TypedValue typedValue = sTmpValue.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            sTmpValue.set(typedValue);
        }
        String string = typedArray.getString(R.styleable.NavArgument_argType);
        int i2 = null;
        NavType fromArgType = string != null ? NavType.fromArgType(string, resources.getResourcePackageName(i)) : null;
        if (typedArray.getValue(R.styleable.NavArgument_android_defaultValue, typedValue)) {
            if (fromArgType == NavType.ReferenceType) {
                if (typedValue.resourceId != 0) {
                    i2 = Integer.valueOf(typedValue.resourceId);
                } else if (typedValue.type == 16 && typedValue.data == 0) {
                    i2 = 0;
                } else {
                    throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + fromArgType.getName() + ". Must be a reference to a resource.");
                }
            } else if (typedValue.resourceId != 0) {
                if (fromArgType == null) {
                    fromArgType = NavType.ReferenceType;
                    i2 = Integer.valueOf(typedValue.resourceId);
                } else {
                    throw new XmlPullParserException("unsupported value '" + typedValue.string + "' for " + fromArgType.getName() + ". You must use a \"" + NavType.ReferenceType.getName() + "\" type to reference other resources.");
                }
            } else if (fromArgType == NavType.StringType) {
                i2 = typedArray.getString(R.styleable.NavArgument_android_defaultValue);
            } else {
                int i3 = typedValue.type;
                if (i3 == 3) {
                    String charSequence = typedValue.string.toString();
                    if (fromArgType == null) {
                        fromArgType = NavType.inferFromValue(charSequence);
                    }
                    i2 = fromArgType.parseValue(charSequence);
                } else if (i3 == 4) {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.FloatType, string, "float");
                    i2 = Float.valueOf(typedValue.getFloat());
                } else if (i3 == 5) {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.IntType, string, "dimension");
                    i2 = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                } else if (i3 == 18) {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.BoolType, string, "boolean");
                    if (typedValue.data != 0) {
                        z = true;
                    }
                    i2 = Boolean.valueOf(z);
                } else if (typedValue.type < 16 || typedValue.type > 31) {
                    throw new XmlPullParserException("unsupported argument type " + typedValue.type);
                } else {
                    fromArgType = checkNavType(typedValue, fromArgType, NavType.IntType, string, "integer");
                    i2 = Integer.valueOf(typedValue.data);
                }
            }
        }
        if (i2 != null) {
            builder.setDefaultValue(i2);
        }
        if (fromArgType != null) {
            builder.setType(fromArgType);
        }
        return builder.build();
    }

    private static NavType checkNavType(TypedValue typedValue, NavType navType, NavType navType2, String str, String str2) throws XmlPullParserException {
        if (navType == null || navType == navType2) {
            return navType != null ? navType : navType2;
        }
        throw new XmlPullParserException("Type is " + str + " but found " + str2 + ": " + typedValue.data);
    }

    private void inflateDeepLink(Resources resources, NavDestination navDestination, AttributeSet attributeSet) {
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavDeepLink);
        String string = obtainAttributes.getString(R.styleable.NavDeepLink_uri);
        if (!TextUtils.isEmpty(string)) {
            navDestination.addDeepLink(string.replace(APPLICATION_ID_PLACEHOLDER, this.mContext.getPackageName()));
            obtainAttributes.recycle();
            return;
        }
        throw new IllegalArgumentException("Every <deepLink> must include an app:uri");
    }

    private void inflateAction(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i) throws IOException, XmlPullParserException {
        int depth;
        TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, R.styleable.NavAction);
        int resourceId = obtainAttributes.getResourceId(R.styleable.NavAction_android_id, 0);
        NavAction navAction = new NavAction(obtainAttributes.getResourceId(R.styleable.NavAction_destination, 0));
        NavOptions.Builder builder = new NavOptions.Builder();
        builder.setLaunchSingleTop(obtainAttributes.getBoolean(R.styleable.NavAction_launchSingleTop, false));
        builder.setPopUpTo(obtainAttributes.getResourceId(R.styleable.NavAction_popUpTo, -1), obtainAttributes.getBoolean(R.styleable.NavAction_popUpToInclusive, false));
        builder.setEnterAnim(obtainAttributes.getResourceId(R.styleable.NavAction_enterAnim, -1));
        builder.setExitAnim(obtainAttributes.getResourceId(R.styleable.NavAction_exitAnim, -1));
        builder.setPopEnterAnim(obtainAttributes.getResourceId(R.styleable.NavAction_popEnterAnim, -1));
        builder.setPopExitAnim(obtainAttributes.getResourceId(R.styleable.NavAction_popExitAnim, -1));
        navAction.setNavOptions(builder.build());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next != 1 && ((depth = xmlResourceParser.getDepth()) >= depth2 || next != 3)) {
                if (next == 2 && depth <= depth2 && TAG_ARGUMENT.equals(xmlResourceParser.getName())) {
                    inflateArgumentForBundle(resources, bundle, attributeSet, i);
                }
            }
        }
        if (!bundle.isEmpty()) {
            navAction.setDefaultArguments(bundle);
        }
        navDestination.putAction(resourceId, navAction);
        obtainAttributes.recycle();
    }
}
