package com.fernandez.batchtest.repository;

import com.fernandez.batchtest.model.entity.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ResultsRepository extends JpaRepository<Results,Long> {
    Set<String> findMatchIdsByMatchIdIn(Set<String> matchIds);
}
