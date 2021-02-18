
--创建用户表

CREATE TABLE user(
    userId bigint(32) NOT NULL AUTO_INCREMENT primary key,
    username varchar(256) NOT NULL DEFAULT '',
    mobile varchar(11) NOT NULL DEFAULT '',
    email varchar(256) NOT NULL DEFAULT '',
    password varchar(256) NOT NULL DEFAULT '',
    imgurl varchar(256) NOT NULL DEFAULT '',
    idCard varchar(256) NOT NULL DEFAULT '',
    createTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updateTime  timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP  COMMENT '更新时间',
                     UNIQUE INDEX (mobile)
) ENGINE=InnoDB  DEFAULT CHARSET=gbk