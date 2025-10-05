-- =============================================
-- Script solo para crear la tabla UserEntity
-- (Asume que la BD ya existe)
-- =============================================

USE security_db;

-- Eliminar tabla si existe (para recrear)
DROP TABLE IF EXISTS user_entity;

-- Crear la tabla user_entity basada en tu UserEntity.java
CREATE TABLE user_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT 'ID auto-generado',
    uuid_user CHAR(36) NOT NULL UNIQUE COMMENT 'UUID único del usuario',
    email VARCHAR(255) NOT NULL UNIQUE COMMENT 'Email del usuario',
    password VARCHAR(255) NOT NULL COMMENT 'Contraseña encriptada',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de creación',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha de actualización'
) ENGINE=InnoDB 
  DEFAULT CHARSET=utf8mb4 
  COLLATE=utf8mb4_unicode_ci
  COMMENT='Tabla de usuarios del sistema';

-- Crear índices
CREATE INDEX idx_user_email ON user_entity(email);
CREATE INDEX idx_user_uuid ON user_entity(uuid_user);

-- Mostrar estructura de la tabla
DESCRIBE user_entity;