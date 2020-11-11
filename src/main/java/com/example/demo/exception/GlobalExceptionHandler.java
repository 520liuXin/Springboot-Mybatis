package com.example.demo.exception;


import com.example.demo.utils.ResponseInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;


/**
 * @author LiJing
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常处理器
 * @date 2019/7/30 13:57
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private static String DUPLICATE_KEY_CODE = "99999";
    private static String PARAM_FAIL_CODE = "99998";
    private static String VALIDATION_CODE = "99997";

    /**
     * 处理自定义异常
     */


    /**
     * 方法参数校验
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseInfo<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.error(e.getMessage(), e);
        return new ResponseInfo(PARAM_FAIL_CODE, e.getBindingResult().getFieldError().getDefaultMessage());
    }

    /**
     * ValidationException
     */
    @ExceptionHandler(ValidationException.class)
    public ResponseInfo<?> handleValidationException(ValidationException e) {
        logger.error(e.getMessage(), e);
        return new ResponseInfo(VALIDATION_CODE, e.getCause().getMessage());
    }

    /**
     * ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseInfo<?> handleConstraintViolationException(ConstraintViolationException e) {
        logger.error(e.getMessage(), e);
        return  new ResponseInfo(PARAM_FAIL_CODE, e.getMessage());
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseInfo<?> handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return new  ResponseInfo("404", "路径不存在，请检查路径是否正确");
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseInfo<?> handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return new  ResponseInfo(DUPLICATE_KEY_CODE, "数据重复，请检查后提交");
    }


    @ExceptionHandler(Exception.class)
    public ResponseInfo<?> handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return new  ResponseInfo("500", "系统繁忙,请稍后再试");
    }
}
