package lv.llu.itf.demo.charging;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_EVEN;

public class PaymentService {
    public BigDecimal getPaymentAmount(BigDecimal totalAmount, Integer numOfPayments) {
        return totalAmount.divide(new BigDecimal(numOfPayments), 2, ROUND_HALF_EVEN);
    }
}
