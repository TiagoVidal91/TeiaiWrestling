package com.TeiaiWrestling.TeiaiWrestling.Repositories;

import com.TeiaiWrestling.TeiaiWrestling.Entities.Wrestler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrestlerRepository extends JpaRepository<Wrestler, Long> {

    List<Wrestler> findAll();
    List<Wrestler> findAllBySex(String sex);
}
