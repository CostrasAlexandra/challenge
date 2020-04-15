package com.planets.challenge.dao;

import com.planets.challenge.model.ExplorationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface ExplorationLogDAO extends JpaRepository<ExplorationLog, ExplorationLog.ExplorationLogId> {
    @Override
    Optional<ExplorationLog> findById(ExplorationLog.ExplorationLogId explorationLogId);
}
