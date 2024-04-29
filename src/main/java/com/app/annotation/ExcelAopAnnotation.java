package com.app.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelAopAnnotation {

    String desc() default "excel";
}
