package com.airbnb.lottie.parser;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class ShapeFillParser {
    private static final JsonReader.Options NAMES = JsonReader.Options.of("nm", "c", "o", "fillEnabled", "r", "hd");

    private ShapeFillParser() {
    }

    static ShapeFill parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableColorValue animatableColorValue = null;
        AnimatableIntegerValue animatableIntegerValue = null;
        int i = 1;
        boolean z = false;
        boolean z2 = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableColorValue = AnimatableValueParser.parseColor(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatableIntegerValue = AnimatableValueParser.parseInteger(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                z = jsonReader.nextBoolean();
            } else if (selectName == 4) {
                i = jsonReader.nextInt();
            } else if (selectName != 5) {
                jsonReader.skipName();
                jsonReader.skipValue();
            } else {
                z2 = jsonReader.nextBoolean();
            }
        }
        return new ShapeFill(str, z, i == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, animatableColorValue, animatableIntegerValue, z2);
    }
}
