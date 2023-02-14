package ar.com.whiskydb.whiskydb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TastingNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_tasting_note")
    @SequenceGenerator(name = "seq_tasting_note", sequenceName = "seq_tasting_note", allocationSize = 1)
    private Long id;
    private String name;
}
