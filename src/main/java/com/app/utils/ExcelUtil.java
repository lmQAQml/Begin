package com.app.utils;

import com.app.entity.ExcelEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExcelUtil {

    public List<ExcelEntity> getData() {
        ArrayList<ExcelEntity> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            ExcelEntity entity = new ExcelEntity();
            entity.setId(i);
            entity.setName("第" + i + "个");
            list.add(entity);
        }
        return list;
    }
}
