package uk.co.echomoo.WhereIsThat.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.echomoo.WhereIsThat.dto.BoxRequest;
import uk.co.echomoo.WhereIsThat.dto.BoxResponse;
import uk.co.echomoo.WhereIsThat.service.BoxService;

import java.util.List;

@RestController
@RequestMapping("/api/box")
@AllArgsConstructor
public class BoxController {

    private final BoxService boxService;

    @PostMapping
    public ResponseEntity<Void> createBox(@RequestBody BoxRequest boxRequest) {
        boxService.save(boxRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BoxResponse>> getAllBoxes() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(boxService.getAllBoxes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoxResponse> getBox(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(boxService.getBox(id));
    }
}
