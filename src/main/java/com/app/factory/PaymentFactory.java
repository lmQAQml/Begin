package com.app.factory;

import com.app.param.PayParam;
import com.app.service.PaymentService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 支付策略工厂
 */
public class PaymentFactory {

    public static Map<Integer, PaymentService> map = new ConcurrentHashMap<>();

    public static PaymentService getByPayMethod(Integer payMethod) {
        return map.get(payMethod);
    }

    public static void register(Integer payMethod, PaymentService service) {
        map.put(payMethod, service);
    }
}
