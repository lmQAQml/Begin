package com.app.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.app.converter.ExcelConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExcelEntity {

    @ExcelProperty("序号")
    private Integer id;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty(converter = ExcelConverter.class)
    private String converterString;

    // 忽略这个字段
    @ExcelIgnore
    private Integer age;
}
