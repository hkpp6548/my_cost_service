/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : testone

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2017-09-25 18:31:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `weight_record`
-- ----------------------------
DROP TABLE IF EXISTS `weight_record`;
CREATE TABLE `weight_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '日期',
  `run_ago_weight` double NOT NULL COMMENT '跑步前体重',
  `run_after_weight` double DEFAULT NULL COMMENT '跑步后体重',
  `bath_after_weight` double DEFAULT NULL COMMENT '洗澡后体重',
  `sleep_ago_weight` double DEFAULT NULL COMMENT '睡觉前体重',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of weight_record
-- ----------------------------
