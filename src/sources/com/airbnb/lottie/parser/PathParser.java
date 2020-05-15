package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class PathParser implements ValueParser<PointF> {
    public static final PathParser INSTANCE = new PathParser();

    private PathParser() {
    }

    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        return JsonUtils.jsonToPoint(jsonReader, f);
    }
}
