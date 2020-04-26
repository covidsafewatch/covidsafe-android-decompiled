package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public interface Hasher extends PrimitiveSink {
    HashCode hash();

    @Deprecated
    int hashCode();

    Hasher putBoolean(boolean z);

    Hasher putByte(byte b);

    Hasher putBytes(ByteBuffer byteBuffer);

    Hasher putBytes(byte[] bArr);

    Hasher putBytes(byte[] bArr, int i, int i2);

    Hasher putChar(char c);

    Hasher putDouble(double d);

    Hasher putFloat(float f);

    Hasher putInt(int i);

    Hasher putLong(long j);

    <T> Hasher putObject(T t, Funnel<? super T> funnel);

    Hasher putShort(short s);

    Hasher putString(CharSequence charSequence, Charset charset);

    Hasher putUnencodedChars(CharSequence charSequence);
}
