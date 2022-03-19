package com.app.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DemoEnum {

    DEMO_ENUM(0, "模板"),
    ;

    private Integer id;

    private String name;

    // 只有默认getter()方法, 其他需要可自定义getter()方法

}
