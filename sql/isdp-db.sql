/*
 Navicat Premium Dump SQL

 Source Server         : localhost-docker
 Source Server Type    : MySQL
 Source Server Version : 80031 (8.0.31)
 Source Host           : localhost:3306
 Source Schema         : isdp-db

 Target Server Type    : MySQL
 Target Server Version : 80031 (8.0.31)
 File Encoding         : 65001

 Date: 04/03/2026 10:45:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pos_category
-- ----------------------------
DROP TABLE IF EXISTS `pos_category`;
CREATE TABLE `pos_category` (
  `category_id` bigint NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `parent_id` bigint NOT NULL DEFAULT '0' COMMENT '父级id',
  `category_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '类别名称',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`category_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='类别表';

-- ----------------------------
-- Records of pos_category
-- ----------------------------
BEGIN;
INSERT INTO `pos_category` (`category_id`, `parent_id`, `category_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 0, '文具', 'admin', '2025-10-01 23:58:40', NULL, NULL);
INSERT INTO `pos_category` (`category_id`, `parent_id`, `category_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 0, '日用品', 'admin', '2025-10-01 23:58:53', NULL, NULL);
INSERT INTO `pos_category` (`category_id`, `parent_id`, `category_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, 0, '手机', 'admin', '2025-10-01 23:59:06', NULL, NULL);
INSERT INTO `pos_category` (`category_id`, `parent_id`, `category_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, 3, 'IOS', 'admin', '2025-10-09 14:36:26', NULL, NULL);
INSERT INTO `pos_category` (`category_id`, `parent_id`, `category_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, 3, 'Android', 'admin', '2025-10-09 14:36:43', NULL, NULL);
INSERT INTO `pos_category` (`category_id`, `parent_id`, `category_name`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, 3, 'HarmonyOS', 'admin', '2025-10-09 14:37:30', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for pos_payment
-- ----------------------------
DROP TABLE IF EXISTS `pos_payment`;
CREATE TABLE `pos_payment` (
  `payment_id` bigint NOT NULL AUTO_INCREMENT COMMENT '支付id',
  `payment_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付编号',
  `sale_id` bigint DEFAULT NULL COMMENT '订单id',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `amount` decimal(10,2) DEFAULT '0.00' COMMENT '支付金额',
  `pay_method` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付方式',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='支付表';

-- ----------------------------
-- Records of pos_payment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for pos_product
-- ----------------------------
DROP TABLE IF EXISTS `pos_product`;
CREATE TABLE `pos_product` (
  `product_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品id',
  `product_sn` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品编号',
  `product_name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品名称',
  `product_description` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '商品描述',
  `price` decimal(10,2) NOT NULL COMMENT '商品价格',
  `product_category_id` bigint NOT NULL COMMENT '类别ID',
  `image_url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主图URL',
  `detail_url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详情URL',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`) USING BTREE,
  UNIQUE KEY `product_sn` (`product_sn`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='商品表';

-- ----------------------------
-- Records of pos_product
-- ----------------------------
BEGIN;
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '1001', '钢笔', '', 65.00, 1, NULL, NULL, 'admin', '2025-10-01 23:58:40', NULL, NULL);
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '1002', '日记本', '', 20.00, 1, NULL, NULL, 'admin', '2025-10-01 23:58:40', NULL, NULL);
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '1003', '铅笔盒', '', 45.00, 1, NULL, NULL, 'admin', '2025-10-01 23:58:40', NULL, NULL);
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, '1004', '毛巾', '', 10.00, 2, NULL, NULL, 'admin', '2025-10-01 23:58:40', NULL, NULL);
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, '1005', '香波', '', 80.00, 2, NULL, NULL, 'admin', '2025-10-01 23:58:40', NULL, NULL);
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, '1006', '拖鞋', '', 30.00, 2, NULL, NULL, 'admin', '2025-10-01 23:58:40', NULL, NULL);
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, '1007', 'Mate X5', '超轻薄四曲折叠，超高分辨率临境双屏', 13499.00, 6, 'https://res6.vmallres.com/pimages//uomcdn/CN/pms/202309/gbom/6942103107320/800_800_959526DD397D0C873FCE80CE67C9A0BFmp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086281788718&sbomCode=2601010457506', 'admin', '2025-10-01 23:58:40', NULL, '2025-10-24 14:23:25');
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (8, '1008', 'Pura 70 Pro', '超聚光微距长焦，超高速风驰闪拍', 6499.00, 6, 'https://res2.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103119071/800_800_AE94E48F4A6370D6E956B4E722588A5Amp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086821546239&sbomCode=2601010486504', 'admin', '2025-10-01 23:58:40', NULL, '2025-10-24 14:39:03');
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (9, '1009', 'Mate 60', '超可靠玄武架构，全焦段超清影像', 5499.00, 6, 'https://res8.vmallres.com/pimages//uomcdn/CN/pms/202403/gbom/6942103107719/800_800_5818B6A12914274ED24FB8FE47F1CD34mp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086970184614&sbomCode=2601010453707', 'admin', '2025-10-01 23:58:40', NULL, '2025-10-24 14:39:12');
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (10, '1010', 'Pura 70', '超高速风驰闪拍，第二代昆仑玻璃', 8499.00, 6, 'https://res4.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103120374/800_800_606AD050130CDD9F17DBBB7EECDD9B4Amp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086157311748&sbomCode=2601010486608', 'admin', '2025-10-01 23:58:40', NULL, '2025-10-24 14:39:29');
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (11, '1011', '测试商品2', '', 200.00, 1, '', '', NULL, '2025-10-24 13:50:40', NULL, '2025-10-24 14:42:26');
INSERT INTO `pos_product` (`product_id`, `product_sn`, `product_name`, `product_description`, `price`, `product_category_id`, `image_url`, `detail_url`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (12, '1012', '测试商品4', '', 1.00, 2, '', '', NULL, '2026-03-04 10:43:02', NULL, '2026-03-04 10:43:11');
COMMIT;

-- ----------------------------
-- Table structure for pos_sale
-- ----------------------------
DROP TABLE IF EXISTS `pos_sale`;
CREATE TABLE `pos_sale` (
  `sale_id` bigint NOT NULL AUTO_INCREMENT COMMENT '销售ID',
  `sale_no` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '销售单号',
  `total` decimal(10,2) DEFAULT '0.00' COMMENT '总金额',
  `sale_time` datetime DEFAULT NULL COMMENT '销售时间',
  `payment_id` bigint DEFAULT NULL COMMENT '支付id',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单状态',
  `del_flag` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '删除标识',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`sale_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pos_sale
-- ----------------------------
BEGIN;
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'so-1542881137129459712', 135.00, '2022-06-25 14:42:06', NULL, 'paid', '0', NULL, '2022-06-25 14:42:28', NULL, '2022-06-26 14:42:28');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 'so-1542881495386001408', 270.00, '2022-06-30 17:55:25', NULL, 'paid', '0', NULL, '2022-06-25 18:20:50', NULL, '2022-06-26 18:20:50');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, 'so-1542881571277635584', 110.00, '2022-06-30 18:18:29', NULL, 'reserved', '0', NULL, '2022-06-25 18:20:56', NULL, NULL);
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, 'so-1981675103756648448', 85.00, '2025-10-24 18:52:17', NULL, 'paid', '0', NULL, '2025-10-24 18:52:24', NULL, '2025-10-24 18:52:28');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, 'so-1981675552396181504', 130.00, '2025-10-24 18:54:04', NULL, 'reserved', '0', NULL, '2025-10-24 18:54:31', NULL, NULL);
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, 'so-1981679578466660352', 130.00, '2025-10-24 19:10:04', NULL, 'paid', '0', NULL, '2025-10-24 19:10:23', NULL, '2025-10-24 19:10:32');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, 'so-1983703165864136704', 170.00, '2025-10-30 09:11:05', NULL, 'paid', '0', NULL, '2025-10-30 09:12:29', NULL, '2025-10-30 09:13:20');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (8, 'so-1984384491915210752', 215.00, '2025-11-01 06:18:26', NULL, 'paid', '0', NULL, '2025-11-01 06:18:37', NULL, '2025-11-01 06:18:42');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (9, 'so-1984420165485801472', 125.00, '2025-11-01 08:40:11', NULL, 'paid', '0', NULL, '2025-11-01 08:40:20', NULL, '2025-11-01 08:40:27');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (10, 'so-1984957487289643008', 85.00, '2025-11-02 20:15:18', NULL, 'reserved', '0', NULL, '2025-11-02 20:15:27', NULL, NULL);
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (11, 'so-1984957987896602624', 150.00, '2025-11-02 20:17:18', NULL, 'reserved', '0', NULL, '2025-11-02 20:17:25', NULL, NULL);
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (12, 'so-1984974891717668864', 130.00, '2025-11-02 21:24:28', NULL, 'paid', '0', NULL, '2025-11-02 21:24:38', NULL, '2025-11-02 21:24:48');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (13, 'so-1985024401365962752', 13629.00, '2025-11-03 00:41:12', NULL, 'paid', '0', NULL, '2025-11-03 00:41:29', NULL, '2025-11-03 00:41:40');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (14, 'so-1985027061402030080', 400.00, '2025-11-03 00:51:46', NULL, 'paid', '0', NULL, '2025-11-03 00:52:39', NULL, '2025-11-03 00:52:55');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (15, 'so-1985029501538983936', 295.00, '2025-11-03 01:01:28', NULL, 'paid', '0', NULL, '2025-11-03 01:02:06', NULL, '2025-11-03 01:02:38');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (16, 'so-1986228624321613824', 65.00, '2025-11-06 08:26:21', NULL, 'paid', '0', NULL, '2025-11-06 08:26:37', NULL, '2025-11-06 08:26:43');
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (17, 'so-2028903367377899520', 325.00, '2026-03-04 02:40:33', NULL, 'reserved', '0', NULL, '2026-03-04 02:40:58', NULL, NULL);
INSERT INTO `pos_sale` (`sale_id`, `sale_no`, `total`, `sale_time`, `payment_id`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (18, 'so-2029011510304919552', 65.00, '2026-03-04 09:50:16', NULL, 'reserved', '0', NULL, '2026-03-04 09:50:20', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for pos_sale_item
-- ----------------------------
DROP TABLE IF EXISTS `pos_sale_item`;
CREATE TABLE `pos_sale_item` (
  `sale_item_id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单明细id',
  `sale_id` bigint DEFAULT NULL COMMENT '订单id',
  `product_id` bigint DEFAULT NULL COMMENT '产品id',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '销售价格',
  `quantity` int DEFAULT NULL COMMENT '购买数量',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '明细状态',
  `del_flag` char(1) COLLATE utf8mb4_unicode_ci DEFAULT '0' COMMENT '删除标识',
  `create_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`sale_item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pos_sale_item
-- ----------------------------
BEGIN;
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 1, 1, 65.00, 1, 'paid', '0', NULL, '2022-06-25 14:43:26', NULL, '2022-06-26 14:43:26');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, 1, 2, 20.00, 2, 'paid', '0', NULL, '2022-06-25 14:44:34', NULL, '2022-06-26 14:44:34');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, 1, 4, 10.00, 3, 'paid', '0', NULL, '2022-06-25 14:45:22', NULL, '2022-06-26 14:45:22');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (4, 2, 2, 20.00, 1, 'paid', '0', NULL, '2022-06-25 18:21:06', NULL, '2022-06-26 18:21:06');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (5, 2, 5, 80.00, 2, 'paid', '0', NULL, '2022-06-25 18:21:10', NULL, '2022-06-26 18:21:10');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (6, 2, 6, 30.00, 3, 'paid', '0', NULL, '2022-06-25 18:21:18', NULL, '2022-06-26 18:21:18');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (7, 3, 5, 80.00, 1, 'reserved', '0', NULL, '2022-06-25 18:21:22', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (8, 3, 6, 30.00, 1, 'reserved', '0', NULL, '2022-06-25 18:21:27', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (9, 4, 1, 65.00, 1, 'paid', '0', NULL, '2025-10-24 18:52:24', NULL, '2025-10-24 18:52:28');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (10, 4, 2, 20.00, 1, 'paid', '0', NULL, '2025-10-24 18:52:24', NULL, '2025-10-24 18:52:28');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (11, 5, 1, 65.00, 2, 'reserved', '0', NULL, '2025-10-24 18:54:31', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (12, 6, 1, 65.00, 2, 'paid', '0', NULL, '2025-10-24 19:10:23', NULL, '2025-10-24 19:10:32');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (13, 7, 2, 20.00, 3, 'paid', '0', NULL, '2025-10-30 09:12:29', NULL, '2025-10-30 09:13:20');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (14, 7, 5, 80.00, 1, 'paid', '0', NULL, '2025-10-30 09:12:29', NULL, '2025-10-30 09:13:20');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (15, 7, 6, 30.00, 1, 'paid', '0', NULL, '2025-10-30 09:12:29', NULL, '2025-10-30 09:13:20');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (16, 8, 1, 65.00, 3, 'paid', '0', NULL, '2025-11-01 06:18:37', NULL, '2025-11-01 06:18:42');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (17, 8, 4, 10.00, 2, 'paid', '0', NULL, '2025-11-01 06:18:37', NULL, '2025-11-01 06:18:42');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (18, 9, 1, 65.00, 1, 'paid', '0', NULL, '2025-11-01 08:40:20', NULL, '2025-11-01 08:40:27');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (19, 9, 2, 20.00, 3, 'paid', '0', NULL, '2025-11-01 08:40:20', NULL, '2025-11-01 08:40:27');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (20, 10, 1, 65.00, 1, 'reserved', '0', NULL, '2025-11-02 20:15:27', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (21, 10, 2, 20.00, 1, 'reserved', '0', NULL, '2025-11-02 20:15:27', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (22, 11, 1, 65.00, 2, 'reserved', '0', NULL, '2025-11-02 20:17:25', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (23, 11, 2, 20.00, 1, 'reserved', '0', NULL, '2025-11-02 20:17:25', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (24, 12, 1, 65.00, 2, 'paid', '0', NULL, '2025-11-02 21:24:38', NULL, '2025-11-02 21:24:48');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (25, 13, 1, 65.00, 2, 'paid', '0', NULL, '2025-11-03 00:41:29', NULL, '2025-11-03 00:41:40');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (26, 13, 7, 13499.00, 1, 'paid', '0', NULL, '2025-11-03 00:41:29', NULL, '2025-11-03 00:41:40');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (27, 14, 1, 65.00, 4, 'paid', '0', NULL, '2025-11-03 00:52:39', NULL, '2025-11-03 00:52:55');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (28, 14, 2, 20.00, 7, 'paid', '0', NULL, '2025-11-03 00:52:39', NULL, '2025-11-03 00:52:55');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (29, 15, 1, 65.00, 3, 'paid', '0', NULL, '2025-11-03 01:02:06', NULL, '2025-11-03 01:02:38');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (30, 15, 2, 20.00, 5, 'paid', '0', NULL, '2025-11-03 01:02:06', NULL, '2025-11-03 01:02:38');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (31, 16, 1, 65.00, 1, 'paid', '0', NULL, '2025-11-06 08:26:37', NULL, '2025-11-06 08:26:43');
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (32, 17, 1, 65.00, 5, 'reserved', '0', NULL, '2026-03-04 02:40:58', NULL, NULL);
INSERT INTO `pos_sale_item` (`sale_item_id`, `sale_id`, `product_id`, `price`, `quantity`, `status`, `del_flag`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (33, 18, 1, 65.00, 1, 'reserved', '0', NULL, '2026-03-04 09:50:20', NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
