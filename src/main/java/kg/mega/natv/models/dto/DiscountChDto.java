package kg.mega.natv.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DiscountChDto {

    int percent;

    @JsonProperty("from_days_count")
    int fromDaysCount;

    @JsonIgnore
    Long channelId;

    public DiscountChDto(int percent, int fromDaysCount, Long channelId) {
        this.percent = percent;
        this.fromDaysCount = fromDaysCount;
        this.channelId = channelId;
    }
}
