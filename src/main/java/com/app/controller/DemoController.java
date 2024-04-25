package com.app.controller;

import com.app.dto.DemoDto;
import com.app.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private DemoService demoService;

    /**
     * 测试捕获异常处理
     * @return
     */
    @GetMapping("/test-demo")
    public DemoDto testDemo() {
        throw new RuntimeException();
//        return new DemoDto(0, "demo");
    }

    @GetMapping("/looking/test")
    public DemoDto testLooking() {
        demoService.testAsync();
        return new DemoDto(0, "look");
    }

    @GetMapping("/searching/test")
    public DemoDto testSearching() {
        return new DemoDto(0, "search");
    }
}
