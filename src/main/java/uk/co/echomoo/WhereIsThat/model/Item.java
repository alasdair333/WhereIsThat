package uk.co.echomoo.WhereIsThat.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @NotBlank(message = "Name is required.")
    private String name;

    @NotBlank(message = "Item description is required.")
    @Lob
    private String description;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Image> images;

    private Instant createdDate;
    private Instant lastAccessed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boxId", referencedColumnName = "id")
    private Box box;
}
