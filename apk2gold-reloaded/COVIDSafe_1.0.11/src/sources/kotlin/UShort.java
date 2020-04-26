package kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b@\u0018\u0000 f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001fB\u0014\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u0010J\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0013J\u001b\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J\u0013\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\rHÖ\u0001J\u0013\u0010%\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b&\u0010\u0005J\u0013\u0010'\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\b(\u0010\u0005J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b*\u0010\u0010J\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b+\u0010\u0013J\u001b\u0010)\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u001fJ\u001b\u0010)\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b-\u0010\u0018J\u001b\u0010.\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\b/\u0010\u000bJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0010J\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b2\u0010\u0013J\u001b\u00100\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b3\u0010\u001fJ\u001b\u00100\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b4\u0010\u0018J\u001b\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b7\u00108J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b:\u0010\u0010J\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b;\u0010\u0013J\u001b\u00109\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\b<\u0010\u001fJ\u001b\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\b=\u0010\u0018J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\nø\u0001\u0000¢\u0006\u0004\b?\u0010\u0010J\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\nø\u0001\u0000¢\u0006\u0004\b@\u0010\u0013J\u001b\u0010>\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\nø\u0001\u0000¢\u0006\u0004\bA\u0010\u001fJ\u001b\u0010>\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\nø\u0001\u0000¢\u0006\u0004\bB\u0010\u0018J\u0010\u0010C\u001a\u00020DH\b¢\u0006\u0004\bE\u0010FJ\u0010\u0010G\u001a\u00020HH\b¢\u0006\u0004\bI\u0010JJ\u0010\u0010K\u001a\u00020LH\b¢\u0006\u0004\bM\u0010NJ\u0010\u0010O\u001a\u00020\rH\b¢\u0006\u0004\bP\u0010QJ\u0010\u0010R\u001a\u00020SH\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\u0003H\b¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[J\u0013\u0010\\\u001a\u00020\u000eH\bø\u0001\u0000¢\u0006\u0004\b]\u0010FJ\u0013\u0010^\u001a\u00020\u0011H\bø\u0001\u0000¢\u0006\u0004\b_\u0010QJ\u0013\u0010`\u001a\u00020\u0014H\bø\u0001\u0000¢\u0006\u0004\ba\u0010UJ\u0013\u0010b\u001a\u00020\u0000H\bø\u0001\u0000¢\u0006\u0004\bc\u0010\u0005J\u001b\u0010d\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\fø\u0001\u0000¢\u0006\u0004\be\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006g"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "data$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-impl", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "hashCode", "inc", "inc-impl", "inv", "inv-impl", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "(S)I", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-impl", "toUInt", "toUInt-impl", "toULong", "toULong-impl", "toUShort", "toUShort-impl", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
/* compiled from: UShort.kt */
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = new Companion(null);
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004XTø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", "S", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
    /* compiled from: UShort.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: box-impl reason: not valid java name */
    public static final /* synthetic */ UShort m249boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: compareTo-xj2QHRw reason: not valid java name */
    private int m253compareToxj2QHRw(short s) {
        return m254compareToxj2QHRw(this.data, s);
    }

    /* renamed from: constructor-impl reason: not valid java name */
    public static short m255constructorimpl(short s) {
        return s;
    }

    public static /* synthetic */ void data$annotations() {
    }

    /* renamed from: equals-impl reason: not valid java name */
    public static boolean m261equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m296unboximpl();
    }

    /* renamed from: equals-impl0 reason: not valid java name */
    public static final boolean m262equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: hashCode-impl reason: not valid java name */
    public static int m263hashCodeimpl(short s) {
        return s;
    }

    /* renamed from: toByte-impl reason: not valid java name */
    private static final byte m284toByteimpl(short s) {
        return (byte) s;
    }

    /* renamed from: toDouble-impl reason: not valid java name */
    private static final double m285toDoubleimpl(short s) {
        return (double) (s & MAX_VALUE);
    }

    /* renamed from: toFloat-impl reason: not valid java name */
    private static final float m286toFloatimpl(short s) {
        return (float) (s & MAX_VALUE);
    }

    /* renamed from: toInt-impl reason: not valid java name */
    private static final int m287toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    /* renamed from: toLong-impl reason: not valid java name */
    private static final long m288toLongimpl(short s) {
        return ((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    /* renamed from: toShort-impl reason: not valid java name */
    private static final short m289toShortimpl(short s) {
        return s;
    }

    /* renamed from: toUShort-impl reason: not valid java name */
    private static final short m294toUShortimpl(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m261equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m263hashCodeimpl(this.data);
    }

    public String toString() {
        return m290toStringimpl(this.data);
    }

    /* renamed from: unbox-impl reason: not valid java name */
    public final /* synthetic */ short m296unboximpl() {
        return this.data;
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return m253compareToxj2QHRw(((UShort) obj).m296unboximpl());
    }

    /* renamed from: compareTo-7apg3OU reason: not valid java name */
    private static final int m250compareTo7apg3OU(short s, byte b) {
        return Intrinsics.compare((int) s & MAX_VALUE, (int) b & 255);
    }

    /* renamed from: compareTo-xj2QHRw reason: not valid java name */
    private static int m254compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare((int) s & MAX_VALUE, (int) s2 & MAX_VALUE);
    }

    /* renamed from: compareTo-WZ4Q5Ns reason: not valid java name */
    private static final int m252compareToWZ4Q5Ns(short s, int i) {
        return UnsignedKt.uintCompare(UInt.m89constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: compareTo-VKZWuLQ reason: not valid java name */
    private static final int m251compareToVKZWuLQ(short s, long j) {
        return UnsignedKt.ulongCompare(ULong.m158constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: plus-7apg3OU reason: not valid java name */
    private static final int m271plus7apg3OU(short s, byte b) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) + UInt.m89constructorimpl(b & 255));
    }

    /* renamed from: plus-xj2QHRw reason: not valid java name */
    private static final int m274plusxj2QHRw(short s, short s2) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) + UInt.m89constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: plus-WZ4Q5Ns reason: not valid java name */
    private static final int m273plusWZ4Q5Ns(short s, int i) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) + i);
    }

    /* renamed from: plus-VKZWuLQ reason: not valid java name */
    private static final long m272plusVKZWuLQ(short s, long j) {
        return ULong.m158constructorimpl(ULong.m158constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j);
    }

    /* renamed from: minus-7apg3OU reason: not valid java name */
    private static final int m266minus7apg3OU(short s, byte b) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) - UInt.m89constructorimpl(b & 255));
    }

    /* renamed from: minus-xj2QHRw reason: not valid java name */
    private static final int m269minusxj2QHRw(short s, short s2) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) - UInt.m89constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: minus-WZ4Q5Ns reason: not valid java name */
    private static final int m268minusWZ4Q5Ns(short s, int i) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) - i);
    }

    /* renamed from: minus-VKZWuLQ reason: not valid java name */
    private static final long m267minusVKZWuLQ(short s, long j) {
        return ULong.m158constructorimpl(ULong.m158constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j);
    }

    /* renamed from: times-7apg3OU reason: not valid java name */
    private static final int m280times7apg3OU(short s, byte b) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) * UInt.m89constructorimpl(b & 255));
    }

    /* renamed from: times-xj2QHRw reason: not valid java name */
    private static final int m283timesxj2QHRw(short s, short s2) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) * UInt.m89constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: times-WZ4Q5Ns reason: not valid java name */
    private static final int m282timesWZ4Q5Ns(short s, int i) {
        return UInt.m89constructorimpl(UInt.m89constructorimpl(s & MAX_VALUE) * i);
    }

    /* renamed from: times-VKZWuLQ reason: not valid java name */
    private static final long m281timesVKZWuLQ(short s, long j) {
        return ULong.m158constructorimpl(ULong.m158constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j);
    }

    /* renamed from: div-7apg3OU reason: not valid java name */
    private static final int m257div7apg3OU(short s, byte b) {
        return UnsignedKt.m315uintDivideJ1ME1BU(UInt.m89constructorimpl(s & MAX_VALUE), UInt.m89constructorimpl(b & 255));
    }

    /* renamed from: div-xj2QHRw reason: not valid java name */
    private static final int m260divxj2QHRw(short s, short s2) {
        return UnsignedKt.m315uintDivideJ1ME1BU(UInt.m89constructorimpl(s & MAX_VALUE), UInt.m89constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: div-WZ4Q5Ns reason: not valid java name */
    private static final int m259divWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m315uintDivideJ1ME1BU(UInt.m89constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: div-VKZWuLQ reason: not valid java name */
    private static final long m258divVKZWuLQ(short s, long j) {
        return UnsignedKt.m317ulongDivideeb3DHEI(ULong.m158constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: rem-7apg3OU reason: not valid java name */
    private static final int m276rem7apg3OU(short s, byte b) {
        return UnsignedKt.m316uintRemainderJ1ME1BU(UInt.m89constructorimpl(s & MAX_VALUE), UInt.m89constructorimpl(b & 255));
    }

    /* renamed from: rem-xj2QHRw reason: not valid java name */
    private static final int m279remxj2QHRw(short s, short s2) {
        return UnsignedKt.m316uintRemainderJ1ME1BU(UInt.m89constructorimpl(s & MAX_VALUE), UInt.m89constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: rem-WZ4Q5Ns reason: not valid java name */
    private static final int m278remWZ4Q5Ns(short s, int i) {
        return UnsignedKt.m316uintRemainderJ1ME1BU(UInt.m89constructorimpl(s & MAX_VALUE), i);
    }

    /* renamed from: rem-VKZWuLQ reason: not valid java name */
    private static final long m277remVKZWuLQ(short s, long j) {
        return UnsignedKt.m318ulongRemaindereb3DHEI(ULong.m158constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX), j);
    }

    /* renamed from: inc-impl reason: not valid java name */
    private static final short m264incimpl(short s) {
        return m255constructorimpl((short) (s + 1));
    }

    /* renamed from: dec-impl reason: not valid java name */
    private static final short m256decimpl(short s) {
        return m255constructorimpl((short) (s - 1));
    }

    /* renamed from: rangeTo-xj2QHRw reason: not valid java name */
    private static final UIntRange m275rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m89constructorimpl(s & MAX_VALUE), UInt.m89constructorimpl(s2 & MAX_VALUE), null);
    }

    /* renamed from: and-xj2QHRw reason: not valid java name */
    private static final short m248andxj2QHRw(short s, short s2) {
        return m255constructorimpl((short) (s & s2));
    }

    /* renamed from: or-xj2QHRw reason: not valid java name */
    private static final short m270orxj2QHRw(short s, short s2) {
        return m255constructorimpl((short) (s | s2));
    }

    /* renamed from: xor-xj2QHRw reason: not valid java name */
    private static final short m295xorxj2QHRw(short s, short s2) {
        return m255constructorimpl((short) (s ^ s2));
    }

    /* renamed from: inv-impl reason: not valid java name */
    private static final short m265invimpl(short s) {
        return m255constructorimpl((short) (~s));
    }

    /* renamed from: toUByte-impl reason: not valid java name */
    private static final byte m291toUByteimpl(short s) {
        return UByte.m22constructorimpl((byte) s);
    }

    /* renamed from: toUInt-impl reason: not valid java name */
    private static final int m292toUIntimpl(short s) {
        return UInt.m89constructorimpl(s & MAX_VALUE);
    }

    /* renamed from: toULong-impl reason: not valid java name */
    private static final long m293toULongimpl(short s) {
        return ULong.m158constructorimpl(((long) s) & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    /* renamed from: toString-impl reason: not valid java name */
    public static String m290toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }
}
