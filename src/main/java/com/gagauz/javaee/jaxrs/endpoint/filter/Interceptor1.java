package com.gagauz.javaee.jaxrs.endpoint.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;

import java.io.IOException;

@PreMatching
@Provider
public class Interceptor1 implements WriterInterceptor {

    private final Logger logger = LoggerFactory.getLogger(Interceptor1.class);

    @Override
    public void aroundWriteTo(WriterInterceptorContext context)
            throws IOException, WebApplicationException {
        try {
            logger.info(">----------------");
            context.proceed();
        } finally {
            logger.info("<----------------");
        }
    }
}