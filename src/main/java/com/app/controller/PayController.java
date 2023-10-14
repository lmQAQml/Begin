package com.app.controller;

import com.app.factory.PaymentFactory;
import com.app.param.PayParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PayController {

    @PostMapping("/payChanel")
    public String pay(@RequestBody PayParam payParam) {
        return PaymentFactory.getByPayMethod(payParam.getPayMethod()).invoke(payParam);
    }
}
