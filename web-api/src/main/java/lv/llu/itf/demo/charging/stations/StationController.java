package lv.llu.itf.demo.charging.stations;

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

    @GetMapping
    public List<StationBean> getStationList() {
        return service.getStationList();
    }

    @PostMapping
    public StationBean createStation(@RequestBody StationBean bean) {
        return service.createStation(bean);
    }

    @GetMapping("/{id}")
    public StationDetailsBean getStation(@PathVariable Long id) {
        return service.getStationById(id);
    }

    @PutMapping("/{id}")
    public StationDetailsBean editStation(@PathVariable Long id, @RequestBody StationBean bean) {
        return service.editStation(id, bean);
    }
}
