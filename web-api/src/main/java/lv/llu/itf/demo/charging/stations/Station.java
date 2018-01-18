package lv.llu.itf.demo.charging.stations;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Station {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 30, nullable = false)
    private String name;

    private Double power;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private LocalDateTime createdTs;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "station")
    private List<StationEvent> events = new ArrayList<>();

}
