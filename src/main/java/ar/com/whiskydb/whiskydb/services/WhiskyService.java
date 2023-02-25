package ar.com.whiskydb.whiskydb.services;

import ar.com.whiskydb.whiskydb.api.DTO.CreateWhisky;
import ar.com.whiskydb.whiskydb.model.Distillery;
import ar.com.whiskydb.whiskydb.model.Whisky;
import ar.com.whiskydb.whiskydb.model.WhiskyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WhiskyService {
    private final WhiskyRepository whiskyRepository;
    private final DistilleryService distilleryService;

    public WhiskyService(WhiskyRepository whiskyRepository, DistilleryService distilleryService) {
        this.whiskyRepository = whiskyRepository;
        this.distilleryService = distilleryService;
    }

    public Page<Whisky> getAll(Pageable pageable, Long distilleryId, String name) {
        String nameFilter = null != name ? "%" + name + "%" : null;
        return whiskyRepository.find(distilleryId, nameFilter, pageable);
    }

    public Whisky getById(long id) {
        return whiskyRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Whisky create(CreateWhisky newWhisky) {
        distilleryService.getById(newWhisky.getDistilleryId());
        Whisky whisky = new Whisky(newWhisky.getDistilleryId(), newWhisky.getName(), newWhisky.getStrength(),
                newWhisky.getVintage(), newWhisky.getAging(), newWhisky.getCategory(), newWhisky.getPhoto());
        whisky.setTastingNotes(newWhisky.getTastingNotes());
        return whiskyRepository.save(whisky);
    }

    @Transactional
    public Whisky update(CreateWhisky whisky, long id) {
        Whisky whisky1 = getById(id);
        if (null != whisky.getName()) {
            whisky1.setName(whisky.getName());
        }
        if (null != whisky.getStrength()) {
            whisky1.setStrength(whisky.getStrength());
        }
        if (null != whisky.getVintage()) {
            whisky1.setVintage(whisky.getVintage());
        }
        if (0 != whisky.getAging()) {
            whisky1.setAging(whisky.getAging());
        }
        if(null != whisky.getCategory()) {
            whisky1.setCategory(whisky.getCategory());
        }
        if(null != whisky.getPhoto()) {
            whisky1.setPhoto(whisky.getPhoto());
        }
        if(null != whisky.getTastingNotes()) {
            whisky1.setTastingNotes(whisky.getTastingNotes());
        }
        return whiskyRepository.save(whisky1);
    }
}
