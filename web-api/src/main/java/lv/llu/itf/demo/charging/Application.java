package lv.llu.itf.demo.charging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    public Application(PaymentService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    private PaymentService service;

    @Override
    public void run(String... args) {
        BigDecimal totalAmount = new BigDecimal("300.00");
        int numOfPayments = 5;
        BigDecimal paymentAmount = service.getPaymentAmount(totalAmount, numOfPayments);
        System.out.println("Payment amount: " + paymentAmount);
        System.out.println("Total payed amount: " + paymentAmount.multiply(new BigDecimal(numOfPayments)));
    }
}
