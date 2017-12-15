package lv.llu.itf.demo.charging;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {

    @GetMapping
    public List<StationBean> getStationList() {
        ArrayList<StationBean> list = new ArrayList<>();
        list.add(new StationBean(1, "first", 1.111));
        list.add(new StationBean(2, "second", 2.222));
        list.add(new StationBean(3, "third", 3.333));
        return list;
    }

    @GetMapping("/{id}")
    public StationBean getStation(@PathVariable long id,
                                  @RequestParam(required = false) String name) {
        return new StationBean(id, name, 12.3456);
    }
}
