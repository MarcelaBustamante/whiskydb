package ar.com.whiskydb.whiskydb.service;

import ar.com.whiskydb.whiskydb.api.DTO.CreateWhisky;
import ar.com.whiskydb.whiskydb.model.Category;
import ar.com.whiskydb.whiskydb.model.DistilleryRepository;
import ar.com.whiskydb.whiskydb.model.Whisky;
import ar.com.whiskydb.whiskydb.services.WhiskyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class WhiskyServiceTests {
    @Autowired
    private WhiskyService whiskyService;

    @Test
    void createOk() {
        CreateWhisky dto = new CreateWhisky(1L, "Talisker 10", 50.0f, 2010, 10,
                Collections.emptyList(), Category.SINGLE_MALT, "");
        Whisky whisky = whiskyService.create(dto);
        Assertions.assertNotNull(whisky);
        Assertions.assertEquals(50.0f, whisky.getStrength());
        Assertions.assertEquals(2010, whisky.getVintage());
        Assertions.assertEquals(1L, whisky.getDistillery().getId());
    }

    @Test
    void create_DistilleryDoesNotExist() {
        CreateWhisky dto = new CreateWhisky(666L, "Talisker 10", 50.0f, 2010, 10,
                Collections.emptyList(), Category.SINGLE_MALT, "");
        Assertions.assertThrows(RuntimeException.class, () -> whiskyService.create(dto));
    }

    @Test
    void update_Ok(){
         CreateWhisky dto = new CreateWhisky(1L, "Talisker 10", 50.0f, 2010, 10,
                 Collections.emptyList(), Category.SINGLE_MALT, "");
        Whisky whisky = whiskyService.create(dto);
        Long id =  whisky.getId();
        dto.setName("Lagavulin");
        dto.setAging(9);
        dto.setVintage(2010);
        dto.setPhoto("https://images.unsplash.com/photo-1602166242292-93a00e63e8e8");
        whisky = whiskyService.update(dto, whisky.getId());
        Assertions.assertEquals(id,whisky.getId());
        Assertions.assertEquals("Lagavulin", whisky.getName());
        Assertions.assertEquals(9, whisky.getAging());
        Assertions.assertEquals(2010,whisky.getVintage());
        Assertions.assertNotEquals("",whisky.getPhoto());
    }
}
