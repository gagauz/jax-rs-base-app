package com.gagauz.javaee.jaxrs.endpoint.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import java.io.IOException;

@PreMatching

public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        final SecurityContext securityContext = requestContext.getSecurityContext();
        if (securityContext == null || !securityContext.isUserInRole("privileged")) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity("User cannot access the resource.").build());
        }
    }
}
