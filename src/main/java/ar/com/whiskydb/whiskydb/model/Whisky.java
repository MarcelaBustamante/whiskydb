package ar.com.whiskydb.whiskydb.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private String name;
    private String strength;
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
}
