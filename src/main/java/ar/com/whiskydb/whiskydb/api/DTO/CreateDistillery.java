package ar.com.whiskydb.whiskydb.api.DTO;

import ar.com.whiskydb.whiskydb.model.Location;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class CreateDistillery {
    private Location location;
    private String name;
    private List<String> photos;
    private LocalDate founded;
}
