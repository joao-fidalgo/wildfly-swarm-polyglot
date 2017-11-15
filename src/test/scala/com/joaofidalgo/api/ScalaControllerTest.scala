package com.joaofidalgo.api

import org.hamcrest.CoreMatchers
import org.jboss.arquillian.container.test.api.{Deployment, RunAsClient}
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.{Archive, ShrinkWrap}
import org.junit.runner.RunWith
import org.junit.{Assert, Test}
import org.openqa.selenium.WebDriver
import org.wildfly.swarm.jaxrs.JAXRSArchive

@RunWith(classOf[Arquillian])
class ScalaControllerTest {

  @Drone
  private var browser: WebDriver = _

  @RunAsClient
  @Test
  def testIt(): Unit = {
    browser.navigate.to("http://localhost:8080/hello-scala")
    Assert.assertThat(browser.getPageSource, CoreMatchers.containsString("Hello, Scala!"))
  }

}

object ScalaControllerTest {

  @Deployment
  def createDeployment(): Archive[_] = {
    val deployment: JAXRSArchive = ShrinkWrap.create(classOf[JAXRSArchive])
    deployment.addResource(classOf[ScalaController])
  }

}
