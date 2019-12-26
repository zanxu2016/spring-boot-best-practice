package info.luckydog.springboot.aopweblog.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * WebLogAspect
 *
 * @author eric
 * @since 2019/12/19
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    /**
     * 以自定义 @WebLog 注解为切点
     */
    @Pointcut("@annotation(info.luckydog.springboot.aopweblog.aspect.WebLog)")
    public void webLog() {
    }

    @Before("webLog() && @annotation(wl)")
    public void doBefore(JoinPoint joinPoint, WebLog wl) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(attributes)) {
            log.error("error occurs in WebLogAspect doBefore...");
            return;
        }
        HttpServletRequest request = attributes.getRequest();

        log.info("==================start==================");
        log.info("URL           : {}", request.getRequestURL().toString());
        log.info("Description   : {}", wl.description());
        log.info("HTTP Method   : {}", request.getMethod());
        log.info("Class Method  : {}.{}()", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        log.info("IP            : {}", request.getRemoteAddr());
//        log.info("Request Args  : {}", this.getRequestArgs(joinPoint));
        log.info("Request Args  : {}", JSON.toJSONString(joinPoint.getArgs()));
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = pjp.proceed();

        log.info("Response Args : {}", JSON.toJSONString(result));
        log.info("Time consuming: {} ms", (System.currentTimeMillis() - start));
        return result;
    }

    @After("webLog()")
    public void doAfter() {
        log.info("==================end=================={}", LINE_SEPARATOR);
    }

    // 获取日志注解描述（废弃，使用切面方法传参方式获取）
    @Deprecated
    private String getAspectLogDescription(JoinPoint joinPoint) {
        Class<?> classTarget = joinPoint.getTarget().getClass();
        Class<?>[] par = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        String methodName = joinPoint.getSignature().getName();
        Method objMethod;
        try {
            objMethod = classTarget.getMethod(methodName, par);
        } catch (NoSuchMethodException e) {
            log.error("getAspectLogDescription, error cause: {}", e.getMessage());
            return "";
        }

        WebLog webLog = objMethod.getAnnotation(WebLog.class);
        return Objects.nonNull(webLog) ? webLog.description() : "";
    }

    // 获取请求参数（得到@RequestBody注解后的类名）
    @Deprecated
    private String getRequestArgs(JoinPoint joinPoint) {
        Object[] argsValue = joinPoint.getArgs();
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] argsName = methodSignature.getParameterNames();
        Map<String, Object> params = new HashMap<>(argsName.length);
        for (int i = 0; i < argsName.length; i++) {
            params.put(argsName[i], argsValue[i]);
        }
        return JSON.toJSONString(params);
    }
}
