package uk.co.echomoo.WhereIsThat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.echomoo.WhereIsThat.model.Box;
import uk.co.echomoo.WhereIsThat.model.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByBox(Box box);
}
