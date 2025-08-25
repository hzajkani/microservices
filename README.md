# Microservices – Spring Boot • Spring Cloud • Docker

A hands‑on, production‑style microservices playground by **Kamran Zajkani**.  
It demonstrates externalized configuration, service discovery, centralized routing, and event‑driven refresh—using Spring Boot 3.x and Spring Cloud.

## Features

- **Centralized Config** via Spring Cloud Config (Git‑backed)
- **Secrets & Encryption** using Spring Cloud Config’s `/encrypt` & `/decrypt` (symmetric key)
- **Hot Refresh** across services with **Spring Cloud Bus + RabbitMQ**
- **Service Discovery** using Eureka
- **API Gateway** with route/filters & rate‑limit placeholders
- **Actuator** health/info/metrics across services
- **Docker Compose** for local infra
---


## Prerequisites

- **Java 21** (or compatible with your code)
- **Maven 3.9+**
- **Docker & Docker Compose**
- **Git**
---


## RabbitMQ (Docker):

install RabbitMQ on docker
```bash
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management
```
---

## Author

**Kamran Zajkani** – _Full‑stack Java & Microservices_  
GitHub: [@hzajkani](https://github.com/hzajkani)
