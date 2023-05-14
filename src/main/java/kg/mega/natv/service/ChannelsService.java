package kg.mega.natv.service;

import kg.mega.natv.models.dto.ChannelDiscountDto;
import kg.mega.natv.models.dto.ChannelsDto;
import kg.mega.natv.models.entity.Channels;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ChannelsService {
    ChannelsDto createChannels(ChannelsDto channelsDto);

    Channels findChannelsById(Long id);

    List<Channels> findAllChannels();

    Channels updateChannels(Channels channels);

    Boolean deleteChannels(Long id);

    List<ChannelDiscountDto> getChannelList(Integer pageNo, Integer pageSize);
}
