package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifierDefault;

@Documented
@TypeQualifierDefault({ElementType.PARAMETER})
@Nonnull
@Retention(RetentionPolicy.RUNTIME)
public @interface ParametersAreNonnullByDefault {
}
