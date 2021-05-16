package uk.co.echomoo.WhereIsThat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uk.co.echomoo.WhereIsThat.dto.ItemDto;
import uk.co.echomoo.WhereIsThat.exceptions.ItemException;
import uk.co.echomoo.WhereIsThat.mapper.ItemMapper;
import uk.co.echomoo.WhereIsThat.model.Item;
import uk.co.echomoo.WhereIsThat.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Transactional
    public ItemDto save(ItemDto itemDto) {
        Item save = itemRepository.save(itemMapper.mapDtoToItem(itemDto));
        itemDto.setItemId(save.getItemId());

        return itemDto;
    }

    @Transactional( readOnly = true )
    public List<ItemDto> getAll() {
        return itemRepository.findAll()
                .stream()
                .map(itemMapper::mapItemToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public ItemDto getItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ItemException("No Item found: " + id));
        return itemMapper.mapItemToDto(item);
    }
}
