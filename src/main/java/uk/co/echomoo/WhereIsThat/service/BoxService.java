package uk.co.echomoo.WhereIsThat.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uk.co.echomoo.WhereIsThat.dto.BoxRequest;
import uk.co.echomoo.WhereIsThat.dto.BoxResponse;
import uk.co.echomoo.WhereIsThat.exceptions.BoxException;
import uk.co.echomoo.WhereIsThat.exceptions.LocationException;
import uk.co.echomoo.WhereIsThat.mapper.BoxMapper;
import uk.co.echomoo.WhereIsThat.model.Box;
import uk.co.echomoo.WhereIsThat.model.Location;
import uk.co.echomoo.WhereIsThat.repository.BoxRepository;
import org.springframework.transaction.annotation.Transactional;
import uk.co.echomoo.WhereIsThat.repository.LocationRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class BoxService {

    private final LocationRepository locationRepository;
    private final BoxRepository boxRepository;
    private final BoxMapper boxMapper;

    public void save(BoxRequest boxRequest) {
        Location location = locationRepository.findByName(boxRequest.getLocationName())
                .orElseThrow(() -> new LocationException(boxRequest.getLocationName()));

        boxRepository.save(boxMapper.map(boxRequest, location));
    }

    @Transactional( readOnly = true )
    public List<BoxResponse> getAllBoxes() {
        return boxRepository.findAll()
                .stream()
                .map(boxMapper::mapToDto)
                .collect(toList());
    }

    @Transactional
    public BoxResponse getBox(Long id) {
        Box box = boxRepository.findById(id)
                .orElseThrow(() -> new BoxException("No box found: " + id));
        return boxMapper.mapToDto(box);
    }
}
