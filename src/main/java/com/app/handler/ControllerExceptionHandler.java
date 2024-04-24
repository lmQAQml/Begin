package com.app.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
@Log4j2
public class ControllerExceptionHandler {


    @ExceptionHandler(RuntimeException.class)
    public void runtimeException(RuntimeException ex, HttpServletRequest request) {
        log.warn("异常接口: {}, 异常信息:{}" , request.getRequestURI() , ex);
    }

}
