package com.gagauz.javaee.jaxrs;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages(true, "com.gagauz.javaee.jaxrs.endpoint");
        for (Class<?> cls : getClasses()) {
            System.out.println(cls.getName());
        }
    }

}
