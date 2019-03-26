package com.beidou.gateway.interceptor;

import com.beidou.common.entity.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import javax.servlet.http.HttpServletRequest;



@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(value = Exception.class)
    public ResponseMsg exceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error(e.getMessage(), e);
        return ResponseMsg.Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }

    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ResponseMsg methodArgumentTypeMismatchExceptionHandler(HttpServletRequest httpServletRequest, Exception e) {
        logger.error(e.getMessage());
        return ResponseMsg.Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }


    /**
     * 处理 BusinessException 异常
     *
     * @param httpServletRequest httpServletRequest
     * @param e                  异常
     * @return
     */
    @ExceptionHandler(value = BusinessException.class)
    public ResponseMsg businessExceptionHandler(HttpServletRequest httpServletRequest, BusinessException e) {
        logger.info("业务异常:code:{},msg:{}" ,e.getCode() , e.getMessage());
        return ResponseMsg.Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
    }




}
