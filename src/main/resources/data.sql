DROP TABLE IF EXISTS user_channel ;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS role;
DROP TABLE IF EXISTS channel;

CREATE TABLE channel(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    
);

CREATE TABLE user(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL,
    role_id INT(20),
  
);

CREATE TABLE message(
    id INT(20) PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    canal_id INT(20),
    user_id INT(20),
    CONSTRAINT fk_message_canal FOREIGN KEY (canal_id) REFERENCES channel(id),
    CONSTRAINT fk_message_user FOREIGN KEY (user_id) REFERENCES user(id)
);

