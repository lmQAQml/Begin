package com.app.controller;

import com.app.param.LightningParam;
import com.app.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    /**
     * 商品秒杀接口
     *
     * @return
     */
    @PostMapping("/lightning")
    public String lightning(@RequestBody LightningParam param) {
        return goodsService.lightningDeal(param);
    }

}
