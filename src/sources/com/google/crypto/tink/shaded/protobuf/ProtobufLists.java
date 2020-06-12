package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.Internal;

final class ProtobufLists {
    private ProtobufLists() {
    }

    public static <E> Internal.ProtobufList<E> emptyProtobufList() {
        return ProtobufArrayList.emptyList();
    }

    public static <E> Internal.ProtobufList<E> mutableCopy(Internal.ProtobufList<E> protobufList) {
        int size = protobufList.size();
        return protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
    }

    public static Internal.BooleanList emptyBooleanList() {
        return BooleanArrayList.emptyList();
    }

    public static Internal.BooleanList newBooleanList() {
        return new BooleanArrayList();
    }

    public static Internal.IntList emptyIntList() {
        return IntArrayList.emptyList();
    }

    public static Internal.IntList newIntList() {
        return new IntArrayList();
    }

    public static Internal.LongList emptyLongList() {
        return LongArrayList.emptyList();
    }

    public static Internal.LongList newLongList() {
        return new LongArrayList();
    }

    public static Internal.FloatList emptyFloatList() {
        return FloatArrayList.emptyList();
    }

    public static Internal.FloatList newFloatList() {
        return new FloatArrayList();
    }

    public static Internal.DoubleList emptyDoubleList() {
        return DoubleArrayList.emptyList();
    }

    public static Internal.DoubleList newDoubleList() {
        return new DoubleArrayList();
    }
}
