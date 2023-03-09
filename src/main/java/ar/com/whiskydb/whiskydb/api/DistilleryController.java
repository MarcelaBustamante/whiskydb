package ar.com.whiskydb.whiskydb.api;

import ar.com.whiskydb.whiskydb.api.DTO.CreateDistillery;
import ar.com.whiskydb.whiskydb.model.Distillery;
import ar.com.whiskydb.whiskydb.services.DistilleryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name ="Destilleries", description = "Here's everything about the distilleries in Argentina that produce whisky")
@RequestMapping("/distilleries")
public class DistilleryController {

    private final DistilleryService distilleryService;

    public DistilleryController(DistilleryService distilleryService) {
        this.distilleryService = distilleryService;
    }

    @Operation(summary = "Get all distilleries", description = "Get all distilleries with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Distillery.class)) }),
    })
    @GetMapping
    public Page<Distillery> getAllDistilleries(Pageable pageable) {
        return distilleryService.getAll(pageable);
    }

    @Operation(summary = "Find Distillery by Id", description = "For valid response try integer IDs with value >= 1. Other values will generated exceptions")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Distillery not found", content = @Content),
            //TODO: hacer el handle error para los casos invalidos
            @ApiResponse(responseCode = "400", description = "Invalid Id suplied")
    })
    @GetMapping("/{id}")
    public Distillery getDistilleryById(@PathVariable long id) {
        return distilleryService.getById(id);
    }

    @Operation(summary = "Create a new distillery", description = "Create a new distillery")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Distillery.class)))
    })
    @PostMapping
    public Distillery createDistillery(@RequestBody CreateDistillery distillery) {
        return distilleryService.create(distillery);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Distillery not found", content = @Content),
            //TODO: hacer el handle error para los casos invalidos
            @ApiResponse(responseCode = "400", description = "Invalid Id suplied")
    })
    @Operation(summary = "Updates an existing distillery", description = "Updates a distillery")
    @PutMapping("/{id}")
    public Distillery updateDistillery(@RequestBody CreateDistillery distillery, @PathVariable long id) {
        return distilleryService.update(distillery, id);
    }
}
