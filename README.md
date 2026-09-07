# vetcare-backend
API REST para el ecosistema VetCare. Desarrollada con Spring Boot bajo una arquitectura basada en capas, asegurando escalabilidad y separación de responsabilidades. Cuenta con seguridad mediante JWT y persistencia de datos en PostgreSQL.

## Tecnologías Utilizadas

* **Java & Spring Boot** - Framework principal.
* **Spring Security & JWT** - Autenticación y autorización basada en tokens.
* **Spring Data JPA** - Abstracción de la capa de datos.
* **PostgreSQL** - Base de datos relacional.
* **Jakarta Validation** - Validaciones de datos en los endpoints.

## Arquitectura y Estructura

El proyecto sigue una **estructura basada en capas** y componentes especializados para garantizar un código limpio, seguro y mantenible:

* **Controller**: Exposición de los endpoints REST y manejo de peticiones HTTP.
* **Service**: Capa de negocio donde se gestiona la lógica principal de la aplicación.
* **Repository**: Interfaz de comunicación y consultas a la base de datos PostgreSQL.
* **Model/Entity**: Representación de las tablas de la base de datos (mapeo ORM).
* **DTO (Data Transfer Object)**: Transferencia de datos segura entre capas y validación de inputs.
* **Security**: Configuración de Spring Security, filtros de autenticación y gestión del ciclo de vida de los tokens **JWT**.
* **Exception**: Manejo centralizado de errores globales (mediante `@RestControllerAdvice`) para retornar respuestas HTTP limpias y estandarizadas al frontend.
