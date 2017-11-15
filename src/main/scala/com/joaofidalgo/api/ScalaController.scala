package com.joaofidalgo.api

import javax.enterprise.context.ApplicationScoped
import javax.ws.rs.{GET, Path, Produces}
import javax.ws.rs.core.MediaType

@ApplicationScoped
@Path("/")
class ScalaController {

  @GET
  @Path("/hello-scala")
  @Produces(Array(MediaType.TEXT_PLAIN))
  def get() = "Hello, Scala!"

}
