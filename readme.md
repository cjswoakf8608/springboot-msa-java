
## MSA BFF(Backend For Frontend) Architecture
- 2024.10.02 까지 완성 예정

## 개발환경

- Java 17
- Gradle 8.10.2
- Spring Boot 3.2.1
    - spring dependency management 1.1.4
    - spring-data-mongodb
    - spring-data-jpa
    - spring-data-redis
    - spring-kafka
- JUnit 5
- MariaDB 11.5.2
- MongoDB 5.0.2
- Kafka 3.7
- Redis

### docker-compose.yml
- MongoDB
- MariaDB
- Kafka
- Redis
- Application Spring Boot/JDK 17

## MSA BFF 구조
  ![img.png](img/img.png)

## Hexagonal Architecture 적용
모든 MSA 도메인은 Hexagonal Architecture에 기반하여 Package 구조및 의존성 개발
  ![img.png](img/img-clean-architecture.png)

## Hexagonal Architecture 의존성 역전의 법칙 적용
- 외부에서 내부 layer 접근을 허용
- 내부에서 외부 layer 접근을 허용하지 않음
  - 따라서 의존성 역전의 법칙으로 Infrastructure를 통해 외부 assets 접근을 적용
  - 1. FeignClient: 의존성 역전의 법칙에 의한 Infrastructure FeignClient 접근
  ![img.png](img/img-reverse-di.png)

  - 2. JPA: 의존성 역전의 법칙에 의한 Infrastructure RDS 접근
  ![img_1.png](img/img-reverse-di-rds.png)

  - 3. 의존성 역전의 법칙을 기반으로 "원하는 기능, lib, 미들웨어 등 변경" 가능
  ![img.png](img/img-change.png)
  











