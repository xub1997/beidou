/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50516
Source Host           : localhost:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50516
File Encoding         : 65001

Date: 2018-12-21 17:06:58
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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_company
-- ----------------------------
INSERT INTO `tb_company` VALUES ('1', '百度自动驾驶广州黄埔分公司', '百度自动驾驶广州黄埔分公司', '广东广州', '020088888888', '2018-12-12 16:17:48', '2018-12-21 15:53:53');
INSERT INTO `tb_company` VALUES ('2', '广东滴滴公司', '广东滴滴公司', '魔都上海', '01066666666', '2018-12-12 16:17:48', '2018-12-21 15:52:10');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_dept
-- ----------------------------
INSERT INTO `tb_dept` VALUES ('1', '研发部门', '2018-12-12 14:41:35', '开发软件、硬件。', '2018-12-21 15:51:09', '1');
INSERT INTO `tb_dept` VALUES ('2', '后勤部门', '2018-12-12 14:41:35', '后勤部门', '2018-12-21 15:53:24', '1');
INSERT INTO `tb_dept` VALUES ('3', '人事部门', '2018-12-12 14:41:35', '人事部门', '2018-12-21 15:54:18', '2');
INSERT INTO `tb_dept` VALUES ('4', '技术支持部门', '2018-12-12 14:41:35', '技术支持部门', '2018-12-21 15:54:50', '2');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', '超级管理员', '超级管理员', '2018-12-12 16:00:10', '2018-12-21 15:55:03');
INSERT INTO `tb_role` VALUES ('2', '管理员', '管理员', '2018-12-12 16:00:13', '2018-12-21 15:55:08');
INSERT INTO `tb_role` VALUES ('3', '普通用户', '普通用户', '2018-12-12 16:00:15', '2018-12-21 15:55:13');

