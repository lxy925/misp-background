package edu.scau.mis.product.domain;

import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "商品维度")
public class SpecAttr {
    private int attr_id;
    private int spec_id;
    private String attr_name;
    private List<String> attr_value;
}
