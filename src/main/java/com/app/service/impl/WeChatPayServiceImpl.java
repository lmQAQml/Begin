package com.app.service.impl;

import com.app.factory.PaymentFactory;
import com.app.param.PayParam;
import com.app.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * 微信支付
 */
@Service
@Slf4j
public class WeChatPayServiceImpl implements PaymentService, InitializingBean {

    @Override
    public void afterPropertiesSet() {
        PaymentFactory.register(2, this);
    }

    @Override
    public String invoke(PayParam payParam) {
        // 逻辑处理
        log.info("微信支付:{}", payParam);
        return null;
    }


}
