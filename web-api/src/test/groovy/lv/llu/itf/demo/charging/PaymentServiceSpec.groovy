package lv.llu.itf.demo.charging

import spock.lang.Specification

class PaymentServiceSpec extends Specification {
    def "should get correct payment amount"() {
        given:
            def service = new PaymentService()
        when:
            def paymentAmount1 = service.getPaymentAmount(100.00, 5)
        then:
            paymentAmount1 == 20.00
        when:
            def paymentAmount2 = service.getPaymentAmount(30.00, 3)
        then:
            paymentAmount2 == 10.00
    }
}
