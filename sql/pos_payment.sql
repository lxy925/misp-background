-- ----------------------------
-- Table structure for pos_payment
-- ----------------------------
DROP TABLE IF EXISTS `pos_payment`;
CREATE TABLE `pos_payment` (
    payment_id bigint NOT NULL AUTO_INCREMENT COMMENT '支付id',
    payment_no varchar(32) NULL COMMENT '支付编号',
    sale_id bigint DEFAULT NULL COMMENT '订单id',
    pay_time datetime DEFAULT NULL COMMENT '支付时间',
    amount decimal(10,2) DEFAULT 0.00 COMMENT '支付金额',
    pay_method varchar(10) DEFAULT NULL COMMENT '支付方式',
    create_by VARCHAR(32) DEFAULT NULL COMMENT '创建者',
    create_time DATETIME DEFAULT NULL COMMENT '创建时间',
    update_by VARCHAR(32) DEFAULT NULL COMMENT '更新者',
    update_time DATETIME DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 ROW_FORMAT=DYNAMIC COMMENT='支付表';

