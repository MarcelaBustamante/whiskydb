package ar.com.whiskydb.whiskydb.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String name;
    private Float strength;
    private Integer vintage;
    private int aging;
    @ManyToMany
    @JoinTable(name = "whisky_tasting_note",
            joinColumns = @JoinColumn(name = "whisky_id"),
            inverseJoinColumns = @JoinColumn(name = "tasting_note_id"))
    private List<TastingNote> tastingNotes;
    @Enumerated(EnumType.STRING)
    private Category category;
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


