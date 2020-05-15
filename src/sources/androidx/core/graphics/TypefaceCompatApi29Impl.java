package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;
import java.io.InputStream;

public class TypefaceCompatApi29Impl extends TypefaceCompatBaseImpl {
    /* access modifiers changed from: protected */
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* access modifiers changed from: protected */
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0057, code lost:
        if (r7 != null) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r7.close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Typeface createFromFontInfo(android.content.Context r11, android.os.CancellationSignal r12, androidx.core.provider.FontsContractCompat.FontInfo[] r13, int r14) {
        /*
            r10 = this;
            android.content.ContentResolver r11 = r11.getContentResolver()
            int r0 = r13.length
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = r2
        L_0x0009:
            r5 = 1
            if (r3 >= r0) goto L_0x0065
            r6 = r13[r3]
            android.net.Uri r7 = r6.getUri()     // Catch:{ IOException -> 0x0062 }
            java.lang.String r8 = "r"
            android.os.ParcelFileDescriptor r7 = r11.openFileDescriptor(r7, r8, r12)     // Catch:{ IOException -> 0x0062 }
            if (r7 != 0) goto L_0x0020
            if (r7 == 0) goto L_0x0062
        L_0x001c:
            r7.close()     // Catch:{ IOException -> 0x0062 }
            goto L_0x0062
        L_0x0020:
            android.graphics.fonts.Font$Builder r8 = new android.graphics.fonts.Font$Builder     // Catch:{ all -> 0x0054 }
            r8.<init>(r7)     // Catch:{ all -> 0x0054 }
            int r9 = r6.getWeight()     // Catch:{ all -> 0x0054 }
            android.graphics.fonts.Font$Builder r8 = r8.setWeight(r9)     // Catch:{ all -> 0x0054 }
            boolean r9 = r6.isItalic()     // Catch:{ all -> 0x0054 }
            if (r9 == 0) goto L_0x0034
            goto L_0x0035
        L_0x0034:
            r5 = r2
        L_0x0035:
            android.graphics.fonts.Font$Builder r5 = r8.setSlant(r5)     // Catch:{ all -> 0x0054 }
            int r6 = r6.getTtcIndex()     // Catch:{ all -> 0x0054 }
            android.graphics.fonts.Font$Builder r5 = r5.setTtcIndex(r6)     // Catch:{ all -> 0x0054 }
            android.graphics.fonts.Font r5 = r5.build()     // Catch:{ all -> 0x0054 }
            if (r4 != 0) goto L_0x004e
            android.graphics.fonts.FontFamily$Builder r6 = new android.graphics.fonts.FontFamily$Builder     // Catch:{ all -> 0x0054 }
            r6.<init>(r5)     // Catch:{ all -> 0x0054 }
            r4 = r6
            goto L_0x0051
        L_0x004e:
            r4.addFont(r5)     // Catch:{ all -> 0x0054 }
        L_0x0051:
            if (r7 == 0) goto L_0x0062
            goto L_0x001c
        L_0x0054:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r6 = move-exception
            if (r7 == 0) goto L_0x0061
            r7.close()     // Catch:{ all -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r7 = move-exception
            r5.addSuppressed(r7)     // Catch:{ IOException -> 0x0062 }
        L_0x0061:
            throw r6     // Catch:{ IOException -> 0x0062 }
        L_0x0062:
            int r3 = r3 + 1
            goto L_0x0009
        L_0x0065:
            if (r4 != 0) goto L_0x0068
            return r1
        L_0x0068:
            android.graphics.fonts.FontStyle r11 = new android.graphics.fonts.FontStyle
            r12 = r14 & 1
            if (r12 == 0) goto L_0x0071
            r12 = 700(0x2bc, float:9.81E-43)
            goto L_0x0073
        L_0x0071:
            r12 = 400(0x190, float:5.6E-43)
        L_0x0073:
            r13 = r14 & 2
            if (r13 == 0) goto L_0x0078
            r2 = r5
        L_0x0078:
            r11.<init>(r12, r2)
            android.graphics.Typeface$CustomFallbackBuilder r12 = new android.graphics.Typeface$CustomFallbackBuilder
            android.graphics.fonts.FontFamily r13 = r4.build()
            r12.<init>(r13)
            android.graphics.Typeface$CustomFallbackBuilder r11 = r12.setStyle(r11)
            android.graphics.Typeface r11 = r11.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.TypefaceCompatApi29Impl.createFromFontInfo(android.content.Context, android.os.CancellationSignal, androidx.core.provider.FontsContractCompat$FontInfo[], int):android.graphics.Typeface");
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        int i2 = 0;
        FontFamily.Builder builder = null;
        int i3 = 0;
        while (true) {
            int i4 = 1;
            if (i3 >= length) {
                break;
            }
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i3];
            try {
                Font.Builder weight = new Font.Builder(resources, fontFileResourceEntry.getResourceId()).setWeight(fontFileResourceEntry.getWeight());
                if (!fontFileResourceEntry.isItalic()) {
                    i4 = 0;
                }
                Font build = weight.setSlant(i4).setTtcIndex(fontFileResourceEntry.getTtcIndex()).setFontVariationSettings(fontFileResourceEntry.getVariationSettings()).build();
                if (builder == null) {
                    builder = new FontFamily.Builder(build);
                } else {
                    builder.addFont(build);
                }
            } catch (IOException unused) {
            }
            i3++;
        }
        if (builder == null) {
            return null;
        }
        int i5 = (i & 1) != 0 ? 700 : 400;
        if ((i & 2) != 0) {
            i2 = 1;
        }
        return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle(i5, i2)).build();
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        try {
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(new Font.Builder(resources, i).build()).build()).setStyle(new FontStyle((i2 & 1) != 0 ? 700 : 400, (i2 & 2) != 0 ? 1 : 0)).build();
        } catch (IOException unused) {
            return null;
        }
    }
}
