package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

class ContentModelParser {
    private static JsonReader.Options NAMES = JsonReader.Options.of("ty", "d");

    private ContentModelParser() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        if (r2.equals("gs") != false) goto L_0x00c0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.airbnb.lottie.model.content.ContentModel parse(com.airbnb.lottie.parser.moshi.JsonReader r7, com.airbnb.lottie.LottieComposition r8) throws java.io.IOException {
        /*
            r7.beginObject()
            r0 = 2
            r1 = 2
        L_0x0005:
            boolean r2 = r7.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0028
            com.airbnb.lottie.parser.moshi.JsonReader$Options r2 = NAMES
            int r2 = r7.selectName(r2)
            if (r2 == 0) goto L_0x0023
            if (r2 == r3) goto L_0x001e
            r7.skipName()
            r7.skipValue()
            goto L_0x0005
        L_0x001e:
            int r1 = r7.nextInt()
            goto L_0x0005
        L_0x0023:
            java.lang.String r2 = r7.nextString()
            goto L_0x0029
        L_0x0028:
            r2 = r4
        L_0x0029:
            if (r2 != 0) goto L_0x002c
            return r4
        L_0x002c:
            r5 = -1
            int r6 = r2.hashCode()
            switch(r6) {
                case 3239: goto L_0x00b5;
                case 3270: goto L_0x00ab;
                case 3295: goto L_0x00a1;
                case 3307: goto L_0x0097;
                case 3308: goto L_0x008e;
                case 3488: goto L_0x0083;
                case 3633: goto L_0x0078;
                case 3646: goto L_0x006d;
                case 3669: goto L_0x0063;
                case 3679: goto L_0x0058;
                case 3681: goto L_0x004d;
                case 3705: goto L_0x0041;
                case 3710: goto L_0x0036;
                default: goto L_0x0034;
            }
        L_0x0034:
            goto L_0x00bf
        L_0x0036:
            java.lang.String r0 = "tr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 5
            goto L_0x00c0
        L_0x0041:
            java.lang.String r0 = "tm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 9
            goto L_0x00c0
        L_0x004d:
            java.lang.String r0 = "st"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 1
            goto L_0x00c0
        L_0x0058:
            java.lang.String r0 = "sr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 10
            goto L_0x00c0
        L_0x0063:
            java.lang.String r0 = "sh"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 6
            goto L_0x00c0
        L_0x006d:
            java.lang.String r0 = "rp"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 12
            goto L_0x00c0
        L_0x0078:
            java.lang.String r0 = "rc"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 8
            goto L_0x00c0
        L_0x0083:
            java.lang.String r0 = "mm"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 11
            goto L_0x00c0
        L_0x008e:
            java.lang.String r3 = "gs"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x00bf
            goto L_0x00c0
        L_0x0097:
            java.lang.String r0 = "gr"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 0
            goto L_0x00c0
        L_0x00a1:
            java.lang.String r0 = "gf"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 4
            goto L_0x00c0
        L_0x00ab:
            java.lang.String r0 = "fl"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 3
            goto L_0x00c0
        L_0x00b5:
            java.lang.String r0 = "el"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x00bf
            r0 = 7
            goto L_0x00c0
        L_0x00bf:
            r0 = -1
        L_0x00c0:
            switch(r0) {
                case 0: goto L_0x0119;
                case 1: goto L_0x0114;
                case 2: goto L_0x010f;
                case 3: goto L_0x010a;
                case 4: goto L_0x0105;
                case 5: goto L_0x0100;
                case 6: goto L_0x00fb;
                case 7: goto L_0x00f6;
                case 8: goto L_0x00f1;
                case 9: goto L_0x00ec;
                case 10: goto L_0x00e7;
                case 11: goto L_0x00dd;
                case 12: goto L_0x00d8;
                default: goto L_0x00c3;
            }
        L_0x00c3:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r0 = "Unknown shape type "
            r8.append(r0)
            r8.append(r2)
            java.lang.String r8 = r8.toString()
            com.airbnb.lottie.utils.Logger.warning(r8)
            goto L_0x011d
        L_0x00d8:
            com.airbnb.lottie.model.content.Repeater r4 = com.airbnb.lottie.parser.RepeaterParser.parse(r7, r8)
            goto L_0x011d
        L_0x00dd:
            com.airbnb.lottie.model.content.MergePaths r4 = com.airbnb.lottie.parser.MergePathsParser.parse(r7)
            java.lang.String r0 = "Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove()."
            r8.addWarning(r0)
            goto L_0x011d
        L_0x00e7:
            com.airbnb.lottie.model.content.PolystarShape r4 = com.airbnb.lottie.parser.PolystarShapeParser.parse(r7, r8)
            goto L_0x011d
        L_0x00ec:
            com.airbnb.lottie.model.content.ShapeTrimPath r4 = com.airbnb.lottie.parser.ShapeTrimPathParser.parse(r7, r8)
            goto L_0x011d
        L_0x00f1:
            com.airbnb.lottie.model.content.RectangleShape r4 = com.airbnb.lottie.parser.RectangleShapeParser.parse(r7, r8)
            goto L_0x011d
        L_0x00f6:
            com.airbnb.lottie.model.content.CircleShape r4 = com.airbnb.lottie.parser.CircleShapeParser.parse(r7, r8, r1)
            goto L_0x011d
        L_0x00fb:
            com.airbnb.lottie.model.content.ShapePath r4 = com.airbnb.lottie.parser.ShapePathParser.parse(r7, r8)
            goto L_0x011d
        L_0x0100:
            com.airbnb.lottie.model.animatable.AnimatableTransform r4 = com.airbnb.lottie.parser.AnimatableTransformParser.parse(r7, r8)
            goto L_0x011d
        L_0x0105:
            com.airbnb.lottie.model.content.GradientFill r4 = com.airbnb.lottie.parser.GradientFillParser.parse(r7, r8)
            goto L_0x011d
        L_0x010a:
            com.airbnb.lottie.model.content.ShapeFill r4 = com.airbnb.lottie.parser.ShapeFillParser.parse(r7, r8)
            goto L_0x011d
        L_0x010f:
            com.airbnb.lottie.model.content.GradientStroke r4 = com.airbnb.lottie.parser.GradientStrokeParser.parse(r7, r8)
            goto L_0x011d
        L_0x0114:
            com.airbnb.lottie.model.content.ShapeStroke r4 = com.airbnb.lottie.parser.ShapeStrokeParser.parse(r7, r8)
            goto L_0x011d
        L_0x0119:
            com.airbnb.lottie.model.content.ShapeGroup r4 = com.airbnb.lottie.parser.ShapeGroupParser.parse(r7, r8)
        L_0x011d:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0127
            r7.skipValue()
            goto L_0x011d
        L_0x0127:
            r7.endObject()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.ContentModelParser.parse(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.content.ContentModel");
    }
}
