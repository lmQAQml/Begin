package com.app.controller;

import com.app.service.PDFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/pdf")
public class PDFController {

    @Autowired
    PDFService pdfService;

    @GetMapping("/casePDF")
    public String casePDF(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return pdfService.casePDF1(request, response);
    }

    @GetMapping("/casePDF2")
    public String casePDF2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return pdfService.casePDF2(request, response);
    }

}
