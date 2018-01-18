package lv.llu.itf.demo.charging.stations;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(indexes = {@Index(columnList = "station_id")})
@Data
public class StationEvent {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private LocalDateTime ts;

    @Column(nullable = false)
    private String message;

    @ManyToOne(optional = false)
    private Station station;
}
