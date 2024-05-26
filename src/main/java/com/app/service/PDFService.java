package com.app.service;

import com.app.param.PayParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * PDF服务
 */
public interface PDFService {

    /**
     * 有文件地址
     */
    String casePDF1(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 传回文件流
     */
    String casePDF2(HttpServletRequest request, HttpServletResponse response) throws Exception;

}
