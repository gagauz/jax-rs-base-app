package com.gagauz.javaee.jaxrs.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path(value = "/some")
@Produces("application/json")
public class SomeResource {
    @GET
    @Path(value = "/{id}")
    public String getSomeById(@PathParam("id") String id) {
        return "OK : " + id;
    }
}
