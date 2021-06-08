package uk.co.echomoo.WhereIsThat.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.echomoo.WhereIsThat.dto.LocationDto;
import uk.co.echomoo.WhereIsThat.service.LocationService;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@AllArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<LocationDto> createLocation(@RequestBody LocationDto locationDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(locationService.save(locationDto));
    }

    @GetMapping
    @CrossOrigin
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locationService.getAll());
    }

    @GetMapping("/{id}")
    @CrossOrigin
    public ResponseEntity<LocationDto> getLocation(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locationService.getLocation(id));
    }
}
