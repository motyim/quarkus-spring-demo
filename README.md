# demo project

This project uses Spring boot.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw clean spring-boot:run 
```
in this version you will use H2 as DB.
## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw clean package -P package
```
It produces the `demo-0.0.1-SNAPSHOT.jar` file in the `/target` directory.

* prerequisite : run postgres on docker 
```shell script
docker run --name my-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=fruits -p 5434:5432 -d postgres
```
The application is now runnable using `java -jar target/demo-0.0.1-SNAPSHOT.jar`.
git