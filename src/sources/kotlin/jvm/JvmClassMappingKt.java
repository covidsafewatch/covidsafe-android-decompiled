package kotlin.jvm;

import java.lang.annotation.Annotation;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.jvm.internal.ClassBasedDeclarationContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001a\u001f\u0010\u0018\u001a\u00020\u0019\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\r*\u0006\u0012\u0002\b\u00030\u001a¢\u0006\u0002\u0010\u001b\"'\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"-\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"&\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000e\";\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018Ç\u0002X\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"+\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b\"-\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0007\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b\"+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00078G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"annotationClass", "Lkotlin/reflect/KClass;", "T", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "java", "Ljava/lang/Class;", "java$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaClass", "", "(Ljava/lang/Object;)Ljava/lang/Class;", "javaClass$annotations", "getRuntimeClassOfKClassInstance", "javaObjectType", "getJavaObjectType", "javaPrimitiveType", "getJavaPrimitiveType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 2, mv = {1, 1, 16})
/* compiled from: JvmClassMapping.kt */
public final class JvmClassMappingKt {
    public static /* synthetic */ void java$annotations(KClass kClass) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static /* synthetic */ void javaClass$annotations(KClass kClass) {
    }

    public static final <T> Class<T> getJavaClass(KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$java");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass != null) {
            return jClass;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$javaPrimitiveType");
        Class<?> jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!jClass.isPrimitive()) {
            String name = jClass.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -2056817302:
                        if (name.equals("java.lang.Integer")) {
                            return Integer.TYPE;
                        }
                        break;
                    case -527879800:
                        if (name.equals("java.lang.Float")) {
                            return Float.TYPE;
                        }
                        break;
                    case -515992664:
                        if (name.equals("java.lang.Short")) {
                            return Short.TYPE;
                        }
                        break;
                    case 155276373:
                        if (name.equals("java.lang.Character")) {
                            return Character.TYPE;
                        }
                        break;
                    case 344809556:
                        if (name.equals("java.lang.Boolean")) {
                            return Boolean.TYPE;
                        }
                        break;
                    case 398507100:
                        if (name.equals("java.lang.Byte")) {
                            return Byte.TYPE;
                        }
                        break;
                    case 398795216:
                        if (name.equals("java.lang.Long")) {
                            return Long.TYPE;
                        }
                        break;
                    case 399092968:
                        if (name.equals("java.lang.Void")) {
                            return Void.TYPE;
                        }
                        break;
                    case 761287205:
                        if (name.equals("java.lang.Double")) {
                            return Double.TYPE;
                        }
                        break;
                }
            }
            return null;
        } else if (jClass != null) {
            return jClass;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$javaObjectType");
        Class jClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (jClass.isPrimitive()) {
            String name = jClass.getName();
            if (name != null) {
                switch (name.hashCode()) {
                    case -1325958191:
                        if (name.equals("double")) {
                            jClass = Double.class;
                            break;
                        }
                        break;
                    case 104431:
                        if (name.equals("int")) {
                            jClass = Integer.class;
                            break;
                        }
                        break;
                    case 3039496:
                        if (name.equals("byte")) {
                            jClass = Byte.class;
                            break;
                        }
                        break;
                    case 3052374:
                        if (name.equals("char")) {
                            jClass = Character.class;
                            break;
                        }
                        break;
                    case 3327612:
                        if (name.equals("long")) {
                            jClass = Long.class;
                            break;
                        }
                        break;
                    case 3625364:
                        if (name.equals("void")) {
                            jClass = Void.class;
                            break;
                        }
                        break;
                    case 64711720:
                        if (name.equals("boolean")) {
                            jClass = Boolean.class;
                            break;
                        }
                        break;
                    case 97526364:
                        if (name.equals("float")) {
                            jClass = Float.class;
                            break;
                        }
                        break;
                    case 109413500:
                        if (name.equals("short")) {
                            jClass = Short.class;
                            break;
                        }
                        break;
                }
            }
            if (jClass != null) {
                return jClass;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        } else if (jClass != null) {
            return jClass;
        } else {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
        }
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> cls) {
        Intrinsics.checkParameterIsNotNull(cls, "$this$kotlin");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public static final <T> Class<T> getJavaClass(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$this$javaClass");
        Class<?> cls = t.getClass();
        if (cls != null) {
            return cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<T>");
    }

    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> kClass) {
        Intrinsics.checkParameterIsNotNull(kClass, "$this$javaClass");
        Class<?> cls = kClass.getClass();
        if (cls != null) {
            return cls;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T>>");
    }

    public static final /* synthetic */ <T> boolean isArrayOf(Object[] objArr) {
        Intrinsics.checkParameterIsNotNull(objArr, "$this$isArrayOf");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T t) {
        Intrinsics.checkParameterIsNotNull(t, "$this$annotationClass");
        Class<? extends Annotation> annotationType = t.annotationType();
        Intrinsics.checkExpressionValueIsNotNull(annotationType, "(this as java.lang.annot…otation).annotationType()");
        KClass<? extends T> kotlinClass = getKotlinClass(annotationType);
        if (kotlinClass != null) {
            return kotlinClass;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.reflect.KClass<out T>");
    }
}
