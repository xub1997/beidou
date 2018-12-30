/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50516
Source Host           : localhost:3307
Source Database       : car

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2018-12-29 14:24:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_car
-- ----------------------------
DROP TABLE IF EXISTS `tb_car`;
CREATE TABLE `tb_car` (
  `carId` int(11) NOT NULL AUTO_INCREMENT COMMENT '车辆编号',
  `carNum` varchar(255) NOT NULL COMMENT '车牌号',
  `carDescription` varchar(255) DEFAULT NULL COMMENT '车辆描述',
  `carType` int(11) DEFAULT NULL COMMENT '类型（测试车辆1 普通车辆1   大型车辆2  ）',
  `brand` varchar(255) DEFAULT NULL COMMENT '品牌',
  `seat` int(11) DEFAULT NULL COMMENT '座位数',
  `status` int(11) DEFAULT NULL COMMENT '状态（0不可用  1可用）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `createTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(255) DEFAULT NULL COMMENT '更新时间',
  `bearWeight` double DEFAULT NULL COMMENT '承重',
  PRIMARY KEY (`carId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_cardriver
-- ----------------------------
DROP TABLE IF EXISTS `tb_cardriver`;
CREATE TABLE `tb_cardriver` (
  `id` int(11) DEFAULT NULL COMMENT '车辆-司机id',
  `carId` int(11) DEFAULT NULL COMMENT '车辆编号',
  `driverId` int(11) DEFAULT NULL COMMENT '司机编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_driver
-- ----------------------------
DROP TABLE IF EXISTS `tb_driver`;
CREATE TABLE `tb_driver` (
  `driverId` int(11) NOT NULL AUTO_INCREMENT COMMENT '司机编号',
  `driverName` varchar(20) DEFAULT NULL COMMENT '司机姓名',
  `sex` int(255) DEFAULT NULL COMMENT '性别(0女  1男)',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `birth` varchar(255) DEFAULT NULL COMMENT '生日',
  `cardId` int(11) DEFAULT NULL COMMENT '身份证类型',
  `licenseType` varchar(255) DEFAULT NULL COMMENT '驾驶证类型',
  `phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `createTime` varchar(255) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(255) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`driverId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
