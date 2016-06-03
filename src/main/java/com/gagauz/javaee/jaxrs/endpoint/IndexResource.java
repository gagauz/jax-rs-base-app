package com.gagauz.javaee.jaxrs.endpoint;

import com.gagauz.javaee.jaxrs.bean.SomeBean;
import com.gagauz.javaee.jaxrs.services.SomeBeanService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path(value = "/index")
public class IndexResource {

    private final Logger logger = LoggerFactory.getLogger(IndexResource.class);

    @Inject
    private SomeBeanService service;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.WILDCARD })
    public SomeBean getItJson(@QueryParam("name") @DefaultValue("Anonymous") String name,
            @QueryParam("age") @DefaultValue("10") int age) {
        logger.info("Handle request with name=" + name + ", age=" + age);
        return service.getBean(name, age);
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Consumes({ MediaType.APPLICATION_JSON })
    public SomeBean postItJson(@Valid SomeBean bean) {
        return bean;
    }
}
