

CREATE DATABASE IF NOT EXISTS `institute`;
USE `institute`;

CREATE USER root IDENTIFIED BY 'root'; 
grant usage on *.* to root@localhost identified by 'root'; 


DROP TABLE IF EXISTS `Admission`;

CREATE TABLE `Admission` (
  `Add_id` INTEGER, 
  `Date1` VARCHAR(255), 
  `stu_id` INTEGER, 
  `stu_name` VARCHAR(255), 
  `stu_add` VARCHAR(255), 
  `stu_gender` VARCHAR(255), 
  `stu_phno` INTEGER, 
  `co_id` VARCHAR(255), 
  `b_id` VARCHAR(255), 
  INDEX (`b_id`), 
  INDEX (`co_id`), 
  INDEX (`stu_id`)
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;



INSERT INTO `Admission` (`Add_id`, `Date1`, `stu_id`, `stu_name`, `stu_add`, `stu_gender`, `stu_phno`, `co_id`, `b_id`) VALUES (2, '3', 2, 'Archana', 'Pune', 'Female', 55555, '102', '101');
INSERT INTO `Admission` (`Add_id`, `Date1`, `stu_id`, `stu_name`, `stu_add`, `stu_gender`, `stu_phno`, `co_id`, `b_id`) VALUES (3, '5/6/2015', 3, 'VIjaya', 'Pune', 'Female', 14526307, '102', '101');
INSERT INTO `Admission` (`Add_id`, `Date1`, `stu_id`, `stu_name`, `stu_add`, `stu_gender`, `stu_phno`, `co_id`, `b_id`) VALUES (4, '2/2/2015', 4, 'Sachin', 'Pune', 'Male', 9854621, ' VB', ' 6/7/90');
# 3 records

#
# Table structure for table 'Batch'
#

DROP TABLE IF EXISTS `Batch`;

CREATE TABLE `Batch` (
  `b_id` INTEGER, 
  `co_name` VARCHAR(255), 
  `date1` VARCHAR(255), 
  `time` VARCHAR(255)
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Batch'
#

INSERT INTO `Batch` (`b_id`, `co_name`, `date1`, `time`) VALUES (201, ' Adv java', ' 1/2/15', ' 10 to 11 am');
# 1 records

#
# Table structure for table 'bill'
#

DROP TABLE IF EXISTS `bill`;

CREATE TABLE `bill` (
  `b_no` INTEGER, 
  `date1` VARCHAR(255), 
  `stu_id` INTEGER, 
  `Add_id` INTEGER, 
  `stu_name` VARCHAR(255), 
  `stu_add` VARCHAR(255), 
  `stu_gender` VARCHAR(255), 
  `stu_phno` INTEGER, 
  `co_id` VARCHAR(255), 
  `b_id` VARCHAR(255), 
  INDEX (`stu_id`), 
  INDEX (`Add_id`), 
  INDEX (`b_id`), 
  INDEX (`co_id`)
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'bill'
#

INSERT INTO `bill` (`b_no`, `date1`, `stu_id`, `Add_id`, `stu_name`, `stu_add`, `stu_gender`, `stu_phno`, `co_id`, `b_id`) VALUES (2, '2', 2, 2, 'Archana', 'Pune', 'Female', 55555, '102', '101');
# 1 records

#
# Table structure for table 'Course'
#

DROP TABLE IF EXISTS `Course`;

CREATE TABLE `Course` (
  `co_id` INTEGER, 
  `co_name` VARCHAR(255), 
  `co_duration` VARCHAR(255), 
  `co_fee` VARCHAR(255)
) ENGINE=innodb DEFAULT CHARSET=utf8;

INSERT INTO `Course` (`co_id`, `co_name`, `co_duration`, `co_fee`) VALUES (102, ' Java', ' 2 month', ' 5000');
INSERT INTO `Course` (`co_id`, `co_name`, `co_duration`, `co_fee`) VALUES (103, ' Adv java', ' 1000', ' 5896');
INSERT INTO `Course` (`co_id`, `co_name`, `co_duration`, `co_fee`) VALUES (104, ' VB', ' 2moth', ' 8956');
DROP TABLE IF EXISTS `Student`;

CREATE TABLE `Student` (
  `ID` INTEGER NOT NULL AUTO_INCREMENT, 
  PRIMARY KEY (`ID`)
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Student'
#

# 0 records

#
# Table structure for table 'Teacher'
#

DROP TABLE IF EXISTS `Teacher`;

CREATE TABLE `Teacher` (
  `t_id` INTEGER, 
  `t_name` VARCHAR(255), 
  `t_add` VARCHAR(255), 
  `t_phno` VARCHAR(255), 
  `t_gender` VARCHAR(255), 
  `co_id` VARCHAR(255), 
  `b_id` VARCHAR(255)
) ENGINE=innodb DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Teacher'
#

# 0 records

