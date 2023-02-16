package ar.com.whiskydb.whiskydb.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Distillery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_distillery")
    @SequenceGenerator(name = "seq_distillery", sequenceName = "seq_distillery", allocationSize = 1)
    private Long id;
    @Embedded
    private Location location;
    private String name;
    @ElementCollection
    private List<String> photos;
    private LocalDate founded;

    public Distillery(Location location, String name, List<String> photos, LocalDate founded) {
        this.location = location;
        this.name = name;
        this.photos = photos;
        this.founded = founded;
    }
}
