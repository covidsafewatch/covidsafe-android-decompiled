package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: KType.kt */
public final class KTypeProjection {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final KTypeProjection STAR = new KTypeProjection((KVariance) null, (KType) null);
    private final KType type;
    private final KVariance variance;

    public static /* synthetic */ KTypeProjection copy$default(KTypeProjection kTypeProjection, KVariance kVariance, KType kType, int i, Object obj) {
        if ((i & 1) != 0) {
            kVariance = kTypeProjection.variance;
        }
        if ((i & 2) != 0) {
            kType = kTypeProjection.type;
        }
        return kTypeProjection.copy(kVariance, kType);
    }

    public final KVariance component1() {
        return this.variance;
    }

    public final KType component2() {
        return this.type;
    }

    public final KTypeProjection copy(KVariance kVariance, KType kType) {
        return new KTypeProjection(kVariance, kType);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KTypeProjection)) {
            return false;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) obj;
        return Intrinsics.areEqual((Object) this.variance, (Object) kTypeProjection.variance) && Intrinsics.areEqual((Object) this.type, (Object) kTypeProjection.type);
    }

    public int hashCode() {
        KVariance kVariance = this.variance;
        int i = 0;
        int hashCode = (kVariance != null ? kVariance.hashCode() : 0) * 31;
        KType kType = this.type;
        if (kType != null) {
            i = kType.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "KTypeProjection(variance=" + this.variance + ", type=" + this.type + ")";
    }

    public KTypeProjection(KVariance kVariance, KType kType) {
        this.variance = kVariance;
        this.type = kType;
    }

    public final KVariance getVariance() {
        return this.variance;
    }

    public final KType getType() {
        return this.type;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    /* compiled from: KType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KTypeProjection getSTAR() {
            return KTypeProjection.STAR;
        }

        public final KTypeProjection invariant(KType kType) {
            Intrinsics.checkParameterIsNotNull(kType, "type");
            return new KTypeProjection(KVariance.INVARIANT, kType);
        }

        public final KTypeProjection contravariant(KType kType) {
            Intrinsics.checkParameterIsNotNull(kType, "type");
            return new KTypeProjection(KVariance.IN, kType);
        }

        public final KTypeProjection covariant(KType kType) {
            Intrinsics.checkParameterIsNotNull(kType, "type");
            return new KTypeProjection(KVariance.OUT, kType);
        }
    }
}
