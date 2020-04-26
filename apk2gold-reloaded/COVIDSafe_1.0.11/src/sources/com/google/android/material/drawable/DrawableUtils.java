package com.google.android.material.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableUtils {
    private DrawableUtils() {
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable drawable, ColorStateList colorStateList, Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }

    public static AttributeSet parseDrawableXml(Context context, int i, CharSequence charSequence) {
        int next;
        try {
            XmlResourceParser xml = context.getResources().getXml(i);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            } else if (TextUtils.equals(xml.getName(), charSequence)) {
                return Xml.asAttributeSet(xml);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Must have a <");
                sb.append(charSequence);
                sb.append("> start tag");
                throw new XmlPullParserException(sb.toString());
            }
        } catch (IOException | XmlPullParserException e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Can't load badge resource ID #0x");
            sb2.append(Integer.toHexString(i));
            NotFoundException notFoundException = new NotFoundException(sb2.toString());
            notFoundException.initCause(e);
            throw notFoundException;
        }
    }
}
