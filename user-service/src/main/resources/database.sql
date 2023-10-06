create database user_service;

use user_service;


CREATE TABLE roles
(
    roles_id BIGINT AUTO_INCREMENT NOT NULL,
    name     VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_roles PRIMARY KEY (roles_id)
);

CREATE TABLE users
(
    users_id BIGINT AUTO_INCREMENT NOT NULL,
    email    VARCHAR(255)          NOT NULL,
    password VARCHAR(255)          NOT NULL,
    role_id  BIGINT                NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (users_id)
);

ALTER TABLE users
    ADD CONSTRAINT FK_USERS_ON_ROLE FOREIGN KEY (role_id) REFERENCES roles (roles_id);