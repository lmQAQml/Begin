package com.app.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayParam implements Serializable {

    private static final long serialVersionUID = -64963065484587L;

    /**
     * 支付方式 1.支付宝 2.微信 3.现金
     */
    private Integer payMethod;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private Long userID;
}
