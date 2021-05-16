package uk.co.echomoo.WhereIsThat.mapper;

import com.github.marlonlom.utilities.timeago.TimeAgo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uk.co.echomoo.WhereIsThat.dto.ItemRequest;
import uk.co.echomoo.WhereIsThat.dto.ItemResponse;
import uk.co.echomoo.WhereIsThat.model.Box;
import uk.co.echomoo.WhereIsThat.model.Item;
import uk.co.echomoo.WhereIsThat.model.Location;

import java.time.Instant;

@Mapper( componentModel = "spring")
public abstract class ItemMapper {

    @Mapping(target = "id", source = "itemId")
    @Mapping(target = "itemName", source = "name")
    @Mapping(target = "boxName", source = "box.boxName")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "created", expression = "java(getTimeAgo(item.getCreatedDate()))")
    @Mapping(target = "accessed", expression = "java(getTimeAgo(item.getLastAccessed()))")
    public abstract ItemResponse mapToDto(Item item);

    @Mapping( target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping( target = "lastAccessed", expression = "java(java.time.Instant.now())")
    @Mapping( target = "itemId", source = "itemRequest.itemId")
    @Mapping( target = "name", source = "itemRequest.itemName")
    @Mapping( target = "description", source = "itemRequest.description")
    @Mapping( target = "box", source = "box")
    public abstract Item map(ItemRequest itemRequest, Box box);

    @InheritInverseConfiguration
    @Mapping(target = "images", ignore = true)
    public abstract Item mapDtoToItem(ItemRequest itemRequest);

    String getTimeAgo(Instant time) { return TimeAgo.using(time.toEpochMilli()); }
}
