package kg.mega.natv.models.mapper;

import kg.mega.natv.models.dto.ChannelsDto;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.entity.Channels;
import kg.mega.natv.models.entity.Discounts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChannelsMapper {
    ChannelsMapper INSTANCE = Mappers.getMapper(ChannelsMapper.class);


    ChannelsDto entityToDto (Channels channels);
    Channels dtoToEntity (ChannelsDto channelsDto);

}
