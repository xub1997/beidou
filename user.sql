/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50516
Source Host           : localhost:3307
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2018-12-18 16:38:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 用户表
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('root', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:39:24', '无头像', 1, 'root', '13634676678', 21, 0, '广东广州', '21423432@qq.com', '总经理', 1, 1, '');
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('admin', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:32:05', '无头像', 1, 'admin', '13634478678', 22, 1, '魔都上海', '83684633@163.com', '董事长', 3, 2, '');
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('root1', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:39:24', '无头像', 1, 'root', '13634676678', 21, 0, '广东广州', '21423432@qq.com', '总经理', 1, 1, '');
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('admin1', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:32:05', '无头像', 1, 'admin', '13634478678', 22, 1, '魔都上海', '83684633@163.com', '董事长', 4, 2, '');
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('root2', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:39:24', '无头像', 1, 'root', '13634676678', 21, 0, '广东广州', '21423432@qq.com', '总经理', 2, 1, '');
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('admin2', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:32:05', '无头像', 1, 'admin', '13634478678', 22, 1, '魔都上海', '83684633@163.com', '董事长', 4, 2, '');
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('root3', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:39:24', '无头像', 1, 'root', '13634676678', 21, 0, '广东广州', '21423432@qq.com', '总经理', 2, 1, '');
INSERT INTO `tb_user` (`username`, `salt`, `pwd`, `createDate`, `modifyDate`, `avatarUrl`, `status`, `name`, `phone`, `age`, `sex`, `address`, `email`, `job`, `deptId`, `comId`, `remark`) VALUES ('admin3', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:32:05', '无头像', 1, 'admin', '13634478678', 22, 1, '魔都上海', '83684633@163.com', '董事长', 3, 2, '');
-- ----------------------------
-- 角色表
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `roleName` varchar(255) NOT NULL COMMENT '角色名',
  `description` varchar(255) NOT NULL COMMENT '角色描述',
  `createDate` varchar(255) NOT NULL COMMENT '创建时间',
  `modifyDate` varchar(255) NOT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `tb_role` (`roleName`, `description`, `createDate`, `modifyDate`) VALUES ('root', '超级管理员', '2018-12-12 16:00:10', '2018-12-12 16:00:10');
INSERT INTO `tb_role` (`roleName`, `description`, `createDate`, `modifyDate`) VALUES ('admin', '管理员', '2018-12-12 16:00:13', '2018-12-12 16:00:13');
INSERT INTO `tb_role` (`roleName`, `description`, `createDate`, `modifyDate`) VALUES ('user', '普通用户', '2018-12-12 16:00:15', '2018-12-12 16:00:15');
-- ----------------------------
-- 用户角色表
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户_角色id',
  `userId` int(255) NOT NULL COMMENT '用户id',
  `roleId` int(255) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (1, 1);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (1, 2);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (1, 3);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (2, 2);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (2, 3);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (3, 2);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (4, 2);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (4, 3);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (5, 1);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (6, 2);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (7, 3);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (8, 2);
INSERT INTO `tb_user_role` (`userId`, `roleId`) VALUES (8, 3);
-- ----------------------------
-- 角色-权限表
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_rule`;
CREATE TABLE `tb_role_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色_权限id',
  `roleId` int(255) NOT NULL COMMENT '角色id',
  `ruleId` int(255) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 1);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 2);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 3);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 4);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 5);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 6);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 7);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 8);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 9);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 10);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 11);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 12);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 13);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 14);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 15);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 16);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 17);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 18);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 19);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 20);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 21);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 22);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 23);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 24);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 25);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 26);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 27);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 28);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 29);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 30);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 31);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 32);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 33);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 34);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 35);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 36);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 37);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 38);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 39);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 40);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 41);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 42);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 43);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 44);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 45);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 46);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 47);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 48);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 49);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 50);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 51);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 52);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 53);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (1, 54);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 1);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 2);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 3);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 4);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 5);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 6);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 7);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 8);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 9);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 10);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 11);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 12);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 13);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 14);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 15);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 16);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 17);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 18);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 19);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 20);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 21);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 22);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 23);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 24);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 25);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 26);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 27);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 28);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 29);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 30);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 31);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 32);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 33);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 34);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 35);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 36);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 37);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 38);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 39);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 40);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 41);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (2, 42);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 1);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 2);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 3);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 4);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 5);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 6);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 7);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 8);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 9);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 10);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 11);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 12);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 13);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 14);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 15);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 16);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 17);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 18);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 19);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 20);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 21);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 22);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 23);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 24);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 25);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 26);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 27);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 28);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 29);
