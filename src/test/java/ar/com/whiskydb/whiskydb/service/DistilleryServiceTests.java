package ar.com.whiskydb.whiskydb.service;

import ar.com.whiskydb.whiskydb.api.DTO.CreateDistillery;
import ar.com.whiskydb.whiskydb.model.Distillery;
import ar.com.whiskydb.whiskydb.model.DistilleryRepository;
import ar.com.whiskydb.whiskydb.model.Location;
import ar.com.whiskydb.whiskydb.services.DistilleryService;
import org.hibernate.boot.spi.AdditionalJaxbMappingProducer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
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
        Distillery distilleryBase = new Distillery(new Location("Fake","", ""), "Malibu",new ArrayList<>(), LocalDate.now());
        when(distilleryRepository.findById(1L)).thenReturn(Optional.of(distilleryBase));
        when(distilleryRepository.save(any(Distillery.class))).then(i -> i.getArgument(0));
        CreateDistillery dto = new CreateDistillery(new Location("Argentina","Chubut", "Las golondrinas"), "Dockrock",
                new ArrayList<>(), LocalDate.now());
        Distillery distilleryActualizado = distilleryService.update(dto,1L);
        Assertions.assertEquals(dto.getFounded(),distilleryActualizado.getFounded());
        Assertions.assertEquals(dto.getLocation(), distilleryActualizado.getLocation());
        Assertions.assertEquals(dto.getName(), distilleryActualizado.getName());
        Assertions.assertEquals(dto.getPhotos(),distilleryActualizado.getPhotos());
    }

    @Test
    void getById_Ok(){
        // TODO: 2/3/2023  
    }
}
