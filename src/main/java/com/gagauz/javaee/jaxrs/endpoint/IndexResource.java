package com.gagauz.javaee.jaxrs.endpoint;

import com.gagauz.javaee.jaxrs.bean.JaxbBean1;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path(value = "/index")
public class IndexResource {

    @GET
    @Produces({ MediaType.TEXT_PLAIN })
    @Consumes({ MediaType.WILDCARD })
    public String getIt() {
        return "Hi managed bean!";
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public JaxbBean1 getItJson(@QueryParam("name") @DefaultValue("Anonymous") String name,
            @QueryParam("age") @DefaultValue("10") int age) {
        return new JaxbBean1(name, age);
    }
}
