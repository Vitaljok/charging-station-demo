package lv.llu.itf.demo.charging;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PaymentServiceTest {

    @Test
    public void shouldGetCorrectPaymentAmount() {
        PaymentService service = new PaymentService();

        BigDecimal paymentAmount1 = service.getPaymentAmount(new BigDecimal("100.00"), 5);
        assertEquals(new BigDecimal("20.00"), paymentAmount1);

        BigDecimal paymentAmount2 = service.getPaymentAmount(new BigDecimal("30.00"), 3);
        assertEquals(new BigDecimal("10.00"), paymentAmount2);
    }
}