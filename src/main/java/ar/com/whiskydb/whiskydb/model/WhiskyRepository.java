package ar.com.whiskydb.whiskydb.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    @Query("SELECT w FROM Whisky w " +
            "WHERE (:distilleryId IS NULL OR w.distillery.id = :distilleryId) " +
            "AND (:name IS NULL OR LOWER(w.name) LIKE LOWER(:name))")
    Page<Whisky> find(Long distilleryId, String name, Pageable pageable);
}
