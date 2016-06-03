package com.gagauz.javaee.jaxrs.endpoint.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;

@PreMatching
@Provider
public class LogFilter implements ContainerResponseFilter {

    private final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        String log = requestContext.getMethod() + " " + requestContext.getUriInfo().getAbsolutePath() + "\n";
        for (Entry<String, List<String>> e : requestContext.getHeaders().entrySet()) {
            log += e.getKey() + ": " + e.getValue() + "\n";
        }
        log += "Language: " + requestContext.getAcceptableLanguages() + "\n";
        log += "Accept: " + requestContext.getAcceptableMediaTypes() + "\n";
        logger.info(log);


    }
}