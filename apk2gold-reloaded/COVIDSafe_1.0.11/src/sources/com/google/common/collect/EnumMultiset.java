package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    public transient int[] counts;
    /* access modifiers changed from: private */
    public transient int distinctElements;
    /* access modifiers changed from: private */
    public transient E[] enumConstants;
    /* access modifiers changed from: private */
    public transient long size;
    private transient Class<E> type;

    abstract class Itr<T> implements Iterator<T> {
        int index = 0;
        int toRemove = -1;

        /* access modifiers changed from: 0000 */
        public abstract T output(int i);

        Itr() {
        }

        public boolean hasNext() {
            while (this.index < EnumMultiset.this.enumConstants.length) {
                int[] access$100 = EnumMultiset.this.counts;
                int i = this.index;
                if (access$100[i] > 0) {
                    return true;
                }
                this.index = i + 1;
            }
            return false;
        }

        public T next() {
            if (hasNext()) {
                T output = output(this.index);
                int i = this.index;
                this.toRemove = i;
                this.index = i + 1;
                return output;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove >= 0);
            if (EnumMultiset.this.counts[this.toRemove] > 0) {
                EnumMultiset.this.distinctElements = EnumMultiset.this.distinctElements - 1;
                EnumMultiset enumMultiset = EnumMultiset.this;
                enumMultiset.size = enumMultiset.size - ((long) EnumMultiset.this.counts[this.toRemove]);
                EnumMultiset.this.counts[this.toRemove] = 0;
            }
            this.toRemove = -1;
        }
    }

    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    public /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(((Enum) it.next()).getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        Preconditions.checkArgument(cls.isEnum());
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.enumConstants = eArr;
        this.counts = new int[eArr.length];
    }

    private boolean isActuallyE(@NullableDecl Object obj) {
        if (!(obj instanceof Enum)) {
            return false;
        }
        E e = (Enum) obj;
        int ordinal = e.ordinal();
        E[] eArr = this.enumConstants;
        if (ordinal >= eArr.length || eArr[ordinal] != e) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: 0000 */
    public void checkIsE(@NullableDecl Object obj) {
        Preconditions.checkNotNull(obj);
        if (!isActuallyE(obj)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected an ");
            sb.append(this.type);
            sb.append(" but got ");
            sb.append(obj);
            throw new ClassCastException(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    public int distinctElements() {
        return this.distinctElements;
    }

    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public int count(@NullableDecl Object obj) {
        if (!isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    public int add(E e, int i) {
        checkIsE(e);
        CollectPreconditions.checkNonnegative(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        int ordinal = e.ordinal();
        int i2 = this.counts[ordinal];
        long j = (long) i;
        long j2 = ((long) i2) + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.counts[ordinal] = (int) j2;
        if (i2 == 0) {
            this.distinctElements++;
        }
        this.size += j;
        return i2;
    }

    public int remove(@NullableDecl Object obj, int i) {
        if (!isActuallyE(obj)) {
            return 0;
        }
        Enum enumR = (Enum) obj;
        CollectPreconditions.checkNonnegative(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        int ordinal = enumR.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        if (i2 == 0) {
            return 0;
        }
        if (i2 <= i) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= (long) i2;
        } else {
            iArr[ordinal] = i2 - i;
            this.size -= (long) i;
        }
        return i2;
    }

    public int setCount(E e, int i) {
        checkIsE(e);
        CollectPreconditions.checkNonnegative(i, "count");
        int ordinal = e.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        iArr[ordinal] = i;
        this.size += (long) (i - i2);
        if (i2 == 0 && i > 0) {
            this.distinctElements++;
        } else if (i2 > 0 && i == 0) {
            this.distinctElements--;
        }
        return i2;
    }

    public void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    /* access modifiers changed from: 0000 */
    public Iterator<E> elementIterator() {
        return new Itr<E>() {
            /* access modifiers changed from: 0000 */
            public E output(int i) {
                return EnumMultiset.this.enumConstants[i];
            }
        };
    }

    /* access modifiers changed from: 0000 */
    public Iterator<Entry<E>> entryIterator() {
        return new Itr<Entry<E>>() {
            /* access modifiers changed from: 0000 */
            public Entry<E> output(final int i) {
                return new AbstractEntry<E>() {
                    public E getElement() {
                        return EnumMultiset.this.enumConstants[i];
                    }

                    public int getCount() {
                        return EnumMultiset.this.counts[i];
                    }
                };
            }
        };
    }

    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Class<E> cls = (Class) objectInputStream.readObject();
        this.type = cls;
        E[] eArr = (Enum[]) cls.getEnumConstants();
        this.enumConstants = eArr;
        this.counts = new int[eArr.length];
        Serialization.populateMultiset(this, objectInputStream);
    }
}
