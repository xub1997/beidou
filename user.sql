/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2018-12-15 00:11:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_company
-- ----------------------------
DROP TABLE IF EXISTS `tb_company`;
CREATE TABLE `tb_company` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '公司id',
  `name` varchar(255) NOT NULL COMMENT '公司名字',
  `description` varchar(255) NOT NULL COMMENT '公司描述',
  `address` varchar(255) NOT NULL COMMENT '公司地址',
  `phone` varchar(255) NOT NULL COMMENT '公司电话',
  `createDate` varchar(255) NOT NULL COMMENT '创建时间',
  `modifyDate` varchar(255) NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_dept
-- ----------------------------
DROP TABLE IF EXISTS `tb_dept`;
CREATE TABLE `tb_dept` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `name` varchar(255) NOT NULL COMMENT '部门名称',
  `createDate` varchar(255) NOT NULL COMMENT '创建时间',
  `description` varchar(255) NOT NULL COMMENT '部门描述',
  `modifyDate` varchar(255) NOT NULL COMMENT '修改日期',
  `comId` int(11) DEFAULT NULL COMMENT '公司id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(255) NOT NULL COMMENT '角色名',
  `description` varchar(255) NOT NULL COMMENT '角色描述',
  `createDate` varchar(255) NOT NULL COMMENT '创建时间',
  `modifyDate` varchar(255) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_role_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_rule`;
CREATE TABLE `tb_role_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色_权限id',
  `roleId` int(255) NOT NULL COMMENT '角色id',
  `ruleId` int(255) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_rule`;
CREATE TABLE `tb_rule` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `ruleName` varchar(255) NOT NULL COMMENT '权限名称',
  `description` varchar(255) NOT NULL COMMENT '权限描述',
  `type` varchar(255) DEFAULT NULL COMMENT '类型 0菜单 1按钮',
  `permissions` varchar(255) DEFAULT NULL COMMENT '权限',
  `url` varchar(255) NOT NULL COMMENT '对应url',
  `orderNum` int(11) DEFAULT NULL COMMENT '排序',
  `pid` int(11) NOT NULL COMMENT '上级菜单id',
  `createDate` varchar(255) NOT NULL COMMENT '创建时间',
  `modifyDate` varchar(255) NOT NULL COMMENT '修改日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `salt` varchar(255) DEFAULT NULL COMMENT '盐值（加密密码用）',
  `pwd` varchar(255) NOT NULL,
  `createDate` varchar(255) NOT NULL COMMENT '创建时间',
  `modifyDate` varchar(255) DEFAULT NULL COMMENT '修改时间',
  `avatarUrl` varchar(255) DEFAULT NULL COMMENT '头像',
  `status` int(255) DEFAULT NULL COMMENT '状态  0 不可用  1 可用',
  `name` varchar(255) DEFAULT NULL COMMENT '真实姓名',
  `phone` varchar(255) DEFAULT NULL COMMENT '手机',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` int(255) DEFAULT NULL COMMENT '性别 0男 1女',
  `address` varchar(255) DEFAULT NULL COMMENT '家庭住址',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `job` varchar(255) DEFAULT NULL COMMENT '职位',
  `deptId` int(11) DEFAULT NULL COMMENT '部门id',
  `comId` int(11) DEFAULT NULL COMMENT '公司id',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户_角色id',
  `userId` int(255) NOT NULL COMMENT '用户id',
  `roleId` int(255) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