INSERT INTO `tb_role_rule` (`roleId`, `ruleId`) VALUES (3, 30);

-- ----------------------------
-- 权限表
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('系统设置', '系统设置', 'menu', 'system:setting', 'javascript:;', 0, 0, '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('报表导出', '报表导出', 'menu', 'excelExports', 'excelExports.html', 0, 1, '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('用户管理接口文档', '用户管理接口文档', 'menu', 'user:swagger', 'swagger-ui.html', 0, 1, '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('数据库监控', '数据库监控', 'menu', 'user:druid', 'druid', 0, 1, '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('用户设置', '用户设置', 'menu', 'user:manage', 'javascript:;', 0, 0, '2018-12-12 13:39:45', '2018-12-12 13:39:45');
-- ----------------------------
-- 用户设置   5  10
-- ----------------------------
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('用户管理', '用户管理', 'menu', 'user:manage', 'user/userSetting.html', 0, 5, '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('角色管理', '角色管理', 'menu', 'role:manage', 'user/characterSetting.html', 0, 5, '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('权限管理', '权限管理', 'menu', 'rule:manage', 'user/rightSetting.html', 0, 5, '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('公司管理', '公司管理', 'menu', 'company:manage', 'user/companySetting.html', 0, 5, '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('部门管理', '部门管理', 'menu', 'dept:manage', 'user/departmentSetting.html', 0, 5, '2018：12：15', '2018：12：15');
-- ----------------------------
-- 用户管理  6   20
-- ----------------------------
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('用户添加', '用户添加', 'button', 'user:create', 'api/v1/user/user', 0, 6, '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取id对应的用户信息', '获取id对应的用户信息', 'button', 'user:read', 'api/v1/user/user', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('更新用户信息', '更新用户信息', 'button', 'user:update', 'api/v1/user/user', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('删除用户', '删除用户信息', 'button', 'user:delete ', 'api/v1/user/user', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取用户列表', '获取用户列表', 'button', 'users:read', 'api/v1/user/users', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取用户信息列表(对应公司)', '获取用户信息列表(对应公司)', 'button', 'userCom:read', 'api/v1/user/userCom', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('查找用户', '查找用户', 'button', 'user:searchUser', 'api/v1/user/user/searchByUsername', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('查找公司用户', '查找公司用户', 'button', 'user:searchComUser', 'api/v1/user/user/searchByUserNameAndComId', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('判断用户名重复', '判断用户名重复', 'button', 'user:judgeUsername', 'api/v1/user/user/judgeUsername', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('修改密码', '修改密码', 'button', 'user:modifyPwd', 'api/v1/user/user/modifyPwd', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');

-- ----------------------------
-- 角色管理  7   27
-- ----------------------------

INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('角色添加', '角色添加', 'button', 'role:create', 'api/v1/user/role', 0, 7, '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取id对应的角色信息', '获取id对应的角色信息', 'button', 'role:read', 'api/v1/user/role', 0, 7, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('更新角色信息', '更新角色信息', 'button', 'role:update', 'api/v1/user/role', 0, 7, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('删除角色', '删除角色信息', 'button', 'role:delete ', 'api/v1/user/role', 0, 7, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取角色列表', '获取角色列表', 'button', 'roles:read', 'api/v1/user/roles', 0, 7, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('查找角色', '查找角色', 'button', 'role:searchByName', 'api/v1/user/user/searchByName', 0, 7, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取用户对应角色', '获取用户对应角色', 'button', 'role:userRole', 'api/v1/user/userRole', 0, 6, '2018-12-12 16:17:48', '2018-12-12 16:17:48');

-- ----------------------------
-- 权限管理  8   34
-- ----------------------------

INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('权限添加', '权限添加', 'button', 'rule:create', 'api/v1/user/rule', 0, 8, '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取id对应的权限信息', '获取id对应的权限信息', 'button', 'rule:read', 'api/v1/user/rule', 0, 8, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('更新权限信息', '更新权限信息', 'button', 'rule:update', 'api/v1/user/rule', 0, 8, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('删除权限', '删除权限信息', 'button', 'rule:delete ', 'api/v1/user/rule', 0, 8, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取权限列表', '获取权限列表', 'button', 'rules:read', 'api/v1/user/rules', 0, 8, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('查找权限', '查找权限', 'button', 'rule:searchByName', 'api/v1/user/role/searchByName', 0, 8, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取角色对应权限', '获取角色对应权限', 'button', 'roleRule:read', 'api/v1/user/roleRule', 0, 8, '2018-12-12 13:39:24', '2018-12-12 13:39:24');


-- ----------------------------
-- 公司管理  9   41
-- ----------------------------


INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('公司添加', '公司添加', 'button', 'company:create', 'api/v1/user/company', 0, 9, '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取id对应的公司信息', '获取id对应的公司信息', 'button', 'company:read', 'api/v1/user/rule', 0, 9, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('更新公司信息', '更新公司信息', 'button', 'company:update', 'api/v1/user/company', 0, 9, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('删除公司', '删除公司信息', 'button', 'company:delete ', 'api/v1/user/company', 0, 9, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取权限列表', '获取公司列表', 'button', 'companys:read', 'api/v1/user/companys', 0, 9, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('查找公司', '查找公司', 'button', 'company:searchByName', 'api/v1/user/company/searchByName', 0, 9, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取公司信息', '获取公司信息', 'button', 'company:readAll', 'api/v1/user/company', 0, 9, '2018-12-12 13:39:24', '2018-12-12 13:39:24');

-- ----------------------------
-- 部门管理  10   51
-- ----------------------------

INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('部门添加', '部门添加', 'button', 'dept:create', 'api/v1/user/dept', 0, 10, '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取id对应的部门信息', '获取id对应的部门信息', 'button', 'dept:read', 'api/v1/user/dept', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('更新部门信息', '更新部门信息', 'button', 'dept:update', 'api/v1/user/dept', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('删除部门', '删除部门信息', 'button', 'dept:delete ', 'api/v1/user/dept', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取公司部门', '获取公司部门', 'button', 'comDept:read', 'api/v1/user/comDept', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取部门信息', '获取部门信息', 'button', 'dept:readAll', 'api/v1/user/dept', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取部门信息列表', '获取部门信息列表', 'button', 'depts:read', 'api/v1/user/depts', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('获取部门列表（对应公司）', '获取部门列表（对应公司）', 'button', 'comDepts:read', 'api/v1/user/comDepts', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('查找部门', '查找部门', 'button', 'dept:searchByName', 'api/v1/user/dept/searchByName', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('查找公司部门', '查找公司部门', 'button', 'dept:searchByNameAndComId', 'api/v1/user/dept/searchByNameAndComId', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');

-- ----------------------------
-- 用户-角色管理  6   53
-- ----------------------------
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('添加用户-角色管理信息', '添加用户-角色管理信息', 'button', 'userRole:create', 'api/v1/user/userRole', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('更新id对应的用户-角色管理信息', '更新id对应的用户-角色管理信息', 'button', 'userRole:update', 'api/v1/user/userRole', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');


-- ----------------------------
-- 角色-权限管理  7   55
-- ----------------------------
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('添加角色-权限管理信息', '添加角色-权限管理信息', 'button', 'roleRule:create', 'api/v1/user/roleRule', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` (`ruleName`, `description`, `type`, `permissions`, `url`, `orderNum`, `pid`, `createDate`, `modifyDate`) VALUES ('更新id对应的角色-权限管理信息', '更新id对应的角色-权限管理信息', 'button', 'roleRule:create', 'api/v1/user/roleRule', 0, 10, '2018-12-12 16:17:48', '2018-12-12 16:17:48');


-- ----------------------------
-- 公司表
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `tb_company` (`name`, `description`, `address`, `phone`, `createDate`, `modifyDate`) VALUES ('公司1', '公司1', '广东广州', '020', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_company` (`name`, `description`, `address`, `phone`, `createDate`, `modifyDate`) VALUES ('公司2', '公司2', '魔都上海', '010', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
-- ----------------------------
-- 部门表
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
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO `tb_dept` (`name`, `createDate`, `description`, `modifyDate`, `comId`) VALUES ('部门1', '2018-12-12 14:41:35', '部门1', '2018-12-12 14:41:35', 1);
INSERT INTO `tb_dept` (`name`, `createDate`, `description`, `modifyDate`, `comId`) VALUES ('部门2', '2018-12-12 14:41:35', '部门2', '2018-12-12 14:41:35', 1);
INSERT INTO `tb_dept` (`name`, `createDate`, `description`, `modifyDate`, `comId`) VALUES ('部门3', '2018-12-12 14:41:35', '部门3', '2018-12-12 14:41:35', 2);
INSERT INTO `tb_dept` (`name`, `createDate`, `description`, `modifyDate`, `comId`) VALUES ('部门4', '2018-12-12 14:41:35', '部门4', '2018-12-12 14:41:35', 2);