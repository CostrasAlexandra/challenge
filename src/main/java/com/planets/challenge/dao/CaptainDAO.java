package com.planets.challenge.dao;

import com.planets.challenge.model.Captain;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CaptainDAO extends JpaRepository<Captain,Long> {
}
