package com.TeiaiWrestling.TeiaiWrestling.Repositories;

import com.TeiaiWrestling.TeiaiWrestling.Entities.WrestlingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrestlingCardRepository extends JpaRepository<WrestlingCard, Long> {

    @Override
    List<WrestlingCard> findAll();

    WrestlingCard findWrestlingCardByWrestlerWrestlerName(String wrestlerName);

}
