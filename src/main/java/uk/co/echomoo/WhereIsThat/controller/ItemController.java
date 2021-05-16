package uk.co.echomoo.WhereIsThat.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.echomoo.WhereIsThat.dto.ItemRequest;
import uk.co.echomoo.WhereIsThat.dto.ItemResponse;
import uk.co.echomoo.WhereIsThat.service.ItemService;

import java.util.List;

@RestController
@RequestMapping("/api/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody ItemRequest itemRequest) {
        itemService.save(itemRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ItemResponse>> getAllItems() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemService.getAllItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItem(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(itemService.getItem(id));
    }
}
