package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0012J\u001b\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u000fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0012J\u001b\u0010)\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u000fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0012J\u001b\u00100\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u000fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0012J\u001b\u00109\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u000fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0012J\u001b\u0010>\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020\u0003H\b¢\u0006\u0004\bD\u0010\u0005J\u0010\u0010E\u001a\u00020FH\b¢\u0006\u0004\bG\u0010HJ\u0010\u0010I\u001a\u00020JH\b¢\u0006\u0004\bK\u0010LJ\u0010\u0010M\u001a\u00020\rH\b¢\u0006\u0004\bN\u0010OJ\u0010\u0010P\u001a\u00020QH\b¢\u0006\u0004\bR\u0010SJ\u0010\u0010T\u001a\u00020UH\b¢\u0006\u0004\bV\u0010WJ\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b]\u0010\u0005J\u0013\u0010^\u001a\u00020\u0010H\bø\u0001\u0000¢\u0006\u0004\b_\u0010OJ\u0013\u0010`\u001a\u00020\u0013H\bø\u0001\u0000¢\u0006\u0004\ba\u0010SJ\u0013\u0010b\u001a\u00020\u0016H\bø\u0001\u0000¢\u0006\u0004\bc\u0010WJ\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "data$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "(B)I", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: UByte.kt */
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = new Companion(null);
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    /* compiled from: UByte.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: box-impl reason: not valid java name */
    public static final /* synthetic */ UByte m16boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: compareTo-7apg3OU reason: not valid java name */
    private int m17compareTo7apg3OU(byte b) {
        return m18compareTo7apg3OU(this.data, b);
    }

    /* renamed from: constructor-impl reason: not valid java name */
    public static byte m22constructorimpl(byte b) {
        return b;
    }

    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m28equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m63unboximpl();
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m29equalsimpl0(byte b, byte b2) {
        return b == b2;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m30hashCodeimpl(byte b) {
        return b;
    }

    /* renamed from: toByte-impl reason: not valid java name */
    private static final byte m51toByteimpl(byte b) {
        return b;
    }

    /* renamed from: toDouble-impl reason: not valid java name */
    private static final double m52toDoubleimpl(byte b) {
        return (double) (b & 255);
    }

    /* renamed from: toFloat-impl reason: not valid java name */
    private static final float m53toFloatimpl(byte b) {
        return (float) (b & 255);
    }

    /* renamed from: toInt-impl reason: not valid java name */
    private static final int m54toIntimpl(byte b) {
        return b & 255;
    }

    /* renamed from: toLong-impl reason: not valid java name */
    private static final long m55toLongimpl(byte b) {
        return ((long) b) & 255;
    }

    /* renamed from: toShort-impl reason: not valid java name */
    private static final short m56toShortimpl(byte b) {
        return (short) (((short) b) & 255);
    }

    /* renamed from: toUByte-impl reason: not valid java name */
    private static final byte m58toUByteimpl(byte b) {
        return b;
    }

    public boolean equals(Object obj) {
        return m28equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m30hashCodeimpl(this.data);
    }

    public String toString() {
        return m57toStringimpl(this.data);
    }

    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ byte m63unboximpl() {
        return this.data;
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m17compareTo7apg3OU(((UByte) obj).m63unboximpl());
    }

    /* renamed from: compareTo-7apg3OU reason: not valid java name */
    private static int m18compareTo7apg3OU(byte b, byte b2) {
        return Intrinsics.compare((int) b & 255, (int) b2 & 255);
    }

    /* renamed from: compareTo-xj2QHRw reason: not valid java name */
    private static final int m21compareToxj2QHRw(byte b, short s) {
        return Intrinsics.compare((int) b & 255, (int) s & UShort.MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns reason: not valid java name */
    private static final int m20compareToWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.uintCompare(UInt.m89constructorimpl(b & 255), i);
    }

    /* renamed from: compareTo-VKZWuLQ reason: not valid java name */
    private static final int m19compareToVKZWuLQ(byte b, long j) {
        return UnsignedKt.ulongCompare(ULong.m158constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: plus-7apg3OU reason: not valid java name */
    private static final int m38plus7apg3OU(byte b, byte b2) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) + UInt.m89constructorimpl(b2 & 255));
    }

    /* renamed from: plus-xj2QHRw reason: not valid java name */
    private static final int m41plusxj2QHRw(byte b, short s) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) + UInt.m89constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns reason: not valid java name */
    private static final int m40plusWZ4Q5Ns(byte b, int i) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) + i);
    }

    /* renamed from: plus-VKZWuLQ reason: not valid java name */
    private static final long m39plusVKZWuLQ(byte b, long j) {
        return ULong.m158constructorimpl(ULong.m158constructorimpl(((long) b) & 255) + j);
    }

    /* renamed from: minus-7apg3OU reason: not valid java name */
    private static final int m33minus7apg3OU(byte b, byte b2) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) - UInt.m89constructorimpl(b2 & 255));
    }

    /* renamed from: minus-xj2QHRw reason: not valid java name */
    private static final int m36minusxj2QHRw(byte b, short s) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) - UInt.m89constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns reason: not valid java name */
    private static final int m35minusWZ4Q5Ns(byte b, int i) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) - i);
    }

    /* renamed from: minus-VKZWuLQ reason: not valid java name */
    private static final long m34minusVKZWuLQ(byte b, long j) {
        return ULong.m158constructorimpl(ULong.m158constructorimpl(((long) b) & 255) - j);
    }

    /* renamed from: times-7apg3OU reason: not valid java name */
    private static final int m47times7apg3OU(byte b, byte b2) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) * UInt.m89constructorimpl(b2 & 255));
    }

    /* renamed from: times-xj2QHRw reason: not valid java name */
    private static final int m50timesxj2QHRw(byte b, short s) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) * UInt.m89constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns reason: not valid java name */
    private static final int m49timesWZ4Q5Ns(byte b, int i) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(b & 255) * i);
    }

    /* renamed from: times-VKZWuLQ reason: not valid java name */
    private static final long m48timesVKZWuLQ(byte b, long j) {
        return ULong.m158constructorimpl(ULong.m158constructorimpl(((long) b) & 255) * j);
    }

    /* renamed from: div-7apg3OU reason: not valid java name */
    private static final int m24div7apg3OU(byte b, byte b2) {
        return UnsignedKt.m315uintDivideJ1ME1BU(UInt.m89constructorimpl(b & 255), UInt.m89constructorimpl(b2 & 255));
    }

    /* renamed from: div-xj2QHRw reason: not valid java name */
    private static final int m27divxj2QHRw(byte b, short s) {
        return UnsignedKt.m315uintDivideJ1ME1BU(UInt.m89constructorimpl(b & 255), UInt.m89constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns reason: not valid java name */
    private static final int m26divWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m315uintDivideJ1ME1BU(UInt.m89constructorimpl(b & 255), i);
    }

    /* renamed from: div-VKZWuLQ reason: not valid java name */
    private static final long m25divVKZWuLQ(byte b, long j) {
        return UnsignedKt.m317ulongDivideeb3DHEI(ULong.m158constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: rem-7apg3OU reason: not valid java name */
    private static final int m43rem7apg3OU(byte b, byte b2) {
        return UnsignedKt.m316uintRemainderJ1ME1BU(UInt.m89constructorimpl(b & 255), UInt.m89constructorimpl(b2 & 255));
    }

    /* renamed from: rem-xj2QHRw reason: not valid java name */
    private static final int m46remxj2QHRw(byte b, short s) {
        return UnsignedKt.m316uintRemainderJ1ME1BU(UInt.m89constructorimpl(b & 255), UInt.m89constructorimpl(s & UShort.MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns reason: not valid java name */
    private static final int m45remWZ4Q5Ns(byte b, int i) {
        return UnsignedKt.m316uintRemainderJ1ME1BU(UInt.m89constructorimpl(b & 255), i);
    }

    /* renamed from: rem-VKZWuLQ reason: not valid java name */
    private static final long m44remVKZWuLQ(byte b, long j) {
        return UnsignedKt.m318ulongRemaindereb3DHEI(ULong.m158constructorimpl(((long) b) & 255), j);
    }

    /* renamed from: inc-impl reason: not valid java name */
    private static final byte m31incimpl(byte b) {
        return m22constructorimpl((byte) (b + 1));
    }

    /* renamed from: dec-impl reason: not valid java name */
    private static final byte m23decimpl(byte b) {
        return m22constructorimpl((byte) (b - 1));
    }

    /* renamed from: rangeTo-7apg3OU reason: not valid java name */
    private static final UIntRange m42rangeTo7apg3OU(byte b, byte b2) {
        return new UIntRange(UInt.m89constructorimpl(b & 255), UInt.m89constructorimpl(b2 & 255), null);
    }

    /* renamed from: and-7apg3OU reason: not valid java name */
    private static final byte m15and7apg3OU(byte b, byte b2) {
        return m22constructorimpl((byte) (b & b2));
    }

    /* renamed from: or-7apg3OU reason: not valid java name */
    private static final byte m37or7apg3OU(byte b, byte b2) {
        return m22constructorimpl((byte) (b | b2));
    }

    /* renamed from: xor-7apg3OU reason: not valid java name */
    private static final byte m62xor7apg3OU(byte b, byte b2) {
        return m22constructorimpl((byte) (b ^ b2));
    }

    /* renamed from: inv-impl reason: not valid java name */
    private static final byte m32invimpl(byte b) {
        return m22constructorimpl((byte) (~b));
    }

    /* renamed from: toUShort-impl reason: not valid java name */
    private static final short m61toUShortimpl(byte b) {
        return UShort.m255constructorimpl((short) (((short) b) & 255));
    }

    /* renamed from: toUInt-impl reason: not valid java name */
    private static final int m59toUIntimpl(byte b) {
        return UInt.m89constructorimpl(b & 255);
    }

    /* renamed from: toULong-impl reason: not valid java name */
    private static final long m60toULongimpl(byte b) {
        return ULong.m158constructorimpl(((long) b) & 255);
    }

    /* renamed from: toString-impl reason: not valid java name */
    public static String m57toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }
}
