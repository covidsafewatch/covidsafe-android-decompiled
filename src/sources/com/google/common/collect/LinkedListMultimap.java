package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class LinkedListMultimap<K, V> extends AbstractMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    private static final long serialVersionUID = 0;
    /* access modifiers changed from: private */
    @NullableDecl
    public transient Node<K, V> head;
    /* access modifiers changed from: private */
    public transient Map<K, KeyList<K, V>> keyToKeyList;
    /* access modifiers changed from: private */
    public transient int modCount;
    /* access modifiers changed from: private */
    public transient int size;
    /* access modifiers changed from: private */
    @NullableDecl
    public transient Node<K, V> tail;

    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    public /* bridge */ /* synthetic */ boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    public /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    public /* bridge */ /* synthetic */ boolean putAll(@NullableDecl Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public /* bridge */ /* synthetic */ boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.remove(obj, obj2);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    private static final class Node<K, V> extends AbstractMapEntry<K, V> {
        @NullableDecl
        final K key;
        @NullableDecl
        Node<K, V> next;
        @NullableDecl
        Node<K, V> nextSibling;
        @NullableDecl
        Node<K, V> previous;
        @NullableDecl
        Node<K, V> previousSibling;
        @NullableDecl
        V value;

        Node(@NullableDecl K k, @NullableDecl V v) {
            this.key = k;
            this.value = v;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(@NullableDecl V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }
    }

    private static class KeyList<K, V> {
        int count = 1;
        Node<K, V> head;
        Node<K, V> tail;

        KeyList(Node<K, V> node) {
            this.head = node;
            this.tail = node;
            node.previousSibling = null;
            node.nextSibling = null;
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap<>();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int i) {
        return new LinkedListMultimap<>(i);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap<>(multimap);
    }

    LinkedListMultimap() {
        this(12);
    }

    private LinkedListMultimap(int i) {
        this.keyToKeyList = Platform.newHashMapWithExpectedSize(i);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    /* access modifiers changed from: private */
    public Node<K, V> addNode(@NullableDecl K k, @NullableDecl V v, @NullableDecl Node<K, V> node) {
        Node<K, V> node2 = new Node<>(k, v);
        if (this.head == null) {
            this.tail = node2;
            this.head = node2;
            this.keyToKeyList.put(k, new KeyList(node2));
            this.modCount++;
        } else if (node == null) {
            this.tail.next = node2;
            node2.previous = this.tail;
            this.tail = node2;
            KeyList keyList = this.keyToKeyList.get(k);
            if (keyList == null) {
                this.keyToKeyList.put(k, new KeyList(node2));
                this.modCount++;
            } else {
                keyList.count++;
                Node<K, V> node3 = keyList.tail;
                node3.nextSibling = node2;
                node2.previousSibling = node3;
                keyList.tail = node2;
            }
        } else {
            this.keyToKeyList.get(k).count++;
            node2.previous = node.previous;
            node2.previousSibling = node.previousSibling;
            node2.next = node;
            node2.nextSibling = node;
            if (node.previousSibling == null) {
                this.keyToKeyList.get(k).head = node2;
            } else {
                node.previousSibling.nextSibling = node2;
            }
            if (node.previous == null) {
                this.head = node2;
            } else {
                node.previous.next = node2;
            }
            node.previous = node2;
            node.previousSibling = node2;
        }
        this.size++;
        return node2;
    }

    /* access modifiers changed from: private */
    public void removeNode(Node<K, V> node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
        if (node.previousSibling == null && node.nextSibling == null) {
            this.keyToKeyList.remove(node.key).count = 0;
            this.modCount++;
        } else {
            KeyList keyList = this.keyToKeyList.get(node.key);
            keyList.count--;
            if (node.previousSibling == null) {
                keyList.head = node.nextSibling;
            } else {
                node.previousSibling.nextSibling = node.nextSibling;
            }
            if (node.nextSibling == null) {
                keyList.tail = node.previousSibling;
            } else {
                node.nextSibling.previousSibling = node.previousSibling;
            }
        }
        this.size--;
    }

    /* access modifiers changed from: private */
    public void removeAllNodes(@NullableDecl Object obj) {
        Iterators.clear(new ValueForKeyIterator(obj));
    }

    /* access modifiers changed from: private */
    public static void checkElement(@NullableDecl Object obj) {
        if (obj == null) {
            throw new NoSuchElementException();
        }
    }

    private class NodeIterator implements ListIterator<Map.Entry<K, V>> {
        @NullableDecl
        Node<K, V> current;
        int expectedModCount = LinkedListMultimap.this.modCount;
        @NullableDecl
        Node<K, V> next;
        int nextIndex;
        @NullableDecl
        Node<K, V> previous;

        NodeIterator(int i) {
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(i, size);
            if (i < size / 2) {
                this.next = LinkedListMultimap.this.head;
                while (true) {
                    int i2 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i2;
                }
            } else {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = size;
                while (true) {
                    int i3 = i + 1;
                    if (i >= size) {
                        break;
                    }
                    previous();
                    i = i3;
                }
            }
            this.current = null;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        public Node<K, V> next() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node = this.next;
            this.current = node;
            this.previous = node;
            this.next = node.next;
            this.nextIndex++;
            return this.current;
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previous;
                this.nextIndex--;
            } else {
                this.next = node.next;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        public boolean hasPrevious() {
            checkForConcurrentModification();
            return this.previous != null;
        }

        public Node<K, V> previous() {
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.previous);
            Node<K, V> node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = node.previous;
            this.nextIndex--;
            return this.current;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void set(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        public void add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public void setValue(V v) {
            Preconditions.checkState(this.current != null);
            this.current.value = v;
        }
    }

    private class DistinctKeyIterator implements Iterator<K> {
        @NullableDecl
        Node<K, V> current;
        int expectedModCount;
        Node<K, V> next;
        final Set<K> seenKeys;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }

        private void checkForConcurrentModification() {
            if (LinkedListMultimap.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.next != null;
        }

        public K next() {
            Node<K, V> node;
            checkForConcurrentModification();
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node2 = this.next;
            this.current = node2;
            this.seenKeys.add(node2.key);
            do {
                node = this.next.next;
                this.next = node;
                if (node == null || this.seenKeys.add(node.key)) {
                }
                node = this.next.next;
                this.next = node;
                break;
            } while (this.seenKeys.add(node.key));
            return this.current.key;
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.current != null);
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
            this.expectedModCount = LinkedListMultimap.this.modCount;
        }
    }

    private class ValueForKeyIterator implements ListIterator<V> {
        @NullableDecl
        Node<K, V> current;
        @NullableDecl
        final Object key;
        @NullableDecl
        Node<K, V> next;
        int nextIndex;
        @NullableDecl
        Node<K, V> previous;

        ValueForKeyIterator(@NullableDecl Object obj) {
            Node<K, V> node;
            this.key = obj;
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(obj);
            if (keyList == null) {
                node = null;
            } else {
                node = keyList.head;
            }
            this.next = node;
        }

        public ValueForKeyIterator(@NullableDecl Object obj, int i) {
            int i2;
            Node<K, V> node;
            Node<K, V> node2;
            KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(obj);
            if (keyList == null) {
                i2 = 0;
            } else {
                i2 = keyList.count;
            }
            Preconditions.checkPositionIndex(i, i2);
            if (i < i2 / 2) {
                if (keyList == null) {
                    node = null;
                } else {
                    node = keyList.head;
                }
                this.next = node;
                while (true) {
                    int i3 = i - 1;
                    if (i <= 0) {
                        break;
                    }
                    next();
                    i = i3;
                }
            } else {
                if (keyList == null) {
                    node2 = null;
                } else {
                    node2 = keyList.tail;
                }
                this.previous = node2;
                this.nextIndex = i2;
                while (true) {
                    int i4 = i + 1;
                    if (i >= i2) {
                        break;
                    }
                    previous();
                    i = i4;
                }
            }
            this.key = obj;
            this.current = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public V next() {
            LinkedListMultimap.checkElement(this.next);
            Node<K, V> node = this.next;
            this.current = node;
            this.previous = node;
            this.next = node.nextSibling;
            this.nextIndex++;
            return this.current.value;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public V previous() {
            LinkedListMultimap.checkElement(this.previous);
            Node<K, V> node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = node.previousSibling;
            this.nextIndex--;
            return this.current.value;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.current != null);
            Node<K, V> node = this.current;
            if (node != this.next) {
                this.previous = node.previousSibling;
                this.nextIndex--;
            } else {
                this.next = node.nextSibling;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
        }

        public void set(V v) {
            Preconditions.checkState(this.current != null);
            this.current.value = v;
        }

        public void add(V v) {
            this.previous = LinkedListMultimap.this.addNode(this.key, v, this.next);
            this.nextIndex++;
            this.current = null;
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return this.keyToKeyList.containsKey(obj);
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    public boolean put(@NullableDecl K k, @NullableDecl V v) {
        addNode(k, v, (Node) null);
        return true;
    }

    public List<V> replaceValues(@NullableDecl K k, Iterable<? extends V> iterable) {
        List<V> copy = getCopy(k);
        ValueForKeyIterator valueForKeyIterator = new ValueForKeyIterator(k);
        Iterator<? extends V> it = iterable.iterator();
        while (valueForKeyIterator.hasNext() && it.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.set(it.next());
        }
        while (valueForKeyIterator.hasNext()) {
            valueForKeyIterator.next();
            valueForKeyIterator.remove();
        }
        while (it.hasNext()) {
            valueForKeyIterator.add(it.next());
        }
        return copy;
    }

    private List<V> getCopy(@NullableDecl Object obj) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(obj)));
    }

    public List<V> removeAll(@NullableDecl Object obj) {
        List<V> copy = getCopy(obj);
        removeAllNodes(obj);
        return copy;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyToKeyList.clear();
        this.size = 0;
        this.modCount++;
    }

    public List<V> get(@NullableDecl final K k) {
        return new AbstractSequentialList<V>() {
            public int size() {
                KeyList keyList = (KeyList) LinkedListMultimap.this.keyToKeyList.get(k);
                if (keyList == null) {
                    return 0;
                }
                return keyList.count;
            }

            public ListIterator<V> listIterator(int i) {
                return new ValueForKeyIterator(k, i);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Set<K> createKeySet() {
        return new Sets.ImprovedAbstractSet<K>() {
            public int size() {
                return LinkedListMultimap.this.keyToKeyList.size();
            }

            public Iterator<K> iterator() {
                return new DistinctKeyIterator();
            }

            public boolean contains(Object obj) {
                return LinkedListMultimap.this.containsKey(obj);
            }

            public boolean remove(Object obj) {
                return !LinkedListMultimap.this.removeAll(obj).isEmpty();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> createKeys() {
        return new Multimaps.Keys(this);
    }

    public List<V> values() {
        return (List) super.values();
    }

    /* access modifiers changed from: package-private */
    public List<V> createValues() {
        return new AbstractSequentialList<V>() {
            public int size() {
                return LinkedListMultimap.this.size;
            }

            public ListIterator<V> listIterator(int i) {
                final NodeIterator nodeIterator = new NodeIterator(i);
                return new TransformedListIterator<Map.Entry<K, V>, V>(nodeIterator) {
                    /* access modifiers changed from: package-private */
                    public V transform(Map.Entry<K, V> entry) {
                        return entry.getValue();
                    }

                    public void set(V v) {
                        nodeIterator.setValue(v);
                    }
                };
            }
        };
    }

    public List<Map.Entry<K, V>> entries() {
        return (List) super.entries();
    }

    /* access modifiers changed from: package-private */
    public List<Map.Entry<K, V>> createEntries() {
        return new AbstractSequentialList<Map.Entry<K, V>>() {
            public int size() {
                return LinkedListMultimap.this.size;
            }

            public ListIterator<Map.Entry<K, V>> listIterator(int i) {
                return new NodeIterator(i);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> entryIterator() {
        throw new AssertionError("should never be called");
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> createAsMap() {
        return new Multimaps.AsMap(this);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyToKeyList = CompactLinkedHashMap.create();
        int readInt = objectInputStream.readInt();
        for (int i = 0; i < readInt; i++) {
            put(objectInputStream.readObject(), objectInputStream.readObject());
        }
    }
}
