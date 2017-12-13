package lv.llu.itf.demo.charging;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations")
public class StationController {

    @GetMapping("/{id}")
    public StationBean getStation(@PathVariable long id,
                                  @RequestParam(required = false) String name) {
        StationBean bean = new StationBean();
        bean.setId(id);
        bean.setName(name);
        bean.setPower(12.3456);
        return bean;
    }
}
