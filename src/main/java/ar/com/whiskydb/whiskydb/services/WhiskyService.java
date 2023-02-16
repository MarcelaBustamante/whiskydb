package ar.com.whiskydb.whiskydb.services;

import ar.com.whiskydb.whiskydb.api.DTO.CreateWhisky;
import ar.com.whiskydb.whiskydb.model.Whisky;
import ar.com.whiskydb.whiskydb.model.WhiskyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class WhiskyService {
    private final WhiskyRepository whiskyRepository;

    public WhiskyService(WhiskyRepository whiskyRepository) {
        this.whiskyRepository = whiskyRepository;
    }

    public Page<Whisky> getAll(Pageable pageable) {
        return whiskyRepository.findAll(pageable);
    }

    public Whisky getById(long id) {
        return whiskyRepository.findById(id).orElseThrow();
    }

    @Transactional
    public Whisky create(CreateWhisky whisky) {
        Whisky whisky1 = new Whisky(whisky.getName(), whisky.getStrength(), whisky.getVintage(), whisky.getAging());
        return whiskyRepository.save(whisky1);
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
        return whiskyRepository.save(whisky1);
    }
}
