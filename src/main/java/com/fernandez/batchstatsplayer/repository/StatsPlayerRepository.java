package com.fernandez.batchstatsplayer.repository;

import com.fernandez.batchstatsplayer.model.entity.StatsPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsPlayerRepository extends JpaRepository<StatsPlayer,Long> {
}
