package com.airbnb.lottie;

import android.graphics.Bitmap;

public interface ImageAssetDelegate {
    Bitmap fetchBitmap(LottieImageAsset lottieImageAsset);
}
