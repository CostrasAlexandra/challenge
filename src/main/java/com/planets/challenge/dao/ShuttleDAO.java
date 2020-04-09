package com.planets.challenge.dao;

import com.planets.challenge.model.Shuttle;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ShuttleDAO extends JpaRepository<Shuttle, Long> {

}
