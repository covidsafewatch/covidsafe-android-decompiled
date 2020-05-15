package kotlin.experimental;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(AnnotationRetention.BINARY)
@Documented
@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lkotlin/experimental/ExperimentalTypeInference;", "", "kotlin-stdlib"}, k = 1, mv = {1, 1, 16})
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: inferenceMarker.kt */
public @interface ExperimentalTypeInference {
}
