package kg.mega.natv.service.impl;

import kg.mega.natv.models.entity.Prices;
import kg.mega.natv.repository.PricesRepo;
import kg.mega.natv.service.PricesService;
import org.springframework.stereotype.Service;

@Service
public class PricesServiceImpl implements PricesService {

    private final PricesRepo pricesRepo;

    public PricesServiceImpl(PricesRepo pricesRepo) {
        this.pricesRepo = pricesRepo;
    }

    @Override
    public Prices getPriceByChannel(Long channelId) {
        return pricesRepo.getPriceByChannel(channelId);
    }
}
