package uk.co.echomoo.WhereIsThat.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uk.co.echomoo.WhereIsThat.dto.ItemDto;
import uk.co.echomoo.WhereIsThat.model.Item;

@Mapper( componentModel = "spring")
public interface ItemMapper {

    ItemDto mapItemToDto(Item item);

    @InheritInverseConfiguration
    @Mapping(target = "images", ignore = true)
    Item mapDtoToItem(ItemDto itemDto);
}
