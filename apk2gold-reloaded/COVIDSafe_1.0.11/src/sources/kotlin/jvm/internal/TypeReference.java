package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\u0017\u001a\u00020\u0013H\u0002J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\f\u0010\u0017\u001a\u00020\u0013*\u00020\u0006H\u0002R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u001c\u0010\u0012\u001a\u00020\u0013*\u0006\u0012\u0002\b\u00030\u00148BX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "()Z", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "equals", "other", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: TypeReference.kt */
public final class TypeReference implements KType {
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final boolean isMarkedNullable;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            $EnumSwitchMapping$0[KVariance.IN.ordinal()] = 2;
            $EnumSwitchMapping$0[KVariance.OUT.ordinal()] = 3;
        }
    }

    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        Intrinsics.checkParameterIsNotNull(kClassifier, "classifier");
        Intrinsics.checkParameterIsNotNull(list, "arguments");
        this.classifier = kClassifier;
        this.arguments = list;
        this.isMarkedNullable = z;
    }

    public KClassifier getClassifier() {
        return this.classifier;
    }

    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (Intrinsics.areEqual((Object) getClassifier(), (Object) typeReference.getClassifier()) && Intrinsics.areEqual((Object) getArguments(), (Object) typeReference.getArguments()) && isMarkedNullable() == typeReference.isMarkedNullable()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Boolean.valueOf(isMarkedNullable()).hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(asString());
        sb.append(" (Kotlin reflection is not available)");
        return sb.toString();
    }

    private final String asString() {
        String str;
        String str2;
        KClassifier classifier2 = getClassifier();
        Class cls = null;
        if (!(classifier2 instanceof KClass)) {
            classifier2 = null;
        }
        KClass kClass = (KClass) classifier2;
        if (kClass != null) {
            cls = JvmClassMappingKt.getJavaClass(kClass);
        }
        if (cls == null) {
            str = getClassifier().toString();
        } else if (cls.isArray()) {
            str = getArrayClassName(cls);
        } else {
            str = cls.getName();
        }
        String str3 = "";
        if (getArguments().isEmpty()) {
            str2 = str3;
        } else {
            str2 = CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new TypeReference$asString$args$1(this), 24, null);
        }
        if (isMarkedNullable()) {
            str3 = "?";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    private final String getArrayClassName(Class<?> cls) {
        if (Intrinsics.areEqual((Object) cls, (Object) boolean[].class)) {
            return "kotlin.BooleanArray";
        }
        if (Intrinsics.areEqual((Object) cls, (Object) char[].class)) {
            return "kotlin.CharArray";
        }
        if (Intrinsics.areEqual((Object) cls, (Object) byte[].class)) {
            return "kotlin.ByteArray";
        }
        if (Intrinsics.areEqual((Object) cls, (Object) short[].class)) {
            return "kotlin.ShortArray";
        }
        if (Intrinsics.areEqual((Object) cls, (Object) int[].class)) {
            return "kotlin.IntArray";
        }
        if (Intrinsics.areEqual((Object) cls, (Object) float[].class)) {
            return "kotlin.FloatArray";
        }
        if (Intrinsics.areEqual((Object) cls, (Object) long[].class)) {
            return "kotlin.LongArray";
        }
        return Intrinsics.areEqual((Object) cls, (Object) double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        if (r0 != null) goto L_0x0025;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String asString(kotlin.reflect.KTypeProjection r3) {
        /*
            r2 = this;
            kotlin.reflect.KVariance r0 = r3.getVariance()
            if (r0 != 0) goto L_0x0009
            java.lang.String r3 = "*"
            return r3
        L_0x0009:
            kotlin.reflect.KType r0 = r3.getType()
            boolean r1 = r0 instanceof kotlin.jvm.internal.TypeReference
            if (r1 != 0) goto L_0x0012
            r0 = 0
        L_0x0012:
            kotlin.jvm.internal.TypeReference r0 = (kotlin.jvm.internal.TypeReference) r0
            if (r0 == 0) goto L_0x001d
            java.lang.String r0 = r0.asString()
            if (r0 == 0) goto L_0x001d
            goto L_0x0025
        L_0x001d:
            kotlin.reflect.KType r0 = r3.getType()
            java.lang.String r0 = java.lang.String.valueOf(r0)
        L_0x0025:
            kotlin.reflect.KVariance r3 = r3.getVariance()
            if (r3 == 0) goto L_0x0060
            int[] r1 = kotlin.jvm.internal.TypeReference.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r1[r3]
            r1 = 1
            if (r3 == r1) goto L_0x005f
            r1 = 2
            if (r3 == r1) goto L_0x004e
            r1 = 3
            if (r3 != r1) goto L_0x0060
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "out "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            goto L_0x005f
        L_0x004e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = "in "
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x005f:
            return r0
        L_0x0060:
            kotlin.NoWhenBranchMatchedException r3 = new kotlin.NoWhenBranchMatchedException
            r3.<init>()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.TypeReference.asString(kotlin.reflect.KTypeProjection):java.lang.String");
    }
}
