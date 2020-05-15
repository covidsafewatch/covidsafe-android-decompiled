package com.google.protobuf;

import java.io.IOException;

public class LazyFieldLite {
    private static final ExtensionRegistryLite EMPTY_REGISTRY = ExtensionRegistryLite.getEmptyRegistry();
    private ByteString delayedBytes;
    private ExtensionRegistryLite extensionRegistry;
    private volatile ByteString memoizedBytes;
    protected volatile MessageLite value;

    public int hashCode() {
        return 1;
    }

    public LazyFieldLite(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        checkArguments(extensionRegistryLite, byteString);
        this.extensionRegistry = extensionRegistryLite;
        this.delayedBytes = byteString;
    }

    public LazyFieldLite() {
    }

    public static LazyFieldLite fromValue(MessageLite messageLite) {
        LazyFieldLite lazyFieldLite = new LazyFieldLite();
        lazyFieldLite.setValue(messageLite);
        return lazyFieldLite;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.value;
        MessageLite messageLite2 = lazyFieldLite.value;
        if (messageLite == null && messageLite2 == null) {
            return toByteString().equals(lazyFieldLite.toByteString());
        }
        if (messageLite != null && messageLite2 != null) {
            return messageLite.equals(messageLite2);
        }
        if (messageLite != null) {
            return messageLite.equals(lazyFieldLite.getValue(messageLite.getDefaultInstanceForType()));
        }
        return getValue(messageLite2.getDefaultInstanceForType()).equals(messageLite2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
        r0 = r2.delayedBytes;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean containsDefaultInstance() {
        /*
            r2 = this;
            com.google.protobuf.ByteString r0 = r2.memoizedBytes
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.EMPTY
            if (r0 == r1) goto L_0x0015
            com.google.protobuf.MessageLite r0 = r2.value
            if (r0 != 0) goto L_0x0013
            com.google.protobuf.ByteString r0 = r2.delayedBytes
            if (r0 == 0) goto L_0x0015
            com.google.protobuf.ByteString r1 = com.google.protobuf.ByteString.EMPTY
            if (r0 != r1) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyFieldLite.containsDefaultInstance():boolean");
    }

    public void clear() {
        this.delayedBytes = null;
        this.value = null;
        this.memoizedBytes = null;
    }

    public void set(LazyFieldLite lazyFieldLite) {
        this.delayedBytes = lazyFieldLite.delayedBytes;
        this.value = lazyFieldLite.value;
        this.memoizedBytes = lazyFieldLite.memoizedBytes;
        ExtensionRegistryLite extensionRegistryLite = lazyFieldLite.extensionRegistry;
        if (extensionRegistryLite != null) {
            this.extensionRegistry = extensionRegistryLite;
        }
    }

    public MessageLite getValue(MessageLite messageLite) {
        ensureInitialized(messageLite);
        return this.value;
    }

    public MessageLite setValue(MessageLite messageLite) {
        MessageLite messageLite2 = this.value;
        this.delayedBytes = null;
        this.memoizedBytes = null;
        this.value = messageLite;
        return messageLite2;
    }

    public void merge(LazyFieldLite lazyFieldLite) {
        ByteString byteString;
        if (!lazyFieldLite.containsDefaultInstance()) {
            if (containsDefaultInstance()) {
                set(lazyFieldLite);
                return;
            }
            if (this.extensionRegistry == null) {
                this.extensionRegistry = lazyFieldLite.extensionRegistry;
            }
            ByteString byteString2 = this.delayedBytes;
            if (byteString2 != null && (byteString = lazyFieldLite.delayedBytes) != null) {
                this.delayedBytes = byteString2.concat(byteString);
            } else if (this.value == null && lazyFieldLite.value != null) {
                setValue(mergeValueAndBytes(lazyFieldLite.value, this.delayedBytes, this.extensionRegistry));
            } else if (this.value != null && lazyFieldLite.value == null) {
                setValue(mergeValueAndBytes(this.value, lazyFieldLite.delayedBytes, lazyFieldLite.extensionRegistry));
            } else if (lazyFieldLite.extensionRegistry != null) {
                setValue(mergeValueAndBytes(this.value, lazyFieldLite.toByteString(), lazyFieldLite.extensionRegistry));
            } else if (this.extensionRegistry != null) {
                setValue(mergeValueAndBytes(lazyFieldLite.value, toByteString(), this.extensionRegistry));
            } else {
                setValue(mergeValueAndBytes(this.value, lazyFieldLite.toByteString(), EMPTY_REGISTRY));
            }
        }
    }

    public void mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        if (containsDefaultInstance()) {
            setByteString(codedInputStream.readBytes(), extensionRegistryLite);
            return;
        }
        if (this.extensionRegistry == null) {
            this.extensionRegistry = extensionRegistryLite;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            setByteString(byteString.concat(codedInputStream.readBytes()), this.extensionRegistry);
            return;
        }
        try {
            setValue(this.value.toBuilder().mergeFrom(codedInputStream, extensionRegistryLite).build());
        } catch (InvalidProtocolBufferException unused) {
        }
    }

    private static MessageLite mergeValueAndBytes(MessageLite messageLite, ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        try {
            return messageLite.toBuilder().mergeFrom(byteString, extensionRegistryLite).build();
        } catch (InvalidProtocolBufferException unused) {
            return messageLite;
        }
    }

    public void setByteString(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        checkArguments(extensionRegistryLite, byteString);
        this.delayedBytes = byteString;
        this.extensionRegistry = extensionRegistryLite;
        this.value = null;
        this.memoizedBytes = null;
    }

    public int getSerializedSize() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes.size();
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.value != null) {
            return this.value.getSerializedSize();
        }
        return 0;
    }

    public ByteString toByteString() {
        if (this.memoizedBytes != null) {
            return this.memoizedBytes;
        }
        ByteString byteString = this.delayedBytes;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            if (this.memoizedBytes != null) {
                ByteString byteString2 = this.memoizedBytes;
                return byteString2;
            }
            if (this.value == null) {
                this.memoizedBytes = ByteString.EMPTY;
            } else {
                this.memoizedBytes = this.value.toByteString();
            }
            ByteString byteString3 = this.memoizedBytes;
            return byteString3;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r3.value = r4;
        r3.memoizedBytes = com.google.protobuf.ByteString.EMPTY;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x002c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void ensureInitialized(com.google.protobuf.MessageLite r4) {
        /*
            r3 = this;
            com.google.protobuf.MessageLite r0 = r3.value
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            monitor-enter(r3)
            com.google.protobuf.MessageLite r0 = r3.value     // Catch:{ all -> 0x0034 }
            if (r0 == 0) goto L_0x000c
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x000c:
            com.google.protobuf.ByteString r0 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            if (r0 == 0) goto L_0x0025
            com.google.protobuf.Parser r0 = r4.getParserForType()     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r1 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ExtensionRegistryLite r2 = r3.extensionRegistry     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            java.lang.Object r0 = r0.parseFrom((com.google.protobuf.ByteString) r1, (com.google.protobuf.ExtensionRegistryLite) r2)     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.MessageLite r0 = (com.google.protobuf.MessageLite) r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.value = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r0 = r3.delayedBytes     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.memoizedBytes = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x0025:
            r3.value = r4     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.EMPTY     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            r3.memoizedBytes = r0     // Catch:{ InvalidProtocolBufferException -> 0x002c }
            goto L_0x0032
        L_0x002c:
            r3.value = r4     // Catch:{ all -> 0x0034 }
            com.google.protobuf.ByteString r4 = com.google.protobuf.ByteString.EMPTY     // Catch:{ all -> 0x0034 }
            r3.memoizedBytes = r4     // Catch:{ all -> 0x0034 }
        L_0x0032:
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            return
        L_0x0034:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0034 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.LazyFieldLite.ensureInitialized(com.google.protobuf.MessageLite):void");
    }

    private static void checkArguments(ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        if (extensionRegistryLite == null) {
            throw new NullPointerException("found null ExtensionRegistry");
        } else if (byteString == null) {
            throw new NullPointerException("found null ByteString");
        }
    }
}
