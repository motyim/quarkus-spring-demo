# getting-started project
** to see spring code switch to spring-branch **
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```
in this version you will use H2 as DB.
## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `getting-started-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```
* prerequisite : run postgres on docker 
```shell script
docker run --name my-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=fruits -p 5434:5432 -d postgres
```
The application is now runnable using `java -Dquarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5433/fruits -Dquarkus.datasource.username=postgres -Dquarkus.datasource.password=postgres -jar target/getting-started-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/getting-started-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Running Using Docker Compose 

This application could run using docker compose to connect postgres DB 
```shell script
cd src/main/resoures
docker-compose up 
```
then you can access service http://localhost:8080

# Conclusion

* Quarkus shows an amazing performance on startup over spring boot usually Quarkus take about 2s less than Spring , and for quarkus native image it start on less than 1 second which is great.  
  - Quarkus native image startup time
![Quarkus native image startup time](./screenshot/Quarkus_StartUp.png?raw=true "Quarkus native image startup time")
  - Quarkus startup time (GraalVM)
![Quarkus startup time](./screenshot/Quarkus_notnative-startup.png?raw=true "Quarkus startup time")
  - Spring boot startup time (GraalVM)
![Spring boot startup time](./screenshot/Spring_Start_time.png?raw=true "Spring boot startup time")

* For memory foot print its seem clearly that quarkus optimize it since it load and package only the needed classes .
  - spring on left / Quarkus on right (GraalVM)
![memory](./screenshot/memory.png?raw=true "memory")

* for response time (spring boot / quarkus ) give much better response time when using GraalVM over OpenJDk . 
  The GET response time looks good, with the native executable application handily beating the GraalVM versions. But POST calls on Quarkus some times in the two versions get more time than spring.
  - spring load test (GraalVM)
![load test spring](./screenshot/spring-load-test.png?raw=true "spring load test")

  - quarkus load test (native)
![quarkus load test.png](./screenshot/quarkus_load_test.png?raw=true "quarkus load test.png")

* it's has a lot of extension to integrate and use spring annotation it's easy to migrate from spring 
* it has a drawback that it has a very fast cycle in launch release like release each week and till now not have a big community
# Nice to read
* [QUARKUS - CREATING YOUR FIRST APPLICATION](https://quarkus.io/guides/getting-started)
* [How Does The Quarkus Java Framework Compare With Spring ?](https://simply-how.com/quarkus-vs-spring)
* [quarkus for spring developers](https://quarkus.io/blog/quarkus-for-spring-developers/)
* [GraalVM Native Image: Spring VS Quarkus](https://medium.com/swlh/graalvm-native-image-spring-vs-quarkus-a738263df069)
* [Quarkus Runtime Performance](https://quarkus.io/blog/runtime-performance/)
* [Thoughts on Quarkus](https://dzone.com/articles/thoughts-on-quarkus)
* [quarkus-cheat-sheet](https://lordofthejars.github.io/quarkus-cheat-sheet/#_spring_web)
* [build native image](https://quarkus.io/guides/building-native-image)
* [issue build native image](https://github.com/quarkusio/quarkus/issues/8974)
* [Migrating a Spring Boot microservices application to Quarkus](https://developers.redhat.com/blog/2020/04/10/migrating-a-spring-boot-microservices-application-to-quarkus/)