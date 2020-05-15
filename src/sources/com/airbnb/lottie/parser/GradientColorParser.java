package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GradientColorParser implements ValueParser<GradientColor> {
    private int colorPoints;

    public GradientColorParser(int i) {
        this.colorPoints = i;
    }

    public GradientColor parse(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z = jsonReader.peek() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.beginArray();
        }
        while (jsonReader.hasNext()) {
            arrayList.add(Float.valueOf((float) jsonReader.nextDouble()));
        }
        if (z) {
            jsonReader.endArray();
        }
        if (this.colorPoints == -1) {
            this.colorPoints = arrayList.size() / 4;
        }
        int i = this.colorPoints;
        float[] fArr = new float[i];
        int[] iArr = new int[i];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.colorPoints * 4; i4++) {
            int i5 = i4 / 4;
            double floatValue = (double) ((Float) arrayList.get(i4)).floatValue();
            int i6 = i4 % 4;
            if (i6 == 0) {
                fArr[i5] = (float) floatValue;
            } else if (i6 == 1) {
                i2 = (int) (floatValue * 255.0d);
            } else if (i6 == 2) {
                i3 = (int) (floatValue * 255.0d);
            } else if (i6 == 3) {
                iArr[i5] = Color.argb(255, i2, i3, (int) (floatValue * 255.0d));
            }
        }
        GradientColor gradientColor = new GradientColor(fArr, iArr);
        addOpacityStopsToGradientIfNeeded(gradientColor, arrayList);
        return gradientColor;
    }

    private void addOpacityStopsToGradientIfNeeded(GradientColor gradientColor, List<Float> list) {
        int i = this.colorPoints * 4;
        if (list.size() > i) {
            int size = (list.size() - i) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i2 = 0;
            while (i < list.size()) {
                if (i % 2 == 0) {
                    dArr[i2] = (double) list.get(i).floatValue();
                } else {
                    dArr2[i2] = (double) list.get(i).floatValue();
                    i2++;
                }
                i++;
            }
            for (int i3 = 0; i3 < gradientColor.getSize(); i3++) {
                int i4 = gradientColor.getColors()[i3];
                gradientColor.getColors()[i3] = Color.argb(getOpacityAtPosition((double) gradientColor.getPositions()[i3], dArr, dArr2), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
    }

    private int getOpacityAtPosition(double d, double[] dArr, double[] dArr2) {
        double d2;
        double[] dArr3 = dArr;
        double[] dArr4 = dArr2;
        int i = 1;
        while (true) {
            if (i >= dArr3.length) {
                d2 = dArr4[dArr4.length - 1];
                break;
            }
            int i2 = i - 1;
            double d3 = dArr3[i2];
            double d4 = dArr3[i];
            if (dArr3[i] >= d) {
                d2 = MiscUtils.lerp(dArr4[i2], dArr4[i], (d - d3) / (d4 - d3));
                break;
            }
            i++;
        }
        return (int) (d2 * 255.0d);
    }
}
