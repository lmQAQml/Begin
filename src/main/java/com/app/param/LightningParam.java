package com.app.param;

import lombok.Data;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Data
public class LightningParam implements Serializable {

    private static final long serialVersionUID = -64963065484587L;

    /**
     * 商品关键字段
     */
    String key;

    /**
     * 锁的过期时间
     */
    long time;

    /**
     * 单位
     */
    TimeUnit timeUnit;
}
