package uk.co.echomoo.WhereIsThat.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.echomoo.WhereIsThat.dto.ItemRequest;
import uk.co.echomoo.WhereIsThat.dto.ItemResponse;
import uk.co.echomoo.WhereIsThat.exceptions.BoxException;
import uk.co.echomoo.WhereIsThat.exceptions.ItemException;
import uk.co.echomoo.WhereIsThat.mapper.ItemMapper;
import uk.co.echomoo.WhereIsThat.model.Box;
import uk.co.echomoo.WhereIsThat.model.Item;
import uk.co.echomoo.WhereIsThat.repository.BoxRepository;
import uk.co.echomoo.WhereIsThat.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

    private final BoxRepository boxRepository;
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public void save(ItemRequest itemRequest) {
        Box box = boxRepository.findByBoxName(itemRequest.getBoxName())
                .orElseThrow(() -> new BoxException(itemRequest.getBoxName()));
        itemRepository.save(itemMapper.map(itemRequest, box));
    }

    @Transactional( readOnly = true )
    public List<ItemResponse> getAllItems() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemResponse getItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemException("No Item found: " + id));
        return itemMapper.mapToDto(item);
    }
}
