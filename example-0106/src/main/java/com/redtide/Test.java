package com.redtide;

import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Test{

    Class<String> value() default String.class;

}
