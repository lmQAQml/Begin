package com.app.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 */
@Data
@AllArgsConstructor
public class ExceptionResponse {

    /**
     * 请求url
     */
    private String requestUrl;

    /**
     * 异常信息
     */
    private String exceptionMessage;

    /**
     * 异常时间
     */
//    private String exceptionTime;
}
