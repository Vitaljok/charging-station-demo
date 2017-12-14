package lv.llu.itf.demo.charging

import spock.lang.Specification

class StationControllerSpec extends Specification {

    def service = Mock(StationService)

    def controller = new StationController(service)

    def "should get list of stations"() {
        when:
            def beans = controller.listStations()
        then:
            beans.size() == 3
            1 * service.getStationList() >> [new StationBean(), new StationBean(), new StationBean()]

    }

    def "should get station details"() {
        when:
            controller.getStation(123)
        then:
            1 * service.getStation(123) >> new StationDetailsBean()
    }

    def "should update station"() {
        when:
            controller.editStation(123, new StationDetailsBean())
        then:
            1 * service.updateStation(123, _)
    }

    def "should remove station"() {
        when:
            controller.removeStation(123)
        then:
            1 * service.removeStation(123)
    }

    def "should create station"() {
        when:
            controller.createStation(new StationDetailsBean())
        then:
            1 * service.createStation(_)
    }
}
