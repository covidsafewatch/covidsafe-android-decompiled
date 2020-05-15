package com.airbnb.lottie.model;

import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

public interface KeyPathElement {
    <T> void addValueCallback(T t, LottieValueCallback<T> lottieValueCallback);

    void resolveKeyPath(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2);
}
