package kg.mega.natv.models.entity;

import jakarta.persistence.*;
import kg.mega.natv.models.enums.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String customersName;
    String phoneNumber;
    String email;
    String orderText;
    Status status;
    Double totalPrice;
    Double totalAfterDiscount;
    Date createAt;
    Date updateAt;

    @PrePersist
    public void setCreateAt() {
        this.createAt = new Date();
    }

    @PreUpdate
    public void setUpdateAt() {
        this.updateAt = new Date();
    }
}
