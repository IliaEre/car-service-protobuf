-- DDL
CREATE TABLE car
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    name  VARCHAR(255) NOT NULL UNIQUE,
    title VARCHAR(255) NOT NULL
);