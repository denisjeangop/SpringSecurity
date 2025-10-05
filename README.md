# 🔐 Sistema de Autenticación y Autorización con Spring Security

## 📖 Descripción del Proyecto

Este proyecto es una **aplicación web completa** desarrollada con **Spring Boot** que implementa un sistema robusto de autenticación y autorización utilizando **Spring Security**. La aplicación demuestra el manejo profesional de seguridad en aplicaciones empresariales, incluyendo gestión de usuarios, roles y permisos de manera escalable y segura.

## 🎯 Objetivos Técnicos Alcanzados

### Seguridad y Autenticación
- **Autenticación personalizada** con email y contraseña
- **Encriptación de contraseñas** usando BCrypt con salt único
- **Gestión de sesiones** seguras con Spring Security
- **Protección CSRF** habilitada para prevenir ataques
- **Autorización granular** basada en roles a nivel de controlador y vista

### Arquitectura y Persistencia
- **Arquitectura por capas** siguiendo principios SOLID
- **Entidades JPA** con relaciones OneToMany para usuarios y roles
- **Repositorios personalizados** con consultas JPQL optimizadas
- **Transacciones** manejadas por Spring Framework
- **Base de datos MySQL** con esquema normalizado

### Frontend y Experiencia de Usuario
- **Templates Thymeleaf** con integración completa de Spring Security
- **Autorización condicional** en vistas usando Spring Security tags
- **Interfaz responsive** con CSS personalizado
- **Mensajes de feedback** para acciones del usuario

## 🛠️ Stack Tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 21 LTS | Lenguaje de programación |
| **Spring Boot** | 3.3.4 | Framework principal |
| **Spring Security** | 6.3.3 | Autenticación y autorización |
| **Spring Data JPA** | 3.3.4 | Persistencia de datos |
| **Hibernate** | 6.5.3 | ORM |
| **Thymeleaf** | 3.1.2 | Motor de plantillas |
| **MySQL** | 8.0+ | Base de datos |
| **Maven** | 3.9+ | Gestión de dependencias |

## 💡 Características Implementadas

### 🔒 Sistema de Roles Multinivel
```java
- ROLE_ADMIN: Acceso completo al sistema y gestión de usuarios
- ROLE_USER: Acceso básico a funcionalidades estándar  
- ROLE_MODERATOR: Permisos intermedios para moderación
```

### 🏗️ Arquitectura de Seguridad
- **UserDetailsService personalizado** para carga de usuarios desde BD
- **PasswordEncoder configurado** con BCrypt strength 10
- **Autorización por anotaciones** usando `@PreAuthorize`
- **Filtros de seguridad** personalizados para endpoints específicos

### 📊 Gestión de Datos
- **Entidades relacionales** con mapeo JPA bidireccional
- **Consultas optimizadas** con JOIN FETCH para evitar N+1 queries
- **Validación de datos** en múltiples capas
- **Manejo de transacciones** para operaciones complejas
