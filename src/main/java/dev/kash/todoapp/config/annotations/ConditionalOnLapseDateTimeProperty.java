package dev.kash.todoapp.config.annotations;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(FeatureToggleLapseDateTimeCondition.class)
public @interface ConditionalOnLapseDateTimeProperty {
    String name();
    String defaultValue() default "";
    String format() default "yyyy-MM-dd HH:mm:ss";
}
