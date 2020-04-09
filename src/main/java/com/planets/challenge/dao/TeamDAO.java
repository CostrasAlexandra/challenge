package com.planets.challenge.dao;

import com.planets.challenge.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface TeamDAO extends JpaRepository<Team,Long> {
}
