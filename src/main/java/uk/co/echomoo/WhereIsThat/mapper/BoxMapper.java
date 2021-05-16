package uk.co.echomoo.WhereIsThat.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uk.co.echomoo.WhereIsThat.dto.BoxRequest;
import uk.co.echomoo.WhereIsThat.dto.BoxResponse;
import uk.co.echomoo.WhereIsThat.model.Box;
import uk.co.echomoo.WhereIsThat.model.Item;
import uk.co.echomoo.WhereIsThat.model.Location;

import java.time.Instant;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BoxMapper {


    @Mapping(target = "id", source = "id")
    @Mapping(target = "locationName", source = "location.name")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "created", expression = "java(getTimeAgo(box.getCreationDate()))")
    @Mapping(target = "accessed", expression = "java(getTimeAgo(box.getAccessDate()))")
    public abstract BoxResponse mapToDto(Box box);

    @Mapping( target = "creationDate", expression = "java(java.time.Instant.now())")
    @Mapping( target = "accessDate", expression = "java(java.time.Instant.now())")
    @Mapping( target = "id", source = "boxRequest.boxId")
    @Mapping( target = "description", source = "boxRequest.description")
    @Mapping( target = "location", source = "location")
    public abstract Box map(BoxRequest boxRequest, Location location);

    @InheritInverseConfiguration
    public abstract Box mapDtoToBox(BoxRequest boxRequest);

    String getTimeAgo(Instant time) { return TimeAgo.using(time.toEpochMilli()); }
}
