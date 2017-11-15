package com.joaofidalgo.api

import org.hamcrest.CoreMatchers
import org.jboss.arquillian.container.test.api.Deployment
import org.jboss.arquillian.container.test.api.RunAsClient
import org.jboss.arquillian.drone.api.annotation.Drone
import org.jboss.arquillian.junit.Arquillian
import org.jboss.shrinkwrap.api.Archive
import org.jboss.shrinkwrap.api.ShrinkWrap
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver
import org.wildfly.swarm.arquillian.DefaultDeployment
import org.wildfly.swarm.jaxrs.JAXRSArchive

@RunWith(Arquillian::class)
@DefaultDeployment
class KotlinControllerTest {

    @Drone
    private lateinit var browser: WebDriver

    companion object {
        @Deployment
        @JvmStatic fun createDeployment(): Archive<*> {
            val deployment: JAXRSArchive = ShrinkWrap.create(JAXRSArchive::class.java)
            return deployment.addResource(KotlinController::class.java)
        }
    }

    @RunAsClient
    @Test
    fun testIt() {
        browser.navigate().to("http://localhost:8080/hello-kotlin")
        Assert.assertThat(browser.pageSource, CoreMatchers.containsString("Hello, Kotlin!"))
    }

}