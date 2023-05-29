# Getting Started

This microservice uses Clean Architecture:
- [What is Clean Architecture?](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6)

How this microservice is divided?

![drawing](src/main/resources/static/simple-clean-arch.webp)

Every UseCase uses a Gateway Interface which is implemented by Dataprovider. 