package ar.com.whiskydb.whiskydb.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
}
