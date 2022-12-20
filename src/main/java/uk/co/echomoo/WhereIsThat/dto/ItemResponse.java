package uk.co.echomoo.WhereIsThat.dto;

import lombok.*;

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
