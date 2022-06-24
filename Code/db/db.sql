/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - cloud_green_computing
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `cloud_green_computing`;

USE `cloud_green_computing`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `admin_id` char(100) NOT NULL,
  `admin_pwd` char(20) NOT NULL,
  `admin_ipaddress` varchar(50) default NULL,
  `admin_port` int(20) default NULL,
  PRIMARY KEY  (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`admin_id`,`admin_pwd`,`admin_ipaddress`,`admin_port`) values ('admin','admin','192.168.1.8',9000);

/*Table structure for table `m_application` */

DROP TABLE IF EXISTS `m_application`;

CREATE TABLE `m_application` (
  `a_no` int(10) NOT NULL auto_increment,
  `a_name` varchar(100) NOT NULL,
  `s_no` int(50) default NULL,
  `a_image` varchar(100) default NULL,
  `a_status` varchar(50) default NULL,
  PRIMARY KEY  (`a_no`),
  KEY `FK_m_application` (`s_no`),
  CONSTRAINT `m_application_ibfk_1` FOREIGN KEY (`s_no`) REFERENCES `m_server_configuration` (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_application` */

insert into `m_application` (`a_no`,`a_name`,`s_no`,`a_image`,`a_status`) values (1,'Numerology',1,'numerology1.png',NULL);
insert into `m_application` (`a_no`,`a_name`,`s_no`,`a_image`,`a_status`) values (5,'Encryption',5,'encryption.png',NULL);

/*Table structure for table `m_connections` */

DROP TABLE IF EXISTS `m_connections`;

CREATE TABLE `m_connections` (
  `con_no` int(5) NOT NULL auto_increment,
  `con_date` varchar(25) default NULL,
  `con_time_begin` varchar(25) default NULL,
  `con_time_end` varchar(25) default NULL,
  `con_ip` varchar(50) default NULL,
  `s_no` int(10) default NULL,
  `a_no` int(10) default NULL,
  `da_status` varchar(15) default NULL,
  PRIMARY KEY  (`con_no`),
  KEY `f1` (`s_no`),
  KEY `FK_m_connections` (`a_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_connections` */

/*Table structure for table `m_server_configuration` */

DROP TABLE IF EXISTS `m_server_configuration`;

CREATE TABLE `m_server_configuration` (
  `s_no` int(10) NOT NULL auto_increment,
  `s_name` varchar(30) NOT NULL,
  `s_url` varchar(100) default NULL,
  `s_current_connection` int(25) default NULL,
  `s_status` varchar(10) default NULL,
  `s_ipaddress` varchar(50) NOT NULL,
  `s_port` int(50) NOT NULL,
  PRIMARY KEY  (`s_no`,`s_ipaddress`,`s_port`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_server_configuration` */

insert into `m_server_configuration` (`s_no`,`s_name`,`s_url`,`s_current_connection`,`s_status`,`s_ipaddress`,`s_port`) values (1,'A','http://192.168.1.8:7070/',0,'Active','192.168.1.8',7001);
insert into `m_server_configuration` (`s_no`,`s_name`,`s_url`,`s_current_connection`,`s_status`,`s_ipaddress`,`s_port`) values (5,'B','http://192.168.1.19:9090/',0,'Active','192.168.1.19',7002);

/*Table structure for table `m_serverdetails` */

DROP TABLE IF EXISTS `m_serverdetails`;

CREATE TABLE `m_serverdetails` (
  `s_no` int(11) NOT NULL auto_increment,
  `ip_address` varchar(100) NOT NULL,
  `port_number` int(20) NOT NULL,
  `vendor` varchar(50) default NULL,
  `processor` varchar(50) default NULL,
  `mhz` int(50) default NULL,
  `number_of_cpu` int(10) default NULL,
  `cpu_usage` varchar(100) default NULL,
  `system_memory` varchar(50) default NULL,
  `used_memory` varchar(50) default NULL,
  `free_memory` varchar(50) default NULL,
  `no_access` int(50) default '0',
  `status` varchar(100) default NULL,
  `usage_percent` float default NULL,
  `server_status` varchar(100) default NULL,
  PRIMARY KEY  (`s_no`,`ip_address`,`port_number`),
  CONSTRAINT `m_serverdetails_ibfk_1` FOREIGN KEY (`s_no`) REFERENCES `m_server_configuration` (`s_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_serverdetails` */

insert into `m_serverdetails` (`s_no`,`ip_address`,`port_number`,`vendor`,`processor`,`mhz`,`number_of_cpu`,`cpu_usage`,`system_memory`,`used_memory`,`free_memory`,`no_access`,`status`,`usage_percent`,`server_status`) values (1,'192.168.1.8',7001,'Intel','Core(TM) i3-4150 CPU @ 3.50GHz',3491,4,'0.0%','3584228 KB','2296776 KB','1287452 KB',0,'cold_spot',3.204,'ON');
insert into `m_serverdetails` (`s_no`,`ip_address`,`port_number`,`vendor`,`processor`,`mhz`,`number_of_cpu`,`cpu_usage`,`system_memory`,`used_memory`,`free_memory`,`no_access`,`status`,`usage_percent`,`server_status`) values (5,'192.168.1.19',7002,'Intel','Core(TM) i3-4150 CPU @ 3.50GHz',3491,4,'0.0%','3588764 KB','2291332 KB','1297432 KB',0,'cold_spot',3.19237,'ON');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
