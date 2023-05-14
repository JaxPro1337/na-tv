package kg.mega.natv.models.mapper;

import kg.mega.natv.models.dto.ChannelsDto;
import kg.mega.natv.models.dto.OrderResponseDto;
import kg.mega.natv.models.entity.Channels;
import kg.mega.natv.models.entity.Orders;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    @Mapping(target = "orderId", source = "id")
    OrderResponseDto entityToDto (Orders orders);
    Orders dtoToEntity (OrderResponseDto orderResponseDto);
}
