package lv.llu.itf.demo.charging.stations;

import lv.llu.itf.demo.charging.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
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

        for (int i = 0; i < 5; i++) {
            StationEvent event = new StationEvent();
            event.setTs(LocalDateTime.now());
            event.setMessage("Event #" + i);
            event.setStation(entity);
            entity.getEvents().add(event);
        }

        return entity;
    }

    public List<StationBean> getStationList() {
        return repository.findAll().stream()
                .map(this::transform)
                .collect(Collectors.toList());
    }

    public StationDetailsBean createStation(StationBean bean) {
        Station station = new Station();
        station.setName(bean.getName());
        station.setPower(bean.getPower());
        station.setCreatedBy("fake user");
        station.setCreatedTs(LocalDateTime.now());
        Station savedStation = repository.save(station);
        return transformDetails(savedStation);
    }

    private StationBean transform(Station entity) {
        return new StationBean(entity.getId(), entity.getName(), entity.getPower());
    }

    private StationDetailsBean transformDetails(Station entity) {
        StationDetailsBean bean = new StationDetailsBean();
        bean.setId(entity.getId());
        bean.setName(entity.getName());
        bean.setPower(entity.getPower());
        bean.setCreatedBy(entity.getCreatedBy());
        bean.setCreatedTs(entity.getCreatedTs().atZone(ZoneId.systemDefault()));
        bean.setEventMessages(
                entity.getEvents()
                        .stream()
                        .map(StationEvent::getMessage)
                        .collect(Collectors.toList())
        );
        return bean;
    }

    public StationDetailsBean getStationById(Long id) {
        Station station = repository.findOne(id);
        if (station == null) {
            throw new NotFoundException();
        }
        return transformDetails(station);
    }

    public StationDetailsBean editStation(Long id, StationBean bean) {
        Station station = repository.findOne(id);
        station.setPower(bean.getPower());
        return transformDetails(station);
    }
}
