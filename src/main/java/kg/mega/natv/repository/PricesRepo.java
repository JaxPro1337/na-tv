package kg.mega.natv.repository;

import kg.mega.natv.models.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PricesRepo extends JpaRepository<Prices, Long> {

    @Query("select  p from Prices p where  p.channels.id = ?1 and current_timestamp between p.startDate and p.endDate")
    Prices getPriceByChannel(Long channelId);
}
