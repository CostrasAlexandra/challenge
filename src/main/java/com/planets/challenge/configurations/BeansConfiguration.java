package com.planets.challenge.configurations;

import com.planets.challenge.api.dto.PlanetDTO;
import com.planets.challenge.dao.CaptainDAO;
import com.planets.challenge.dao.PlanetDAO;
import com.planets.challenge.dao.ShuttleDAO;
import com.planets.challenge.dao.TeamDAO;
import com.planets.challenge.model.Planet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@Configuration
public class BeansConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(PlanetDAO planetDAO, CaptainDAO captainDAO, TeamDAO teamDAO, ShuttleDAO shuttleDAO){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
//                System.out.println(planetDAO.findByShortestDistance(1,2,3));
//                System.out.println(captainDAO.findAll().toString());
//                long x = 2;
//                System.out.println(captainDAO.findById(x).toString());
//                System.out.println(teamDAO.findById(x).get().getCaptain().getName());
//                //return teamDAO.findById(teamId).get().getCaptain().getName();
//                Planet planet = planetDAO.findById(x).get();
//                System.out.println(planet.toString());
//                System.out.println(planet.getShuttleId());
//                long teamId =shuttleDAO.findById(planet.getShuttleId()).get().getTeamId();
//                System.out.println(teamId);
//                System.out.println(teamDAO.findById(teamId).get().getCaptain().getName());
//                System.out.println();
//                for(Planet planet:planets){
//                    System.out.println(planet.getName());
//                    //System.out.println(planet.getShuttleId());
//                }

            }
        };
    }
}
