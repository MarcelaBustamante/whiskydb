package ar.com.whiskydb.whiskydb.api;

import ar.com.whiskydb.whiskydb.api.DTO.CreateWhisky;
import ar.com.whiskydb.whiskydb.model.Whisky;
import ar.com.whiskydb.whiskydb.services.WhiskyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Whiskies", description = "Information about Argentinan whisky and something else")
@RequestMapping("/whiskies")
public class WhiskyController {
    private final WhiskyService whiskyService;

    public WhiskyController(WhiskyService whiskyService) {
        this.whiskyService = whiskyService;
    }

    @Operation(summary = "Get all distilleries paged",description = "Also you can find distilleries by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @GetMapping
    public Page<Whisky> getAllWhiskies(Pageable pageable,
                                       @RequestParam(required = false) Long distilleryId,
                                       @RequestParam(required = false) String name){
        return whiskyService.getAll(pageable, distilleryId, name);
    }

    @Operation(summary = "Find whisky by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Whisky not found", content = @Content),
            //TODO: hacer el handle error para los casos invalidos
            @ApiResponse(responseCode = "400", description = "Invalid Id suplied", content = @Content)
    })
    @GetMapping("/{id}")
    public Whisky getWhiskyById(@PathVariable long id) {
        return whiskyService.getById(id);
    }

    @Operation(summary = "Add a new whisky to the distillery")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    @PostMapping
    public Whisky createWhisky(@RequestBody CreateWhisky whisky) {
        return whiskyService.create(whisky);
    }

    @Operation(summary = "Update an existing whisky")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "Whisky not found", content = @Content),
            //TODO: hacer el handle error para los casos invalidos
            @ApiResponse(responseCode = "400", description = "Invalid Id suplied", content = @Content)
    })
    @PutMapping("/{id}")
    public Whisky updateWhisky(@RequestBody CreateWhisky whisky, @PathVariable long id) {
        return whiskyService.update(whisky,id);
    }
}


