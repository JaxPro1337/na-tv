package kg.mega.natv.service.impl;

import kg.mega.natv.models.dto.ChannelDiscountDto;
import kg.mega.natv.models.dto.ChannelsDto;
import kg.mega.natv.models.dto.DiscountChDto;
import kg.mega.natv.models.entity.Channels;
import kg.mega.natv.repository.ChannelsRepo;
import kg.mega.natv.service.ChannelsService;
import kg.mega.natv.service.DiscountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChannelsServiceImpl implements ChannelsService {
    private final ChannelsRepo channelsRepo;
    private final DiscountsService discountsService;

    @Override
    public ChannelsDto createChannels(ChannelsDto channelsDto) {
        channelsRepo.save(Channels
                .builder()
                .name(channelsDto.getName())
                .logo(channelsDto.getLogo())
                .isActive(true)
                .build());
        return channelsDto;
    }

    @Override
    public Channels findChannelsById(Long id) {
        Optional<Channels> optionalChannels = channelsRepo.findById(id);
        Channels channels = null;
        if (optionalChannels.isPresent()) {
            channels = optionalChannels.get();
        }
        return channels;
    }

    @Override
    public List<Channels> findAllChannels() {
        return channelsRepo.findAll();
    }

    @Override
    public Channels updateChannels(Channels channels) {
        return channelsRepo.save(channels);
    }

    @Override
    public Boolean deleteChannels(Long id) {
        Optional<Channels> optionalChannels = channelsRepo.findById(id);
        if (optionalChannels.isPresent()){
            Channels channels = optionalChannels.get();
            channels.setIsActive(false);
            channelsRepo.save(channels);
            return true;
        }
        return false;
    }

    @Override
    public List<ChannelDiscountDto> getChannelList(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        List<Channels> channels = channelsRepo.findAllByIsActiveTrueOrderByName(pageable);

        List<DiscountChDto> discountChDtos = discountsService.findDiscountsByChannelList(channels);

        List<ChannelDiscountDto> channelDiscountDtoList =
                channels.stream()
                        .map(x ->{
                            ChannelDiscountDto channelDiscountDto = new ChannelDiscountDto();
                            channelDiscountDto.setChannelId((x.getId()));
                            channelDiscountDto.setChannelName(x.getName());
                            channelDiscountDto.setChannelLogo(x.getLogo());

                            channelDiscountDto.setDiscount(
                                    discountChDtos.stream()
                                            .filter(y -> y.getChannelId().equals(x.getId()))
                                            .collect(Collectors.toList())
                            );

                            return channelDiscountDto;
                        })
                        .collect(Collectors.toList());

        return channelDiscountDtoList;
    }
}
