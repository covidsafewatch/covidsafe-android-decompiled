package com.google.protobuf;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import com.google.protobuf.GeneratedMessageLite.ExtendableMessage;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeSet;
import kotlin.text.Typography;

final class MessageLiteToString {
    private static final String BUILDER_LIST_SUFFIX = "OrBuilderList";
    private static final String BYTES_SUFFIX = "Bytes";
    private static final String LIST_SUFFIX = "List";

    MessageLiteToString() {
    }

    static String toString(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        reflectivePrintWithIndent(messageLite, sb, 0);
        return sb.toString();
    }

    private static void reflectivePrintWithIndent(MessageLite messageLite, StringBuilder sb, int i) {
        String str;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        Method[] declaredMethods = messageLite.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i2 = 0;
        while (true) {
            str = "get";
            if (i2 >= length) {
                break;
            }
            Method method = declaredMethods[i2];
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith(str)) {
                    treeSet.add(method.getName());
                }
            }
            i2++;
        }
        for (String replaceFirst : treeSet) {
            String replaceFirst2 = replaceFirst.replaceFirst(str, "");
            boolean z = true;
            if (replaceFirst2.endsWith(LIST_SUFFIX) && !replaceFirst2.endsWith(BUILDER_LIST_SUFFIX)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(replaceFirst2.substring(0, 1).toLowerCase());
                sb2.append(replaceFirst2.substring(1, replaceFirst2.length() - 4));
                String sb3 = sb2.toString();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append(replaceFirst2);
                Method method2 = (Method) hashMap.get(sb4.toString());
                if (method2 != null) {
                    printField(sb, i, camelCaseToSnakeCase(sb3), GeneratedMessageLite.invokeOrDie(method2, messageLite, new Object[0]));
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("set");
            sb5.append(replaceFirst2);
            if (((Method) hashMap2.get(sb5.toString())) != null) {
                if (replaceFirst2.endsWith(BYTES_SUFFIX)) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append(replaceFirst2.substring(0, replaceFirst2.length() - 5));
                    if (hashMap.containsKey(sb6.toString())) {
                    }
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(replaceFirst2.substring(0, 1).toLowerCase());
                sb7.append(replaceFirst2.substring(1));
                String sb8 = sb7.toString();
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str);
                sb9.append(replaceFirst2);
                Method method3 = (Method) hashMap.get(sb9.toString());
                StringBuilder sb10 = new StringBuilder();
                sb10.append("has");
                sb10.append(replaceFirst2);
                Method method4 = (Method) hashMap.get(sb10.toString());
                if (method3 != null) {
                    Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method3, messageLite, new Object[0]);
                    if (method4 != null) {
                        z = ((Boolean) GeneratedMessageLite.invokeOrDie(method4, messageLite, new Object[0])).booleanValue();
                    } else if (isDefaultValue(invokeOrDie)) {
                        z = false;
                    }
                    if (z) {
                        printField(sb, i, camelCaseToSnakeCase(sb8), invokeOrDie);
                    }
                }
            }
        }
        if (messageLite instanceof ExtendableMessage) {
            Iterator it = ((ExtendableMessage) messageLite).extensions.iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                StringBuilder sb11 = new StringBuilder();
                sb11.append("[");
                sb11.append(((ExtensionDescriptor) entry.getKey()).getNumber());
                sb11.append("]");
                printField(sb, i, sb11.toString(), entry.getValue());
            }
        }
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) messageLite;
        if (generatedMessageLite.unknownFields != null) {
            generatedMessageLite.unknownFields.printWithIndent(sb, i);
        }
    }

    private static boolean isDefaultValue(Object obj) {
        boolean z = true;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() != 0) {
                z = false;
            }
            return z;
        } else if (obj instanceof Float) {
            if (((Float) obj).floatValue() != 0.0f) {
                z = false;
            }
            return z;
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() != 0.0d) {
                z = false;
            }
            return z;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj != ((MessageLite) obj).getDefaultInstanceForType()) {
                    z = false;
                }
                return z;
            } else if (!(obj instanceof Enum)) {
                return false;
            } else {
                if (((Enum) obj).ordinal() != 0) {
                    z = false;
                }
                return z;
            }
        }
    }

    static final void printField(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object printField : (List) obj) {
                printField(sb, i, str, printField);
            }
            return;
        }
        sb.append(10);
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(' ');
        }
        sb.append(str);
        String str2 = ": \"";
        if (obj instanceof String) {
            sb.append(str2);
            sb.append(TextFormatEscaper.escapeText((String) obj));
            sb.append(Typography.quote);
        } else if (obj instanceof ByteString) {
            sb.append(str2);
            sb.append(TextFormatEscaper.escapeBytes((ByteString) obj));
            sb.append(Typography.quote);
        } else if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            reflectivePrintWithIndent((GeneratedMessageLite) obj, sb, i + 2);
            sb.append(StringUtils.EOL);
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append("}");
        } else {
            sb.append(": ");
            sb.append(obj.toString());
        }
    }

    private static final String camelCaseToSnakeCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
