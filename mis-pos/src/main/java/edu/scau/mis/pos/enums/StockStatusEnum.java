package edu.scau.mis.pos.enums;

/**
 * 库存状态
 */
public enum StockStatusEnum {
    /*
    normal 正常：产品库存属于安全范围
    out_of_stock 缺货：缺货状态为上架产品但因无货无法售卖
    running_low 即将售罄：剩余库存小于10（或小于某既定数）
    */
    normal,
    out_of_stock,
    running_low
}
