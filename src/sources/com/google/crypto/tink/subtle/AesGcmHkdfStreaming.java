package com.google.crypto.tink.subtle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesGcmHkdfStreaming extends NonceBasedStreamingAead {
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlg;
    private final byte[] ikm;
    /* access modifiers changed from: private */
    public final int keySizeInBytes;
    private final int plaintextSegmentSize;

    public int getCiphertextOverhead() {
        return 16;
    }

    public /* bridge */ /* synthetic */ ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newDecryptingChannel(readableByteChannel, bArr);
    }

    public /* bridge */ /* synthetic */ InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newDecryptingStream(inputStream, bArr);
    }

    public /* bridge */ /* synthetic */ WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newEncryptingChannel(writableByteChannel, bArr);
    }

    public /* bridge */ /* synthetic */ OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newEncryptingStream(outputStream, bArr);
    }

    public /* bridge */ /* synthetic */ SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) throws GeneralSecurityException, IOException {
        return super.newSeekableDecryptingChannel(seekableByteChannel, bArr);
    }

    public AesGcmHkdfStreaming(byte[] bArr, String str, int i, int i2, int i3) throws InvalidAlgorithmParameterException {
        if (bArr.length < 16 || bArr.length < i) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i));
        }
        Validators.validateAesKeySize(i);
        if (i2 > getHeaderLength() + i3 + 16) {
            this.ikm = Arrays.copyOf(bArr, bArr.length);
            this.hkdfAlg = str;
            this.keySizeInBytes = i;
            this.ciphertextSegmentSize = i2;
            this.firstSegmentOffset = i3;
            this.plaintextSegmentSize = i2 - 16;
            return;
        }
        throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
    }

    public AesGcmHkdfStreamEncrypter newStreamSegmentEncrypter(byte[] bArr) throws GeneralSecurityException {
        return new AesGcmHkdfStreamEncrypter(bArr);
    }

    public AesGcmHkdfStreamDecrypter newStreamSegmentDecrypter() throws GeneralSecurityException {
        return new AesGcmHkdfStreamDecrypter();
    }

    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    public int getHeaderLength() {
        return this.keySizeInBytes + 1 + 7;
    }

    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    public long expectedCiphertextSize(long j) {
        long ciphertextOffset = j + ((long) getCiphertextOffset());
        int i = this.plaintextSegmentSize;
        long j2 = (ciphertextOffset / ((long) i)) * ((long) this.ciphertextSegmentSize);
        long j3 = ciphertextOffset % ((long) i);
        return j3 > 0 ? j2 + j3 + 16 : j2;
    }

    /* access modifiers changed from: private */
    public static Cipher cipherInstance() throws GeneralSecurityException {
        return EngineFactory.CIPHER.getInstance("AES/GCM/NoPadding");
    }

    /* access modifiers changed from: private */
    public byte[] randomSalt() {
        return Random.randBytes(this.keySizeInBytes);
    }

    /* access modifiers changed from: private */
    public GCMParameterSpec paramsForSegment(byte[] bArr, int i, boolean z) {
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.put(bArr);
        allocate.putInt(i);
        allocate.put(z ? (byte) 1 : 0);
        return new GCMParameterSpec(128, allocate.array());
    }

    /* access modifiers changed from: private */
    public byte[] randomNonce() {
        return Random.randBytes(7);
    }

    /* access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        return new SecretKeySpec(Hkdf.computeHkdf(this.hkdfAlg, this.ikm, bArr, bArr2, this.keySizeInBytes), "AES");
    }

    class AesGcmHkdfStreamEncrypter implements StreamSegmentEncrypter {
        private final Cipher cipher;
        private int encryptedSegments;
        private ByteBuffer header;
        private final SecretKeySpec keySpec;
        private final byte[] noncePrefix;

        public AesGcmHkdfStreamEncrypter(byte[] bArr) throws GeneralSecurityException {
            this.encryptedSegments = 0;
            this.cipher = AesGcmHkdfStreaming.cipherInstance();
            this.encryptedSegments = 0;
            byte[] access$100 = AesGcmHkdfStreaming.this.randomSalt();
            this.noncePrefix = AesGcmHkdfStreaming.this.randomNonce();
            ByteBuffer allocate = ByteBuffer.allocate(AesGcmHkdfStreaming.this.getHeaderLength());
            this.header = allocate;
            allocate.put((byte) AesGcmHkdfStreaming.this.getHeaderLength());
            this.header.put(access$100);
            this.header.put(this.noncePrefix);
            this.header.flip();
            this.keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(access$100, bArr);
        }

        public ByteBuffer getHeader() {
            return this.header.asReadOnlyBuffer();
        }

        public synchronized void encryptSegment(ByteBuffer byteBuffer, boolean z, ByteBuffer byteBuffer2) throws GeneralSecurityException {
            this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.this.paramsForSegment(this.noncePrefix, this.encryptedSegments, z));
            this.encryptedSegments++;
            this.cipher.doFinal(byteBuffer, byteBuffer2);
        }

        public synchronized void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, ByteBuffer byteBuffer3) throws GeneralSecurityException {
            this.cipher.init(1, this.keySpec, AesGcmHkdfStreaming.this.paramsForSegment(this.noncePrefix, this.encryptedSegments, z));
            this.encryptedSegments++;
            if (byteBuffer2.hasRemaining()) {
                this.cipher.update(byteBuffer, byteBuffer3);
                this.cipher.doFinal(byteBuffer2, byteBuffer3);
            } else {
                this.cipher.doFinal(byteBuffer, byteBuffer3);
            }
        }
    }

    class AesGcmHkdfStreamDecrypter implements StreamSegmentDecrypter {
        private Cipher cipher;
        private SecretKeySpec keySpec;
        private byte[] noncePrefix;

        AesGcmHkdfStreamDecrypter() {
        }

        public synchronized void init(ByteBuffer byteBuffer, byte[] bArr) throws GeneralSecurityException {
            if (byteBuffer.remaining() != AesGcmHkdfStreaming.this.getHeaderLength()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            } else if (byteBuffer.get() == AesGcmHkdfStreaming.this.getHeaderLength()) {
                this.noncePrefix = new byte[7];
                byte[] bArr2 = new byte[AesGcmHkdfStreaming.this.keySizeInBytes];
                byteBuffer.get(bArr2);
                byteBuffer.get(this.noncePrefix);
                this.keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(bArr2, bArr);
                this.cipher = AesGcmHkdfStreaming.cipherInstance();
            } else {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
        }

        public synchronized void decryptSegment(ByteBuffer byteBuffer, int i, boolean z, ByteBuffer byteBuffer2) throws GeneralSecurityException {
            this.cipher.init(2, this.keySpec, AesGcmHkdfStreaming.this.paramsForSegment(this.noncePrefix, i, z));
            this.cipher.doFinal(byteBuffer, byteBuffer2);
        }
    }
}
