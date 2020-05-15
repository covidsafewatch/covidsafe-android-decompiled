package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

public class PointFParser implements ValueParser<PointF> {
    public static final PointFParser INSTANCE = new PointFParser();

    private PointFParser() {
    }

    public PointF parse(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token peek = jsonReader.peek();
        if (peek == JsonReader.Token.BEGIN_ARRAY) {
            return JsonUtils.jsonToPoint(jsonReader, f);
        }
        if (peek == JsonReader.Token.BEGIN_OBJECT) {
            return JsonUtils.jsonToPoint(jsonReader, f);
        }
        if (peek == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f, ((float) jsonReader.nextDouble()) * f);
            while (jsonReader.hasNext()) {
                jsonReader.skipValue();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + peek);
    }
}
