package ar.com.whiskydb.whiskydb.services;

import ar.com.whiskydb.whiskydb.api.DTO.CreateDistillery;
import ar.com.whiskydb.whiskydb.model.Distillery;
import ar.com.whiskydb.whiskydb.model.DistilleryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DistilleryService {
    private final DistilleryRepository distilleryRepository;

    public DistilleryService(DistilleryRepository distilleryRepository) {
        this.distilleryRepository = distilleryRepository;
    }

    @Transactional
    public Distillery create(CreateDistillery newDistillery) {
        Distillery distillery = new Distillery(newDistillery.getLocation(),
                newDistillery.getName(), newDistillery.getPhotos(),newDistillery.getFounded());
        return distilleryRepository.save(distillery);
    }

    public Page<Distillery> getAll(Pageable pageable) {
        return distilleryRepository.findAll(pageable);
    }

    public Distillery getById(long id) {
        Optional<Distillery> distillery = distilleryRepository.findById(id);
        return distillery.orElseThrow();
    }

    @Transactional
    public Distillery update(CreateDistillery updateDistillery, long id) {
           Distillery distillery = getById(id);
           if (null != updateDistillery.getFounded()) {
               distillery.setFounded(updateDistillery.getFounded());
           }
           if (null != updateDistillery.getLocation()) {
               distillery.setLocation(updateDistillery.getLocation());
           }
           if (null != updateDistillery.getName()) {
               distillery.setName(updateDistillery.getName());
           }
           if(null != updateDistillery.getPhotos()) {
               distillery.setPhotos(updateDistillery.getPhotos());
           }
           return distilleryRepository.save(distillery);
    }
}
