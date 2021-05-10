package uk.co.echomoo.WhereIsThat.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.echomoo.WhereIsThat.dto.BoxDto;
import uk.co.echomoo.WhereIsThat.service.BoxService;

@RestController
@RequestMapping("/api/box")
@AllArgsConstructor
public class BoxController {

    private final BoxService boxService;

    public ResponseEntity<BoxDto> createBox(@RequestBody BoxDto boxDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(boxService.save(boxDto));
    }
}
