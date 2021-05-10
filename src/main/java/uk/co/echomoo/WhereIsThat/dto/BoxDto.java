package uk.co.echomoo.WhereIsThat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxDto {

    private Long id;
    private Long locationId;
    private String name;
    private String description;
    private Integer numberOfItems;
}
