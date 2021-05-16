package uk.co.echomoo.WhereIsThat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoxResponse {

    private Long id;
    private String boxName;
    private String locationName;
    private String description;
    private Integer itemCount;
    private String created;
    private String accessed;

}
