/*
Navicat MySQL Data Transfer

Source Server         : nonobank_v2_test_user
Source Server Version : 50619
Source Host           : 192.168.1.70:3306
Source Database       : nonobank_user

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-10-15 10:14:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for DICT_BANK
-- ----------------------------
DROP TABLE IF EXISTS `DICT_BANK`;
CREATE TABLE `DICT_BANK` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BANK_NAME` varchar(100) NOT NULL COMMENT '银行名称',
  `LOC_CODE` int(11) DEFAULT NULL COMMENT '所在地代码（见DICT_LOCATION）',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父ID（ID）',
  PRIMARY KEY (`ID`),
  KEY `IDX_BANK_L_CODE` (`LOC_CODE`),
  KEY `IDX_BANK_PID` (`PARENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for DICT_COLLEGE
-- ----------------------------
DROP TABLE IF EXISTS `DICT_COLLEGE`;
CREATE TABLE `DICT_COLLEGE` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CC_NAME` varchar(100) NOT NULL,
  `CC_PROVINCE` varchar(50) DEFAULT NULL COMMENT '学校所在省份（州）',
  `CC_SN` varchar(10) DEFAULT NULL COMMENT '序列号(暂时无用)',
  `CC_TYPE` tinyint(4) DEFAULT NULL COMMENT '学校类型（等级？）',
  `ENABLED` tinyint(1) DEFAULT '1' COMMENT '是否可用 {1|0}',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IDX_NAME_AND_PROVINCE` (`CC_NAME`,`CC_PROVINCE`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for DICT_COMMON
-- ----------------------------
DROP TABLE IF EXISTS `DICT_COMMON`;
CREATE TABLE `DICT_COMMON` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TYPE_KEY` varchar(50) NOT NULL COMMENT '字典数据分类关键字',
  `D_CODE` varchar(20) NOT NULL COMMENT '字典数据编号（编码），对于同一个TYPE_KEY是唯一的',
  `D_NAME` varchar(50) NOT NULL COMMENT '字典数据名称（通常是对应的中文名）',
  `I18N_KEY` varchar(100) DEFAULT NULL COMMENT '国际化资源key',
  `ORDER_NO` int(8) unsigned DEFAULT '1' COMMENT '基于 TYPE_KEY 的排序序号',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IDX_MD_TYPE_KEY_CODE` (`TYPE_KEY`,`D_CODE`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for DICT_LOCATION
-- ----------------------------
DROP TABLE IF EXISTS `DICT_LOCATION`;
CREATE TABLE `DICT_LOCATION` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TIER` tinyint(4) DEFAULT NULL COMMENT '层级',
  `L_CODE` int(11) DEFAULT NULL COMMENT '编码',
  `FULL_NAME` varchar(20) NOT NULL COMMENT '名称',
  `SHORT_NAME` varchar(20) DEFAULT NULL,
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '对应于ID',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `IDX_LOCAL_CODE` (`L_CODE`) USING BTREE,
  UNIQUE KEY `IDX_LOCAL_SN_PID` (`SHORT_NAME`,`PARENT_ID`) USING BTREE,
  KEY `IDX_LOCAL_FN` (`FULL_NAME`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;