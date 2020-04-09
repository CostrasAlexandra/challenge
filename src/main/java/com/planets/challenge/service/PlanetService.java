package com.planets.challenge.service;

import com.planets.challenge.api.dto.PlanetDTO;
import com.planets.challenge.api.dto.PlanetDiscoveredDTO;
import com.planets.challenge.dao.PlanetDAO;
import com.planets.challenge.dao.RobotDAO;
import com.planets.challenge.dao.ShuttleDAO;
import com.planets.challenge.model.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;

@Service
@AllArgsConstructor
public class PlanetService {

    private PlanetDAO planetDAO;

    private ShuttleDAO shuttleDAO;

    private RobotDAO robotDAO;

    private PlanetConverter planetConverter;


    public Page<PlanetDTO> findAll(final Pageable pageable) {
        final Page<Planet> planetsPage = planetDAO.findAll(pageable);
        final List<Long> shuttlesIds = planetsPage.getContent().stream()
                .map(Planet::getShuttleId)
                .collect(Collectors.toList());
        final List<Shuttle> shuttles = shuttleDAO.findAllById(shuttlesIds);
        final Map<Long, Shuttle> shuttleMap = shuttles.stream().collect(Collectors.toMap(Shuttle::getId,
                shuttle -> shuttle));
        return planetsPage.map(planet -> planetConverter.convert(planet, shuttleMap));
    }

    public long findTheClosestPlanet(final long x, final long y, final long z) {
        return planetDAO.findByShortestDistance(x, y, z);
    }

    public long findTheClosestPlanetForThisShuttle(final long shuttleId, final long x, final long y, final long z){
        return planetDAO.findClosestPlanetFromCurrentShuttle(shuttleId,x,y,z);
    }

    public PlanetDiscoveredDTO updatePlanet(long id, PlanetDiscoveredDTO planetDiscoveredDTO){
        Set<Robot> robots = robotDAO.findAllByNameIn(new ArrayList<>(planetDiscoveredDTO.getRobots()));
        Planet planet = planetDAO
                .findById(id)
                .get()
                .setDescription(planetDiscoveredDTO.getDescription())
                .setStatus(planetDiscoveredDTO.getStatus())
                .setRobots(robots);
        Planet planetUpdated = planetDAO.save(planet);
        Team team = shuttleDAO
                .findById(planetUpdated.getShuttleId())
                .get()
                .getTeam();
        return planetConverter.convert(planetUpdated,team);



    }




}
