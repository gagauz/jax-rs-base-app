package com.gagauz.javaee.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;


@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    private final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    public ApplicationConfig() {
        packages(true, "com.gagauz.javaee.jaxrs.endpoint");
        for (Class<?> cls : getClasses()) {
            logger.info("Register resource {}", cls);
        }
    }

}
