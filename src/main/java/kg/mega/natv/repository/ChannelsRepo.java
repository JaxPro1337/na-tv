package kg.mega.natv.repository;


import kg.mega.natv.models.entity.Channels;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ChannelsRepo extends JpaRepository<Channels, Long> {

    List<Channels> findAllByIsActiveTrueOrderByName(Pageable pageable);



}
