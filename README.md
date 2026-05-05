# 🔐 Spring Security Blog API

API REST segura para gestión de blog desarrollada con **Java + Spring Boot + Spring Security**.

Este proyecto fue realizado como trabajo integrador final del curso **Seguridad con Spring Security** de TodoCode Academy, con foco en autenticación, autorización y buenas prácticas de seguridad backend.

---

## 🚀 Tecnologías utilizadas

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* MySQL
* JWT (JSON Web Token)
* OAuth2
* BCrypt
* Maven
* Lombok
* Postman

---

## 📌 Funcionalidades

### Blog

* CRUD de posteos
* CRUD de autores

### Seguridad

* Registro de usuarios
* Login mediante `/auth/login`
* Generación de token JWT
* Validación de autenticación
* Password hashing con BCrypt
* OAuth2 authentication

### Administración

* CRUD de usuarios
* CRUD de roles
* CRUD de permisos

---

## 🔑 Roles implementados

### Admin

Permisos completos sobre todos los endpoints:

* CREATE
* READ
* UPDATE
* DELETE

Incluye acceso a:

* usuarios
* roles
* permisos
* autores
* posteos

---

### User

Permisos limitados:

* READ posts
* READ authors

---

### Author

Permisos orientados a contenido:

* CREATE posts
* READ posts
* READ authors
* UPDATE posts

---

## 🧩 Permisos

Los permisos manejados por el sistema son:

* READ
* CREATE
* UPDATE
* DELETE

Cada rol posee permisos específicos almacenados en base de datos.

---

## 🗄️ Base de datos

Base de datos MySQL:

```
blog_security_db
```

Entidades principales:

* User
* Role
* Permission
* Author
* Post

Relaciones:

* User ↔ Role
* Role ↔ Permission
* Post ↔ Author

---

## 🔐 Autenticación JWT

Flujo:

1. Usuario inicia sesión en `/auth/login`
2. Se validan credenciales
3. Se genera token JWT
4. Token enviado en headers:

```
Authorization: Bearer TOKEN
```

---

## 📮 Endpoints principales

### Auth

* POST `/auth/login`

### Users

* GET `api/users`
* POST `api/users`

### Roles

* GET `api/roles`
* POST `api/roles`

### Permissions

* GET `api/permissions`
* POST `api/permissions`

### Posts

* CRUD completo

### Authors

* CRUD completo

---

## 🧪 Testing

Pruebas realizadas con Postman:

* autenticación
* autorización por roles
* acceso restringido
* validación JWT
* CRUD completo

---

## 📷 Capturas

*Aca proximemente screenshots de Postman, base de datos*

---

## 📚 Objetivo del proyecto

Validar conocimientos prácticos sobre:

* seguridad backend
* autenticación y autorización
* arquitectura REST
* manejo de tokens
* control de acceso basado en roles y permisos

Además, este proyecto forma parte de mi portfolio backend.

---

## 👩‍💻 Autora

**Ingrid**

Desarrolladora de aplicaciones enfocada en backend, seguridad y desarrollo web.

GitHub: https://github.com/ingridl23/
LinkedIn: https://linkedin.com/in/ingrid-ledesma

---
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.5-green)
![JWT](https://img.shields.io/badge/Auth-JWT-blue)
![MySQL](https://img.shields.io/badge/Database-MySQL-lightblue)
