# Wildfly Swarm Polyglot

This example takes a normal JAX-RS build supporting multiple JVM languages such as `java`, `scala` and `kotlin`, and wraps it into a `-swarm` runnable jar. 

## Project `pom.xml`

This project is a traditional JAX-RS project, with maven packaging of `war` in the `pom.xml`

    <packaging>war</packaging>

The project adds a `<plugin>` to configure `wildfly-swarm-plugin` to create the runnable `.jar`.

    <plugin>
      <groupId>org.wildfly.swarm</groupId>
      <artifactId>wildfly-swarm-plugin</artifactId>
      <version>${version.wildfly-swarm}</version>
      <executions>
        <execution>
          <goals>
            <goal>package</goal>
          </goals>
        </execution>
      </executions>
    </plugin>

## Run

* mvn package && java -jar ./target/wildfly-swarm-polyglot-swarm.jar
* mvn wildfly-swarm:run
* From your IDE, run class `org.wildfly.swarm.Swarm`

## TODO

- [ ] Docker Support
