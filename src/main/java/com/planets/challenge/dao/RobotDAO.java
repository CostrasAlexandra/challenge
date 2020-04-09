package com.planets.challenge.dao;

import com.planets.challenge.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Set;

@Transactional
public interface RobotDAO extends JpaRepository<Robot, Long> {

    Set<Robot> findAllByNameIn(Collection<String> name);
}
