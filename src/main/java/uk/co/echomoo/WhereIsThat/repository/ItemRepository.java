package uk.co.echomoo.WhereIsThat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.echomoo.WhereIsThat.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
