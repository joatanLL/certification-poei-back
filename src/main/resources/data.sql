DROP TABLE IF EXISTS user_channel ;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS canaux;

CREATE TABLE canaux(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    description TEXT,
    name VARCHAR(255) NOT NULL,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE roles(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    role VARCHAR(255)
);

CREATE TABLE users(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    role_id INT(20),
    CONSTRAINT fk_user_role FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE messages(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ,
    updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    canal_id INT(20),
    user_id INT(20),
    CONSTRAINT fk_message_canal FOREIGN KEY (canal_id) REFERENCES canaux(id),
    CONSTRAINT fk_message_user FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE user_channel(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    canal_id INT(20),
    user_id INT(20),
    CONSTRAINT fk_user_canal FOREIGN KEY (canal_id) REFERENCES canaux(id),
    CONSTRAINT fk_canal_user FOREIGN KEY (user_id) REFERENCES users(id)
);