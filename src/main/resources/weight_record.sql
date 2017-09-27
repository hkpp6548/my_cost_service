/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : testone

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-09-26 00:13:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for weight_record
-- ----------------------------
DROP TABLE IF EXISTS `weight_record`;
CREATE TABLE `weight_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL COMMENT '日期',
  `runAgoWeight` double NOT NULL COMMENT '跑步前体重',
  `runAfterWeight` double DEFAULT NULL COMMENT '跑步后体重',
  `bathAfterWeight` double DEFAULT NULL COMMENT '洗澡后体重',
  `sleepAgoWeight` double DEFAULT NULL COMMENT '睡觉前体重',
  `isRun` int(11) NOT NULL COMMENT '有没有跑步 0：有 1：没有',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of weight_record
-- ----------------------------
INSERT INTO `weight_record` VALUES ('1', '2017-09-25 00:00:00', '150.2', '148.2', '0', '0', '0');
