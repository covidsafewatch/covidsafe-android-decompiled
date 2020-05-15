package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import kotlin.text.Typography;

public class JsonReader implements Closeable {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer = new char[1024];
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess() {
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader) jsonReader).promoteNameToValue();
                    return;
                }
                int i = jsonReader.peeked;
                if (i == 0) {
                    i = jsonReader.doPeek();
                }
                if (i == 13) {
                    jsonReader.peeked = 9;
                } else if (i == 12) {
                    jsonReader.peeked = 8;
                } else if (i == 14) {
                    jsonReader.peeked = 10;
                } else {
                    throw new IllegalStateException("Expected a name but was " + jsonReader.peek() + jsonReader.locationString());
                }
            }
        };
    }

    public JsonReader(Reader reader) {
        int[] iArr = new int[32];
        this.stack = iArr;
        this.stackSize = 0;
        this.stackSize = 0 + 1;
        iArr[0] = 6;
        this.pathNames = new String[32];
        this.pathIndices = new int[32];
        if (reader != null) {
            this.in = reader;
            return;
        }
        throw new NullPointerException("in == null");
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public void beginArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            push(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + peek() + locationString());
    }

    public void endArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + peek() + locationString());
    }

    public void beginObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            push(3);
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + peek() + locationString());
    }

    public void endObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            int i2 = this.stackSize - 1;
            this.stackSize = i2;
            this.pathNames[i2] = null;
            int[] iArr = this.pathIndices;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
            this.peeked = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + peek() + locationString());
    }

    public boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4) ? false : true;
    }

    public JsonToken peek() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* access modifiers changed from: package-private */
    public int doPeek() throws IOException {
        int nextNonWhitespace;
        int[] iArr = this.stack;
        int i = this.stackSize;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int nextNonWhitespace2 = nextNonWhitespace(true);
            if (nextNonWhitespace2 != 44) {
                if (nextNonWhitespace2 == 59) {
                    checkLenient();
                } else if (nextNonWhitespace2 == 93) {
                    this.peeked = 4;
                    return 4;
                } else {
                    throw syntaxError("Unterminated array");
                }
            }
        } else if (i2 == 3 || i2 == 5) {
            this.stack[this.stackSize - 1] = 4;
            if (i2 == 5 && (nextNonWhitespace = nextNonWhitespace(true)) != 44) {
                if (nextNonWhitespace == 59) {
                    checkLenient();
                } else if (nextNonWhitespace == 125) {
                    this.peeked = 2;
                    return 2;
                } else {
                    throw syntaxError("Unterminated object");
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                this.pos--;
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i2 != 5) {
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i2 == 4) {
            iArr[i - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.pos < this.limit || fillBuffer(1)) {
                        char[] cArr = this.buffer;
                        int i3 = this.pos;
                        if (cArr[i3] == '>') {
                            this.pos = i3 + 1;
                        }
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i2 == 6) {
            if (this.lenient) {
                consumeNonExecutePrefix();
            }
            this.stack[this.stackSize - 1] = 7;
        } else if (i2 == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 17;
                return 17;
            }
            checkLenient();
            this.pos--;
        } else if (i2 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 != 39) {
            if (!(nextNonWhitespace5 == 44 || nextNonWhitespace5 == 59)) {
                if (nextNonWhitespace5 == 91) {
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 != 123) {
                        this.pos--;
                        int peekKeyword = peekKeyword();
                        if (peekKeyword != 0) {
                            return peekKeyword;
                        }
                        int peekNumber = peekNumber();
                        if (peekNumber != 0) {
                            return peekNumber;
                        }
                        if (isLiteral(this.buffer[this.pos])) {
                            checkLenient();
                            this.peeked = 10;
                            return 10;
                        }
                        throw syntaxError("Expected value");
                    }
                    this.peeked = 1;
                    return 1;
                } else if (i2 == 1) {
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i2 == 1 || i2 == 2) {
                checkLenient();
                this.pos--;
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        } else {
            checkLenient();
            this.peeked = 8;
            return 8;
        }
    }

    private int peekKeyword() throws IOException {
        String str;
        String str2;
        int i;
        char c = this.buffer[this.pos];
        if (c == 't' || c == 'T') {
            i = 5;
            str2 = "true";
            str = "TRUE";
        } else if (c == 'f' || c == 'F') {
            i = 6;
            str2 = "false";
            str = "FALSE";
        } else if (c != 'n' && c != 'N') {
            return 0;
        } else {
            i = 7;
            str2 = "null";
            str = "NULL";
        }
        int length = str2.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.pos + i2 >= this.limit && !fillBuffer(i2 + 1)) {
                return 0;
            }
            char c2 = this.buffer[this.pos + i2];
            if (c2 != str2.charAt(i2) && c2 != str.charAt(i2)) {
                return 0;
            }
        }
        if ((this.pos + length < this.limit || fillBuffer(length + 1)) && isLiteral(this.buffer[this.pos + length])) {
            return 0;
        }
        this.pos += length;
        this.peeked = i;
        return i;
    }

    private int peekNumber() throws IOException {
        char c;
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        char c2 = 0;
        boolean z2 = false;
        long j = 0;
        while (true) {
            if (i + i4 == i2) {
                if (i4 == cArr.length) {
                    return i3;
                }
                if (!fillBuffer(i4 + 1)) {
                    break;
                }
                i = this.pos;
                i2 = this.limit;
            }
            c = cArr[i + i4];
            char c3 = 3;
            if (c == '+') {
                c3 = 6;
                i3 = 0;
                if (c2 != 5) {
                    return 0;
                }
            } else if (c == 'E' || c == 'e') {
                i3 = 0;
                if (c2 != 2 && c2 != 4) {
                    return 0;
                }
                c2 = 5;
                i4++;
            } else if (c == '-') {
                c3 = 6;
                i3 = 0;
                if (c2 == 0) {
                    c2 = 1;
                    z2 = true;
                    i4++;
                } else if (c2 != 5) {
                    return 0;
                }
            } else if (c == '.') {
                i3 = 0;
                if (c2 != 2) {
                    return 0;
                }
            } else if (c >= '0' && c <= '9') {
                if (c2 == 1 || c2 == 0) {
                    j = (long) (-(c - '0'));
                    c2 = 2;
                } else if (c2 != 2) {
                    if (c2 == 3) {
                        i3 = 0;
                        c2 = 4;
                    } else if (c2 == 5 || c2 == 6) {
                        i3 = 0;
                        c2 = 7;
                    }
                    i4++;
                } else if (j == 0) {
                    return 0;
                } else {
                    long j2 = (10 * j) - ((long) (c - '0'));
                    int i5 = (j > -922337203685477580L ? 1 : (j == -922337203685477580L ? 0 : -1));
                    z &= i5 > 0 || (i5 == 0 && j2 < j);
                    j = j2;
                }
                i3 = 0;
                i4++;
            }
            c2 = c3;
            i4++;
        }
        if (isLiteral(c)) {
            return 0;
        }
        if (c2 == 2 && z && ((j != Long.MIN_VALUE || z2) && (j != 0 || !z2))) {
            if (!z2) {
                j = -j;
            }
            this.peekedLong = j;
            this.pos += i4;
            this.peeked = 15;
            return 15;
        } else if (c2 != 2 && c2 != 4 && c2 != 7) {
            return 0;
        } else {
            this.peekedNumberLength = i4;
            this.peeked = 16;
            return 16;
        }
    }

    private boolean isLiteral(char c) throws IOException {
        if (c == 9 || c == 10 || c == 12 || c == 13 || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    public String nextName() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            str = nextUnquotedValue();
        } else if (i == 12) {
            str = nextQuotedValue('\'');
        } else if (i == 13) {
            str = nextQuotedValue(Typography.quote);
        } else {
            throw new IllegalStateException("Expected a name but was " + peek() + locationString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    public String nextString() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            str = nextUnquotedValue();
        } else if (i == 8) {
            str = nextQuotedValue('\'');
        } else if (i == 9) {
            str = nextQuotedValue(Typography.quote);
        } else if (i == 11) {
            str = this.peekedString;
            this.peekedString = null;
        } else if (i == 15) {
            str = Long.toString(this.peekedLong);
        } else if (i == 16) {
            str = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else {
            throw new IllegalStateException("Expected a string but was " + peek() + locationString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public boolean nextBoolean() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + peek() + locationString());
        }
    }

    public void nextNull() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 7) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + peek() + locationString());
    }

    public double nextDouble() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return (double) this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9) {
            this.peekedString = nextQuotedValue(i == 8 ? '\'' : Typography.quote);
        } else if (i == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i != 11) {
            throw new IllegalStateException("Expected a double but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        if (this.lenient || (!Double.isNaN(parseDouble) && !Double.isInfinite(parseDouble))) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        }
        throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + locationString());
    }

    public long nextLong() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i == 8 ? '\'' : Typography.quote);
            }
            try {
                long parseLong = Long.parseLong(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected a long but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        long j = (long) parseDouble;
        if (((double) j) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i4 = this.stackSize - 1;
            iArr3[i4] = iArr3[i4] + 1;
            return j;
        }
        throw new NumberFormatException("Expected a long but was " + this.peekedString + locationString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r1 != null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.pos = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextQuotedValue(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.buffer
            r1 = 0
        L_0x0003:
            int r2 = r9.pos
            int r3 = r9.limit
        L_0x0007:
            r4 = r3
            r3 = r2
        L_0x0009:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L_0x005c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L_0x0028
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0020
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L_0x0020:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L_0x0028:
            r8 = 92
            if (r2 != r8) goto L_0x004f
            r9.pos = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L_0x0040
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L_0x0040:
            r1.append(r0, r3, r7)
            char r2 = r9.readEscapeCharacter()
            r1.append(r2)
            int r2 = r9.pos
            int r3 = r9.limit
            goto L_0x0007
        L_0x004f:
            r5 = 10
            if (r2 != r5) goto L_0x005a
            int r2 = r9.lineNumber
            int r2 = r2 + r6
            r9.lineNumber = r2
            r9.lineStart = r7
        L_0x005a:
            r2 = r7
            goto L_0x0009
        L_0x005c:
            if (r1 != 0) goto L_0x006c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L_0x006c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.pos = r2
            boolean r2 = r9.fillBuffer(r6)
            if (r2 == 0) goto L_0x007a
            goto L_0x0003
        L_0x007a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.syntaxError(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextQuotedValue(char):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004a, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String nextUnquotedValue() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = r0
        L_0x0003:
            int r3 = r6.pos
            int r4 = r3 + r2
            int r5 = r6.limit
            if (r4 >= r5) goto L_0x004e
            char[] r4 = r6.buffer
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L_0x005c
            r4 = 10
            if (r3 == r4) goto L_0x005c
            r4 = 12
            if (r3 == r4) goto L_0x005c
            r4 = 13
            if (r3 == r4) goto L_0x005c
            r4 = 32
            if (r3 == r4) goto L_0x005c
            r4 = 35
            if (r3 == r4) goto L_0x004a
            r4 = 44
            if (r3 == r4) goto L_0x005c
            r4 = 47
            if (r3 == r4) goto L_0x004a
            r4 = 61
            if (r3 == r4) goto L_0x004a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L_0x005c
            r4 = 58
            if (r3 == r4) goto L_0x005c
            r4 = 59
            if (r3 == r4) goto L_0x004a
            switch(r3) {
                case 91: goto L_0x005c;
                case 92: goto L_0x004a;
                case 93: goto L_0x005c;
                default: goto L_0x0047;
            }
        L_0x0047:
            int r2 = r2 + 1
            goto L_0x0003
        L_0x004a:
            r6.checkLenient()
            goto L_0x005c
        L_0x004e:
            char[] r3 = r6.buffer
            int r3 = r3.length
            if (r2 >= r3) goto L_0x005e
            int r3 = r2 + 1
            boolean r3 = r6.fillBuffer(r3)
            if (r3 == 0) goto L_0x005c
            goto L_0x0003
        L_0x005c:
            r0 = r2
            goto L_0x007e
        L_0x005e:
            if (r1 != 0) goto L_0x006b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L_0x006b:
            char[] r3 = r6.buffer
            int r4 = r6.pos
            r1.append(r3, r4, r2)
            int r3 = r6.pos
            int r3 = r3 + r2
            r6.pos = r3
            r2 = 1
            boolean r2 = r6.fillBuffer(r2)
            if (r2 != 0) goto L_0x0002
        L_0x007e:
            if (r1 != 0) goto L_0x008a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.<init>(r2, r3, r0)
            goto L_0x0095
        L_0x008a:
            char[] r2 = r6.buffer
            int r3 = r6.pos
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L_0x0095:
            int r2 = r6.pos
            int r2 = r2 + r0
            r6.pos = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.nextUnquotedValue():java.lang.String");
    }

    private void skipQuotedValue(char c) throws IOException {
        char[] cArr = this.buffer;
        do {
            int i = this.pos;
            int i2 = this.limit;
            while (i < i2) {
                int i3 = i + 1;
                char c2 = cArr[i];
                if (c2 == c) {
                    this.pos = i3;
                    return;
                } else if (c2 == '\\') {
                    this.pos = i3;
                    readEscapeCharacter();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    if (c2 == 10) {
                        this.lineNumber++;
                        this.lineStart = i3;
                    }
                    i = i3;
                }
            }
            this.pos = i;
        } while (fillBuffer(1));
        throw syntaxError("Unterminated string");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0048, code lost:
        checkLenient();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void skipUnquotedValue() throws java.io.IOException {
        /*
            r4 = this;
        L_0x0000:
            r0 = 0
        L_0x0001:
            int r1 = r4.pos
            int r2 = r1 + r0
            int r3 = r4.limit
            if (r2 >= r3) goto L_0x0051
            char[] r2 = r4.buffer
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L_0x004b
            r2 = 10
            if (r1 == r2) goto L_0x004b
            r2 = 12
            if (r1 == r2) goto L_0x004b
            r2 = 13
            if (r1 == r2) goto L_0x004b
            r2 = 32
            if (r1 == r2) goto L_0x004b
            r2 = 35
            if (r1 == r2) goto L_0x0048
            r2 = 44
            if (r1 == r2) goto L_0x004b
            r2 = 47
            if (r1 == r2) goto L_0x0048
            r2 = 61
            if (r1 == r2) goto L_0x0048
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L_0x004b
            r2 = 58
            if (r1 == r2) goto L_0x004b
            r2 = 59
            if (r1 == r2) goto L_0x0048
            switch(r1) {
                case 91: goto L_0x004b;
                case 92: goto L_0x0048;
                case 93: goto L_0x004b;
                default: goto L_0x0045;
            }
        L_0x0045:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x0048:
            r4.checkLenient()
        L_0x004b:
            int r1 = r4.pos
            int r1 = r1 + r0
            r4.pos = r1
            return
        L_0x0051:
            int r1 = r1 + r0
            r4.pos = r1
            r0 = 1
            boolean r0 = r4.fillBuffer(r0)
            if (r0 != 0) goto L_0x0000
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.JsonReader.skipUnquotedValue():void");
    }

    public int nextInt() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 15) {
            long j = this.peekedLong;
            int i2 = (int) j;
            if (j == ((long) i2)) {
                this.peeked = 0;
                int[] iArr = this.pathIndices;
                int i3 = this.stackSize - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.peekedLong + locationString());
        }
        if (i == 16) {
            this.peekedString = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.pos += this.peekedNumberLength;
        } else if (i == 8 || i == 9 || i == 10) {
            if (i == 10) {
                this.peekedString = nextUnquotedValue();
            } else {
                this.peekedString = nextQuotedValue(i == 8 ? '\'' : Typography.quote);
            }
            try {
                int parseInt = Integer.parseInt(this.peekedString);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else {
            throw new IllegalStateException("Expected an int but was " + peek() + locationString());
        }
        this.peeked = 11;
        double parseDouble = Double.parseDouble(this.peekedString);
        int i5 = (int) parseDouble;
        if (((double) i5) == parseDouble) {
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        }
        throw new NumberFormatException("Expected an int but was " + this.peekedString + locationString());
    }

    public void close() throws IOException {
        this.peeked = 0;
        this.stack[0] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    public void skipValue() throws IOException {
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                push(1);
            } else if (i2 == 1) {
                push(3);
            } else {
                if (i2 == 4) {
                    this.stackSize--;
                } else if (i2 == 2) {
                    this.stackSize--;
                } else if (i2 == 14 || i2 == 10) {
                    skipUnquotedValue();
                    this.peeked = 0;
                } else if (i2 == 8 || i2 == 12) {
                    skipQuotedValue('\'');
                    this.peeked = 0;
                } else if (i2 == 9 || i2 == 13) {
                    skipQuotedValue(Typography.quote);
                    this.peeked = 0;
                } else {
                    if (i2 == 16) {
                        this.pos += this.peekedNumberLength;
                    }
                    this.peeked = 0;
                }
                i--;
                this.peeked = 0;
            }
            i++;
            this.peeked = 0;
        } while (i != 0);
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.pathNames[i3 - 1] = "null";
    }

    private void push(int i) {
        int i2 = this.stackSize;
        int[] iArr = this.stack;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.stack = Arrays.copyOf(iArr, i3);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i3);
            this.pathNames = (String[]) Arrays.copyOf(this.pathNames, i3);
        }
        int[] iArr2 = this.stack;
        int i4 = this.stackSize;
        this.stackSize = i4 + 1;
        iArr2[i4] = i;
    }

    private boolean fillBuffer(int i) throws IOException {
        int i2;
        char[] cArr = this.buffer;
        int i3 = this.lineStart;
        int i4 = this.pos;
        this.lineStart = i3 - i4;
        int i5 = this.limit;
        if (i5 != i4) {
            int i6 = i5 - i4;
            this.limit = i6;
            System.arraycopy(cArr, i4, cArr, 0, i6);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            int i7 = this.limit;
            int read = reader.read(cArr, i7, cArr.length - i7);
            if (read == -1) {
                return false;
            }
            int i8 = this.limit + read;
            this.limit = i8;
            if (this.lineNumber == 0 && (i2 = this.lineStart) == 0 && i8 > 0 && cArr[0] == 65279) {
                this.pos++;
                this.lineStart = i2 + 1;
                i++;
            }
        } while (this.limit < i);
        return true;
    }

    private int nextNonWhitespace(boolean z) throws IOException {
        char[] cArr = this.buffer;
        int i = this.pos;
        int i2 = this.limit;
        while (true) {
            if (i == i2) {
                this.pos = i;
                if (fillBuffer(1)) {
                    i = this.pos;
                    i2 = this.limit;
                } else if (!z) {
                    return -1;
                } else {
                    throw new EOFException("End of input" + locationString());
                }
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == 10) {
                this.lineNumber++;
                this.lineStart = i3;
            } else if (!(c == ' ' || c == 13 || c == 9)) {
                if (c == '/') {
                    this.pos = i3;
                    if (i3 == i2) {
                        this.pos = i3 - 1;
                        boolean fillBuffer = fillBuffer(2);
                        this.pos++;
                        if (!fillBuffer) {
                            return c;
                        }
                    }
                    checkLenient();
                    int i4 = this.pos;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.pos = i4 + 1;
                        if (skipTo("*/")) {
                            i = this.pos + 2;
                            i2 = this.limit;
                        } else {
                            throw syntaxError("Unterminated comment");
                        }
                    } else if (c2 != '/') {
                        return c;
                    } else {
                        this.pos = i4 + 1;
                        skipToEndOfLine();
                        i = this.pos;
                        i2 = this.limit;
                    }
                } else if (c == '#') {
                    this.pos = i3;
                    checkLenient();
                    skipToEndOfLine();
                    i = this.pos;
                    i2 = this.limit;
                } else {
                    this.pos = i3;
                    return c;
                }
            }
            i = i3;
        }
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c;
        do {
            if (this.pos < this.limit || fillBuffer(1)) {
                char[] cArr = this.buffer;
                int i = this.pos;
                int i2 = i + 1;
                this.pos = i2;
                c = cArr[i];
                if (c == 10) {
                    this.lineNumber++;
                    this.lineStart = i2;
                    return;
                }
            } else {
                return;
            }
        } while (c != 13);
    }

    private boolean skipTo(String str) throws IOException {
        int length = str.length();
        while (true) {
            int i = 0;
            if (this.pos + length > this.limit && !fillBuffer(length)) {
                return false;
            }
            char[] cArr = this.buffer;
            int i2 = this.pos;
            if (cArr[i2] == 10) {
                this.lineNumber++;
                this.lineStart = i2 + 1;
            } else {
                while (i < length) {
                    if (this.buffer[this.pos + i] == str.charAt(i)) {
                        i++;
                    }
                }
                return true;
            }
            this.pos++;
        }
    }

    public String toString() {
        return getClass().getSimpleName() + locationString();
    }

    /* access modifiers changed from: package-private */
    public String locationString() {
        return " at line " + (this.lineNumber + 1) + " column " + ((this.pos - this.lineStart) + 1) + " path " + getPath();
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.dollar);
        int i = this.stackSize;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.stack[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.pathIndices[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String[] strArr = this.pathNames;
                if (strArr[i2] != null) {
                    sb.append(strArr[i2]);
                }
            }
        }
        return sb.toString();
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (this.pos != this.limit || fillBuffer(1)) {
            char[] cArr = this.buffer;
            int i3 = this.pos;
            int i4 = i3 + 1;
            this.pos = i4;
            char c = cArr[i3];
            if (c == 10) {
                this.lineNumber++;
                this.lineStart = i4;
            } else if (!(c == '\"' || c == '\'' || c == '/' || c == '\\')) {
                if (c == 'b') {
                    return 8;
                }
                if (c == 'f') {
                    return 12;
                }
                if (c == 'n') {
                    return 10;
                }
                if (c == 'r') {
                    return 13;
                }
                if (c == 't') {
                    return 9;
                }
                if (c != 'u') {
                    throw syntaxError("Invalid escape sequence");
                } else if (i4 + 4 <= this.limit || fillBuffer(4)) {
                    char c2 = 0;
                    int i5 = this.pos;
                    int i6 = i5 + 4;
                    while (i5 < i6) {
                        char c3 = this.buffer[i5];
                        char c4 = (char) (c2 << 4);
                        if (c3 < '0' || c3 > '9') {
                            if (c3 >= 'a' && c3 <= 'f') {
                                i = c3 - 'a';
                            } else if (c3 < 'A' || c3 > 'F') {
                                throw new NumberFormatException("\\u" + new String(this.buffer, this.pos, 4));
                            } else {
                                i = c3 - 'A';
                            }
                            i2 = i + 10;
                        } else {
                            i2 = c3 - '0';
                        }
                        c2 = (char) (c4 + i2);
                        i5++;
                    }
                    this.pos += 4;
                    return c2;
                } else {
                    throw syntaxError("Unterminated escape sequence");
                }
            }
            return c;
        }
        throw syntaxError("Unterminated escape sequence");
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + locationString());
    }

    private void consumeNonExecutePrefix() throws IOException {
        nextNonWhitespace(true);
        int i = this.pos - 1;
        this.pos = i;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (i + cArr.length <= this.limit || fillBuffer(cArr.length)) {
            int i2 = 0;
            while (true) {
                char[] cArr2 = NON_EXECUTE_PREFIX;
                if (i2 >= cArr2.length) {
                    this.pos += cArr2.length;
                    return;
                } else if (this.buffer[this.pos + i2] == cArr2[i2]) {
                    i2++;
                } else {
                    return;
                }
            }
        }
    }
}
