package kg.mega.natv.service.impl;

import kg.mega.natv.models.dto.DiscountChDto;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.dto.OrderChannelDto;
import kg.mega.natv.models.entity.Channels;
import kg.mega.natv.models.entity.Discounts;
import kg.mega.natv.models.mapper.DiscountMapper;
import kg.mega.natv.repository.DiscountsRepo;
import kg.mega.natv.service.DiscountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountsServiceImpl implements DiscountsService {
    private final DiscountMapper discountMapper = DiscountMapper.INSTANCE;

    private final DiscountsRepo discountsRepo;
    @Override
    public DiscountDto createDiscounts(DiscountDto discountDto) {

        discountsRepo.save(discountMapper.dtoToEntity(discountDto));
        return discountDto;
    }

    @Override
    public Optional<Discounts> findDiscountsById(Long id) {

        return discountsRepo.findById(id);
    }

    @Override
    public List<Discounts> findAllDiscounts() {
        return discountsRepo.findAll();
    }

    @Override
    public Discounts updateDiscounts(Discounts discounts) {
        return discountsRepo.save(discounts);
    }

    @Override
    public List<DiscountChDto> findDiscountsByChannelList(List<Channels> channels) {


        return discountsRepo.findActiveDiscountsByChannels(channels);
    }

    @Override
    public Boolean deleteDiscounts(Long id) {
        Optional<Discounts> optionalDiscounts = discountsRepo.findById(id);
        if (optionalDiscounts.isPresent()){
            Discounts discounts = optionalDiscounts.get();
            discounts.setEntDate(new Timestamp(System.currentTimeMillis()));
            discountsRepo.save(discounts);
            return true;
        }
        return false;
    }

    @Override
    public DiscountDto findDiscountsByOrderChannelDto(OrderChannelDto orderChannelDto) {
        Integer quantityDays = orderChannelDto.getAdDates().size();
        List<DiscountDto> discounts = discountsRepo.findAllByChannels(orderChannelDto.getChannelId(), quantityDays);
        if (discounts.size() == 0){
            return null;
        }
        DiscountDto discountDto = discounts.stream()
                .max(Comparator.comparing(DiscountDto::getFromDaysCount))
                .get();

        return discountDto;
    }
}
