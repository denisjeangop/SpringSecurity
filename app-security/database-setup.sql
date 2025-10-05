-- =============================================
-- Script ACTUALIZADO para recrear la base de datos
-- Basado en UserEntity + AuthoritiesEntity con relaciones
-- =============================================

-- Eliminar la base de datos existente y recrearla
DROP DATABASE IF EXISTS security_db;
CREATE DATABASE security_db 
    CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- Usar la base de datos
USE security_db;

-- Crear la tabla user_entity
CREATE TABLE user_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    uuid_user CHAR(36) UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB;

-- Crear la tabla authorities
CREATE TABLE authorities (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    authority VARCHAR(255) NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES user_entity(id) ON DELETE CASCADE
) ENGINE=InnoDB;

-- Crear índices para optimizar consultas
CREATE INDEX idx_user_email ON user_entity(email);
CREATE INDEX idx_user_uuid ON user_entity(uuid_user);
CREATE INDEX idx_authorities_user_id ON authorities(user_id);
CREATE INDEX idx_authorities_authority ON authorities(authority);

-- Insertar usuarios de prueba con passwords encriptados
-- Password para todos: "password" (encriptado con BCrypt strength 10)
INSERT INTO user_entity (uuid_user, email, password) VALUES 
    (UUID(), 'admin@test.com', '$2a$10$iGwNHS3bq19EHeo77kM1VObqkAGC5uu1F2IgiQSHQmgOwy2F3/iM.'),
    (UUID(), 'user@test.com', '$2a$10$iGwNHS3bq19EHeo77kM1VObqkAGC5uu1F2IgiQSHQmgOwy2F3/iM.'),
    (UUID(), 'moderator@test.com', '$2a$10$iGwNHS3bq19EHeo77kM1VObqkAGC5uu1F2IgiQSHQmgOwy2F3/iM.');

-- Insertar authorities/roles para cada usuario
-- Admin: ROLE_USER + ROLE_ADMIN
INSERT INTO authorities (authority, user_id) VALUES 
    ('ROLE_USER', 1),
    ('ROLE_ADMIN', 1);

-- User: Solo ROLE_USER  
INSERT INTO authorities (authority, user_id) VALUES 
    ('ROLE_USER', 2);

-- Moderator: ROLE_USER + ROLE_MODERATOR
INSERT INTO authorities (authority, user_id) VALUES 
    ('ROLE_USER', 3),
    ('ROLE_MODERATOR', 3);

-- Verificar la creación
SELECT 'Base de datos recreada correctamente' AS status;

-- Mostrar usuarios creados
SELECT u.id, u.email, GROUP_CONCAT(a.authority) AS roles
FROM user_entity u
LEFT JOIN authorities a ON u.id = a.user_id
GROUP BY u.id, u.email;

-- Mostrar total de registros
SELECT 
    (SELECT COUNT(*) FROM user_entity) AS total_users,
    (SELECT COUNT(*) FROM authorities) AS total_authorities;