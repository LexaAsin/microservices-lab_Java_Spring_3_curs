📚 Микросервисная система управления библиотекой

Веб-приложение на Java + Spring Boot для автоматизации работы библиотеки: управление книгами, авторами, сотрудниками и библиотечными процессами.

🎯 О проекте

Учебный проект — лабораторные работы по курсу «Проектирование микросервисных архитектур программных систем».  
Студент: Асин А.А., группа ПИ‑331

Проект реализует *микросервисную архитектуру* с полным набором облачных технологий:

- ✅ регистрация и аутентификация через *Keycloak* (роли USER / ADMIN)
- ✅ управление книгами и авторами через REST API
- ✅ централизованная конфигурация через *Spring Cloud Config Server*
- ✅ регистрация и обнаружение сервисов через *Netflix Eureka*
- ✅ мониторинг метрик через *Prometheus + Grafana*
- ✅ централизованное журналирование через *ELK Stack* (Elasticsearch, Logstash, Kibana)
- ✅ распределённая трассировка через *Zipkin + Spring Cloud Sleuth*


🛠️ Стек технологий

| Технология | Назначение |

| Java 17 | язык программирования |
| Spring Boot 2.7.5 / 3.0.0 | фреймворк для микросервисов |
| Spring Cloud Config | централизованная конфигурация |
| Netflix Eureka | обнаружение сервисов |
| Spring Data JPA / Hibernate | работа с базой данных |
| PostgreSQL 15* | хранение данных |
| Spring Security + Keycloak | аутентификация и авторизация |
| Spring Boot Actuator + Micrometer | сбор метрик |
| Prometheus + Grafan* | мониторинг и визуализация |
| ELK Stack | централизованное логирование |
| Zipkin + Spring Cloud Sleuth | распределённая трассировка |
| Docker | контейнеризация сервисов |
| Maven | сборка и управление зависимостями |



📦 Состав микросервисов

| Сервис | Порт | Описание |
|--------|------|----------|
| Config Server | 8071 | Централизованное хранение конфигураций |
| Eureka Server | 8070 | Сервер обнаружения сервисов |
| Author Service | 8080 | Управление авторами |
| Book Service | 8082 | Управление книгами |
| PostgreSQL | 5432 | База данных |
| Keycloak | 8180 | Сервер аутентификации |
| Prometheus | 9090 | Сбор метрик |
| Grafana | 3000 | Визуализация метрик |
| Elasticsearch | 9200 | Хранение логов |
| Logstash | 5000 | Приём и обработка логов |
| Kibana | 5601 | Визуализация логов |
| Zipkin | 9411 | Визуализация трассировки |

---

🚀 Запуск проекта

1️⃣ Запуск Docker-сервисов

bash
PostgreSQL
docker run -d --name postgres-license -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=licenses_dev -p 5432:5432 postgres:15

Keycloak
docker run -d --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -p 8180:8080 quay.io/keycloak/keycloak:22.0.5 start-dev

Zipkin
docker run -d -p 9411:9411 --name zipkin openzipkin/zipkin
