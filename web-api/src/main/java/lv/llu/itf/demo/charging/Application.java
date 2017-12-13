package lv.llu.itf.demo.charging;

import java.math.BigDecimal;

public class Application {
    public static void main(String[] args) {
        new Application().run();
    }

    public void run() {
        PaymentService service = new PaymentService();

        BigDecimal totalAmount = new BigDecimal("300.00");
        int numOfPayments = 5;
        BigDecimal paymentAmount = service.getPaymentAmount(totalAmount, numOfPayments);
        System.out.println("Payment amount: " + paymentAmount);
        System.out.println("Total payed amount: " + paymentAmount.multiply(new BigDecimal(numOfPayments)));
    }
}
