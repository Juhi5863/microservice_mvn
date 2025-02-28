# Microservices with Maven, Docker, and Kubernetes

## Prerequisites
Ensure the following are installed and properly configured on your system:
1. **Java 21** (set environment variables)
2. **Maven**
3. **Docker Desktop**
4. **Enable Kubernetes inside Docker Desktop**
5. **PostgreSQL**
6. **Kafka & Zookeeper**

### VS Code Extensions
- Install Java, Spring Boot, Docker, and Kubernetes tools.

---

## Setting Up Spring Boot Microservices
Run the following Maven commands to create the microservices:

```sh
mvn archetype:generate -DgroupId=com.ecommerce -DartifactId=user-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.ecommerce -DartifactId=product-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.ecommerce -DartifactId=order-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
mvn archetype:generate -DgroupId=com.ecommerce -DartifactId=payment-service -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

---

## File Structure
```
Microservices/
  ├── docker-compose.yml
  ├── k8s/
  │   ├── order-service-deployment.yml
  │   ├── payment-service-deployment.yml
  │   ├── postgres-deployment.yml
  │   ├── product-service-deployment.yml
  │   └── user-service-deployment.yml
  ├── user-service/
  ├── product-service/
  ├── order-service/
  ├── payment-service/
```

---

## PostgreSQL Configuration

**docker-compose.yml**
```yaml
services:
  postgres:
    image: postgres:17.4
    container_name: postgres_db
    environment:
      POSTGRES_USER: myuser
      POSTGRES_PASSWORD: mypassword
      POSTGRES_DB: ecommercedb
    ports:
      - "5432:5432"
    networks:
      - ecommerce-network
```

---

## Database Connection in Microservices
Each microservice should have the following PostgreSQL configuration inside `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://postgres_db:5432/ecommercedb
spring.datasource.username=myuser
spring.datasource.password=mypassword
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.sql.init.mode=always
```

---

## Running PostgreSQL with Docker Compose
Start PostgreSQL and all services:
```sh
docker-compose up -d
```
Check running containers:
```sh
docker ps
```
Stop services:
```sh
docker-compose down
```

---

## Verifying PostgreSQL Connection
Access PostgreSQL inside the container:
```sh
docker exec -it postgres_db psql -U myuser -d ecommercedb
```
Check tables:
```sql
\dt
```
If no tables are found, ensure the microservices are running and Hibernate is configured correctly.

---

## Building the Microservices
```sh
cd user-service && mvn clean package -DskipTests
cd product-service && mvn clean package -DskipTests
cd order-service && mvn clean package -DskipTests
cd payment-service && mvn clean package -DskipTests
```

---

## Running Services with Docker Compose
Navigate to the root directory where `docker-compose.yml` is located and build images:
```sh
docker-compose up -d --build
```

Check running containers:
```sh
docker ps
```
View logs for a specific service (e.g., user-service):
```sh
docker logs user-service --tail 50
```
Stop and remove all services:
```sh
docker-compose down -v
```

---



## Conclusion
This setup ensures a fully containerized microservices architecture using Spring Boot, PostgreSQL, Kafka, Docker, and Kubernetes.

