package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.view.ViewCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ColorStateListInflaterCompat {
    private ColorStateListInflaterCompat() {
    }

    public static ColorStateList inflate(Resources resources, int i, Resources.Theme theme) {
        try {
            return createFromXml(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList createFromXml(android.content.res.Resources r4, org.xmlpull.v1.XmlPullParser r5, android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x000f
            r3 = 1
            if (r1 == r3) goto L_0x000f
            goto L_0x0004
        L_0x000f:
            if (r1 != r2) goto L_0x0016
            android.content.res.ColorStateList r4 = createFromXmlInner(r4, r5, r0, r6)
            return r4
        L_0x0016:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.createFromXml(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static ColorStateList createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return inflate(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList inflate(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r19
            int r1 = r18.getDepth()
            r2 = 1
            int r1 = r1 + r2
            r3 = 20
            int[][] r4 = new int[r3][]
            int[] r3 = new int[r3]
            r5 = 0
            r6 = 0
        L_0x0010:
            int r7 = r18.next()
            if (r7 == r2) goto L_0x00b1
            int r8 = r18.getDepth()
            if (r8 >= r1) goto L_0x001f
            r9 = 3
            if (r7 == r9) goto L_0x00b1
        L_0x001f:
            r9 = 2
            if (r7 != r9) goto L_0x00aa
            if (r8 > r1) goto L_0x00aa
            java.lang.String r7 = r18.getName()
            java.lang.String r8 = "item"
            boolean r7 = r7.equals(r8)
            if (r7 != 0) goto L_0x0032
            goto L_0x00aa
        L_0x0032:
            int[] r7 = androidx.core.R.styleable.ColorStateListItem
            r8 = r17
            r9 = r20
            android.content.res.TypedArray r7 = obtainAttributes(r8, r9, r0, r7)
            int r10 = androidx.core.R.styleable.ColorStateListItem_android_color
            r11 = -65281(0xffffffffffff00ff, float:NaN)
            int r10 = r7.getColor(r10, r11)
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            boolean r12 = r7.hasValue(r12)
            if (r12 == 0) goto L_0x0056
            int r12 = androidx.core.R.styleable.ColorStateListItem_android_alpha
            float r11 = r7.getFloat(r12, r11)
            goto L_0x0064
        L_0x0056:
            int r12 = androidx.core.R.styleable.ColorStateListItem_alpha
            boolean r12 = r7.hasValue(r12)
            if (r12 == 0) goto L_0x0064
            int r12 = androidx.core.R.styleable.ColorStateListItem_alpha
            float r11 = r7.getFloat(r12, r11)
        L_0x0064:
            r7.recycle()
            int r7 = r19.getAttributeCount()
            int[] r12 = new int[r7]
            r13 = 0
            r14 = 0
        L_0x006f:
            if (r13 >= r7) goto L_0x0094
            int r15 = r0.getAttributeNameResource(r13)
            r2 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r15 == r2) goto L_0x0090
            r2 = 16843551(0x101031f, float:2.3695797E-38)
            if (r15 == r2) goto L_0x0090
            int r2 = androidx.core.R.attr.alpha
            if (r15 == r2) goto L_0x0090
            int r2 = r14 + 1
            boolean r16 = r0.getAttributeBooleanValue(r13, r5)
            if (r16 == 0) goto L_0x008c
            goto L_0x008d
        L_0x008c:
            int r15 = -r15
        L_0x008d:
            r12[r14] = r15
            r14 = r2
        L_0x0090:
            int r13 = r13 + 1
            r2 = 1
            goto L_0x006f
        L_0x0094:
            int[] r2 = android.util.StateSet.trimStateSet(r12, r14)
            int r7 = modulateColorAlpha(r10, r11)
            int[] r3 = androidx.core.content.res.GrowingArrayUtils.append((int[]) r3, (int) r6, (int) r7)
            java.lang.Object[] r2 = androidx.core.content.res.GrowingArrayUtils.append((T[]) r4, (int) r6, r2)
            r4 = r2
            int[][] r4 = (int[][]) r4
            int r6 = r6 + 1
            goto L_0x00ae
        L_0x00aa:
            r8 = r17
            r9 = r20
        L_0x00ae:
            r2 = 1
            goto L_0x0010
        L_0x00b1:
            int[] r0 = new int[r6]
            int[][] r1 = new int[r6][]
            java.lang.System.arraycopy(r3, r5, r0, r5, r6)
            java.lang.System.arraycopy(r4, r5, r1, r5, r6)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ColorStateListInflaterCompat.inflate(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    private static TypedArray obtainAttributes(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    private static int modulateColorAlpha(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (Math.round(((float) Color.alpha(i)) * f) << 24);
    }
}
