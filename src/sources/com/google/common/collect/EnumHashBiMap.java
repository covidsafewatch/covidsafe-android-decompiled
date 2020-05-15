package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ boolean containsValue(@NullableDecl Object obj) {
        return super.containsValue(obj);
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ BiMap inverse() {
        return super.inverse();
    }

    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    public /* bridge */ /* synthetic */ Object remove(@NullableDecl Object obj) {
        return super.remove(obj);
    }

    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.inferKeyType(map));
        create.putAll(map);
        return create;
    }

    private EnumHashBiMap(Class<K> cls) {
        super(new EnumMap(cls), Maps.newHashMapWithExpectedSize(((Enum[]) cls.getEnumConstants()).length));
        this.keyType = cls;
    }

    /* access modifiers changed from: package-private */
    public K checkKey(K k) {
        return (Enum) Preconditions.checkNotNull(k);
    }

    public V put(K k, @NullableDecl V v) {
        return super.put(k, v);
    }

    public V forcePut(K k, @NullableDecl V v) {
        return super.forcePut(k, v);
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        Serialization.writeMap(this, objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        setDelegates(new EnumMap(this.keyType), new HashMap((((Enum[]) this.keyType.getEnumConstants()).length * 3) / 2));
        Serialization.populateMap(this, objectInputStream);
    }
}
