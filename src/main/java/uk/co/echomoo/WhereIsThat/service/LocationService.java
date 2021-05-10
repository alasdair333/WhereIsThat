package uk.co.echomoo.WhereIsThat.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.echomoo.WhereIsThat.dto.LocationDto;
import uk.co.echomoo.WhereIsThat.exceptions.LocationException;
import uk.co.echomoo.WhereIsThat.mapper.LocationMapper;
import uk.co.echomoo.WhereIsThat.model.Location;
import uk.co.echomoo.WhereIsThat.repository.LocationRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    @Transactional
    public LocationDto save(LocationDto locationDto) {
        Location save = locationRepository.save(locationMapper.mapDtoToLocation(locationDto));
        locationDto.setId(save.getId());
        return locationDto;
    }

    @Transactional( readOnly = true )
    public List<LocationDto> getAll() {
        return locationRepository.findAll()
                .stream()
                .map(locationMapper::mapLocationToDto)
                .collect(toList());
    }

    @Transactional
    public LocationDto getLocation(Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new LocationException("No location found: "+ id));
        return locationMapper.mapLocationToDto(location);
    }
}
