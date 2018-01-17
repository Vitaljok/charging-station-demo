package lv.llu.itf.demo.charging.stations;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Station {
    @Id
    long id;
    @Column(length = 30, nullable = false)
    String name;
    Float power;
}
