package com.google.common.net;

import com.google.common.base.Ascii;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;
import kotlin.text.Typography;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable
public final class MediaType {
    public static final MediaType AAC_AUDIO = createConstant(AUDIO_TYPE, "aac");
    public static final MediaType ANY_APPLICATION_TYPE = createConstant(APPLICATION_TYPE, WILDCARD);
    public static final MediaType ANY_AUDIO_TYPE = createConstant(AUDIO_TYPE, WILDCARD);
    public static final MediaType ANY_IMAGE_TYPE = createConstant(IMAGE_TYPE, WILDCARD);
    public static final MediaType ANY_TEXT_TYPE = createConstant(TEXT_TYPE, WILDCARD);
    public static final MediaType ANY_TYPE = createConstant(WILDCARD, WILDCARD);
    public static final MediaType ANY_VIDEO_TYPE = createConstant(VIDEO_TYPE, WILDCARD);
    public static final MediaType APPLE_MOBILE_CONFIG = createConstant(APPLICATION_TYPE, "x-apple-aspen-config");
    public static final MediaType APPLE_PASSBOOK = createConstant(APPLICATION_TYPE, "vnd.apple.pkpass");
    public static final MediaType APPLICATION_BINARY = createConstant(APPLICATION_TYPE, "binary");
    private static final String APPLICATION_TYPE = "application";
    public static final MediaType APPLICATION_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xml");
    public static final MediaType ATOM_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "atom+xml");
    private static final String AUDIO_TYPE = "audio";
    public static final MediaType BASIC_AUDIO = createConstant(AUDIO_TYPE, "basic");
    public static final MediaType BMP = createConstant(IMAGE_TYPE, "bmp");
    public static final MediaType BZIP2 = createConstant(APPLICATION_TYPE, "x-bzip2");
    public static final MediaType CACHE_MANIFEST_UTF_8 = createConstantUtf8(TEXT_TYPE, "cache-manifest");
    private static final String CHARSET_ATTRIBUTE = "charset";
    public static final MediaType CRW = createConstant(IMAGE_TYPE, "x-canon-crw");
    public static final MediaType CSS_UTF_8 = createConstantUtf8(TEXT_TYPE, "css");
    public static final MediaType CSV_UTF_8 = createConstantUtf8(TEXT_TYPE, "csv");
    public static final MediaType DART_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "dart");
    public static final MediaType EOT = createConstant(APPLICATION_TYPE, "vnd.ms-fontobject");
    public static final MediaType EPUB = createConstant(APPLICATION_TYPE, "epub+zip");
    public static final MediaType FLV_VIDEO = createConstant(VIDEO_TYPE, "x-flv");
    public static final MediaType FORM_DATA = createConstant(APPLICATION_TYPE, "x-www-form-urlencoded");
    public static final MediaType GEO_JSON = createConstant(APPLICATION_TYPE, "geo+json");
    public static final MediaType GIF = createConstant(IMAGE_TYPE, "gif");
    public static final MediaType GZIP = createConstant(APPLICATION_TYPE, "x-gzip");
    public static final MediaType HAL_JSON = createConstant(APPLICATION_TYPE, "hal+json");
    public static final MediaType HEIF = createConstant(IMAGE_TYPE, "heif");
    public static final MediaType HTML_UTF_8 = createConstantUtf8(TEXT_TYPE, "html");
    public static final MediaType ICO = createConstant(IMAGE_TYPE, "vnd.microsoft.icon");
    private static final String IMAGE_TYPE = "image";
    public static final MediaType I_CALENDAR_UTF_8 = createConstantUtf8(TEXT_TYPE, "calendar");
    public static final MediaType JAVASCRIPT_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "javascript");
    public static final MediaType JOSE = createConstant(APPLICATION_TYPE, "jose");
    public static final MediaType JOSE_JSON = createConstant(APPLICATION_TYPE, "jose+json");
    public static final MediaType JP2K = createConstant(IMAGE_TYPE, "jp2");
    public static final MediaType JPEG = createConstant(IMAGE_TYPE, "jpeg");
    public static final MediaType JSON_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "json");
    public static final MediaType KEY_ARCHIVE = createConstant(APPLICATION_TYPE, "pkcs12");
    public static final MediaType KML = createConstant(APPLICATION_TYPE, "vnd.google-earth.kml+xml");
    public static final MediaType KMZ = createConstant(APPLICATION_TYPE, "vnd.google-earth.kmz");
    private static final Map<MediaType, MediaType> KNOWN_TYPES = Maps.newHashMap();
    public static final MediaType L16_AUDIO = createConstant(AUDIO_TYPE, "l16");
    public static final MediaType L24_AUDIO = createConstant(AUDIO_TYPE, "l24");
    private static final CharMatcher LINEAR_WHITE_SPACE = CharMatcher.anyOf(" \t\r\n");
    public static final MediaType MANIFEST_JSON_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "manifest+json");
    public static final MediaType MBOX = createConstant(APPLICATION_TYPE, "mbox");
    public static final MediaType MEDIA_PRESENTATION_DESCRIPTION = createConstant(APPLICATION_TYPE, "dash+xml");
    public static final MediaType MICROSOFT_EXCEL = createConstant(APPLICATION_TYPE, "vnd.ms-excel");
    public static final MediaType MICROSOFT_OUTLOOK = createConstant(APPLICATION_TYPE, "vnd.ms-outlook");
    public static final MediaType MICROSOFT_POWERPOINT = createConstant(APPLICATION_TYPE, "vnd.ms-powerpoint");
    public static final MediaType MICROSOFT_WORD = createConstant(APPLICATION_TYPE, "msword");
    public static final MediaType MP4_AUDIO = createConstant(AUDIO_TYPE, "mp4");
    public static final MediaType MP4_VIDEO = createConstant(VIDEO_TYPE, "mp4");
    public static final MediaType MPEG_AUDIO = createConstant(AUDIO_TYPE, "mpeg");
    public static final MediaType MPEG_VIDEO = createConstant(VIDEO_TYPE, "mpeg");
    public static final MediaType NACL_APPLICATION = createConstant(APPLICATION_TYPE, "x-nacl");
    public static final MediaType NACL_PORTABLE_APPLICATION = createConstant(APPLICATION_TYPE, "x-pnacl");
    public static final MediaType OCTET_STREAM = createConstant(APPLICATION_TYPE, "octet-stream");
    public static final MediaType OGG_AUDIO = createConstant(AUDIO_TYPE, "ogg");
    public static final MediaType OGG_CONTAINER = createConstant(APPLICATION_TYPE, "ogg");
    public static final MediaType OGG_VIDEO = createConstant(VIDEO_TYPE, "ogg");
    public static final MediaType OOXML_DOCUMENT = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final MediaType OOXML_PRESENTATION = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final MediaType OOXML_SHEET = createConstant(APPLICATION_TYPE, "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final MediaType OPENDOCUMENT_GRAPHICS = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.graphics");
    public static final MediaType OPENDOCUMENT_PRESENTATION = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.presentation");
    public static final MediaType OPENDOCUMENT_SPREADSHEET = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.spreadsheet");
    public static final MediaType OPENDOCUMENT_TEXT = createConstant(APPLICATION_TYPE, "vnd.oasis.opendocument.text");
    public static final MediaType OPENSEARCH_DESCRIPTION_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "opensearchdescription+xml");
    private static final Joiner.MapJoiner PARAMETER_JOINER = Joiner.on("; ").withKeyValueSeparator("=");
    public static final MediaType PDF = createConstant(APPLICATION_TYPE, "pdf");
    public static final MediaType PLAIN_TEXT_UTF_8 = createConstantUtf8(TEXT_TYPE, "plain");
    public static final MediaType PNG = createConstant(IMAGE_TYPE, "png");
    public static final MediaType POSTSCRIPT = createConstant(APPLICATION_TYPE, "postscript");
    public static final MediaType PROTOBUF = createConstant(APPLICATION_TYPE, "protobuf");
    public static final MediaType PSD = createConstant(IMAGE_TYPE, "vnd.adobe.photoshop");
    public static final MediaType QUICKTIME = createConstant(VIDEO_TYPE, "quicktime");
    private static final CharMatcher QUOTED_TEXT_MATCHER = CharMatcher.ascii().and(CharMatcher.noneOf("\"\\\r"));
    public static final MediaType RDF_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "rdf+xml");
    public static final MediaType RTF_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "rtf");
    public static final MediaType SFNT = createConstant(APPLICATION_TYPE, "font-sfnt");
    public static final MediaType SHOCKWAVE_FLASH = createConstant(APPLICATION_TYPE, "x-shockwave-flash");
    public static final MediaType SKETCHUP = createConstant(APPLICATION_TYPE, "vnd.sketchup.skp");
    public static final MediaType SOAP_XML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "soap+xml");
    public static final MediaType SVG_UTF_8 = createConstantUtf8(IMAGE_TYPE, "svg+xml");
    public static final MediaType TAR = createConstant(APPLICATION_TYPE, "x-tar");
    public static final MediaType TEXT_JAVASCRIPT_UTF_8 = createConstantUtf8(TEXT_TYPE, "javascript");
    private static final String TEXT_TYPE = "text";
    public static final MediaType THREE_GPP2_VIDEO = createConstant(VIDEO_TYPE, "3gpp2");
    public static final MediaType THREE_GPP_VIDEO = createConstant(VIDEO_TYPE, "3gpp");
    public static final MediaType TIFF = createConstant(IMAGE_TYPE, "tiff");
    /* access modifiers changed from: private */
    public static final CharMatcher TOKEN_MATCHER = CharMatcher.ascii().and(CharMatcher.javaIsoControl().negate()).and(CharMatcher.isNot(' ')).and(CharMatcher.noneOf("()<>@,;:\\\"/[]?="));
    public static final MediaType TSV_UTF_8 = createConstantUtf8(TEXT_TYPE, "tab-separated-values");
    private static final ImmutableListMultimap<String, String> UTF_8_CONSTANT_PARAMETERS = ImmutableListMultimap.of(CHARSET_ATTRIBUTE, Ascii.toLowerCase(Charsets.UTF_8.name()));
    public static final MediaType VCARD_UTF_8 = createConstantUtf8(TEXT_TYPE, "vcard");
    private static final String VIDEO_TYPE = "video";
    public static final MediaType VND_REAL_AUDIO = createConstant(AUDIO_TYPE, "vnd.rn-realaudio");
    public static final MediaType VND_WAVE_AUDIO = createConstant(AUDIO_TYPE, "vnd.wave");
    public static final MediaType VORBIS_AUDIO = createConstant(AUDIO_TYPE, "vorbis");
    public static final MediaType VTT_UTF_8 = createConstantUtf8(TEXT_TYPE, "vtt");
    public static final MediaType WASM_APPLICATION = createConstant(APPLICATION_TYPE, "wasm");
    public static final MediaType WAX_AUDIO = createConstant(AUDIO_TYPE, "x-ms-wax");
    public static final MediaType WEBM_AUDIO = createConstant(AUDIO_TYPE, "webm");
    public static final MediaType WEBM_VIDEO = createConstant(VIDEO_TYPE, "webm");
    public static final MediaType WEBP = createConstant(IMAGE_TYPE, "webp");
    private static final String WILDCARD = "*";
    public static final MediaType WMA_AUDIO = createConstant(AUDIO_TYPE, "x-ms-wma");
    public static final MediaType WML_UTF_8 = createConstantUtf8(TEXT_TYPE, "vnd.wap.wml");
    public static final MediaType WMV = createConstant(VIDEO_TYPE, "x-ms-wmv");
    public static final MediaType WOFF = createConstant(APPLICATION_TYPE, "font-woff");
    public static final MediaType WOFF2 = createConstant(APPLICATION_TYPE, "font-woff2");
    public static final MediaType XHTML_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xhtml+xml");
    public static final MediaType XML_UTF_8 = createConstantUtf8(TEXT_TYPE, "xml");
    public static final MediaType XRD_UTF_8 = createConstantUtf8(APPLICATION_TYPE, "xrd+xml");
    public static final MediaType ZIP = createConstant(APPLICATION_TYPE, "zip");
    @LazyInit
    private int hashCode;
    private final ImmutableListMultimap<String, String> parameters;
    @LazyInit
    private Optional<Charset> parsedCharset;
    private final String subtype;
    @LazyInit
    private String toString;
    private final String type;

    private static MediaType createConstant(String str, String str2) {
        MediaType addKnownType = addKnownType(new MediaType(str, str2, ImmutableListMultimap.of()));
        addKnownType.parsedCharset = Optional.absent();
        return addKnownType;
    }

    private static MediaType createConstantUtf8(String str, String str2) {
        MediaType addKnownType = addKnownType(new MediaType(str, str2, UTF_8_CONSTANT_PARAMETERS));
        addKnownType.parsedCharset = Optional.of(Charsets.UTF_8);
        return addKnownType;
    }

    private static MediaType addKnownType(MediaType mediaType) {
        KNOWN_TYPES.put(mediaType, mediaType);
        return mediaType;
    }

    private MediaType(String str, String str2, ImmutableListMultimap<String, String> immutableListMultimap) {
        this.type = str;
        this.subtype = str2;
        this.parameters = immutableListMultimap;
    }

    public String type() {
        return this.type;
    }

    public String subtype() {
        return this.subtype;
    }

    public ImmutableListMultimap<String, String> parameters() {
        return this.parameters;
    }

    private Map<String, ImmutableMultiset<String>> parametersAsMap() {
        return Maps.transformValues(this.parameters.asMap(), new Function<Collection<String>, ImmutableMultiset<String>>() {
            public ImmutableMultiset<String> apply(Collection<String> collection) {
                return ImmutableMultiset.copyOf(collection);
            }
        });
    }

    public Optional<Charset> charset() {
        Optional<Charset> optional = this.parsedCharset;
        if (optional == null) {
            Optional<Charset> absent = Optional.absent();
            UnmodifiableIterator it = this.parameters.get((Object) CHARSET_ATTRIBUTE).iterator();
            Optional<Charset> optional2 = absent;
            String str = null;
            optional = optional2;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str == null) {
                    optional = Optional.of(Charset.forName(str2));
                    str = str2;
                } else if (!str.equals(str2)) {
                    throw new IllegalStateException("Multiple charset values defined: " + str + ", " + str2);
                }
            }
            this.parsedCharset = optional;
        }
        return optional;
    }

    public MediaType withoutParameters() {
        return this.parameters.isEmpty() ? this : create(this.type, this.subtype);
    }

    public MediaType withParameters(Multimap<String, String> multimap) {
        return create(this.type, this.subtype, multimap);
    }

    public MediaType withParameters(String str, Iterable<String> iterable) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(iterable);
        String normalizeToken = normalizeToken(str);
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        UnmodifiableIterator<Map.Entry<String, String>> it = this.parameters.entries().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String str2 = (String) next.getKey();
            if (!normalizeToken.equals(str2)) {
                builder.put(str2, next.getValue());
            }
        }
        for (String normalizeParameterValue : iterable) {
            builder.put(normalizeToken, normalizeParameterValue(normalizeToken, normalizeParameterValue));
        }
        MediaType mediaType = new MediaType(this.type, this.subtype, builder.build());
        if (!normalizeToken.equals(CHARSET_ATTRIBUTE)) {
            mediaType.parsedCharset = this.parsedCharset;
        }
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
    }

    public MediaType withParameter(String str, String str2) {
        return withParameters(str, ImmutableSet.of(str2));
    }

    public MediaType withCharset(Charset charset) {
        Preconditions.checkNotNull(charset);
        MediaType withParameter = withParameter(CHARSET_ATTRIBUTE, charset.name());
        withParameter.parsedCharset = Optional.of(charset);
        return withParameter;
    }

    public boolean hasWildcard() {
        return WILDCARD.equals(this.type) || WILDCARD.equals(this.subtype);
    }

    public boolean is(MediaType mediaType) {
        return (mediaType.type.equals(WILDCARD) || mediaType.type.equals(this.type)) && (mediaType.subtype.equals(WILDCARD) || mediaType.subtype.equals(this.subtype)) && this.parameters.entries().containsAll(mediaType.parameters.entries());
    }

    public static MediaType create(String str, String str2) {
        MediaType create = create(str, str2, ImmutableListMultimap.of());
        create.parsedCharset = Optional.absent();
        return create;
    }

    private static MediaType create(String str, String str2, Multimap<String, String> multimap) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(str2);
        Preconditions.checkNotNull(multimap);
        String normalizeToken = normalizeToken(str);
        String normalizeToken2 = normalizeToken(str2);
        Preconditions.checkArgument(!WILDCARD.equals(normalizeToken) || WILDCARD.equals(normalizeToken2), "A wildcard type cannot be used with a non-wildcard subtype");
        ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
        for (Map.Entry next : multimap.entries()) {
            String normalizeToken3 = normalizeToken((String) next.getKey());
            builder.put(normalizeToken3, normalizeParameterValue(normalizeToken3, (String) next.getValue()));
        }
        MediaType mediaType = new MediaType(normalizeToken, normalizeToken2, builder.build());
        return (MediaType) MoreObjects.firstNonNull(KNOWN_TYPES.get(mediaType), mediaType);
    }

    static MediaType createApplicationType(String str) {
        return create(APPLICATION_TYPE, str);
    }

    static MediaType createAudioType(String str) {
        return create(AUDIO_TYPE, str);
    }

    static MediaType createImageType(String str) {
        return create(IMAGE_TYPE, str);
    }

    static MediaType createTextType(String str) {
        return create(TEXT_TYPE, str);
    }

    static MediaType createVideoType(String str) {
        return create(VIDEO_TYPE, str);
    }

    private static String normalizeToken(String str) {
        Preconditions.checkArgument(TOKEN_MATCHER.matchesAllOf(str));
        Preconditions.checkArgument(!str.isEmpty());
        return Ascii.toLowerCase(str);
    }

    private static String normalizeParameterValue(String str, String str2) {
        Preconditions.checkNotNull(str2);
        Preconditions.checkArgument(CharMatcher.ascii().matchesAllOf(str2), "parameter values must be ASCII: %s", (Object) str2);
        return CHARSET_ATTRIBUTE.equals(str) ? Ascii.toLowerCase(str2) : str2;
    }

    public static MediaType parse(String str) {
        String str2;
        Preconditions.checkNotNull(str);
        Tokenizer tokenizer = new Tokenizer(str);
        try {
            String consumeToken = tokenizer.consumeToken(TOKEN_MATCHER);
            tokenizer.consumeCharacter('/');
            String consumeToken2 = tokenizer.consumeToken(TOKEN_MATCHER);
            ImmutableListMultimap.Builder builder = ImmutableListMultimap.builder();
            while (tokenizer.hasMore()) {
                tokenizer.consumeTokenIfPresent(LINEAR_WHITE_SPACE);
                tokenizer.consumeCharacter(';');
                tokenizer.consumeTokenIfPresent(LINEAR_WHITE_SPACE);
                String consumeToken3 = tokenizer.consumeToken(TOKEN_MATCHER);
                tokenizer.consumeCharacter('=');
                if ('\"' == tokenizer.previewChar()) {
                    tokenizer.consumeCharacter((char) Typography.quote);
                    StringBuilder sb = new StringBuilder();
                    while ('\"' != tokenizer.previewChar()) {
                        if ('\\' == tokenizer.previewChar()) {
                            tokenizer.consumeCharacter('\\');
                            sb.append(tokenizer.consumeCharacter(CharMatcher.ascii()));
                        } else {
                            sb.append(tokenizer.consumeToken(QUOTED_TEXT_MATCHER));
                        }
                    }
                    str2 = sb.toString();
                    tokenizer.consumeCharacter((char) Typography.quote);
                } else {
                    str2 = tokenizer.consumeToken(TOKEN_MATCHER);
                }
                builder.put(consumeToken3, str2);
            }
            return create(consumeToken, consumeToken2, builder.build());
        } catch (IllegalStateException e) {
            throw new IllegalArgumentException("Could not parse '" + str + "'", e);
        }
    }

    private static final class Tokenizer {
        final String input;
        int position = 0;

        Tokenizer(String str) {
            this.input = str;
        }

        /* access modifiers changed from: package-private */
        public String consumeTokenIfPresent(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            int i = this.position;
            this.position = charMatcher.negate().indexIn(this.input, i);
            return hasMore() ? this.input.substring(i, this.position) : this.input.substring(i);
        }

        /* access modifiers changed from: package-private */
        public String consumeToken(CharMatcher charMatcher) {
            int i = this.position;
            String consumeTokenIfPresent = consumeTokenIfPresent(charMatcher);
            Preconditions.checkState(this.position != i);
            return consumeTokenIfPresent;
        }

        /* access modifiers changed from: package-private */
        public char consumeCharacter(CharMatcher charMatcher) {
            Preconditions.checkState(hasMore());
            char previewChar = previewChar();
            Preconditions.checkState(charMatcher.matches(previewChar));
            this.position++;
            return previewChar;
        }

        /* access modifiers changed from: package-private */
        public char consumeCharacter(char c) {
            Preconditions.checkState(hasMore());
            Preconditions.checkState(previewChar() == c);
            this.position++;
            return c;
        }

        /* access modifiers changed from: package-private */
        public char previewChar() {
            Preconditions.checkState(hasMore());
            return this.input.charAt(this.position);
        }

        /* access modifiers changed from: package-private */
        public boolean hasMore() {
            int i = this.position;
            return i >= 0 && i < this.input.length();
        }
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MediaType)) {
            return false;
        }
        MediaType mediaType = (MediaType) obj;
        if (!this.type.equals(mediaType.type) || !this.subtype.equals(mediaType.subtype) || !parametersAsMap().equals(mediaType.parametersAsMap())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = Objects.hashCode(this.type, this.subtype, parametersAsMap());
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public String toString() {
        String str = this.toString;
        if (str != null) {
            return str;
        }
        String computeToString = computeToString();
        this.toString = computeToString;
        return computeToString;
    }

    private String computeToString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.type);
        sb.append('/');
        sb.append(this.subtype);
        if (!this.parameters.isEmpty()) {
            sb.append("; ");
            PARAMETER_JOINER.appendTo(sb, (Iterable<? extends Map.Entry<?, ?>>) Multimaps.transformValues(this.parameters, new Function<String, String>() {
                public String apply(String str) {
                    return (!MediaType.TOKEN_MATCHER.matchesAllOf(str) || str.isEmpty()) ? MediaType.escapeAndQuote(str) : str;
                }
            }).entries());
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public static String escapeAndQuote(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append(Typography.quote);
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == 13 || charAt == '\\' || charAt == '\"') {
                sb.append('\\');
            }
            sb.append(charAt);
        }
        sb.append(Typography.quote);
        return sb.toString();
    }
}
