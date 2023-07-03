-- auto Generated on 2023-06-30
-- DROP TABLE IF EXISTS chat_message;
CREATE TABLE chat_message(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	send_user_id BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'sendUserId',
	receive_user_id BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'receiveUserId',
	send_user_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'sendUserName',
	receive_user_name VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'receiveUserName',
	send_content VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'sendContent',
	create_time DATETIME NOT NULL DEFAULT '1000-01-01 00:00:00' COMMENT 'createTime',
	send_time VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'sendTime',
	send_user_avatar VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'sendUserAvatar',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'chat_message';
