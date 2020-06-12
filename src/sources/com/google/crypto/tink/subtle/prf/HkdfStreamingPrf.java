package com.google.crypto.tink.subtle.prf;

import com.google.crypto.tink.subtle.EngineFactory;
import com.google.crypto.tink.subtle.Enums;
import com.google.errorprone.annotations.Immutable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

@Immutable
public class HkdfStreamingPrf implements StreamingPrf {
    /* access modifiers changed from: private */
    public final Enums.HashType hashType;
    /* access modifiers changed from: private */
    public final byte[] ikm;
    /* access modifiers changed from: private */
    public final byte[] salt;

    /* renamed from: com.google.crypto.tink.subtle.prf.HkdfStreamingPrf$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.google.crypto.tink.subtle.Enums$HashType[] r0 = com.google.crypto.tink.subtle.Enums.HashType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = r0
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA256     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA384     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.crypto.tink.subtle.Enums$HashType r1 = com.google.crypto.tink.subtle.Enums.HashType.SHA512     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.crypto.tink.subtle.prf.HkdfStreamingPrf.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    public static String getJavaxHmacName(Enums.HashType hashType2) throws GeneralSecurityException {
        int i = AnonymousClass1.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType2.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha384";
        }
        if (i == 4) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("No getJavaxHmacName for given hash " + hashType2 + " known");
    }

    public HkdfStreamingPrf(Enums.HashType hashType2, byte[] bArr, byte[] bArr2) {
        this.hashType = hashType2;
        this.ikm = Arrays.copyOf(bArr, bArr.length);
        this.salt = Arrays.copyOf(bArr2, bArr2.length);
    }

    private class HkdfInputStream extends InputStream {
        private ByteBuffer buffer;
        private int ctr = -1;
        private final byte[] input;
        private Mac mac;
        private byte[] prk;

        public HkdfInputStream(byte[] bArr) {
            this.input = Arrays.copyOf(bArr, bArr.length);
        }

        private void initialize() throws GeneralSecurityException, IOException {
            try {
                this.mac = EngineFactory.MAC.getInstance(HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType));
                if (HkdfStreamingPrf.this.salt == null || HkdfStreamingPrf.this.salt.length == 0) {
                    this.mac.init(new SecretKeySpec(new byte[this.mac.getMacLength()], HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                } else {
                    this.mac.init(new SecretKeySpec(HkdfStreamingPrf.this.salt, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                }
                this.mac.update(HkdfStreamingPrf.this.ikm);
                this.prk = this.mac.doFinal();
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(0);
                this.buffer = allocateDirect;
                allocateDirect.mark();
                this.ctr = 0;
            } catch (GeneralSecurityException e) {
                throw new IOException("Creating HMac failed", e);
            }
        }

        private void updateBuffer() throws GeneralSecurityException, IOException {
            this.mac.init(new SecretKeySpec(this.prk, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
            this.buffer.reset();
            this.mac.update(this.buffer);
            this.mac.update(this.input);
            int i = this.ctr + 1;
            this.ctr = i;
            this.mac.update((byte) i);
            ByteBuffer wrap = ByteBuffer.wrap(this.mac.doFinal());
            this.buffer = wrap;
            wrap.mark();
        }

        public int read() throws IOException {
            byte[] bArr = new byte[1];
            int read = read(bArr, 0, 1);
            if (read == 1) {
                return bArr[0] & 255;
            }
            if (read == -1) {
                return read;
            }
            throw new IOException("Reading failed");
        }

        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            try {
                if (this.ctr == -1) {
                    initialize();
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (!this.buffer.hasRemaining()) {
                        if (this.ctr == 255) {
                            return i3;
                        }
                        updateBuffer();
                    }
                    int min = Math.min(i2 - i3, this.buffer.remaining());
                    this.buffer.get(bArr, i, min);
                    i += min;
                    i3 += min;
                }
                return i3;
            } catch (GeneralSecurityException e) {
                this.mac = null;
                throw new IOException("HkdfInputStream failed", e);
            }
        }
    }

    public InputStream computePrf(byte[] bArr) {
        return new HkdfInputStream(bArr);
    }
}
