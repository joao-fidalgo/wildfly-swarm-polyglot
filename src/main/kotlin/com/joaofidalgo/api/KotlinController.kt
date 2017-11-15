package com.joaofidalgo.api

import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@ApplicationScoped
@Path("/")
open class KotlinController {

    @GET
    @Path("/hello-kotlin")
    @Produces(MediaType.TEXT_PLAIN)
    open fun get() : String = "Hello, Kotlin!"

}