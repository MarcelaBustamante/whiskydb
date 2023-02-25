package ar.com.whiskydb.whiskydb.service;

import ar.com.whiskydb.whiskydb.api.DTO.CreateWhisky;
import ar.com.whiskydb.whiskydb.model.Category;
import ar.com.whiskydb.whiskydb.model.Whisky;
import ar.com.whiskydb.whiskydb.model.WhiskyRepository;
import ar.com.whiskydb.whiskydb.services.DistilleryService;
import ar.com.whiskydb.whiskydb.services.WhiskyService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class WhiskyServiceTests {
    @Autowired
    private WhiskyService whiskyService;
    @MockBean
    private WhiskyRepository whiskyRepository;
    @MockBean
    private DistilleryService distilleryService;

    @Test
    void createOk() {
        when(whiskyRepository.save(any(Whisky.class))).thenReturn(new Whisky());

        CreateWhisky dto = new CreateWhisky(1L, "Talisker 10", 50.0f, 2010, 10,
                Collections.emptyList(), Category.SINGLE_MALT, "");
        Whisky whisky = whiskyService.create(dto);

        Assertions.assertNotNull(whisky);
    }

    @Test
    void create_DistilleryDoesNotExist() {
        when(distilleryService.getById(anyLong())).thenThrow(new RuntimeException());

        CreateWhisky dto = new CreateWhisky(666L, "Talisker 10", 50.0f, 2010, 10,
                Collections.emptyList(), Category.SINGLE_MALT, "");

        Assertions.assertThrows(RuntimeException.class, () -> whiskyService.create(dto));
    }

    @Test
    void update_Ok(){
        Whisky whiskyBase = new Whisky(1L, "Nombre incorrecto", 0f, 0, 0,
                Category.BLENDED, "photo inválida");
        when(whiskyRepository.findById(1L)).thenReturn(Optional.of(whiskyBase));
        when(whiskyRepository.save(any(Whisky.class))).then(i -> i.getArgument(0));

        CreateWhisky dto = new CreateWhisky(1L, "Lagavulin", 50.0f, 2010, 10,
                Collections.emptyList(), Category.SINGLE_MALT, "https://img.png");

        Whisky whiskyActualizado = whiskyService.update(dto, 1L);

        Assertions.assertEquals("Lagavulin", whiskyActualizado.getName());
        Assertions.assertEquals(50.0f, whiskyActualizado.getStrength());
        Assertions.assertEquals(2010, whiskyActualizado.getVintage());
        Assertions.assertEquals(10, whiskyActualizado.getAging());
        Assertions.assertTrue(whiskyActualizado.getTastingNotes().isEmpty());
        Assertions.assertEquals(Category.SINGLE_MALT, whiskyActualizado.getCategory());
        Assertions.assertEquals("https://img.png", whiskyActualizado.getPhoto());
    }
}
