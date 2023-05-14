package kg.mega.natv.controller;

import kg.mega.natv.models.dto.ChannelDiscountDto;
import kg.mega.natv.models.dto.ChannelsDto;
import kg.mega.natv.models.entity.Channels;
import kg.mega.natv.service.ChannelsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/channels")
public class ChannelsController {

    private final ChannelsService channelsService;

    @PostMapping("/create")
    public ResponseEntity<?>createChannels(@RequestBody ChannelsDto channelsDto){
        return ResponseEntity.ok(channelsService.createChannels(channelsDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> findChannelsById(@PathVariable Long id){
        return ResponseEntity.ok(channelsService.findChannelsById(id));
    }
    @GetMapping("/find-all")
    public ResponseEntity<?> findAllChannels(){
        return ResponseEntity.ok(channelsService.findAllChannels());
    }
    @PutMapping("/update")
    public ResponseEntity<?> updateChannels(@RequestBody Channels channels){
        return ResponseEntity.ok(channelsService.updateChannels(channels));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChannels(@PathVariable Long id){
        return ResponseEntity.ok(channelsService.deleteChannels(id));
    }

    @GetMapping("/list")
    public ResponseEntity<?> getChannelList(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "9") Integer pageSize
    ){
        List<ChannelDiscountDto> channelDiscountDtoList =
                channelsService.getChannelList(pageNo, pageSize);


        return ResponseEntity.ok(channelDiscountDtoList);
    }


}
