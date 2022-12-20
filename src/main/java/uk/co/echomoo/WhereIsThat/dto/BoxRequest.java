package uk.co.echomoo.WhereIsThat.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxRequest {

    private Long boxId;
    private String locationName;
    private String boxName;
    private String description;

}
