package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

class RectangleShapeParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("nm", "p", "s", "r", "hd");

    private RectangleShapeParser() {
    }

    static RectangleShape parse(JsonReader jsonReader, LottieComposition lottieComposition) throws IOException {
        String str = null;
        AnimatableValue<PointF, PointF> animatableValue = null;
        AnimatablePointValue animatablePointValue = null;
        AnimatableFloatValue animatableFloatValue = null;
        boolean z = false;
        while (jsonReader.hasNext()) {
            int selectName = jsonReader.selectName(NAMES);
            if (selectName == 0) {
                str = jsonReader.nextString();
            } else if (selectName == 1) {
                animatableValue = AnimatablePathValueParser.parseSplitPath(jsonReader, lottieComposition);
            } else if (selectName == 2) {
                animatablePointValue = AnimatableValueParser.parsePoint(jsonReader, lottieComposition);
            } else if (selectName == 3) {
                animatableFloatValue = AnimatableValueParser.parseFloat(jsonReader, lottieComposition);
            } else if (selectName != 4) {
                jsonReader.skipValue();
            } else {
                z = jsonReader.nextBoolean();
            }
        }
        return new RectangleShape(str, animatableValue, animatablePointValue, animatableFloatValue, z);
    }
}
