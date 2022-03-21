package com.app.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public String noAuth() {
        return "NO AUTH";
    }

}
