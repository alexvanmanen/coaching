package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BootcampRepository extends JpaRepository<Bootcamp, Long> {

    Bootcamp findByBootcampName(String name);
    Page<Bootcamp> findAllByActive(boolean active, Pageable pageable);

}
