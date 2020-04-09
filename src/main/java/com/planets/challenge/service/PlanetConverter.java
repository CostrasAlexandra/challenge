package com.planets.challenge.service;

import com.planets.challenge.api.dto.PlanetDTO;
import com.planets.challenge.api.dto.PlanetDiscoveredDTO;
import com.planets.challenge.model.Planet;
import com.planets.challenge.model.Robot;
import com.planets.challenge.model.Shuttle;
import com.planets.challenge.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PlanetConverter {

    public PlanetDTO convert(final Planet planet, final Map<Long, Shuttle> shuttleMap) {

        final Team team = shuttleMap.get(planet.getShuttleId()).getTeam();
        final String captainName = team.getCaptain().getName();
        final Set<String> robotsNames = team.getRobots().stream().map(Robot::getName).collect(Collectors.toSet());

        return new PlanetDTO()
                .setName(planet.getName())
                .setImage(planet.getImage())
                .setDescription(planet.getDescription())
                .setStatus(planet.getStatus())
                .setCaptainName(captainName)
                .setRobotsName(robotsNames);

    }

    public PlanetDiscoveredDTO convert(final Planet planet, final Team team){
        final Set<String> robotsNames = team.getRobots().stream().map(Robot::getName).collect(Collectors.toSet());
        final long captainId = team.getCaptainId();
        return new PlanetDiscoveredDTO()
                .setDescription(planet.getDescription())
                .setStatus(planet.getStatus())
                .setRobots(robotsNames)
                .setCaptainId(captainId);
    }

}
