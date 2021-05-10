package uk.co.echomoo.WhereIsThat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocationDto {

    private Long id;
    private String name;
    private String description;
    private Integer numberOfBoxes;
}
