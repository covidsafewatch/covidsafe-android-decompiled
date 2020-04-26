package com.github.razir.progressbutton;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/github/razir/progressbutton/DrawableParams;", "invoke"}, k = 3, mv = {1, 1, 16})
/* compiled from: DrawableButtonExtensions.kt */
final class DrawableButtonExtensionsKt$showDrawable$1 extends Lambda implements Function1<DrawableParams, Unit> {
    public static final DrawableButtonExtensionsKt$showDrawable$1 INSTANCE = new DrawableButtonExtensionsKt$showDrawable$1();

    DrawableButtonExtensionsKt$showDrawable$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((DrawableParams) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(DrawableParams drawableParams) {
        Intrinsics.checkParameterIsNotNull(drawableParams, "$receiver");
    }
}
