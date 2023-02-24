package ar.com.whiskydb.whiskydb.api.DTO;

import ar.com.whiskydb.whiskydb.model.Category;
import ar.com.whiskydb.whiskydb.model.TastingNote;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateWhisky {
    private long distilleryId;
    private String name;
    private Float strength;
    private Integer vintage;
    private int aging;
    private List<TastingNote> tastingNotes;
    private Category category;
    private String photo;
}
