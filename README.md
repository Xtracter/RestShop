# Rest Shop

Spring Boot REST application with Spring Thymeleaf and PostgreSQL.

Fredrik Roos 2025.

## Prerequisites
- JDK 17
- Maven
- Docker
- PostgreSQL 17 (If not uing Docker)
## Run PostgreSQL with Docker
```bash
sudo docker-compose up -d
```

## Run App in Docker
```
sudo docker build -t restshop-app .
sudo docker run -p 8080:8080 restshop-app
```

## Check Docker containers
```
sudo docker ps
```

## Build and run (No Docker)
```bash
./mvnw spring-boot:run
```
# or
```bash
mvn clean package
java -jar target/restshop-0.0.1-SNAPSHOT.jar
```
