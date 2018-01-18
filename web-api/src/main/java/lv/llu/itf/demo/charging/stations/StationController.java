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
    public StationBean getStation(@PathVariable long id,
                                  @RequestParam(required = false) String name) {
        return new StationBean(id, name, 12.3456);
    }
}
