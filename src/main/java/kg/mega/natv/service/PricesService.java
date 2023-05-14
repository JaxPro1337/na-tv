package kg.mega.natv.service;

import kg.mega.natv.models.entity.Prices;

public interface PricesService {


    Prices getPriceByChannel(Long channelId);
}
