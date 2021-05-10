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
import java.util.Optional;

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