-- ----------------------------
-- Table structure for tb_role_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_rule`;
CREATE TABLE `tb_role_rule` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色_权限id',
  `roleId` int(255) NOT NULL COMMENT '角色id',
  `ruleId` int(255) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_role_rule
-- ----------------------------
INSERT INTO `tb_role_rule` VALUES ('1', '1', '1');
INSERT INTO `tb_role_rule` VALUES ('2', '1', '2');
INSERT INTO `tb_role_rule` VALUES ('3', '1', '3');
INSERT INTO `tb_role_rule` VALUES ('4', '1', '4');
INSERT INTO `tb_role_rule` VALUES ('5', '1', '5');
INSERT INTO `tb_role_rule` VALUES ('6', '1', '6');
INSERT INTO `tb_role_rule` VALUES ('7', '1', '7');
INSERT INTO `tb_role_rule` VALUES ('8', '1', '8');
INSERT INTO `tb_role_rule` VALUES ('9', '1', '9');
INSERT INTO `tb_role_rule` VALUES ('10', '1', '10');
INSERT INTO `tb_role_rule` VALUES ('11', '1', '11');
INSERT INTO `tb_role_rule` VALUES ('12', '1', '12');
INSERT INTO `tb_role_rule` VALUES ('13', '1', '13');
INSERT INTO `tb_role_rule` VALUES ('14', '1', '14');
INSERT INTO `tb_role_rule` VALUES ('15', '1', '15');
INSERT INTO `tb_role_rule` VALUES ('16', '1', '16');
INSERT INTO `tb_role_rule` VALUES ('17', '1', '17');
INSERT INTO `tb_role_rule` VALUES ('18', '1', '18');
INSERT INTO `tb_role_rule` VALUES ('19', '1', '19');
INSERT INTO `tb_role_rule` VALUES ('20', '1', '20');
INSERT INTO `tb_role_rule` VALUES ('21', '1', '21');
INSERT INTO `tb_role_rule` VALUES ('22', '1', '22');
INSERT INTO `tb_role_rule` VALUES ('23', '1', '23');
INSERT INTO `tb_role_rule` VALUES ('24', '1', '24');
INSERT INTO `tb_role_rule` VALUES ('25', '1', '25');
INSERT INTO `tb_role_rule` VALUES ('26', '1', '26');
INSERT INTO `tb_role_rule` VALUES ('27', '1', '27');
INSERT INTO `tb_role_rule` VALUES ('28', '1', '28');
INSERT INTO `tb_role_rule` VALUES ('29', '1', '29');
INSERT INTO `tb_role_rule` VALUES ('30', '1', '30');
INSERT INTO `tb_role_rule` VALUES ('31', '1', '31');
INSERT INTO `tb_role_rule` VALUES ('32', '1', '32');
INSERT INTO `tb_role_rule` VALUES ('33', '1', '33');
INSERT INTO `tb_role_rule` VALUES ('34', '1', '34');
INSERT INTO `tb_role_rule` VALUES ('35', '1', '35');
INSERT INTO `tb_role_rule` VALUES ('36', '1', '36');
INSERT INTO `tb_role_rule` VALUES ('37', '1', '37');
INSERT INTO `tb_role_rule` VALUES ('38', '1', '38');
INSERT INTO `tb_role_rule` VALUES ('39', '1', '39');
INSERT INTO `tb_role_rule` VALUES ('40', '1', '40');
INSERT INTO `tb_role_rule` VALUES ('41', '1', '41');
INSERT INTO `tb_role_rule` VALUES ('42', '1', '42');
INSERT INTO `tb_role_rule` VALUES ('43', '1', '43');
INSERT INTO `tb_role_rule` VALUES ('44', '1', '44');
INSERT INTO `tb_role_rule` VALUES ('45', '1', '45');
INSERT INTO `tb_role_rule` VALUES ('46', '1', '46');
INSERT INTO `tb_role_rule` VALUES ('47', '1', '47');
INSERT INTO `tb_role_rule` VALUES ('48', '1', '48');
INSERT INTO `tb_role_rule` VALUES ('49', '1', '49');
INSERT INTO `tb_role_rule` VALUES ('50', '1', '50');
INSERT INTO `tb_role_rule` VALUES ('51', '1', '51');
INSERT INTO `tb_role_rule` VALUES ('52', '1', '52');
INSERT INTO `tb_role_rule` VALUES ('53', '1', '53');
INSERT INTO `tb_role_rule` VALUES ('54', '1', '54');
INSERT INTO `tb_role_rule` VALUES ('55', '2', '1');
INSERT INTO `tb_role_rule` VALUES ('56', '2', '2');
INSERT INTO `tb_role_rule` VALUES ('57', '2', '3');
INSERT INTO `tb_role_rule` VALUES ('58', '2', '4');
INSERT INTO `tb_role_rule` VALUES ('59', '2', '5');
INSERT INTO `tb_role_rule` VALUES ('60', '2', '6');
INSERT INTO `tb_role_rule` VALUES ('61', '2', '7');
INSERT INTO `tb_role_rule` VALUES ('62', '2', '8');
INSERT INTO `tb_role_rule` VALUES ('63', '2', '9');
INSERT INTO `tb_role_rule` VALUES ('64', '2', '10');
INSERT INTO `tb_role_rule` VALUES ('65', '2', '11');
INSERT INTO `tb_role_rule` VALUES ('66', '2', '12');
INSERT INTO `tb_role_rule` VALUES ('67', '2', '13');
INSERT INTO `tb_role_rule` VALUES ('68', '2', '14');
INSERT INTO `tb_role_rule` VALUES ('69', '2', '15');
INSERT INTO `tb_role_rule` VALUES ('70', '2', '16');
INSERT INTO `tb_role_rule` VALUES ('71', '2', '17');
INSERT INTO `tb_role_rule` VALUES ('72', '2', '18');
INSERT INTO `tb_role_rule` VALUES ('73', '2', '19');
INSERT INTO `tb_role_rule` VALUES ('74', '2', '20');
INSERT INTO `tb_role_rule` VALUES ('75', '2', '21');
INSERT INTO `tb_role_rule` VALUES ('76', '2', '22');
INSERT INTO `tb_role_rule` VALUES ('77', '2', '23');
INSERT INTO `tb_role_rule` VALUES ('78', '2', '24');
INSERT INTO `tb_role_rule` VALUES ('79', '2', '25');
INSERT INTO `tb_role_rule` VALUES ('80', '2', '26');
INSERT INTO `tb_role_rule` VALUES ('81', '2', '27');
INSERT INTO `tb_role_rule` VALUES ('82', '2', '28');
INSERT INTO `tb_role_rule` VALUES ('83', '2', '29');
INSERT INTO `tb_role_rule` VALUES ('84', '2', '30');
INSERT INTO `tb_role_rule` VALUES ('85', '2', '31');
INSERT INTO `tb_role_rule` VALUES ('86', '2', '32');
INSERT INTO `tb_role_rule` VALUES ('87', '2', '33');
INSERT INTO `tb_role_rule` VALUES ('88', '2', '34');
INSERT INTO `tb_role_rule` VALUES ('89', '2', '35');
INSERT INTO `tb_role_rule` VALUES ('90', '2', '36');
INSERT INTO `tb_role_rule` VALUES ('91', '2', '37');
INSERT INTO `tb_role_rule` VALUES ('92', '2', '38');
INSERT INTO `tb_role_rule` VALUES ('93', '2', '39');
INSERT INTO `tb_role_rule` VALUES ('94', '2', '40');
INSERT INTO `tb_role_rule` VALUES ('95', '2', '41');
INSERT INTO `tb_role_rule` VALUES ('96', '2', '42');
INSERT INTO `tb_role_rule` VALUES ('97', '3', '1');
INSERT INTO `tb_role_rule` VALUES ('98', '3', '2');
INSERT INTO `tb_role_rule` VALUES ('99', '3', '3');
INSERT INTO `tb_role_rule` VALUES ('100', '3', '4');
INSERT INTO `tb_role_rule` VALUES ('101', '3', '5');
INSERT INTO `tb_role_rule` VALUES ('102', '3', '6');
INSERT INTO `tb_role_rule` VALUES ('103', '3', '7');
INSERT INTO `tb_role_rule` VALUES ('104', '3', '8');
INSERT INTO `tb_role_rule` VALUES ('105', '3', '9');
INSERT INTO `tb_role_rule` VALUES ('106', '3', '10');
INSERT INTO `tb_role_rule` VALUES ('107', '3', '11');
INSERT INTO `tb_role_rule` VALUES ('108', '3', '12');
INSERT INTO `tb_role_rule` VALUES ('109', '3', '13');
INSERT INTO `tb_role_rule` VALUES ('110', '3', '14');
INSERT INTO `tb_role_rule` VALUES ('111', '3', '15');
INSERT INTO `tb_role_rule` VALUES ('112', '3', '16');
INSERT INTO `tb_role_rule` VALUES ('113', '3', '17');
INSERT INTO `tb_role_rule` VALUES ('114', '3', '18');
INSERT INTO `tb_role_rule` VALUES ('115', '3', '19');
INSERT INTO `tb_role_rule` VALUES ('116', '3', '20');
INSERT INTO `tb_role_rule` VALUES ('117', '3', '21');
INSERT INTO `tb_role_rule` VALUES ('118', '3', '22');
INSERT INTO `tb_role_rule` VALUES ('119', '3', '23');
INSERT INTO `tb_role_rule` VALUES ('120', '3', '24');
INSERT INTO `tb_role_rule` VALUES ('121', '3', '25');
INSERT INTO `tb_role_rule` VALUES ('122', '3', '26');
INSERT INTO `tb_role_rule` VALUES ('123', '3', '27');
INSERT INTO `tb_role_rule` VALUES ('124', '3', '28');
INSERT INTO `tb_role_rule` VALUES ('125', '3', '29');
INSERT INTO `tb_role_rule` VALUES ('126', '3', '30');
INSERT INTO `tb_role_rule` VALUES ('127', '1', '55');
INSERT INTO `tb_role_rule` VALUES ('128', '1', '56');
INSERT INTO `tb_role_rule` VALUES ('129', '1', '57');
INSERT INTO `tb_role_rule` VALUES ('130', '1', '58');
INSERT INTO `tb_role_rule` VALUES ('131', '1', '59');
INSERT INTO `tb_role_rule` VALUES ('132', '1', '60');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_rule
-- ----------------------------
INSERT INTO `tb_rule` VALUES ('1', '系统设置', '系统设置', 'menu', 'system:setting', 'javascript:;', '0', '0', '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` VALUES ('2', '报表导出', '报表导出', 'menu', 'excelExports', 'excelExports.html', '0', '0', '2018-12-12 13:39:45', '2018-12-21 10:55:33');
INSERT INTO `tb_rule` VALUES ('3', '用户管理接口文档', '用户管理接口文档', 'menu', 'user:swagger', 'swagger-ui.html', '0', '1', '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` VALUES ('4', '数据库监控', '数据库监控', 'menu', 'user:druid', 'druid', '0', '1', '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` VALUES ('5', '用户设置', '用户设置', 'menu', 'user:manage', 'javascript:;', '0', '0', '2018-12-12 13:39:45', '2018-12-12 13:39:45');
INSERT INTO `tb_rule` VALUES ('6', '用户管理', '用户管理', 'menu', 'user:manage', 'user/userSetting.html', '0', '5', '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` VALUES ('7', '角色管理', '角色管理', 'menu', 'role:manage', 'user/characterSetting.html', '0', '5', '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` VALUES ('8', '权限管理', '权限管理', 'menu', 'rule:manage', 'user/rightSetting.html', '0', '5', '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` VALUES ('9', '公司管理', '公司管理', 'menu', 'company:manage', 'user/companySetting.html', '0', '5', '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` VALUES ('10', '部门管理', '部门管理', 'menu', 'dept:manage', 'user/departmentSetting.html', '0', '5', '2018：12：15', '2018：12：15');
INSERT INTO `tb_rule` VALUES ('11', '用户添加', '用户添加', 'button', 'user:create', 'api/v1/user/user', '0', '6', '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` VALUES ('12', '获取id对应的用户信息', '获取id对应的用户信息', 'button', 'user:read', 'api/v1/user/user', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('13', '更新用户信息', '更新用户信息', 'button', 'user:update', 'api/v1/user/user', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('14', '删除用户', '删除用户信息', 'button', 'user:delete ', 'api/v1/user/user', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('15', '获取用户列表', '获取用户列表', 'button', 'users:read', 'api/v1/user/users', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('16', '获取用户信息列表(对应公司)', '获取用户信息列表(对应公司)', 'button', 'userCom:read', 'api/v1/user/userCom', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('17', '查找用户', '查找用户', 'button', 'user:searchUser', 'api/v1/user/user/searchByUsername', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('18', '查找公司用户', '查找公司用户', 'button', 'user:searchComUser', 'api/v1/user/user/searchByUserNameAndComId', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('19', '判断用户名重复', '判断用户名重复', 'button', 'user:judgeUsername', 'api/v1/user/user/judgeUsername', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('20', '修改密码', '修改密码', 'button', 'user:modifyPwd', 'api/v1/user/user/modifyPwd', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('21', '角色添加', '角色添加', 'button', 'role:create', 'api/v1/user/role', '0', '7', '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` VALUES ('22', '获取id对应的角色信息', '获取id对应的角色信息', 'button', 'role:read', 'api/v1/user/role', '0', '7', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('23', '更新角色信息', '更新角色信息', 'button', 'role:update', 'api/v1/user/role', '0', '7', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('24', '删除角色', '删除角色信息', 'button', 'role:delete ', 'api/v1/user/role', '0', '7', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('25', '获取角色列表', '获取角色列表', 'button', 'roles:read', 'api/v1/user/roles', '0', '7', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('26', '查找角色', '查找角色', 'button', 'role:searchByName', 'api/v1/user/user/searchByName', '0', '7', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('27', '获取用户对应角色', '获取用户对应角色', 'button', 'role:userRole', 'api/v1/user/userRole', '0', '6', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('28', '权限添加', '权限添加', 'button', 'rule:create', 'api/v1/user/rule', '0', '8', '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` VALUES ('29', '获取id对应的权限信息', '获取id对应的权限信息', 'button', 'rule:read', 'api/v1/user/rule', '0', '8', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('30', '更新权限信息', '更新权限信息', 'button', 'rule:update', 'api/v1/user/rule', '0', '8', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('31', '删除权限', '删除权限信息', 'button', 'rule:delete ', 'api/v1/user/rule', '0', '8', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('32', '获取权限列表', '获取权限列表', 'button', 'rules:read', 'api/v1/user/rules', '0', '8', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('33', '查找权限', '查找权限', 'button', 'rule:searchByName', 'api/v1/user/role/searchByName', '0', '8', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('34', '获取角色对应权限', '获取角色对应权限', 'button', 'roleRule:read', 'api/v1/user/roleRule', '0', '8', '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` VALUES ('35', '公司添加', '公司添加', 'button', 'company:create', 'api/v1/user/company', '0', '9', '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` VALUES ('36', '获取id对应的公司信息', '获取id对应的公司信息', 'button', 'company:read', 'api/v1/user/rule', '0', '9', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('37', '更新公司信息', '更新公司信息', 'button', 'company:update', 'api/v1/user/company', '0', '9', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('38', '删除公司', '删除公司信息', 'button', 'company:delete ', 'api/v1/user/company', '0', '9', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('39', '获取权限列表', '获取公司列表', 'button', 'companys:read', 'api/v1/user/companys', '0', '9', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('40', '查找公司', '查找公司', 'button', 'company:searchByName', 'api/v1/user/company/searchByName', '0', '9', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('41', '获取公司信息', '获取公司信息', 'button', 'company:readAll', 'api/v1/user/company', '0', '9', '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` VALUES ('42', '部门添加', '部门添加', 'button', 'dept:create', 'api/v1/user/dept', '0', '10', '2018-12-12 13:39:24', '2018-12-12 13:39:24');
INSERT INTO `tb_rule` VALUES ('43', '获取id对应的部门信息', '获取id对应的部门信息', 'button', 'dept:read', 'api/v1/user/dept', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('44', '更新部门信息', '更新部门信息', 'button', 'dept:update', 'api/v1/user/dept', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('45', '删除部门', '删除部门信息', 'button', 'dept:delete ', 'api/v1/user/dept', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('46', '获取公司部门', '获取公司部门', 'button', 'comDept:read', 'api/v1/user/comDept', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('47', '获取部门信息', '获取部门信息', 'button', 'dept:readAll', 'api/v1/user/dept', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('48', '获取部门信息列表', '获取部门信息列表', 'button', 'depts:read', 'api/v1/user/depts', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('49', '获取部门列表（对应公司）', '获取部门列表（对应公司）', 'button', 'comDepts:read', 'api/v1/user/comDepts', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('50', '查找部门', '查找部门', 'button', 'dept:searchByName', 'api/v1/user/dept/searchByName', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('51', '查找公司部门', '查找公司部门', 'button', 'dept:searchByNameAndComId', 'api/v1/user/dept/searchByNameAndComId', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('52', '添加用户-角色管理信息', '添加用户-角色管理信息', 'button', 'userRole:create', 'api/v1/user/userRole', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('53', '更新id对应的用户-角色管理信息', '更新id对应的用户-角色管理信息', 'button', 'userRole:update', 'api/v1/user/userRole', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('54', '添加角色-权限管理信息', '添加角色-权限管理信息', 'button', 'roleRule:create', 'api/v1/user/roleRule', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('55', '更新id对应的角色-权限管理信息', '更新id对应的角色-权限管理信息', 'button', 'roleRule:create', 'api/v1/user/roleRule', '0', '10', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('56', '获取全部角色', '获取全部角色', 'button', 'role:getAll', 'api/v1/user/role/getAll', '0', '7', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('57', '获取全部权限', '获取全部权限', 'button', 'rule:getAll', 'api/v1/user/rule/getAll', '0', '8', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('58', '车辆监控', '车辆监控', 'menu', 'car:monitor', 'javascript:;', '0', '0', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('59', '实时定位', '实时定位', 'menu', 'realTime:position', 'bds.html', '0', '58', '2018-12-12 16:17:48', '2018-12-12 16:17:48');
INSERT INTO `tb_rule` VALUES ('60', '历史轨迹', '历史轨迹', 'menu', 'car:trackBack', 'trackBack.html', '0', '58', '2018-12-12 16:17:48', '2018-12-12 16:17:48');

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
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', 'root', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-21 16:27:32', '1', '1', 'root', '14657861456', '27', '1', '广东广州', '211423432@qq.com', '总经理', '2', '1', '');
INSERT INTO `tb_user` VALUES ('2', 'admin', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-21 16:29:57', '1', '1', 'admin', '13634478678', '22', '1', '魔都上海', '83684633@163.com', '董事长', '3', '2', '');
INSERT INTO `tb_user` VALUES ('3', 'root1', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:39:24', '无头像', '1', 'root', '13634676678', '21', '0', '广东广州', '21423432@qq.com', '总经理', '1', '1', '');
INSERT INTO `tb_user` VALUES ('4', 'admin1', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:32:05', '无头像', '1', 'admin', '13634478678', '22', '1', '魔都上海', '83684633@163.com', '董事长', '4', '2', '');
INSERT INTO `tb_user` VALUES ('5', 'root2', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:39:24', '无头像', '1', 'root', '13634676678', '21', '0', '广东广州', '21423432@qq.com', '总经理', '2', '1', '');
INSERT INTO `tb_user` VALUES ('6', 'admin2', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:32:05', '无头像', '1', 'admin', '13634478678', '22', '1', '魔都上海', '83684633@163.com', '董事长', '4', '2', '');
INSERT INTO `tb_user` VALUES ('7', 'root3', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:39:24', '无头像', '1', 'root', '13634676678', '21', '0', '广东广州', '21423432@qq.com', '总经理', '2', '1', '');
INSERT INTO `tb_user` VALUES ('8', 'admin3', '63856b59dd154d64a2ebba7601c4c87b', '38BFDE3B8BA4F59C7CBA5DDFEDFB916B', '2018-12-12 13:32:05', '2018-12-12 13:32:05', '无头像', '1', 'admin', '13634478678', '22', '1', '魔都上海', '83684633@163.com', '董事长', '3', '2', '');

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户_角色id',
  `userId` int(255) NOT NULL COMMENT '用户id',
  `roleId` int(255) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_user_role
-- ----------------------------
INSERT INTO `tb_user_role` VALUES ('1', '1', '1');
INSERT INTO `tb_user_role` VALUES ('2', '1', '2');
INSERT INTO `tb_user_role` VALUES ('3', '1', '3');
INSERT INTO `tb_user_role` VALUES ('4', '2', '2');
INSERT INTO `tb_user_role` VALUES ('5', '2', '3');
INSERT INTO `tb_user_role` VALUES ('6', '3', '2');
INSERT INTO `tb_user_role` VALUES ('7', '4', '2');
INSERT INTO `tb_user_role` VALUES ('8', '4', '3');
INSERT INTO `tb_user_role` VALUES ('9', '5', '1');
INSERT INTO `tb_user_role` VALUES ('10', '6', '2');
INSERT INTO `tb_user_role` VALUES ('11', '7', '3');
INSERT INTO `tb_user_role` VALUES ('12', '8', '2');
INSERT INTO `tb_user_role` VALUES ('13', '8', '3');
INSERT INTO `tb_user_role` VALUES ('14', '5', '2');
INSERT INTO `tb_user_role` VALUES ('15', '5', '3');
