package info.luckydog.springboot.paramvalid.handler;

import info.luckydog.springboot.paramvalid.model.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Objects;

/**
 * GlobalExceptionHandler
 *
 * @author eric
 * @since 2020/1/6
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 方法入参实体参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultDTO handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        String errorMsg = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        log.error("param valid error: {}", errorMsg);
        return ResultDTO.failure(errorMsg);
    }

    /**
     * 方法入参单个参数校验
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResultDTO handleConstraintViolationException(ConstraintViolationException e) {
        String errorMsg = ((ConstraintViolation) (e.getConstraintViolations().toArray()[0])).getMessageTemplate();
        log.error("param valid error: {}", errorMsg);
        return ResultDTO.failure(errorMsg);
    }
}
