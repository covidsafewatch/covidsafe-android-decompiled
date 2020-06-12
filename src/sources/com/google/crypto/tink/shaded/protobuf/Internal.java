package com.google.crypto.tink.shaded.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

public final class Internal {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final ByteBuffer EMPTY_BYTE_BUFFER;
    public static final CodedInputStream EMPTY_CODED_INPUT_STREAM = CodedInputStream.newInstance(EMPTY_BYTE_ARRAY);
    static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");

    public interface BooleanList extends ProtobufList<Boolean> {
        void addBoolean(boolean z);

        boolean getBoolean(int i);

        BooleanList mutableCopyWithCapacity(int i);

        boolean setBoolean(int i, boolean z);
    }

    public interface DoubleList extends ProtobufList<Double> {
        void addDouble(double d);

        double getDouble(int i);

        DoubleList mutableCopyWithCapacity(int i);

        double setDouble(int i, double d);
    }

    public interface EnumLite {
        int getNumber();
    }

    public interface EnumLiteMap<T extends EnumLite> {
        T findValueByNumber(int i);
    }

    public interface EnumVerifier {
        boolean isInRange(int i);
    }

    public interface FloatList extends ProtobufList<Float> {
        void addFloat(float f);

        float getFloat(int i);

        FloatList mutableCopyWithCapacity(int i);

        float setFloat(int i, float f);
    }

    public interface IntList extends ProtobufList<Integer> {
        void addInt(int i);

        int getInt(int i);

        IntList mutableCopyWithCapacity(int i);

        int setInt(int i, int i2);
    }

    public interface LongList extends ProtobufList<Long> {
        void addLong(long j);

        long getLong(int i);

        LongList mutableCopyWithCapacity(int i);

        long setLong(int i, long j);
    }

    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean isModifiable();

        void makeImmutable();

