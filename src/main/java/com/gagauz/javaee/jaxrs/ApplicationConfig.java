package com.gagauz.javaee.jaxrs;

import com.gagauz.javaee.jaxrs.services.factory.ServiceBinder;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.stream.JsonGenerator;
import javax.ws.rs.ApplicationPath;


@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {

    private final Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

    public ApplicationConfig() {
        packages(true, "com.gagauz.javaee.jaxrs.endpoint");

        register(JacksonFeature.class)
                .packages("com.gagauz.javaee.jaxrs.bean")
                .packages("com.gagauz.javaee.jaxrs.endpoint.filter")
                .property(JsonGenerator.PRETTY_PRINTING, true);
        register(new ServiceBinder());

        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        for (Class<?> cls : getClasses()) {
            logger.info("Register resource {}", cls);
        }
    }

}
