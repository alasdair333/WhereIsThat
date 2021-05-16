package uk.co.echomoo.WhereIsThat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.echomoo.WhereIsThat.model.Image;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

    private Long itemId;
    private String itemName;
    private String boxName;
    private String description;
}
