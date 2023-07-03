-- auto Generated on 2023-06-29
-- DROP TABLE IF EXISTS user_relate;
CREATE TABLE user_relate(
	sendUserId VARCHAR (50) NOT NULL COMMENT 'sendUserId',
	receiveUserId VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'receiveUserId',
	lastTime VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lastTime',
	lastWord VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'lastWord',
	PRIMARY KEY (sendUserId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_relate';
