package lv.llu.itf.demo.charging.stations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StationService {

    private final StationRepository repository;

    @Autowired
    public StationService(StationRepository repository) {
        this.repository = repository;

        repository.save(initStation("First station", 10.10));
        repository.save(initStation("Second station", 20.20));
        repository.save(initStation("Third station", 30.30));
    }

    private Station initStation(String name, double power) {
        Station entity = new Station();
        entity.setName(name);
        entity.setPower(power);
        entity.setCreatedBy("init user");
        entity.setCreatedTs(LocalDateTime.now());
        return entity;
    }

    public List<StationBean> getStationList() {
        return repository.findAll().stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }

    public StationBean createStation(StationBean bean) {
        Station station = new Station();
        station.setName(bean.getName());
        station.setPower(bean.getPower());
        station.setCreatedBy("fake user");
        station.setCreatedTs(LocalDateTime.now());
        Station savedStation = repository.save(station);
        return transform(savedStation);
    }

    private StationBean transform(Station entity) {
        return new StationBean(entity.getId(), entity.getName(), entity.getPower());
    }
}
