package edu.scau.mis.common.domain;
import lombok.Data;

/**
 * 公共分页查询参数
 */
@Data
public class PageQuery {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
}