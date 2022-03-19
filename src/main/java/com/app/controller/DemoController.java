package com.app.controller;

import com.app.dto.DemoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/test-demo")
    public DemoDto testDemo() {
        return new DemoDto(0, "demo");
    }
}
