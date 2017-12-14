package lv.llu.itf.demo.charging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    private final StationService service;

    @Autowired
    public StationController(StationService service) {
        this.service = service;
    }

    @PostMapping
    public Long createStation(StationDetailsBean bean) {
        return service.createStation(bean);
    }

    @GetMapping
    public List<StationBean> listStations() {
        return service.getStationList();
    }

    @GetMapping("/{id}")
    public StationDetailsBean getStation(@PathVariable long id) {
        return service.getStation(id);
    }

    @PutMapping("/{id}")
    public void editStation(@PathVariable long id, StationDetailsBean bean) {
        service.updateStation(id, bean);
    }

    @DeleteMapping("/{id}")
    public void removeStation(@PathVariable long id) {
        service.removeStation(id);
    }

}
