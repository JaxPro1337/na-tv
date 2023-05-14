package kg.mega.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelDiscountDto {

    @JsonProperty("channel_id")
    Long channelId;

    @JsonProperty("channel_name")
    String channelName;

    @JsonProperty("logo")
    String channelLogo;

    List<DiscountChDto> discount;



}
