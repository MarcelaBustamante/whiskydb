package ar.com.whiskydb.whiskydb.api.DTO;

import ar.com.whiskydb.whiskydb.model.Category;
import ar.com.whiskydb.whiskydb.model.TastingNote;

import java.time.LocalDateTime;
import java.util.List;

public class CreateWhisky {
    private String name;
    private String strength;
    private Integer vintage;
    private int aging;
    private List<TastingNote> tastingNotes;
    private Category category;
    private String photo;
}
