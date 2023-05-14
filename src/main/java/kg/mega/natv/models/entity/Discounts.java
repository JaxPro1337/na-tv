package kg.mega.natv.models.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
@Table(name = "discounts")
public class Discounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    Integer percent;
    @JoinColumn(name = "from_days_count")
    Integer fromDaysCount;
    @ManyToOne
    @JoinColumn(name = "channels",referencedColumnName = "id")
    Channels channels;
    @JoinColumn(name = "start_date")
    Timestamp startDate;
    @JoinColumn(name = "end_date")
    Timestamp entDate;

}
