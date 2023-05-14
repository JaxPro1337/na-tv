package kg.mega.natv.repository;

import kg.mega.natv.models.entity.OrderDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDaysRepo extends JpaRepository<OrderDays, Long> {
}
