package com.google.protobuf;

import com.atlassian.mobilekit.module.core.utils.StringUtils;
import com.google.protobuf.GeneratedMessageLite;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : messageLite.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String replaceFirst : treeSet) {
            String replaceFirst2 = replaceFirst.replaceFirst("get", "");
            boolean z = true;
            if (replaceFirst2.endsWith(LIST_SUFFIX) && !replaceFirst2.endsWith(BUILDER_LIST_SUFFIX)) {
                String str = replaceFirst2.substring(0, 1).toLowerCase() + replaceFirst2.substring(1, replaceFirst2.length() - 4);
                Method method2 = (Method) hashMap.get("get" + replaceFirst2);
                if (method2 != null) {
                    printField(sb, i, camelCaseToSnakeCase(str), GeneratedMessageLite.invokeOrDie(method2, messageLite, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst2)) != null) {
                if (replaceFirst2.endsWith(BYTES_SUFFIX)) {
                    if (hashMap.containsKey("get" + replaceFirst2.substring(0, replaceFirst2.length() - 5))) {
                    }
                }
                String str2 = replaceFirst2.substring(0, 1).toLowerCase() + replaceFirst2.substring(1);
                Method method3 = (Method) hashMap.get("get" + replaceFirst2);
                Method method4 = (Method) hashMap.get("has" + replaceFirst2);
                if (method3 != null) {
                    Object invokeOrDie = GeneratedMessageLite.invokeOrDie(method3, messageLite, new Object[0]);
                    if (method4 != null) {
                        z = ((Boolean) GeneratedMessageLite.invokeOrDie(method4, messageLite, new Object[0])).booleanValue();
                    } else if (isDefaultValue(invokeOrDie)) {
                        z = false;
                    }
                    if (z) {
                        printField(sb, i, camelCaseToSnakeCase(str2), invokeOrDie);
                    }
                }
            }
        }
        if (messageLite instanceof GeneratedMessageLite.ExtendableMessage) {
            Iterator<Map.Entry<GeneratedMessageLite.ExtensionDescriptor, Object>> it = ((GeneratedMessageLite.ExtendableMessage) messageLite).extensions.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                printField(sb, i, "[" + ((GeneratedMessageLite.ExtensionDescriptor) next.getKey()).getNumber() + "]", next.getValue());
            }
        }
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) messageLite;
        if (generatedMessageLite.unknownFields != null) {
            generatedMessageLite.unknownFields.printWithIndent(sb, i);
        }
    }

    private static boolean isDefaultValue(Object obj) {
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == 0) {
                return true;
            }
            return false;
        } else if (obj instanceof Float) {
            if (((Float) obj).floatValue() == 0.0f) {
                return true;
            }
            return false;
        } else if (obj instanceof Double) {
            if (((Double) obj).doubleValue() == 0.0d) {
                return true;
            }
            return false;
        } else if (obj instanceof String) {
            return obj.equals("");
        } else {
            if (obj instanceof ByteString) {
                return obj.equals(ByteString.EMPTY);
            }
            if (obj instanceof MessageLite) {
                if (obj == ((MessageLite) obj).getDefaultInstanceForType()) {
                    return true;
                }
                return false;
            } else if (!(obj instanceof Enum)) {
                return false;
            } else {
                if (((Enum) obj).ordinal() == 0) {
                    return true;
                }
                return false;
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
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.escapeText((String) obj));
            sb.append(Typography.quote);
        } else if (obj instanceof ByteString) {
            sb.append(": \"");
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
