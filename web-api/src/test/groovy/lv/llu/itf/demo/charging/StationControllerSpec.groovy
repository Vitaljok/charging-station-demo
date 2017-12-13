package lv.llu.itf.demo.charging

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
}
