package com.google.common.net;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.primitives.Ints;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.UShort;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class InetAddresses {
    /* access modifiers changed from: private */
    public static final Inet4Address ANY4 = ((Inet4Address) forString("0.0.0.0"));
    private static final int IPV4_PART_COUNT = 4;
    private static final Splitter IPV4_SPLITTER = Splitter.on('.').limit(4);
    private static final int IPV6_PART_COUNT = 8;
    private static final Splitter IPV6_SPLITTER = Splitter.on(':').limit(10);
    private static final Inet4Address LOOPBACK4 = ((Inet4Address) forString("127.0.0.1"));

    private InetAddresses() {
    }

    private static Inet4Address getInet4Address(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 4, "Byte array has invalid length for an IPv4 address: %s != 4.", bArr.length);
        return (Inet4Address) bytesToInetAddress(bArr);
    }

    public static InetAddress forString(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes != null) {
            return bytesToInetAddress(ipStringToBytes);
        }
        throw formatIllegalArgumentException("'%s' is not an IP string literal.", str);
    }

    public static boolean isInetAddress(String str) {
        return ipStringToBytes(str) != null;
    }

    @NullableDecl
    private static byte[] ipStringToBytes(String str) {
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (i >= str.length()) {
                i = -1;
                break;
            }
            char charAt = str.charAt(i);
            if (charAt == '.') {
                z = true;
            } else if (charAt == ':') {
                if (z) {
                    return null;
                }
                z2 = true;
            } else if (charAt == '%') {
                break;
            } else if (Character.digit(charAt, 16) == -1) {
                return null;
            }
            i++;
        }
        if (z2) {
            if (z && (str = convertDottedQuadToHex(str)) == null) {
                return null;
            }
            if (i != -1) {
                str = str.substring(0, i);
            }
            return textToNumericFormatV6(str);
        } else if (z) {
            return textToNumericFormatV4(str);
        } else {
            return null;
        }
    }

    @NullableDecl
    private static byte[] textToNumericFormatV4(String str) {
        byte[] bArr = new byte[4];
        try {
            int i = 0;
            for (String parseOctet : IPV4_SPLITTER.split(str)) {
                int i2 = i + 1;
                bArr[i] = parseOctet(parseOctet);
                i = i2;
            }
            if (i == 4) {
                return bArr;
            }
            return null;
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @NullableDecl
    private static byte[] textToNumericFormatV6(String str) {
        int i;
        int i2;
        List<String> splitToList = IPV6_SPLITTER.splitToList(str);
        if (splitToList.size() < 3 || splitToList.size() > 9) {
            return null;
        }
        int i3 = -1;
        for (int i4 = 1; i4 < splitToList.size() - 1; i4++) {
            if (splitToList.get(i4).length() == 0) {
                if (i3 >= 0) {
                    return null;
                }
                i3 = i4;
            }
        }
        if (i3 >= 0) {
            i2 = (splitToList.size() - i3) - 1;
            if (splitToList.get(0).length() == 0) {
                i = i3 - 1;
                if (i != 0) {
                    return null;
                }
            } else {
                i = i3;
            }
            if (((String) Iterables.getLast(splitToList)).length() == 0 && i2 - 1 != 0) {
                return null;
            }
        } else {
            i = splitToList.size();
            i2 = 0;
        }
        int i5 = 8 - (i + i2);
        if (i3 < 0 ? i5 != 0 : i5 < 1) {
            return null;
        }
        ByteBuffer allocate = ByteBuffer.allocate(16);
        int i6 = 0;
        while (i6 < i) {
            try {
                allocate.putShort(parseHextet(splitToList.get(i6)));
                i6++;
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        for (int i7 = 0; i7 < i5; i7++) {
            allocate.putShort(0);
        }
        while (i2 > 0) {
            allocate.putShort(parseHextet(splitToList.get(splitToList.size() - i2)));
            i2--;
        }
        return allocate.array();
    }

    @NullableDecl
    private static String convertDottedQuadToHex(String str) {
        int lastIndexOf = str.lastIndexOf(58) + 1;
        String substring = str.substring(0, lastIndexOf);
        byte[] textToNumericFormatV4 = textToNumericFormatV4(str.substring(lastIndexOf));
        if (textToNumericFormatV4 == null) {
            return null;
        }
        String hexString = Integer.toHexString(((textToNumericFormatV4[0] & 255) << 8) | (textToNumericFormatV4[1] & 255));
        String hexString2 = Integer.toHexString((textToNumericFormatV4[3] & 255) | ((textToNumericFormatV4[2] & 255) << 8));
        return substring + hexString + ":" + hexString2;
    }

    private static byte parseOctet(String str) {
        int parseInt = Integer.parseInt(str);
        if (parseInt <= 255 && (!str.startsWith("0") || str.length() <= 1)) {
            return (byte) parseInt;
        }
        throw new NumberFormatException();
    }

    private static short parseHextet(String str) {
        int parseInt = Integer.parseInt(str, 16);
        if (parseInt <= 65535) {
            return (short) parseInt;
        }
        throw new NumberFormatException();
    }

    private static InetAddress bytesToInetAddress(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static String toAddrString(InetAddress inetAddress) {
        Preconditions.checkNotNull(inetAddress);
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        Preconditions.checkArgument(inetAddress instanceof Inet6Address);
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            int i2 = i * 2;
            iArr[i] = Ints.fromBytes((byte) 0, (byte) 0, address[i2], address[i2 + 1]);
        }
        compressLongestRunOfZeroes(iArr);
        return hextetsToIPv6String(iArr);
    }

    private static void compressLongestRunOfZeroes(int[] iArr) {
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < iArr.length + 1; i4++) {
            if (i4 >= iArr.length || iArr[i4] != 0) {
                if (i3 >= 0) {
                    int i5 = i4 - i3;
                    if (i5 > i) {
                        i2 = i3;
                        i = i5;
                    }
                    i3 = -1;
                }
            } else if (i3 < 0) {
                i3 = i4;
            }
        }
        if (i >= 2) {
            Arrays.fill(iArr, i2, i + i2, -1);
        }
    }

    private static String hextetsToIPv6String(int[] iArr) {
        StringBuilder sb = new StringBuilder(39);
        int i = 0;
        boolean z = false;
        while (i < iArr.length) {
            boolean z2 = iArr[i] >= 0;
            if (z2) {
                if (z) {
                    sb.append(':');
                }
                sb.append(Integer.toHexString(iArr[i]));
            } else if (i == 0 || z) {
                sb.append("::");
            }
            i++;
            z = z2;
        }
        return sb.toString();
    }

    public static String toUriString(InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet6Address)) {
            return toAddrString(inetAddress);
        }
        return "[" + toAddrString(inetAddress) + "]";
    }

    public static InetAddress forUriString(String str) {
        InetAddress forUriStringNoThrow = forUriStringNoThrow(str);
        if (forUriStringNoThrow != null) {
            return forUriStringNoThrow;
        }
        throw formatIllegalArgumentException("Not a valid URI IP literal: '%s'", str);
    }

    @NullableDecl
    private static InetAddress forUriStringNoThrow(String str) {
        int i;
        Preconditions.checkNotNull(str);
        if (!str.startsWith("[") || !str.endsWith("]")) {
            i = 4;
        } else {
            str = str.substring(1, str.length() - 1);
            i = 16;
        }
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes == null || ipStringToBytes.length != i) {
            return null;
        }
        return bytesToInetAddress(ipStringToBytes);
    }

    public static boolean isUriInetAddress(String str) {
        return forUriStringNoThrow(str) != null;
    }

    public static boolean isCompatIPv4Address(Inet6Address inet6Address) {
        if (!inet6Address.isIPv4CompatibleAddress()) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if (address[12] == 0 && address[13] == 0 && address[14] == 0 && (address[15] == 0 || address[15] == 1)) {
            return false;
        }
        return true;
    }

    public static Inet4Address getCompatIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isCompatIPv4Address(inet6Address), "Address '%s' is not IPv4-compatible.", (Object) toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static boolean is6to4Address(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] == 32 && address[1] == 2) {
            return true;
        }
        return false;
    }

    public static Inet4Address get6to4IPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(is6to4Address(inet6Address), "Address '%s' is not a 6to4 address.", (Object) toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 2, 6));
    }

    public static final class TeredoInfo {
        private final Inet4Address client;
        private final int flags;
        private final int port;
        private final Inet4Address server;

        public TeredoInfo(@NullableDecl Inet4Address inet4Address, @NullableDecl Inet4Address inet4Address2, int i, int i2) {
            boolean z = true;
            Preconditions.checkArgument(i >= 0 && i <= 65535, "port '%s' is out of range (0 <= port <= 0xffff)", i);
            Preconditions.checkArgument((i2 < 0 || i2 > 65535) ? false : z, "flags '%s' is out of range (0 <= flags <= 0xffff)", i2);
            this.server = (Inet4Address) MoreObjects.firstNonNull(inet4Address, InetAddresses.ANY4);
            this.client = (Inet4Address) MoreObjects.firstNonNull(inet4Address2, InetAddresses.ANY4);
            this.port = i;
            this.flags = i2;
        }

        public Inet4Address getServer() {
            return this.server;
        }

        public Inet4Address getClient() {
            return this.client;
        }

        public int getPort() {
            return this.port;
        }

        public int getFlags() {
            return this.flags;
        }
    }

    public static boolean isTeredoAddress(Inet6Address inet6Address) {
        byte[] address = inet6Address.getAddress();
        if (address[0] == 32 && address[1] == 1 && address[2] == 0 && address[3] == 0) {
            return true;
        }
        return false;
    }

    public static TeredoInfo getTeredoInfo(Inet6Address inet6Address) {
        Preconditions.checkArgument(isTeredoAddress(inet6Address), "Address '%s' is not a Teredo address.", (Object) toAddrString(inet6Address));
        byte[] address = inet6Address.getAddress();
        Inet4Address inet4Address = getInet4Address(Arrays.copyOfRange(address, 4, 8));
        short readShort = ByteStreams.newDataInput(address, 8).readShort() & UShort.MAX_VALUE;
        int i = 65535 & (~ByteStreams.newDataInput(address, 10).readShort());
        byte[] copyOfRange = Arrays.copyOfRange(address, 12, 16);
        for (int i2 = 0; i2 < copyOfRange.length; i2++) {
            copyOfRange[i2] = (byte) (~copyOfRange[i2]);
        }
        return new TeredoInfo(inet4Address, getInet4Address(copyOfRange), i, readShort);
    }

    public static boolean isIsatapAddress(Inet6Address inet6Address) {
        if (isTeredoAddress(inet6Address)) {
            return false;
        }
        byte[] address = inet6Address.getAddress();
        if ((address[8] | 3) == 3 && address[9] == 0 && address[10] == 94 && address[11] == -2) {
            return true;
        }
        return false;
    }

    public static Inet4Address getIsatapIPv4Address(Inet6Address inet6Address) {
        Preconditions.checkArgument(isIsatapAddress(inet6Address), "Address '%s' is not an ISATAP address.", (Object) toAddrString(inet6Address));
        return getInet4Address(Arrays.copyOfRange(inet6Address.getAddress(), 12, 16));
    }

    public static boolean hasEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        return isCompatIPv4Address(inet6Address) || is6to4Address(inet6Address) || isTeredoAddress(inet6Address);
    }

    public static Inet4Address getEmbeddedIPv4ClientAddress(Inet6Address inet6Address) {
        if (isCompatIPv4Address(inet6Address)) {
            return getCompatIPv4Address(inet6Address);
        }
        if (is6to4Address(inet6Address)) {
            return get6to4IPv4Address(inet6Address);
        }
        if (isTeredoAddress(inet6Address)) {
            return getTeredoInfo(inet6Address).getClient();
        }
        throw formatIllegalArgumentException("'%s' has no embedded IPv4 address.", toAddrString(inet6Address));
    }

    public static boolean isMappedIPv4Address(String str) {
        byte[] ipStringToBytes = ipStringToBytes(str);
        if (ipStringToBytes == null || ipStringToBytes.length != 16) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= 10) {
                for (int i2 = 10; i2 < 12; i2++) {
                    if (ipStringToBytes[i2] != -1) {
                        return false;
                    }
                }
                return true;
            } else if (ipStringToBytes[i] != 0) {
                return false;
            } else {
                i++;
            }
        }
    }

    public static Inet4Address getCoercedIPv4Address(InetAddress inetAddress) {
        boolean z;
        long j;
        if (inetAddress instanceof Inet4Address) {
            return (Inet4Address) inetAddress;
        }
        byte[] address = inetAddress.getAddress();
        int i = 0;
        while (true) {
            if (i >= 15) {
                z = true;
                break;
            } else if (address[i] != 0) {
                z = false;
                break;
            } else {
                i++;
            }
        }
        if (z && address[15] == 1) {
            return LOOPBACK4;
        }
        if (z && address[15] == 0) {
            return ANY4;
        }
        Inet6Address inet6Address = (Inet6Address) inetAddress;
        if (hasEmbeddedIPv4ClientAddress(inet6Address)) {
            j = (long) getEmbeddedIPv4ClientAddress(inet6Address).hashCode();
        } else {
            j = ByteBuffer.wrap(inet6Address.getAddress(), 0, 8).getLong();
        }
        int asInt = Hashing.murmur3_32().hashLong(j).asInt() | -536870912;
        if (asInt == -1) {
            asInt = -2;
        }
        return getInet4Address(Ints.toByteArray(asInt));
    }

    public static int coerceToInteger(InetAddress inetAddress) {
        return ByteStreams.newDataInput(getCoercedIPv4Address(inetAddress).getAddress()).readInt();
    }

    public static BigInteger toBigInteger(InetAddress inetAddress) {
        return new BigInteger(1, inetAddress.getAddress());
    }

    public static Inet4Address fromInteger(int i) {
        return getInet4Address(Ints.toByteArray(i));
    }

    public static Inet4Address fromIPv4BigInteger(BigInteger bigInteger) {
        return (Inet4Address) fromBigInteger(bigInteger, false);
    }

    public static Inet6Address fromIPv6BigInteger(BigInteger bigInteger) {
        return (Inet6Address) fromBigInteger(bigInteger, true);
    }

    private static InetAddress fromBigInteger(BigInteger bigInteger, boolean z) {
        Preconditions.checkArgument(bigInteger.signum() >= 0, "BigInteger must be greater than or equal to 0");
        int i = z ? 16 : 4;
        byte[] byteArray = bigInteger.toByteArray();
        byte[] bArr = new byte[i];
        int max = Math.max(0, byteArray.length - i);
        int length = byteArray.length - max;
        int i2 = i - length;
        int i3 = 0;
        while (i3 < max) {
            if (byteArray[i3] == 0) {
                i3++;
            } else {
                throw formatIllegalArgumentException("BigInteger cannot be converted to InetAddress because it has more than %d bytes: %s", Integer.valueOf(i), bigInteger);
            }
        }
        System.arraycopy(byteArray, max, bArr, i2, length);
        try {
            return InetAddress.getByAddress(bArr);
        } catch (UnknownHostException e) {
            throw new AssertionError(e);
        }
    }

    public static InetAddress fromLittleEndianByteArray(byte[] bArr) throws UnknownHostException {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[(bArr.length - i) - 1];
        }
        return InetAddress.getByAddress(bArr2);
    }

    public static InetAddress decrement(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        int length = address.length - 1;
        while (length >= 0 && address[length] == 0) {
            address[length] = -1;
            length--;
        }
        Preconditions.checkArgument(length >= 0, "Decrementing %s would wrap.", (Object) inetAddress);
        address[length] = (byte) (address[length] - 1);
        return bytesToInetAddress(address);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.net.InetAddress increment(java.net.InetAddress r6) {
        /*
            byte[] r0 = r6.getAddress()
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
        L_0x0007:
            r3 = 0
            if (r1 < 0) goto L_0x0014
            byte r4 = r0[r1]
            r5 = -1
            if (r4 != r5) goto L_0x0014
            r0[r1] = r3
            int r1 = r1 + -1
            goto L_0x0007
        L_0x0014:
            if (r1 < 0) goto L_0x0017
            r3 = 1
        L_0x0017:
            java.lang.String r4 = "Incrementing %s would wrap."
            com.google.common.base.Preconditions.checkArgument((boolean) r3, (java.lang.String) r4, (java.lang.Object) r6)
            byte r6 = r0[r1]
            int r6 = r6 + r2
            byte r6 = (byte) r6
            r0[r1] = r6
            java.net.InetAddress r6 = bytesToInetAddress(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.net.InetAddresses.increment(java.net.InetAddress):java.net.InetAddress");
    }

    public static boolean isMaximum(InetAddress inetAddress) {
        byte[] address = inetAddress.getAddress();
        for (byte b : address) {
            if (b != -1) {
                return false;
            }
        }
        return true;
    }

    private static IllegalArgumentException formatIllegalArgumentException(String str, Object... objArr) {
        return new IllegalArgumentException(String.format(Locale.ROOT, str, objArr));
    }
}
