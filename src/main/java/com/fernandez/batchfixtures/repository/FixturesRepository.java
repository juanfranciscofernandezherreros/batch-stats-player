package com.fernandez.batchfixtures.repository;

import com.fernandez.batchfixtures.model.entity.Fixtures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FixturesRepository extends JpaRepository<Fixtures,Long> {
}
