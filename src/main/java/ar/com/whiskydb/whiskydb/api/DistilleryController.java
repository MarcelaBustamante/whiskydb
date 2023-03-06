package ar.com.whiskydb.whiskydb.api;

import ar.com.whiskydb.whiskydb.api.DTO.CreateDistillery;
import ar.com.whiskydb.whiskydb.model.Distillery;
import ar.com.whiskydb.whiskydb.services.DistilleryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/distilleries")
public class DistilleryController {

    private final DistilleryService distilleryService;

    public DistilleryController(DistilleryService distilleryService) {
        this.distilleryService = distilleryService;
    }

    @Operation(summary = "Get all distilleries", description = "Get all distilleries with pagination")
    @GetMapping
    public Page<Distillery> getAllDistilleries(Pageable pageable) {
        return distilleryService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public Distillery getDistilleryById(@PathVariable long id) {
        return distilleryService.getById(id);
    }

    @PostMapping
    public Distillery createDistillery(@RequestBody CreateDistillery distillery) {
        return distilleryService.create(distillery);
    }

    @PutMapping("/{id}")
    public Distillery updateDistillery(@RequestBody CreateDistillery distillery, @PathVariable long id) {
        return distilleryService.update(distillery, id);
    }
}
