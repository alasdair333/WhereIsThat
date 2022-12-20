package uk.co.echomoo.WhereIsThat.model;


import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Box name can't be blank")
    private String boxName;

    @Nullable
    @Lob
    private String description;

    private Instant creationDate;
    private Instant accessDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "locationId", referencedColumnName = "id")
    private Location location;
}
