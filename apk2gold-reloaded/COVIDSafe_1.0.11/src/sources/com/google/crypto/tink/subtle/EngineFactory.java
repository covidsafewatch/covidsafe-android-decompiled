package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.EngineWrapper;
import com.google.crypto.tink.subtle.EngineWrapper.TCipher;
import com.google.crypto.tink.subtle.EngineWrapper.TKeyAgreement;
import com.google.crypto.tink.subtle.EngineWrapper.TKeyFactory;
import com.google.crypto.tink.subtle.EngineWrapper.TKeyPairGenerator;
import com.google.crypto.tink.subtle.EngineWrapper.TMac;
import com.google.crypto.tink.subtle.EngineWrapper.TMessageDigest;
import com.google.crypto.tink.subtle.EngineWrapper.TSignature;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class EngineFactory<T_WRAPPER extends EngineWrapper<T_ENGINE>, T_ENGINE> {
    public static final EngineFactory<TCipher, Cipher> CIPHER = new EngineFactory<>(new TCipher());
    private static final boolean DEFAULT_LET_FALLBACK = true;
    public static final EngineFactory<TKeyAgreement, KeyAgreement> KEY_AGREEMENT = new EngineFactory<>(new TKeyAgreement());
    public static final EngineFactory<TKeyFactory, KeyFactory> KEY_FACTORY = new EngineFactory<>(new TKeyFactory());
    public static final EngineFactory<TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR = new EngineFactory<>(new TKeyPairGenerator());
    public static final EngineFactory<TMac, Mac> MAC = new EngineFactory<>(new TMac());
    public static final EngineFactory<TMessageDigest, MessageDigest> MESSAGE_DIGEST = new EngineFactory<>(new TMessageDigest());
    public static final EngineFactory<TSignature, Signature> SIGNATURE = new EngineFactory<>(new TSignature());
    private static final List<Provider> defaultPolicy;
    private static final Logger logger = Logger.getLogger(EngineFactory.class.getName());
    private T_WRAPPER instanceBuilder;
    private boolean letFallback;
    private List<Provider> policy;

    static {
        if (SubtleUtil.isAndroid()) {
            defaultPolicy = toProviderList("GmsCore_OpenSSL", "AndroidOpenSSL");
        } else {
            defaultPolicy = new ArrayList();
        }
    }

    public static final EngineFactory<TCipher, Cipher> getCustomCipherProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new TCipher(), toProviderList(strArr), z);
    }

    public static final EngineFactory<TMac, Mac> getCustomMacProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new TMac(), toProviderList(strArr), z);
    }

    public static final EngineFactory<TSignature, Signature> getCustomSignatureProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new TSignature(), toProviderList(strArr), z);
    }

    public static final EngineFactory<TMessageDigest, MessageDigest> getCustomMessageDigestProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new TMessageDigest(), toProviderList(strArr), z);
    }

    public static final EngineFactory<TKeyAgreement, KeyAgreement> getCustomKeyAgreementProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new TKeyAgreement(), toProviderList(strArr), z);
    }

    public static final EngineFactory<TKeyPairGenerator, KeyPairGenerator> getCustomKeyPairGeneratorProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new TKeyPairGenerator(), toProviderList(strArr), z);
    }

    public static final EngineFactory<TKeyFactory, KeyFactory> getCustomKeyFactoryProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new TKeyFactory(), toProviderList(strArr), z);
    }

    public static List<Provider> toProviderList(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                logger.info(String.format("Provider %s not available", new Object[]{str}));
            }
        }
        return arrayList;
    }

    public EngineFactory(T_WRAPPER t_wrapper) {
        this.instanceBuilder = t_wrapper;
        this.policy = defaultPolicy;
        this.letFallback = DEFAULT_LET_FALLBACK;
    }

    public EngineFactory(T_WRAPPER t_wrapper, List<Provider> list) {
        this.instanceBuilder = t_wrapper;
        this.policy = list;
        this.letFallback = DEFAULT_LET_FALLBACK;
    }

    public EngineFactory(T_WRAPPER t_wrapper, List<Provider> list, boolean z) {
        this.instanceBuilder = t_wrapper;
        this.policy = list;
        this.letFallback = z;
    }

    public T_ENGINE getInstance(String str) throws GeneralSecurityException {
        for (Provider provider : this.policy) {
            if (tryProvider(str, provider)) {
                return this.instanceBuilder.getInstance(str, provider);
            }
        }
        if (this.letFallback) {
            return this.instanceBuilder.getInstance(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }

    private boolean tryProvider(String str, Provider provider) {
        try {
            this.instanceBuilder.getInstance(str, provider);
            return DEFAULT_LET_FALLBACK;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
