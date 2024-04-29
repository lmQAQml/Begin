package com.app.controller;

import com.alibaba.excel.EasyExcel;
import com.app.Listener.ExcelListener;
import com.app.entity.ExcelEntity;
import com.app.annotation.ExcelAopAnnotation;
import com.app.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/excel")
public class EasyExcelController {

    @Autowired
    private ExcelUtils excelUtils;

    // 文件下载
    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("UTF-8");
        String fileName = "测试";
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
        try {
            EasyExcel.write(response.getOutputStream(), ExcelEntity.class).sheet("测试模板").doWrite(excelUtils.getData());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 文件上传
    @PostMapping("/upload")
    public String upload(MultipartFile file) throws IOException {
        try {
            EasyExcel.read(file.getInputStream(), ExcelEntity.class, new ExcelListener()).sheet("测试模板")
                    .headRowNumber(1).doRead();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "success";
    }


    @ExcelAopAnnotation
    @GetMapping("/download1/{var}")
    public void download1(HttpServletResponse response, @PathVariable("var") String var) {
        System.out.println("入参: " + var);
    }
}
