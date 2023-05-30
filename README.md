# Getting Started

A Spring Boot application with Java 17 responsible for managing a customer's wishlist.

# This Application uses Clean Architecture
- [What is Clean Architecture?](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6)

# How this application is divided?

![drawing](src/main/resources/static/simple-clean-arch.webp)

#### To view the endpoints exposed by this application access the url
``` 
http://localhost:8080/wishlist/swagger-ui/index.html
```

#### Before start the application, run the docker command below to start mongodb
```
docker compose -f docker-compose.yaml up -d
```
