package kg.mega.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import kg.mega.natv.models.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.mapstruct.Mapping;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderResponseDto {

    @JsonProperty("order_id")
    Long orderId;
    Status status;
    @JsonProperty("total_price")
    Double totalPrice;
    @JsonProperty("total_after_discount")
    Double totalAfterDiscount;

}
