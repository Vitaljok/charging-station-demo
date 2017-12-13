package lv.llu.itf.demo.charging

import spock.lang.Specification

class ApplicationSpec extends Specification {

    def "should get payment amount from service"() {
        given:
            def service = Mock(PaymentService)
            def application = new Application(service)
        when:
            application.run()
        then:
            1 * service.getPaymentAmount(300.00, 5) >> 123.45
    }
}
