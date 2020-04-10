package com.planets.challenge.service;

import com.planets.challenge.dao.PlanetDAO;
import com.planets.challenge.dao.RobotDAO;
import com.planets.challenge.dao.ShuttleDAO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@RunWith(SpringRunner.class)
class PlanetServiceTest {

    @Autowired
    PlanetDAO planetDAO;
    @Autowired
    ShuttleDAO shuttleDAO;
    @Autowired
    RobotDAO robotDAO;
    @Autowired
    PlanetConverter planetConverter;
    @TestConfiguration
    static class PlanetServiceImplTestContextConfiguration {

//        @Bean
//        public PlanetService employeeService() {
//            return new PlanetService(planetDAO,shuttleDAO,robotDAO,planetConverter);
//        }
    }

    @Test
    void findAll() {
        shuttleDAO.findAll();
    }

    @Test
    void findTheClosestPlanet() {
    }

    @Test
    void findTheClosestPlanetForThisShuttle() {
    }

    @Test
    void updatePlanet() {
    }
}