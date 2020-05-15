package com.google.thirdparty.publicsuffix;

public enum PublicSuffixType {
    PRIVATE(':', ','),
    REGISTRY('!', '?');
    
    private final char innerNodeCode;
    private final char leafNodeCode;

    private PublicSuffixType(char c, char c2) {
        this.innerNodeCode = c;
        this.leafNodeCode = c2;
    }

    /* access modifiers changed from: package-private */
    public char getLeafNodeCode() {
        return this.leafNodeCode;
    }

    /* access modifiers changed from: package-private */
    public char getInnerNodeCode() {
        return this.innerNodeCode;
    }

    static PublicSuffixType fromCode(char c) {
        for (PublicSuffixType publicSuffixType : values()) {
            if (publicSuffixType.getInnerNodeCode() == c || publicSuffixType.getLeafNodeCode() == c) {
                return publicSuffixType;
            }
        }
        throw new IllegalArgumentException("No enum corresponding to given code: " + c);
    }

    static PublicSuffixType fromIsPrivate(boolean z) {
        return z ? PRIVATE : REGISTRY;
    }
}
