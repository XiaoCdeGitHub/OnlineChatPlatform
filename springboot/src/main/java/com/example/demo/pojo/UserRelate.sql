CREATE TABLE user_relate(
    sid INT AUTO_INCREMENT PRIMARY KEY,
    sendUserId VARCHAR(50) NOT NULL DEFAULT '',
    receiveUserId VARCHAR(50) NOT NULL DEFAULT '',
    lastTime VARCHAR(50) NOT NULL DEFAULT '',
    lastWord VARCHAR(50) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'user_relate';