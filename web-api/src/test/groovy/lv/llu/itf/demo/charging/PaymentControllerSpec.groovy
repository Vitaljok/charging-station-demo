package lv.llu.itf.demo.charging

import org.springframework.http.HttpStatus
import spock.lang.Specification

class PaymentControllerSpec extends Specification {
    def "should get payment summary"() {
        given:
            def service = Mock(PaymentService)
            def controller = new PaymentController(service)

        when:
            def response = controller.getPayemnt()
        then:
            1 * service.getPaymentAmount(_, _) >> 67.89
            response.statusCode == HttpStatus.OK
            response.body.toString().contains("67.89")
            response.body.toString().contains("339.45")
    }
}
