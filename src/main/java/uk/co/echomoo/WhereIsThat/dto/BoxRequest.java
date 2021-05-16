package uk.co.echomoo.WhereIsThat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxRequest {

    private Long boxId;
    private String locationName;
    private String boxName;
    private String description;
}
