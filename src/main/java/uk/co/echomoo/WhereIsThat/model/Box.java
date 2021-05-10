package uk.co.echomoo.WhereIsThat.model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Box name can't be blank")
    private String boxName;

    @Nullable
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Item> items;

    private Instant creationDate;
    private Instant accessDate;
}
