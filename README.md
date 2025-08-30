# Microservices Playground – Spring Boot • Spring Cloud • Docker

A hands-on, production-ready microservices demo project.  
This project showcases externalized configuration, service discovery, centralized routing, and event-driven refresh using Spring Boot 3.x and Spring Cloud.

---

## Features

- Centralized Configuration with Spring Cloud Config (Git-backed)
- Secrets & Encryption using Config Server `/encrypt` & `/decrypt` (symmetric key)
- Live Refresh across services powered by Spring Cloud Bus + RabbitMQ
- Service Discovery via Eureka
- API Gateway with route filtering & rate-limit stubs
- Monitoring & Observability through Spring Boot Actuator (health, info, metrics)
- Containerized Environment using Docker Compose

---

## Prerequisites

Make sure you have the following installed:

- Java 21
- Maven 3.9+
- Docker & Docker Compose
- Git

---

## Running the Application

To start all services with Docker, navigate to the desired environment under the `docker-compose/` folder and run:

```bash
docker compose up -d
