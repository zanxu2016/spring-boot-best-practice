package info.luckydog.springboot.aopweblog.aspect;

import java.lang.annotation.*;

/**
 * WebLog
 *
 * @author eric
 * @since 2019/12/19
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface WebLog {
    /**
     * 日志描述
     *
     * @return String
     */
    String description() default "";
}
