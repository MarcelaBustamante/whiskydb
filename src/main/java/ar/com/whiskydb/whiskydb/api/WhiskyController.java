package ar.com.whiskydb.whiskydb.api;

import ar.com.whiskydb.whiskydb.api.DTO.CreateWhisky;
import ar.com.whiskydb.whiskydb.model.Whisky;
import ar.com.whiskydb.whiskydb.services.WhiskyService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whiskies")
public class WhiskyController {
    private final WhiskyService whiskyService;

    public WhiskyController(WhiskyService whiskyService) {
        this.whiskyService = whiskyService;
    }

    @GetMapping
    public Page<Whisky> getAllWhiskies(Pageable pageable,
                                       @RequestParam(required = false) Long distilleryId,
                                       @RequestParam(required = false) String name){
        return whiskyService.getAll(pageable, distilleryId, name);
    }

    @GetMapping("/{id}")
    public Whisky getWhiskyById(@PathVariable long id) {
        return whiskyService.getById(id);
    }

    @PostMapping
    public Whisky createWhisky(@RequestBody CreateWhisky whisky) {
        return whiskyService.create(whisky);
    }

    @PutMapping("/{id}")
    public Whisky updateWhisky(@RequestBody CreateWhisky whisky, @PathVariable long id) {
        return whiskyService.update(whisky,id);
    }
}

