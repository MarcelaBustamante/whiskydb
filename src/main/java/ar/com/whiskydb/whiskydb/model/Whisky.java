package ar.com.whiskydb.whiskydb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Whisky {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_whisky")
    @SequenceGenerator(name = "seq_whisky", sequenceName = "seq_whisky", allocationSize = 1)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "distillery_id")
    private Distillery distillery;
    @Schema(description = "Whisky name")
    private String name;

    @Schema(description = "Alcohol by volume", example = "50.0f")
    private Float strength;

    @Schema(description = "the year the spirit was distilled", example = "2010")
    private Integer vintage;

    @Schema(description = "when distilled spirits are placed in barrels to age for a specific period of time", example = "10")
    private int aging;
    @ManyToMany
    @JoinTable(name = "whisky_tasting_note",
            joinColumns = @JoinColumn(name = "whisky_id"),
            inverseJoinColumns = @JoinColumn(name = "tasting_note_id"))
    private List<TastingNote> tastingNotes;
    @Enumerated(EnumType.STRING)
    @Schema(description = "SINGLE_MALT, BOURBON,BLENDED,SINGLE_GRAIN")
    private Category category;

    @Schema(description = "date", example = "2023-03-01")
    private LocalDateTime addedOn;
    private String photo;

    public Whisky(long distillery, String name, Float strength, Integer vintage, int aging, Category category, String photo) {
        this.distillery = new Distillery();
        this.distillery.setId(distillery);
        this.name = name;
        this.strength = strength;
        this.vintage = vintage;
        this.aging = aging;
        this.category = category;
        this.photo = photo;
        this.addedOn = LocalDateTime.now();
        this.tastingNotes = new ArrayList<>();
    }
}


