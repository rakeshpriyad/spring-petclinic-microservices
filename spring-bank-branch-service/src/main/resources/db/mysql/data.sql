CREATE DATABASE `bnkmicroservice`

USE `bnkmicroservice`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account_no` varchar(255) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnnwpo0lfq4xai1rs6887sx02k` (`customer_id`),
  KEY `FKh7o4m3pr31s0ncab8k8j6y8jw` (`type_id`),
  CONSTRAINT `FKh7o4m3pr31s0ncab8k8j6y8jw` FOREIGN KEY (`type_id`) REFERENCES `types` (`id`),
  CONSTRAINT `FKnnwpo0lfq4xai1rs6887sx02k` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `account` */

insert  into `account`(`id`,`account_no`,`customer_id`,`type_id`) values
(1,'SYN00101',1,1),
(2,'SYN00101',2,1),
(3,'SYN00101',3,1),
(4,'SYN00104',4,2);

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `customer` */

insert  into `customer`(`id`,`address`,`city`,`first_name`,`last_name`,`telephone`) values
(1,'RajPuram','Ghaziabad','Rakesh','Kumar','9958145439'),
(2,'RajPuram','Ghaziabad','Rajesh','Kumar','9958145439'),
(3,'RajPuram','Ghaziabad','Mukesh','Kumar','9958145439'),
(4,'RajPuram','Ghaziabad','Rakesh','Kumar','9958145439');

/*Table structure for table `types` */

DROP TABLE IF EXISTS `types`;

CREATE TABLE `types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `types` */

insert  into `types`(`id`,`name`) values
(1,'SB'),
(2,'FD'),
(3,'LN'),
(4,'CR');

