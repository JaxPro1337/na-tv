package kg.mega.natv.service;

import kg.mega.natv.models.dto.DiscountChDto;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.dto.OrderChannelDto;
import kg.mega.natv.models.entity.Channels;
import kg.mega.natv.models.entity.Discounts;

import java.util.List;
import java.util.Optional;

public interface DiscountsService {

    DiscountDto createDiscounts(DiscountDto discountDto);

    Optional<Discounts> findDiscountsById(Long id);

    List<Discounts> findAllDiscounts();

    Discounts updateDiscounts(Discounts discounts);

    List<DiscountChDto> findDiscountsByChannelList(List<Channels> channels);

    Boolean deleteDiscounts(Long id);

    DiscountDto findDiscountsByOrderChannelDto(OrderChannelDto orderChannelDto);
}
