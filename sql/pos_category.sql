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

SET FOREIGN_KEY_CHECKS = 1;
