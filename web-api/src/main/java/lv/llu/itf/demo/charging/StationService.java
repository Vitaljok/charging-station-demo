package lv.llu.itf.demo.charging;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

@Service
public class StationService {

    private long nextId = 1;
    private List<Station> stations;

    public StationService() {
        stations = new ArrayList<>();
        stations.add(fillStation("first", 5.678));
        stations.add(fillStation("second", 6.789));
        stations.add(fillStation("third", 7.89));
        stations.add(fillStation("fourth", 8.901));
    }

    private Station fillStation(String name, Double power) {
        Station station = new Station();
        station.setId(nextId++);
        station.setName(name);
        station.setPower(power);
        station.setCreatedTs(now());
        station.setUpdatedTs(now());
        station.setVersion(1);
        return station;
    }

    public Long createStation(StationDetailsBean bean) {
        Station station = fillStation(bean.getName(), bean.getPower());
        stations.add(station);
        return station.getId();
    }

    public List<StationBean> getStationList() {
        return stations.stream()
                .map(station -> {
                    StationBean bean = new StationBean();
                    bean.setId(station.getId());
                    bean.setName(station.getName());
                    return bean;
                })
                .collect(toList());
    }

    public StationDetailsBean getStation(long id) {
        return stations.stream()
                .filter(station -> id == station.getId())
                .findFirst()
                .map(station -> {
                    StationDetailsBean bean = new StationDetailsBean();
                    bean.setId(station.getId());
                    bean.setName(station.getName());
                    bean.setPower(station.getPower());
                    return bean;
                })
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void updateStation(long id, StationDetailsBean bean) {
        Station found = stations.stream()
                .filter(station -> id == station.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found"));

        found.setName(bean.getName());
        found.setPower(bean.getPower());
        found.setUpdatedTs(now());
    }

    public void removeStation(long id) {
        Station found = stations.stream()
                .filter(station -> id == station.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found"));

        stations.remove(found);
    }

}
