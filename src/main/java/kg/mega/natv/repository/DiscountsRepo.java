package kg.mega.natv.repository;

import kg.mega.natv.models.dto.DiscountChDto;
import kg.mega.natv.models.dto.DiscountDto;
import kg.mega.natv.models.dto.OrderChannelDto;
import kg.mega.natv.models.entity.Channels;
import kg.mega.natv.models.entity.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountsRepo extends JpaRepository<Discounts, Long> {

    @Query("select new kg.mega.natv.models.dto.DiscountChDto (u.percent, u.fromDaysCount, u.channels.id) from Discounts u where u.channels.id = ?1 and u.fromDaysCount <= ?2 and current_timestamp between u.startDate and u.entDate")
    List<DiscountDto> findAllByChannels(Long channelId, Integer quantityDays);

    @Query("select new kg.mega.natv.models.dto.DiscountChDto (u.percent, u.fromDaysCount, u.channels.id) from Discounts u where u.channels in (?1) and current_timestamp between u.startDate and u.entDate")
    List<DiscountChDto> findActiveDiscountsByChannels(List<Channels> channelIds);

}
