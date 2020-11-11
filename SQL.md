
--创建用户表
CREATE TABLE user(
    userId bigint(32) NOT NULL AUTO_INCREMENT primary key,
    username varchar(256) NOT NULL DEFAULT '',
    mobile varchar(11) NOT NULL DEFAULT '',
    email varchar(256) NOT NULL DEFAULT '',
    password varchar(256) NOT NULL DEFAULT '',
    imgurl varchar(256) NOT NULL DEFAULT '',
    idCard varchar(256) NOT NULL DEFAULT '',
    updateTime datetime NOT NULL DEFAULT '1000-10-10 10:10:10',
    createTime  datetime NOT NULL DEFAULT '1000-10-10 10:10:10'
) ENGINE=InnoDB  DEFAULT CHARSET=gbk

