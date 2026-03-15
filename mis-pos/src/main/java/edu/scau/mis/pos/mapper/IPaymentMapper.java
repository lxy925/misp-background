package edu.scau.mis.pos.mapper;

import edu.scau.mis.pos.domain.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IPaymentMapper {
    /**
     * 新增Payment
     * @param payment
     * @return
     */
    int insertPayment(Payment payment);

    /**
     * 根据ID查询Payment
     * @param paymentId
     * @return
     */
    Payment selectPaymentById(Long paymentId);
}
