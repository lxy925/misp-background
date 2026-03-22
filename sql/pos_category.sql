/*
 Navicat Premium Data Transfer

 Source Server         : lxy
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : isdp-db

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 16/03/2026 23:11:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pos_category
-- ----------------------------
DROP TABLE IF EXISTS `pos_category`;
CREATE TABLE `pos_category`  (
  `category_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '分类ID',
  `parent_id` bigint(0) NOT NULL DEFAULT 0 COMMENT '父分类ID，顶级为0',
  `category_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '分类名称',
  `level` tinyint(1) NOT NULL COMMENT '分类级别：1一级 2二级 3三级',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '层级路径，例如 0,1,3',
  `state` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态：0下架 1上架',
  `create_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `update_by` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '' COMMENT '更新者',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 303 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '商品分类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pos_category
-- ----------------------------
INSERT INTO `pos_category` VALUES (1, 0, '宠物食品', 1, '0,1', 1, '', '2026-03-16 22:02:29', '', '2026-03-16 22:02:29');
INSERT INTO `pos_category` VALUES (2, 0, '宠物玩具', 1, '0,2', 1, '', '2026-03-16 22:02:29', '', '2026-03-16 22:02:29');
INSERT INTO `pos_category` VALUES (3, 0, '宠物服装', 1, '0,3', 1, '', '2026-03-16 22:02:29', '', '2026-03-16 22:02:29');
INSERT INTO `pos_category` VALUES (4, 0, '宠物清洁', 1, '0,4', 1, '', '2026-03-16 22:02:29', '', '2026-03-16 22:02:29');
INSERT INTO `pos_category` VALUES (5, 1, '主粮', 2, '0,1,5', 1, '', '2026-03-16 22:02:29', '', '2026-03-16 22:02:29');
INSERT INTO `pos_category` VALUES (6, 1, '零食', 2, '0,1,6', 1, '', '2026-03-16 22:02:29', '', '2026-03-16 22:02:29');
INSERT INTO `pos_category` VALUES (7, 1, '保健品', 2, '0,1,7', 1, '', '2026-03-16 22:02:29', '', '2026-03-16 22:02:29');
INSERT INTO `pos_category` VALUES (8, 2, '猫用玩具', 2, '0,2,8', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (9, 2, '狗用玩具', 2, '0,2,9', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (10, 3, '衣服', 2, '0,3,10', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (11, 3, '配饰', 2, '0,3,11', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (12, 4, '洗护用品', 2, '0,4,12', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (13, 4, '日用品', 2, '0,4,13', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (14, 5, '猫粮', 3, '0,1,5,14', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (15, 5, '狗粮', 3, '0,1,5,15', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (16, 5, '其他', 3, '0,1,5,16', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (17, 6, '猫零食', 3, '0,1,6,17', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (18, 6, '狗零食', 3, '0,1,6,18', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (19, 6, '通用零食', 3, '0,1,6,19', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (20, 7, '肠胃调理', 3, '0,1,7,20', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (21, 7, '营养补充', 3, '0,1,7,21', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (22, 7, '驱虫用品', 3, '0,1,7,22', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (23, 8, '逗猫棒', 3, '0,2,8,23', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (24, 8, '磨爪玩具', 3, '0,2,8,24', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (25, 8, '互动玩具', 3, '0,2,8,25', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (26, 9, '磨牙玩具', 3, '0,2,9,26', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (27, 9, '户外玩具', 3, '0,2,9,27', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (28, 9, '益智玩具', 3, '0,2,9,28', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (29, 10, '日常款', 3, '0,3,10,29', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (30, 10, '功能款', 3, '0,3,10,30', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (31, 10, '华丽款', 3, '0,3,10,31', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (32, 11, '牵引装备', 3, '0,3,11,32', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (33, 11, '装饰配饰', 3, '0,3,11,33', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (34, 11, '身份配饰', 3, '0,3,11,34', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (35, 12, '洗浴类', 3, '0,4,12,35', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (36, 12, '梳理类', 3, '0,4,12,36', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (37, 12, '清洁类', 3, '0,4,12,37', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (38, 13, '尿垫/尿片', 3, '0,4,13,38', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (39, 13, '猫砂/猫砂盆', 3, '0,4,13,39', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');
INSERT INTO `pos_category` VALUES (40, 13, '消毒用品', 3, '0,4,13,40', 1, '', '2026-03-16 22:02:30', '', '2026-03-16 22:02:30');

SET FOREIGN_KEY_CHECKS = 1;
