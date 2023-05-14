package kg.mega.natv.models.mapper;

import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.entity.Discounts;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DiscountMapper {

    DiscountMapper INSTANCE = Mappers.getMapper(DiscountMapper.class);

    Discounts dtoToEntity (DiscountDto discountDto);

}
