package uk.co.echomoo.WhereIsThat.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationDto {

    private Long id;
    private String name;
    private String description;
    private Integer numberOfBoxes;
}
