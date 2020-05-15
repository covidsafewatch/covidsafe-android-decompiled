package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.lang.model.element.Modifier;

@Documented
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface IncompatibleModifiers {
    Modifier[] value();
}
