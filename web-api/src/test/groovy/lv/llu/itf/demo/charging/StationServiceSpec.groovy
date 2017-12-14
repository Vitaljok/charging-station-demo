package lv.llu.itf.demo.charging

import spock.lang.Specification

class StationServiceSpec extends Specification {

    def service = new StationService()

    def "CreateStation"() {
    }

    def "should get station list"() {
        when:
            def list = service.getStationList()
        then:
            list.size() == 4
    }

    def "should get station by id"() {
        when:
            def one = service.getStation(1)
        then:
            one.getId() == 1
    }

    def "should throw exception when id not found"() {
        when:
            service.getStation(123)
        then:
            def ex = thrown(RuntimeException)
            ex.message == "Not found"
    }

    def "should update station"() {
        when:
            service.updateStation(2, new StationDetailsBean(name: "new name"))
        then:
            service.getStation(2).getName() == "new name"
    }

    def "should remove station"() {
        when:
            service.removeStation(4)
        then:
            service.getStationList().size() == 3

    }
}
