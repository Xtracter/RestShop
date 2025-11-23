# Rest Shop

Spring Boot REST application with Spring Thymeleaf and PostgreSQL.

Fredrik Roos 2025.

## Prerequisites
- JDK 17
- Maven
- Docker (optional, to run Postgres)

## Run PostgreSQL with Docker
```bash
docker-compose up -d
```
## Build and run
```bash
./mvnw spring-boot:run
```
# or
```bash
mvn clean package
java -jar target/restshop-0.0.1-SNAPSHOT.jar
```