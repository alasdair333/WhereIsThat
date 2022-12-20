package uk.co.echomoo.WhereIsThat.model;

import jakarta.persistence.*;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Location Name is required")
    private String name;

    @Nullable
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Box> boxes;

    private Instant creationDate;
    private Instant accessedDate;
}
