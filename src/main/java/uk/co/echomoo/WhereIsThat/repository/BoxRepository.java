package uk.co.echomoo.WhereIsThat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.echomoo.WhereIsThat.model.Box;
import uk.co.echomoo.WhereIsThat.model.Location;

import java.util.List;
import java.util.Optional;

public interface BoxRepository extends JpaRepository<Box, Long> {

    Optional<Box> findByBoxName(String boxName);

    List<Box> findByLocation(Location location);
}
