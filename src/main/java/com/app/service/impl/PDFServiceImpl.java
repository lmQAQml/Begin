package com.app.service.impl;

import com.app.service.PDFService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import sun.net.www.protocol.https.Handler;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;

import static org.apache.poi.util.LocaleID.UR;

@Service
@Slf4j
public class PDFServiceImpl implements PDFService {

    public static String fileAddress = "C:/Users/lmQAQ/Desktop/AK.pdf";


    @Override
    public String casePDF1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try  {
            File file = new File(fileAddress);
            FileInputStream fileInputStream = new FileInputStream(file);
            response.setHeader("Content-Type", "application/pdf");
            ServletOutputStream outputStream = response.getOutputStream();
            byte[] bytes = new byte[fileInputStream.available()];
            while ((fileInputStream.read(bytes))!=-1) {
                outputStream.write(bytes);
            }
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @Override
    public String casePDF2(HttpServletRequest request, HttpServletResponse response) throws Exception{

        try {
            File file = new File(fileAddress);
            FileInputStream inputStream = new FileInputStream(file);
            // 输出到浏览器
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode("阿K.pdf", "UTF-8"));
            response.setHeader("Cache-Control", "no-cache");
            response.setContentType("text/html;charset=utf-8");
            ServletOutputStream outputStream = response.getOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0 , len);
            }
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            log.error("PDF文件下载异常:{}", e.getMessage());
        }
        return "success";
    }
}
