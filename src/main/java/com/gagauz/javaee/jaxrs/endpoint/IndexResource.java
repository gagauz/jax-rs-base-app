package com.gagauz.javaee.jaxrs.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path(value = "/index")
public class IndexResource {

    @GET
    @Produces("text/plain")
    public String getIt() {
        return "Hi managed bean!";
    }
}
