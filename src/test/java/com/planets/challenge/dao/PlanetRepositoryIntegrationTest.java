package com.planets.challenge.dao;

import com.planets.challenge.model.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@ActiveProfiles("test")
@TestPropertySource("classpath:application-test.properties")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PlanetRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlanetDAO planetDAO;
    private Planet planet = new Planet().setName("Planet");

    @BeforeEach
    public void arrange() {
        planet = entityManager.persist(planet);
        entityManager.flush();
    }

    @Test
    public void findAll() {
        assert  planetDAO.findAll().size()==1;
        assert true;
    }



}
