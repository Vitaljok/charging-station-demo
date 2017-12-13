package lv.llu.itf.demo.charging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class PaymentController {

    private final PaymentService service;

    @Autowired
    public PaymentController(PaymentService service) {
        this.service = service;
    }

    @RequestMapping(value = "/payment", method = GET)
    public ResponseEntity getPayemnt() {
        BigDecimal totalAmount = new BigDecimal("300.00");
        int numOfPayments = 5;
        BigDecimal paymentAmount = service.getPaymentAmount(totalAmount, numOfPayments);

        String result = "<h1>Payment summary</h1>" +
                "<p>Payment amount: <b>" + paymentAmount + "</b></p>" +
                "<p>Total payed amount: <b>" + paymentAmount.multiply(new BigDecimal(numOfPayments)) + "</b></p>";

        return ResponseEntity.ok()
                .header("My-Header", "Lorem ipsum")
                .body(result);
    }
}
