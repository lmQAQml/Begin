package com.app.controller;

import com.app.dto.DemoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {


    @GetMapping("/test-demo")
    public DemoDto testDemo() {
        return new DemoDto(0, "demo");
    }

    @GetMapping("/looking/test")
    public DemoDto testLooking() {
        return new DemoDto(0, "look");
    }

    @GetMapping("/searching/test")
    public DemoDto testSearching() {
        return new DemoDto(0, "search");
    }
}