        ProtobufList<E> mutableCopyWithCapacity(int i);
    }

    public static int hashBoolean(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int hashLong(long j) {
        return (int) (j ^ (j >>> 32));
    }

    private Internal() {
    }

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_BYTE_BUFFER = ByteBuffer.wrap(bArr);
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw null;
    }

    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static String stringDefaultValue(String str) {
        return new String(str.getBytes(ISO_8859_1), UTF_8);
    }

    public static ByteString bytesDefaultValue(String str) {
        return ByteString.copyFrom(str.getBytes(ISO_8859_1));
    }

    public static byte[] byteArrayDefaultValue(String str) {
        return str.getBytes(ISO_8859_1);
    }

    public static ByteBuffer byteBufferDefaultValue(String str) {
        return ByteBuffer.wrap(byteArrayDefaultValue(str));
    }

    public static ByteBuffer copyByteBuffer(ByteBuffer byteBuffer) {
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        ByteBuffer allocate = ByteBuffer.allocate(duplicate.capacity());
        allocate.put(duplicate);
        allocate.clear();
        return allocate;
    }

    public static boolean isValidUtf8(ByteString byteString) {
        return byteString.isValidUtf8();
    }

    public static boolean isValidUtf8(byte[] bArr) {
        return Utf8.isValidUtf8(bArr);
    }

    public static byte[] toByteArray(String str) {
        return str.getBytes(UTF_8);
    }

    public static String toStringUtf8(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashEnum(EnumLite enumLite) {
        return enumLite.getNumber();
    }

    public static int hashEnumList(List<? extends EnumLite> list) {
        int i = 1;
        for (EnumLite hashEnum : list) {
            i = (i * 31) + hashEnum(hashEnum);
        }
        return i;
    }

    public static boolean equals(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCode(List<byte[]> list) {
        int i = 1;
        for (byte[] hashCode : list) {
            i = (i * 31) + hashCode(hashCode);
        }
        return i;
    }

    public static int hashCode(byte[] bArr) {
        return hashCode(bArr, 0, bArr.length);
    }

    static int hashCode(byte[] bArr, int i, int i2) {
        int partialHash = partialHash(i2, bArr, i, i2);
        if (partialHash == 0) {
            return 1;
        }
        return partialHash;
    }

    static int partialHash(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static boolean equalsByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        if (byteBuffer.capacity() != byteBuffer2.capacity()) {
            return false;
        }
        return byteBuffer.duplicate().clear().equals(byteBuffer2.duplicate().clear());
    }

    public static boolean equalsByteBuffer(List<ByteBuffer> list, List<ByteBuffer> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!equalsByteBuffer(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCodeByteBuffer(List<ByteBuffer> list) {
        int i = 1;
        for (ByteBuffer hashCodeByteBuffer : list) {
            i = (i * 31) + hashCodeByteBuffer(hashCodeByteBuffer);
        }
        return i;
    }

    public static int hashCodeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            int partialHash = partialHash(byteBuffer.capacity(), byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
            if (partialHash == 0) {
                return 1;
            }
            return partialHash;
        }
        int i = 4096;
        if (byteBuffer.capacity() <= 4096) {
            i = byteBuffer.capacity();
        }
        byte[] bArr = new byte[i];
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.clear();
        int capacity = byteBuffer.capacity();
        while (duplicate.remaining() > 0) {
            int remaining = duplicate.remaining() <= i ? duplicate.remaining() : i;
            duplicate.get(bArr, 0, remaining);
            capacity = partialHash(capacity, bArr, 0, remaining);
        }
        if (capacity == 0) {
            return 1;
        }
        return capacity;
    }

    public static <T extends MessageLite> T getDefaultInstance(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            return (MessageLite) method.invoke(method, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException("Failed to get default instance for " + cls, e);
        }
    }

    static Object mergeMessage(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    public static class ListAdapter<F, T> extends AbstractList<T> {
        private final Converter<F, T> converter;
        private final List<F> fromList;

        public interface Converter<F, T> {
            T convert(F f);
        }

        public ListAdapter(List<F> list, Converter<F, T> converter2) {
            this.fromList = list;
            this.converter = converter2;
        }

        public T get(int i) {
            return this.converter.convert(this.fromList.get(i));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {
        private final Map<K, RealValue> realMap;
        /* access modifiers changed from: private */
        public final Converter<RealValue, V> valueConverter;

        public interface Converter<A, B> {
            A doBackward(B b);

            B doForward(A a);
        }

        public static <T extends EnumLite> Converter<Integer, T> newEnumConverter(final EnumLiteMap<T> enumLiteMap, final T t) {
            return new Converter<Integer, T>() {
                public T doForward(Integer num) {
                    T findValueByNumber = EnumLiteMap.this.findValueByNumber(num.intValue());
                    return findValueByNumber == null ? t : findValueByNumber;
                }

                public Integer doBackward(T t) {
                    return Integer.valueOf(t.getNumber());
                }
            };
        }

        public MapAdapter(Map<K, RealValue> map, Converter<RealValue, V> converter) {
            this.realMap = map;
            this.valueConverter = converter;
        }

        public V get(Object obj) {
            RealValue realvalue = this.realMap.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.valueConverter.doForward(realvalue);
        }

        public V put(K k, V v) {
            RealValue put = this.realMap.put(k, this.valueConverter.doBackward(v));
            if (put == null) {
                return null;
            }
            return this.valueConverter.doForward(put);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new SetAdapter(this.realMap.entrySet());
        }

        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {
            private final Set<Map.Entry<K, RealValue>> realSet;

            public SetAdapter(Set<Map.Entry<K, RealValue>> set) {
                this.realSet = set;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new IteratorAdapter(this.realSet.iterator());
            }

            public int size() {
                return this.realSet.size();
            }
        }

        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {
            private final Iterator<Map.Entry<K, RealValue>> realIterator;

            public IteratorAdapter(Iterator<Map.Entry<K, RealValue>> it) {
                this.realIterator = it;
            }

            public boolean hasNext() {
                return this.realIterator.hasNext();
            }

            public Map.Entry<K, V> next() {
                return new EntryAdapter(this.realIterator.next());
            }

            public void remove() {
                this.realIterator.remove();
            }
        }

        private class EntryAdapter implements Map.Entry<K, V> {
            private final Map.Entry<K, RealValue> realEntry;

            public EntryAdapter(Map.Entry<K, RealValue> entry) {
                this.realEntry = entry;
            }

            public K getKey() {
                return this.realEntry.getKey();
            }

            public V getValue() {
                return MapAdapter.this.valueConverter.doForward(this.realEntry.getValue());
            }

            public V setValue(V v) {
                RealValue value = this.realEntry.setValue(MapAdapter.this.valueConverter.doBackward(v));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.valueConverter.doForward(value);
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if ((obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue())) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                return this.realEntry.hashCode();
            }
        }
    }
}
