package com.joaofidalgo.api;

import org.hamcrest.CoreMatchers;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.wildfly.swarm.jaxrs.JAXRSArchive;

@RunWith(Arquillian.class)
public class JavaControllerTest {

    @Drone
    private WebDriver browser;

    @Deployment
    public static Archive createDeployment() {
        JAXRSArchive deployment = ShrinkWrap.create(JAXRSArchive.class);
        return deployment.addResource(JavaController.class);
    }

    @RunAsClient
    @Test
    public void testIt() {
        browser.navigate().to("http://localhost:8080/hello-java");
        Assert.assertThat(browser.getPageSource(), CoreMatchers.containsString("Hello, Java!"));
    }

}
