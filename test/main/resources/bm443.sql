/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.1.73-community : Database - bm_43
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bm_43` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bm_43`;

/*Table structure for table `bm_account_log` */

CREATE TABLE `bm_account_log` (
  `bm_account_log_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(30) NOT NULL DEFAULT '' COMMENT 'uid',
  `change_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '变动类型0充值1支付',
  `before_remain` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变动前余额',
  `after_remain` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '变动后余额',
  `change_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '发生时间',
  `pay_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付方式0微信1支付宝',
  PRIMARY KEY (`bm_account_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `bm_account_log` */

insert  into `bm_account_log`(`bm_account_log_id`,`uid`,`change_type`,`before_remain`,`after_remain`,`change_time`,`pay_type`) values (1,'20170425231430000',1,'90.00','100.00','2017-04-29 00:12:09',1);

/*Table structure for table `bm_files` */

CREATE TABLE `bm_files` (
  `bm_files_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `file_path` varchar(100) NOT NULL DEFAULT '' COMMENT '文件路径',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`bm_files_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `bm_files` */

insert  into `bm_files`(`bm_files_id`,`file_path`,`created_time`,`updated_time`) values (1,'<shshdsp>&scksmmscesmsmsmmcsm','2017-05-01 12:31:05','2017-05-01 12:31:05');

/*Table structure for table `bm_imgs` */

CREATE TABLE `bm_imgs` (
  `bm_imgs_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `img_path` varchar(100) NOT NULL DEFAULT '' COMMENT '文件路径',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`bm_imgs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `bm_imgs` */

insert  into `bm_imgs`(`bm_imgs_id`,`img_path`,`created_time`,`updated_time`) values (2,'<shshdsp>&scksmmscesmsmsmmcsm','2017-05-01 02:07:33','0000-00-00 00:00:00'),(3,'<shshdsp>&scksmmscesmsmsmmcsm','2017-05-01 13:02:36','0000-00-00 00:00:00');

/*Table structure for table `bm_menu` */

CREATE TABLE `bm_menu` (
  `bm_menu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `menu_code` varchar(30) NOT NULL DEFAULT '' COMMENT '角色编码',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT 'url',
  `logistic_url` varchar(100) NOT NULL DEFAULT '' COMMENT '逻辑url，angular',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '启用状态0启用1禁用',
  `menu_name` varchar(50) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `is_under_control` tinyint(4) NOT NULL DEFAULT '0' COMMENT '权限控制',
  `menu_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '类型0菜单1功能',
  `role_code` varchar(30) NOT NULL DEFAULT '' COMMENT '角色编码',
  PRIMARY KEY (`bm_menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `bm_menu` */

insert  into `bm_menu`(`bm_menu_id`,`menu_code`,`url`,`logistic_url`,`status`,`menu_name`,`is_under_control`,`menu_type`,`role_code`) values (1,'A001','login/changepassword','login.changepassword',1,'登陆',0,0,'R001'),(2,'A001','/login/signup','login.signup',1,'注册',0,0,'R001'),(3,'A0101','app/login','app.login',0,'登录',0,0,'R001');

/*Table structure for table `bm_order` */

CREATE TABLE `bm_order` (
  `bm_order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `order_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0单章1全本',
  `uid` varchar(50) NOT NULL DEFAULT '' COMMENT 'uid',
  `books_id` bigint(20) NOT NULL DEFAULT '0' COMMENT 'booksid',
  `order_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '下单时间',
  `order_chapters` bigint(20) NOT NULL DEFAULT '0' COMMENT '购买的章节数',
  `order_fee` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '费用',
  `pay_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '支付时间',
  `pay_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '支付方式0微信1支付宝',
  PRIMARY KEY (`bm_order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `bm_order` */

insert  into `bm_order`(`bm_order_id`,`order_type`,`uid`,`books_id`,`order_date`,`order_chapters`,`order_fee`,`pay_time`,`pay_type`) values (1,1,'20170425231430000',2,'2017-04-29 23:23:43',100,'1.20','2017-04-29 23:28:43',1);

/*Table structure for table `bm_role` */

CREATE TABLE `bm_role` (
  `bm_role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_code` varchar(30) NOT NULL DEFAULT '' COMMENT '角色编码',
  `role_name` varchar(50) NOT NULL DEFAULT '' COMMENT '角色名称',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '启用状态0启用1禁用',
  `uid` varchar(30) NOT NULL DEFAULT '' COMMENT 'uid',
  PRIMARY KEY (`bm_role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `bm_role` */

insert  into `bm_role`(`bm_role_id`,`role_code`,`role_name`,`created_time`,`status`,`uid`) values (1,'R001','super','2017-05-01 14:20:10',1,'20170425230453000'),(2,'R001','test','2017-04-29 23:28:51',0,'20170425230453000'),(3,'R001','test','2017-05-01 13:44:39',0,''),(4,'R002','test','0000-00-00 00:00:00',0,''),(5,'R002','test','0000-00-00 00:00:00',0,''),(6,'R002','test','0000-00-00 00:00:00',0,''),(7,'R002','test','0000-00-00 00:00:00',0,''),(8,'R002','test','0000-00-00 00:00:00',0,''),(9,'R002','test','0000-00-00 00:00:00',0,''),(10,'R002','test','2017-05-01 14:18:17',0,'');

/*Table structure for table `bm_user_account` */

CREATE TABLE `bm_user_account` (
  `bm_user_account_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL DEFAULT '' COMMENT 'uid',
  `remain` decimal(10,0) NOT NULL DEFAULT '0' COMMENT '余额',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '更新时间',
  PRIMARY KEY (`bm_user_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `bm_user_account` */

insert  into `bm_user_account`(`bm_user_account_id`,`uid`,`remain`,`created_time`,`updated_time`) values (1,'20170425231430000','888','2017-04-29 23:36:26','2017-04-29 23:36:26');

/*Table structure for table `book_shelf` */

CREATE TABLE `book_shelf` (
  `book_shelf_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `books_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '图书ID',
  `uid` varchar(30) NOT NULL DEFAULT '' COMMENT 'uid',
  `read_process` decimal(3,2) NOT NULL DEFAULT '0.00' COMMENT '阅读进度',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`book_shelf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `book_shelf` */

insert  into `book_shelf`(`book_shelf_id`,`books_id`,`uid`,`read_process`,`created_time`,`updated_time`) values (2,1,'20170425230453000','0.12','2017-04-30 00:08:31','2017-04-30 14:36:47'),(3,1,'20170425230453000','0.12','2017-04-30 00:08:31','2017-04-30 14:36:48'),(4,2,'20170425230453000','0.12','2017-04-30 00:10:18','2017-04-30 14:36:49'),(5,2,'20170425230453000','0.12','2017-04-30 00:10:18','2017-04-30 14:37:02'),(6,3,'20170425230453000','0.12','2017-04-30 00:11:17','2017-04-30 14:36:51'),(7,2,'20170425230453000','0.12','2017-04-30 00:11:17','2017-04-30 14:37:06');

/*Table structure for table `books` */

CREATE TABLE `books` (
  `books_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `book_name` varchar(50) NOT NULL DEFAULT '' COMMENT '书名',
  `author` varchar(50) NOT NULL DEFAULT '' COMMENT '作者',
  `category` tinyint(10) NOT NULL DEFAULT '0' COMMENT '分类，还没定好',
  `description` varchar(200) NOT NULL DEFAULT '' COMMENT '简介',
  `cost` decimal(20,0) NOT NULL DEFAULT '0' COMMENT '是否需付费，按章节',
  `file_path` varchar(100) NOT NULL DEFAULT '' COMMENT '文件路径',
  `img_path` varchar(100) NOT NULL DEFAULT '' COMMENT '缩略图路径',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `updated_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除',
  `hot_score` bigint(20) NOT NULL DEFAULT '0' COMMENT '热门指数',
  `free_chapters` bigint(20) NOT NULL DEFAULT '0' COMMENT '免费章节',
  `order_discount` decimal(2,0) NOT NULL DEFAULT '1' COMMENT '全本购买折扣',
  PRIMARY KEY (`books_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`books_id`,`book_name`,`author`,`category`,`description`,`cost`,`file_path`,`img_path`,`created_time`,`updated_time`,`is_delete`,`hot_score`,`free_chapters`,`order_discount`) values (1,'大话西游','chunzhi01.yang',2,'大话已有','0','第一章 这是i什么','2','2017-04-30 00:17:59','2017-04-30 00:20:13',0,8,1,'8'),(2,'大话西游','chunzhi',2,'大话已有','0','第一章 这是i什么','2','2017-04-30 16:18:59','2017-04-30 16:19:07',0,8,1,'8'),(3,'大话西游','chunzhi',2,'大话已有','0','第一章 这是i什么','2','2017-04-30 16:19:07','2017-04-30 16:19:07',0,8,1,'8'),(4,'大话西游1111','chunzhi',2,'大话已有','0','111.txt','111.jpg','2017-05-01 17:45:46','2017-05-01 17:45:46',0,8,1,'8'),(5,'大话西游1111','chunzhi',2,'大话已有','0','111.txt','111.jpg','2017-05-01 17:46:15','2017-05-01 17:46:15',0,8,1,'8'),(6,'有神1111','chunzhi',2,'大话已有','0','111.txt','111.jpg','2017-05-01 18:07:18','2017-05-01 18:07:18',0,8,1,'8'),(7,'有神1111','chunzhi',2,'大话已有','0','111.txt','111.jpg','2017-05-01 18:07:27','2017-05-01 18:07:27',0,8,1,'8');

/*Table structure for table `users` */

CREATE TABLE `users` (
  `users_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `uid` varchar(50) NOT NULL DEFAULT '' COMMENT '唯一标识',
  `user_name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `user_password` varchar(50) NOT NULL DEFAULT '' COMMENT '密码',
  `sex` tinyint(2) NOT NULL DEFAULT '0' COMMENT '性别0男1女',
  `birth` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '生日',
  `location` varchar(50) NOT NULL DEFAULT '' COMMENT '位置',
  `description` varchar(100) NOT NULL DEFAULT '' COMMENT '一句话描述',
  `created_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  `img_path` varchar(100) NOT NULL DEFAULT '' COMMENT '头像路径',
  PRIMARY KEY (`users_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`users_id`,`uid`,`user_name`,`user_password`,`sex`,`birth`,`location`,`description`,`created_time`,`img_path`) values (1,'20170425230453000','chunzhi1','E10ADC3949BA59ABBE56E057F20F883E',0,'1992-12-27 18:00:50','??','??','2017-04-25 23:04:53','0'),(2,'20170425231430000','chunzhi123','E10ADC3949BA59ABBE56E057F20F883E',0,'1992-12-27 18:00:50','??','??','2017-04-25 23:14:30','0'),(3,'20170425231904000','chonghui','E10ADC3949BA59ABBE56E057F20F883E',0,'1987-12-27 19:00:50','广州','暂无','2017-04-25 23:19:04','0'),(17,'20170430151249000','aaa','E10ADC3949BA59ABBE56E057F20F883E',0,'1987-12-27 19:00:50','','','2017-04-25 23:19:04','0'),(18,'20170430151353000','123','E10ADC3949BA59ABBE56E057F20F883E',0,'1987-12-27 19:00:50','','','2017-04-25 23:19:04','0'),(19,'20170430151505000','1231','E10ADC3949BA59ABBE56E057F20F883E',0,'1987-12-27 19:00:50','','','2017-04-25 23:19:04','0'),(20,'20170503212657000','cz','B187044C205E19BDA54B89D23FFDFE42',0,'1970-02-01 21:26:57','','','2017-05-03 21:26:57','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
