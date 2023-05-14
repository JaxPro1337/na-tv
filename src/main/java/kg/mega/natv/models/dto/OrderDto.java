package kg.mega.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDto {

    @JsonProperty("adj_text")
    String adjText;
    @JsonProperty("phone_number")
    String phoneNumber;
    String email;
    String customer;
    List<OrderChannelDto> channels;


}
