-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS user_login;
CREATE TABLE login_db(
    userId INT NOT NULL AUTO_INCREMENT,
    email VARCHAR (50) NOT NULL COMMENT 'email',
	`password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
	PRIMARY KEY (userId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_login';
