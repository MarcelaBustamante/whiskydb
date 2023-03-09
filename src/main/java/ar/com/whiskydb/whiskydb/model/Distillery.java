package ar.com.whiskydb.whiskydb.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Distillery model")
@Entity
public class Distillery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_distillery")
    @SequenceGenerator(name = "seq_distillery", sequenceName = "seq_distillery", allocationSize = 1)
    private Long id;
    @Embedded
    private Location location;
    @NotNull
    @Schema(description = "The name of the distillery")
    private String name;
    @ElementCollection
    @Schema(example = "http://photo.com/linkNumber", description = "Whisky gallery")
    private List<String> photos;
    @Schema(example = "2023-03-01")
    private LocalDate founded;

    public Distillery(Location location, String name, List<String> photos, LocalDate founded) {
        this.location = location;
        this.name = name;
        this.photos = photos;
        this.founded = founded;
    }
}
