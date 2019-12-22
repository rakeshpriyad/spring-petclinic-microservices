CREATE DATABASE /*!32312 IF NOT EXISTS*/`bnkmicroservice` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `bnkmicroservice`;

/*Table structure for table `address` */

DROP TABLE IF EXISTS `address`;

CREATE TABLE `address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `zip_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `address` */

insert  into `address`(`id`,`address`,`city`,`country`,`state`,`zip_code`) values (1,'F8','DELHI','India','Delhi','201009');

/*Table structure for table `branch` */

DROP TABLE IF EXISTS `branch`;

CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `branch` */

insert  into `branch`(`id`,`name`) values (1,'Mayur Vihar PhaseII');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` varchar(255) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `emp_no` varchar(255) DEFAULT NULL,
  `address_id` int(11) DEFAULT NULL,
  `branch_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK73hppq93wk1sa6yfmw6fu1eiy` (`address_id`),
  KEY `FKar1e5kfuih8ha6fc322eb24by` (`branch_id`),
  CONSTRAINT `FKar1e5kfuih8ha6fc322eb24by` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`id`),
  CONSTRAINT `FK73hppq93wk1sa6yfmw6fu1eiy` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `emp` */

insert  into `emp`(`id`,`age`,`dob`,`emp_name`,`emp_no`,`address_id`,`branch_id`) values (1,'34','2019-12-22','Rakesh Kumar','E001',1,1),(2,'34','2019-12-22','Rajesh Kumar','E02',1,1),(8,'34','2019-12-22','Rajesh Kumar','E02',1,1);

