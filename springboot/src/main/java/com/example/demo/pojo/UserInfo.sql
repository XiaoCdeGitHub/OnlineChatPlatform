-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	gender VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'gender',
	region VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'region',
	avatar VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'avatar',
	email VARCHAR (50) NOT NULL COMMENT 'email',
	PRIMARY KEY (email)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_info';
