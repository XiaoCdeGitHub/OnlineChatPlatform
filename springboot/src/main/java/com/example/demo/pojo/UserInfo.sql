-- auto Generated on 2023-06-27
-- DROP TABLE IF EXISTS user_info;
CREATE TABLE user_info(
	`name` VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'name',
	gender VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'gender',
	region VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'region',
	avatar VARCHAR (150) NOT NULL DEFAULT 'https://cd-mapbed.oss-cn-beijing.aliyuncs.com/9d17788554f9d008c469b6b2616a8d6.jpg' COMMENT 'avatar',
	email VARCHAR (50) NOT NULL COMMENT 'email',
    userId INT NOT NULL COMMENT 'userId',
	PRIMARY KEY (email),
    FOREIGN KEY (userId) REFERENCES login_db(userId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_info';
