package ar.com.whiskydb.whiskydb.api.DTO;

import ar.com.whiskydb.whiskydb.model.Category;
import ar.com.whiskydb.whiskydb.model.TastingNote;
import ar.com.whiskydb.whiskydb.model.Whisky;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class CreateWhisky {
    private String name;
    private String strength;
    private Integer vintage;
    private int aging;
    private List<TastingNote> tastingNotes;
    private Category category;
    private String photo;
}
