package lv.llu.itf.demo.charging.stations

import spock.lang.Specification

class StationControllerSpec extends Specification {

    def "should get station by id"() {
        given:
            def controller = new StationController()
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
            def controller = new StationController()
        when:
            def list = controller.getStationList()
        then:
            list.size() == 3
            list.collect { it.id } == [1l, 2l, 3l]
    }
}
