package com.app.service;

import com.app.param.LightningParam;

/**
 * 商品Service
 */
public interface GoodsService {

    /**
     * 商品秒杀接口
     *
     * @param param
     * @return
     */
    String lightningDeal(LightningParam param);
}
