package com.app.Listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.app.entity.ExcelEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ExcelListener implements ReadListener<ExcelEntity> {

    public ExcelListener() {
        // 如果使用了spring，再这里加上对应操作即可
    }

    @Override
    public void invoke(ExcelEntity excelEntity, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", excelEntity);

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成");
    }
}
