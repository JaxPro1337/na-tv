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
@Table(name = "prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Double price;
    @JoinColumn(name = "start_date")
    Timestamp startDate;
    @JoinColumn(name = "end_date")
    Timestamp endDate;
    @ManyToOne
    @JoinColumn(name = "channels",referencedColumnName = "id")
    Channels channels;
}
