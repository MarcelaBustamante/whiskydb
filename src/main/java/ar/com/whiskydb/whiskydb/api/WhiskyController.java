package ar.com.whiskydb.whiskydb.api;

import ar.com.whiskydb.whiskydb.api.DTO.CreateWhisky;
import ar.com.whiskydb.whiskydb.model.Whisky;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whiskies")
public class WhiskyController {

    @GetMapping
    public Page<Whisky> getAllWhiskies(Pageable pageable){
        return null;
    }

    @GetMapping("/{id]")
    public Whisky getWhiskyById(@PathVariable long id) {
        return null;
    }

    @PostMapping
    public Whisky createWhisky(@RequestBody CreateWhisky whisky) {
        return null;
    }

    @PutMapping("/{id}")
    public Whisky updateWhisky(@RequestBody CreateWhisky whisky, @PathVariable long id) {
        return null;
    }
}

