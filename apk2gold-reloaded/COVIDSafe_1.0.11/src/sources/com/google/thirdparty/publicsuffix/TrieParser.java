package com.google.thirdparty.publicsuffix;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Lists;
import java.util.List;

final class TrieParser {
    private static final Joiner PREFIX_JOINER = Joiner.on("");

    TrieParser() {
    }

    static ImmutableMap<String, PublicSuffixType> parseTrie(CharSequence charSequence) {
        Builder builder = ImmutableMap.builder();
        int i = 0;
        while (i < charSequence.length()) {
            i += doParseTrieToBuilder(Lists.newLinkedList(), charSequence, i, builder);
        }
        return builder.build();
    }

    private static int doParseTrieToBuilder(List<CharSequence> list, CharSequence charSequence, int i, Builder<String, PublicSuffixType> builder) {
        int length = charSequence.length();
        int i2 = i;
        char c = 0;
        while (i2 < length) {
            c = charSequence.charAt(i2);
            if (c == '&' || c == '?' || c == '!' || c == ':' || c == ',') {
                break;
            }
            i2++;
        }
        list.add(0, reverse(charSequence.subSequence(i, i2)));
        if (c == '!' || c == '?' || c == ':' || c == ',') {
            String join = PREFIX_JOINER.join((Iterable<?>) list);
            if (join.length() > 0) {
                builder.put(join, PublicSuffixType.fromCode(c));
            }
        }
        int i3 = i2 + 1;
        if (c != '?' && c != ',') {
            while (true) {
                if (i3 >= length) {
                    break;
                }
                i3 += doParseTrieToBuilder(list, charSequence, i3, builder);
                if (charSequence.charAt(i3) != '?') {
                    if (charSequence.charAt(i3) == ',') {
                        break;
                    }
                } else {
                    break;
                }
            }
            i3++;
        }
        list.remove(0);
        return i3 - i;
    }

    private static CharSequence reverse(CharSequence charSequence) {
        return new StringBuilder(charSequence).reverse();
    }
}
