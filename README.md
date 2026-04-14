# Task Manager REST API

Task Manager — это backend REST API приложение для управления задачами, разработанное на Spring Boot.

##  Features

- создание задач
- получение задачи по id
- получение всех задач
- обновление задачи
- удаление задачи

## Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger

## Architecture

Проект разделён на слои:

- Controller — обработка HTTP запросов
- Service — бизнес-логика
- Repository — работа с базой

Используется DTO для разделения внутренней модели и API слоя.

## API

Основные endpoints:

- GET /api/task/get/{id} — получить задачу
- GET /api/task/getAll — список задач
- POST /api/task/create — создать задачу
- PUT /api/task/update/{id} — обновить задачу
- DELETE /api/task/delete/{id} — удалить задачу

## Swagger

Документация API доступна через Swagger UI:

http://localhost:8080/swagger-ui/index.html
