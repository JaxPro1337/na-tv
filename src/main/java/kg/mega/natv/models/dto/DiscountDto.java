package kg.mega.natv.models.dto;

import jakarta.persistence.JoinColumn;
import kg.mega.natv.models.entity.Channels;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class DiscountDto {
    Integer percent;
    @JoinColumn(name = "from_days_count")
    Integer fromDaysCount;

    Channels channels;
    @JoinColumn(name = "start_date")
    Timestamp startDate;
    @JoinColumn(name = "end_date")
    Timestamp entDate;

}
