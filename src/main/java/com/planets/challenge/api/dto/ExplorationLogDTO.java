package com.planets.challenge.api.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel
@Data
@Accessors(chain = true)
public class ExplorationLogDTO {

    private long idRobot;

    private long idPlanet;

    private String robotName;

    private String planetName;
}
