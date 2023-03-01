package ar.com.whiskydb.whiskydb.service;

import ar.com.whiskydb.whiskydb.api.DTO.CreateDistillery;
import ar.com.whiskydb.whiskydb.model.Distillery;
import ar.com.whiskydb.whiskydb.model.DistilleryRepository;
import ar.com.whiskydb.whiskydb.model.Location;
import ar.com.whiskydb.whiskydb.services.DistilleryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class DistilleryServiceTests {

    @Autowired
    private DistilleryService distilleryService;
    @MockBean
    private DistilleryRepository distilleryRepository;

    @Test
    void create_Ok() {
        when(distilleryRepository.save(any(Distillery.class))).thenReturn(new Distillery());
        CreateDistillery dto = new CreateDistillery( new Location("", "", ""),
                "Talisker", new ArrayList<String>(), LocalDate.now());
        Distillery distillery = distilleryService.create(dto);
        Assertions.assertNotNull(distillery);
    }

    @Test
    void update_Ok(){
        //todo
    }

}
