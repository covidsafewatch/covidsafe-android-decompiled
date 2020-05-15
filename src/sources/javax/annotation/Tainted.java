package javax.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.When;

@Documented
@Untainted(when = When.MAYBE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Tainted {
}
