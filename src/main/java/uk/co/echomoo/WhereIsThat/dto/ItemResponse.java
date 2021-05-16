package uk.co.echomoo.WhereIsThat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    private Long id;
    private String itemName;
    private String boxName;
    private String description;
    private String created;
    private String accessed;

}
