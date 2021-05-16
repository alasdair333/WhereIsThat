package uk.co.echomoo.WhereIsThat.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import uk.co.echomoo.WhereIsThat.dto.LocationDto;
import uk.co.echomoo.WhereIsThat.model.Location;
import uk.co.echomoo.WhereIsThat.repository.BoxRepository;

@Mapper(componentModel = "spring")
public abstract class LocationMapper {

    @Autowired
    private BoxRepository boxRepository;

    @Mapping(target = "numberOfBoxes", expression = "java(mapBoxes(location))")
    public abstract LocationDto mapLocationToDto(Location location);

    Integer mapBoxes(Location location) { return boxRepository.findByLocation(location).size(); }

    @InheritInverseConfiguration
    @Mapping(target = "boxes", ignore = true)
    public abstract Location mapDtoToLocation(LocationDto locationDto);

}
