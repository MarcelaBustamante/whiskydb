package ar.com.whiskydb.whiskydb.api.DTO;

import ar.com.whiskydb.whiskydb.model.Location;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateDistillery {
    private Location location;
    private String name;
    private List<String> photos;
    private LocalDate founded;
}
