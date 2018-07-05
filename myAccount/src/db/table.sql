USE `manager`;

/*Table structure for table `email_attachment` */

DROP TABLE IF EXISTS `haccount`;

CREATE TABLE `haccount` (
  `HID` VARCHAR (32) NOT NULL,
  `USER_NAME` VARCHAR (50) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) NOT NULL COMMENT '密码',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`HID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `hid` VARCHAR (32) NOT NULL,
  `haccountHid` VARCHAR (32) NOT NULL COMMENT '账号ID',
  `role` VARCHAR (50) NOT NULL COMMENT '角色',
  `authority` VARCHAR (50) NOT NULL COMMENT '角色',
  PRIMARY KEY (`hid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Spring Security 原生 JdbcDaoImpl 中需要用到的table
DROP TABLE IF EXISTS `user`;
create table user(
  hid varchar(50) not null,
  username varchar(50) not null UNIQUE COMMENT '用户名' ,
  password varchar(500) not null COMMENT '密码',
  enabled boolean not null COMMENT '是否启用',
  `CREATE_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`hid`));

DROP TABLE IF EXISTS `authorities`;
create table authorities(
  hid varchar(50) not null primary key,
  userHid varchar(50) not null,
  authority varchar(50) not null,
  constraint fk_authorities_user foreign key(userHid) references user(hid));
-- create unique index ix_auth_username on authorities (userHid,authority);
-- 添加原生表格测试用户
-- 插入两个用户
insert user  VALUES('oi8UHtbxvfrs','admin','admin',1,'2018-06-17');
insert user  VALUES('onaiehtNB02j','haoyu','123456',1,'2018-06-17');
insert user  VALUES('mnyqpo83nfHQ','shijie','123456',1,'2018-06-17');
-- 赋予admin \ haoyu 权限ROLE_USER
insert authorities VALUES('miqu4hzcertI','oi8UHtbxvfrs','ROLE_ADMIN');
insert authorities VALUES('onaiehtQW02j','onaiehtNB02j','ROLE_USER');
insert authorities VALUES('mnyqRD83nfHQ','mnyqpo83nfHQ','ROLE_USER');