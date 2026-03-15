-- ----------------------------
-- Table structure for pos_product
-- ----------------------------
DROP TABLE IF EXISTS `pos_product`;
CREATE TABLE pos_product (
     product_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '商品id',
     product_sn VARCHAR(32) NOT NULL UNIQUE COMMENT '商品编号',
     product_name VARCHAR(32) NOT NULL COMMENT '商品名称',
     product_description VARCHAR(100) NOT NULL COMMENT '商品描述',
     price DECIMAL(10, 2) NOT NULL COMMENT '商品价格',
     product_category_id BIGINT NOT NULL COMMENT '类别ID',
     image_url VARCHAR(200) DEFAULT NULL COMMENT '主图URL',
     detail_url VARCHAR(200) DEFAULT NULL COMMENT '详情URL',
     create_by VARCHAR(32) DEFAULT NULL COMMENT '创建者',
     create_time DATETIME DEFAULT NULL COMMENT '创建时间',
     update_by VARCHAR(32) DEFAULT NULL COMMENT '更新者',
     update_time DATETIME DEFAULT NULL COMMENT '更新时间',
     PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 ROW_FORMAT=DYNAMIC COMMENT='商品表';

-- ----------------------------
-- Records of pos_product
-- ----------------------------
BEGIN;
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (1, '1001', '钢笔', '', 65.00, 1, null, null, 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (2, '1002', '日记本', '', 20.00, 1, null, null, 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (3, '1003', '铅笔盒', '', 45.00, 1, null, null, 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (4, '1004', '毛巾', '', 10.00, 2, null, null, 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (5, '1005', '香波', '', 80.00, 2, null, null, 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (6, '1006', '拖鞋', '', 30.00, 2, null, null, 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (7, '1007', 'Mate X5', '超轻薄四曲折叠，超高分辨率临境双屏', 13499.00, 3, 'https://res6.vmallres.com/pimages//uomcdn/CN/pms/202309/gbom/6942103107320/800_800_959526DD397D0C873FCE80CE67C9A0BFmp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086281788718&sbomCode=2601010457506', 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (8, '1008', 'Pura 70 Pro', '超聚光微距长焦，超高速风驰闪拍', 6499.00, 3, 'https://res2.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103119071/800_800_AE94E48F4A6370D6E956B4E722588A5Amp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086821546239&sbomCode=2601010486504', 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (9, '1009', 'Mate 60', '超可靠玄武架构，全焦段超清影像', 5499.00, 3, 'https://res8.vmallres.com/pimages//uomcdn/CN/pms/202403/gbom/6942103107719/800_800_5818B6A12914274ED24FB8FE47F1CD34mp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086970184614&sbomCode=2601010453707', 'admin', '2025-10-01 23:58:40');
INSERT INTO pos_product (product_id, product_sn, product_name, product_description, price, product_category_id, image_url, detail_url, create_by, create_time)
VALUES (10, '1010', 'Pura 70', '超高速风驰闪拍，第二代昆仑玻璃', 8499.00, 3, 'https://res4.vmallres.com/pimages//uomcdn/CN/pms/202404/gbom/6942103120374/800_800_606AD050130CDD9F17DBBB7EECDD9B4Amp.png', 'https://www.vmall.com/product/comdetail/index.html?prdId=10086157311748&sbomCode=2601010486608', 'admin', '2025-10-01 23:58:40');
COMMIT;