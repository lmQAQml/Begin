package com.app.utils;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class StringUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContextParam) throws BeansException {
        applicationContext = applicationContextParam;
    }

    /**
     * 获取Bean
     *
     * @param className
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> className) {
        return applicationContext.getBean(className);
    }
}
