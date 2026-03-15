package edu.scau.mis.pos.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.scau.mis.common.domain.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class Payment extends BaseEntity implements Serializable {
    private Long paymentId;
    private String paymentNo;
    private Long saleId;
    private BigDecimal amount;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date payTime;
    private String payMethod;
}
