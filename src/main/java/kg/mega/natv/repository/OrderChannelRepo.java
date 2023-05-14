package kg.mega.natv.repository;

import kg.mega.natv.models.entity.OrderChannels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderChannelRepo extends JpaRepository<OrderChannels, Long> {
}
