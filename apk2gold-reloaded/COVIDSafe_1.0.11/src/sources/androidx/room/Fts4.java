package androidx.room;

import androidx.room.FtsOptions.MatchInfo;
import androidx.room.FtsOptions.Order;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface Fts4 {
    Class<?> contentEntity() default Object.class;

    String languageId() default "";

    MatchInfo matchInfo() default MatchInfo.FTS4;

    String[] notIndexed() default {};

    Order order() default Order.ASC;

    int[] prefix() default {};

    String tokenizer() default "simple";

    String[] tokenizerArgs() default {};
}
