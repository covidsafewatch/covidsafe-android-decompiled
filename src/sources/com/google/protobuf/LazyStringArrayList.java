package com.google.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {
    public static final LazyStringList EMPTY = EMPTY_LIST;
    private static final LazyStringArrayList EMPTY_LIST;
    private final List<Object> list;

    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isModifiable() {
        return super.isModifiable();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        EMPTY_LIST = lazyStringArrayList;
        lazyStringArrayList.makeImmutable();
    }

    static LazyStringArrayList emptyList() {
        return EMPTY_LIST;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public LazyStringArrayList(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.list = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    public LazyStringArrayList(List<String> list2) {
        this((ArrayList<Object>) new ArrayList(list2));
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.list = arrayList;
    }

    public LazyStringArrayList mutableCopyWithCapacity(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.list);
            return new LazyStringArrayList((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public String get(int i) {
        Object obj = this.list.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.list.set(i, stringUtf8);
            }
            return stringUtf8;
        }
        byte[] bArr = (byte[]) obj;
        String stringUtf82 = Internal.toStringUtf8(bArr);
        if (Internal.isValidUtf8(bArr)) {
            this.list.set(i, stringUtf82);
        }
        return stringUtf82;
    }

    public int size() {
        return this.list.size();
    }

    public String set(int i, String str) {
        ensureIsMutable();
        return asString(this.list.set(i, str));
    }

    public void add(int i, String str) {
        ensureIsMutable();
        this.list.add(i, str);
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public void add(int i, ByteString byteString) {
        ensureIsMutable();
        this.list.add(i, byteString);
        this.modCount++;
    }

    /* access modifiers changed from: private */
    public void add(int i, byte[] bArr) {
        ensureIsMutable();
        this.list.add(i, bArr);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        ensureIsMutable();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).getUnderlyingElements();
        }
        boolean addAll = this.list.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAllByteString(Collection<? extends ByteString> collection) {
        ensureIsMutable();
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public boolean addAllByteArray(Collection<byte[]> collection) {
        ensureIsMutable();
        boolean addAll = this.list.addAll(collection);
        this.modCount++;
        return addAll;
    }

    public String remove(int i) {
        ensureIsMutable();
        Object remove = this.list.remove(i);
        this.modCount++;
        return asString(remove);
    }

    public void clear() {
        ensureIsMutable();
        this.list.clear();
        this.modCount++;
    }

    public void add(ByteString byteString) {
        ensureIsMutable();
        this.list.add(byteString);
        this.modCount++;
    }

    public void add(byte[] bArr) {
        ensureIsMutable();
        this.list.add(bArr);
        this.modCount++;
    }

    public Object getRaw(int i) {
        return this.list.get(i);
    }

    public ByteString getByteString(int i) {
        Object obj = this.list.get(i);
        ByteString asByteString = asByteString(obj);
        if (asByteString != obj) {
            this.list.set(i, asByteString);
        }
        return asByteString;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.util.List<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: byte[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getByteArray(int r3) {
        /*
            r2 = this;
            java.util.List<java.lang.Object> r0 = r2.list
            java.lang.Object r0 = r0.get(r3)
            byte[] r1 = asByteArray(r0)
            if (r1 == r0) goto L_0x0011
            java.util.List<java.lang.Object> r0 = r2.list
            r0.set(r3, r1)
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyStringArrayList.getByteArray(int):byte[]");
    }

    public void set(int i, ByteString byteString) {
        setAndReturn(i, byteString);
    }

    /* access modifiers changed from: private */
    public Object setAndReturn(int i, ByteString byteString) {
        ensureIsMutable();
        return this.list.set(i, byteString);
    }

    public void set(int i, byte[] bArr) {
        setAndReturn(i, bArr);
    }

    /* access modifiers changed from: private */
    public Object setAndReturn(int i, byte[] bArr) {
        ensureIsMutable();
        return this.list.set(i, bArr);
    }

    private static String asString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).toStringUtf8();
        }
        return Internal.toStringUtf8((byte[]) obj);
    }

    /* access modifiers changed from: private */
    public static ByteString asByteString(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.copyFromUtf8((String) obj);
        }
        return ByteString.copyFrom((byte[]) obj);
    }

    /* access modifiers changed from: private */
    public static byte[] asByteArray(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.toByteArray((String) obj);
        }
        return ((ByteString) obj).toByteArray();
    }

    public List<?> getUnderlyingElements() {
        return Collections.unmodifiableList(this.list);
    }

    public void mergeFrom(LazyStringList lazyStringList) {
        ensureIsMutable();
        for (Object next : lazyStringList.getUnderlyingElements()) {
            if (next instanceof byte[]) {
                byte[] bArr = (byte[]) next;
                this.list.add(Arrays.copyOf(bArr, bArr.length));
            } else {
                this.list.add(next);
            }
        }
    }

    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteArrayListView(LazyStringArrayList lazyStringArrayList) {
            this.list = lazyStringArrayList;
        }

        public byte[] get(int i) {
            return this.list.getByteArray(i);
        }

        public int size() {
            return this.list.size();
        }

        public byte[] set(int i, byte[] bArr) {
            Object access$000 = this.list.setAndReturn(i, bArr);
            this.modCount++;
            return LazyStringArrayList.asByteArray(access$000);
        }

        public void add(int i, byte[] bArr) {
            this.list.add(i, bArr);
            this.modCount++;
        }

        public byte[] remove(int i) {
            String remove = this.list.remove(i);
            this.modCount++;
            return LazyStringArrayList.asByteArray(remove);
        }
    }

    public List<byte[]> asByteArrayList() {
        return new ByteArrayListView(this);
    }

    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {
        private final LazyStringArrayList list;

        ByteStringListView(LazyStringArrayList lazyStringArrayList) {
            this.list = lazyStringArrayList;
        }

        public ByteString get(int i) {
            return this.list.getByteString(i);
        }

        public int size() {
            return this.list.size();
        }

        public ByteString set(int i, ByteString byteString) {
            Object access$300 = this.list.setAndReturn(i, byteString);
            this.modCount++;
            return LazyStringArrayList.asByteString(access$300);
        }

        public void add(int i, ByteString byteString) {
            this.list.add(i, byteString);
            this.modCount++;
        }

        public ByteString remove(int i) {
            String remove = this.list.remove(i);
            this.modCount++;
            return LazyStringArrayList.asByteString(remove);
        }
    }

    public List<ByteString> asByteStringList() {
        return new ByteStringListView(this);
    }

    public LazyStringList getUnmodifiableView() {
        return isModifiable() ? new UnmodifiableLazyStringList(this) : this;
    }
}
