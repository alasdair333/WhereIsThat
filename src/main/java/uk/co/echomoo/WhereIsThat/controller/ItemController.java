package uk.co.echomoo.WhereIsThat.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.echomoo.WhereIsThat.service.ItemService;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ItemController {

    private ItemService itemService;


}
