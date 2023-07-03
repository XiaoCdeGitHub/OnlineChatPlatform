-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS user_login;
CREATE TABLE user_login(
	email VARCHAR (50) NOT NULL COMMENT 'email',
	`password` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'password',
	PRIMARY KEY (email)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_login';
