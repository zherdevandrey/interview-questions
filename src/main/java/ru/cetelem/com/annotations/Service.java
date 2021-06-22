package ru.cetelem.com.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

    String name() default "default";
    boolean lazyLoad() default true;

}
