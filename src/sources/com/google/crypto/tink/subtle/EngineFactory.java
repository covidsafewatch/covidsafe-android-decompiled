package com.google.crypto.tink.subtle;

import com.google.crypto.tink.subtle.EngineWrapper;
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
    public static final EngineFactory<EngineWrapper.TCipher, Cipher> CIPHER = new EngineFactory<>(new EngineWrapper.TCipher());
    private static final boolean DEFAULT_LET_FALLBACK = true;
    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> KEY_AGREEMENT = new EngineFactory<>(new EngineWrapper.TKeyAgreement());
    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> KEY_FACTORY = new EngineFactory<>(new EngineWrapper.TKeyFactory());
    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> KEY_PAIR_GENERATOR = new EngineFactory<>(new EngineWrapper.TKeyPairGenerator());
    public static final EngineFactory<EngineWrapper.TMac, Mac> MAC = new EngineFactory<>(new EngineWrapper.TMac());
    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> MESSAGE_DIGEST = new EngineFactory<>(new EngineWrapper.TMessageDigest());
    public static final EngineFactory<EngineWrapper.TSignature, Signature> SIGNATURE = new EngineFactory<>(new EngineWrapper.TSignature());
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

    public static final EngineFactory<EngineWrapper.TCipher, Cipher> getCustomCipherProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new EngineWrapper.TCipher(), toProviderList(strArr), z);
    }

    public static final EngineFactory<EngineWrapper.TMac, Mac> getCustomMacProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new EngineWrapper.TMac(), toProviderList(strArr), z);
    }

    public static final EngineFactory<EngineWrapper.TSignature, Signature> getCustomSignatureProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new EngineWrapper.TSignature(), toProviderList(strArr), z);
    }

    public static final EngineFactory<EngineWrapper.TMessageDigest, MessageDigest> getCustomMessageDigestProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new EngineWrapper.TMessageDigest(), toProviderList(strArr), z);
    }

    public static final EngineFactory<EngineWrapper.TKeyAgreement, KeyAgreement> getCustomKeyAgreementProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new EngineWrapper.TKeyAgreement(), toProviderList(strArr), z);
    }

    public static final EngineFactory<EngineWrapper.TKeyPairGenerator, KeyPairGenerator> getCustomKeyPairGeneratorProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new EngineWrapper.TKeyPairGenerator(), toProviderList(strArr), z);
    }

    public static final EngineFactory<EngineWrapper.TKeyFactory, KeyFactory> getCustomKeyFactoryProvider(boolean z, String... strArr) {
        return new EngineFactory<>(new EngineWrapper.TKeyFactory(), toProviderList(strArr), z);
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
        Exception exc = null;
        for (Provider instance : this.policy) {
            try {
                return this.instanceBuilder.getInstance(str, instance);
            } catch (Exception e) {
                if (exc == null) {
                    exc = e;
                }
            }
        }
        if (this.letFallback) {
            return this.instanceBuilder.getInstance(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
