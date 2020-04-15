package com.planets.challenge.service;

import com.planets.challenge.api.dto.PlanetDTO;
import com.planets.challenge.api.dto.PlanetDiscoveredDTO;
import com.planets.challenge.api.exception.NotFoundException;
import com.planets.challenge.dao.PlanetDAO;
import com.planets.challenge.dao.RobotDAO;
import com.planets.challenge.dao.ShuttleDAO;
import com.planets.challenge.model.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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

    public PlanetDTO findTheClosestPlanet(final long x, final long y, final long z) {
        Planet planet =  planetDAO.findByShortestDistance(x, y, z);
        return planetConverter.convert(planet);
    }

    public PlanetDTO findTheClosestPlanetForThisShuttle(final long shuttleId, final long x, final long y, final long z){
        Planet planet = planetDAO.findClosestPlanetFromCurrentShuttle(shuttleId,x,y,z);
        return planetConverter.convert(planet);
    }

    public PlanetDiscoveredDTO updatePlanet(long id, PlanetDiscoveredDTO planetDiscoveredDTO){
        Set<Robot> robots = null;

        if(planetDiscoveredDTO.getRobots() != null && planetDiscoveredDTO.getRobots().size() != 0) {
            robots = robotDAO.findAllByNameIn(new ArrayList<>(planetDiscoveredDTO.getRobots()));
        }
            Planet planet = planetDAO
                    .findById(id)
                    .orElseThrow(() -> new NotFoundException("Planet with id: " + id + " not found"));

       planet = planetConverter.updatePlanetData(planet, planetDiscoveredDTO, robots);

        Planet planetUpdated = planetDAO.save(planet);
        Team team = shuttleDAO
                .findById(planetUpdated.getShuttleId())
                .orElseThrow(()-> new NotFoundException("Shuttle with id: "+planetUpdated.getShuttleId() +" not found"))
                .getTeam();

        return planetConverter.convert(planetUpdated,team);
    }

    public void addPlanet(Planet planet){
        Planet newPlanet = planetDAO.save(planet);
    }

    public void deletePlanet(long id) {
        planetDAO.deleteById(id);
    }


}
