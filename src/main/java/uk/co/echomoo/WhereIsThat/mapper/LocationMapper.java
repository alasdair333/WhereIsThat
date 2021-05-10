package uk.co.echomoo.WhereIsThat.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uk.co.echomoo.WhereIsThat.dto.LocationDto;
import uk.co.echomoo.WhereIsThat.model.Box;
import uk.co.echomoo.WhereIsThat.model.Location;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "numberOfBoxes", expression = "java(mapBoxes(location.getBoxes()))")
    LocationDto mapLocationToDto(Location location);

    default Integer mapBoxes(List<Box> numberOfBoxes) { return numberOfBoxes.size(); }

    @Mapping(target = "boxes", ignore = true)
    Location mapDtoToLocation(LocationDto locationDto);

}
