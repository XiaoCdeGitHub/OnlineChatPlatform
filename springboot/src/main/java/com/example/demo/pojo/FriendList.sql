-- auto-generated definition
create table friend_list
(
    userId int not null comment 'userId'
        primary key,
    name varchar(50) not null comment 'name',
    avatar char(50) default '' not null comment 'avatar',
    last_word varchar(50) default '' not null comment 'lastWord',
    last_time varchar(50) default '' null comment 'lastTime'
)
    comment 'friend_list' charset = utf8mb4;

