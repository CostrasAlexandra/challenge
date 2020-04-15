package com.planets.challenge.service;

import com.planets.challenge.api.dto.ExplorationLogDTO;
import com.planets.challenge.model.ExplorationLog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ExplorationLogConverter {

    public ExplorationLogDTO convert (ExplorationLog explorationLog){
        return new ExplorationLogDTO().setIdPlanet(explorationLog.getPlanet().getId())
                .setIdRobot(explorationLog.getRobot().getId())
                .setPlanetName(explorationLog.getPlanet().getName())
                .setRobotName(explorationLog.getRobot().getName());
    }

    public ExplorationLog convert (ExplorationLogDTO explorationLogDTO){
        return new ExplorationLog().setId(
                new ExplorationLog.ExplorationLogId()
                .setPlanetId(explorationLogDTO.getIdPlanet())
                        .setRobotId(explorationLogDTO.getIdRobot()));
    }



}
