package com.joaofidalgo.api;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/")
public class JavaController {

    @GET
    @Path("/hello-java")
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Hello, Java!";
    }

}
