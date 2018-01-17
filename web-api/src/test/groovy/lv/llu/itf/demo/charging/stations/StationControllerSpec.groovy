package lv.llu.itf.demo.charging.stations

import spock.lang.Specification

class StationControllerSpec extends Specification {

    def "should get station by id"() {
        given:
        def controller = new StationController(null)
        expect:
            with(controller.getStation(paramId, paramName)) {
                id == paramId
                name == paramName
            }

        where:
            paramId | paramName
            123     | "first"
            234     | null
    }

    def "should get station list"() {
        given:
        def service = Mock(StationService)
        def controller = new StationController(service)
        when:
            def list = controller.getStationList()
        then:
        1 * service.getStationList()
    }
}
