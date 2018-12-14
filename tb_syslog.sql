/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : syslog

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2018-12-15 00:11:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_syslog
-- ----------------------------
DROP TABLE IF EXISTS `tb_syslog`;
CREATE TABLE `tb_syslog` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作日志id',
  `username` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `ip` varchar(255) NOT NULL COMMENT '用户ip地址',
  `requestMethod` varchar(255) DEFAULT NULL COMMENT '请求方法',
  `url` varchar(255) NOT NULL COMMENT '请求url',
  `operation` varchar(255) NOT NULL COMMENT '操作描述',
  `method` varchar(255) NOT NULL COMMENT '运行方法',
  `params` varchar(255) NOT NULL COMMENT '参数',
  `time` bigint(20) NOT NULL COMMENT '耗时',
  `exception` text NOT NULL COMMENT '异常',
  `result` text NOT NULL COMMENT '操作结果',
  `createDate` varchar(255) NOT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
