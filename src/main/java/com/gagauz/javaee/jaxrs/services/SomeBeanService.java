package com.gagauz.javaee.jaxrs.services;

import com.gagauz.javaee.jaxrs.bean.SomeBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SomeBeanService {
    private Logger logger = LoggerFactory.getLogger(SomeBeanService.class);
    public SomeBeanService() {
        logger.info("Create service");
    }
    public SomeBean getBean(String name, int age) {
        return new SomeBean(name, age);
    }
}
