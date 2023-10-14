package com.app.service;

import com.app.param.PayParam;

/**
 * 支付服务
 */
public interface PaymentService {

    default String invoke(PayParam payParam) {
        throw new RuntimeException("支付业务异常,请稍后重试");
    }

}
