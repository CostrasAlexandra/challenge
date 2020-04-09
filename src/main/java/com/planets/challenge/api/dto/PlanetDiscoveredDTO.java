package com.planets.challenge.api.dto;

import com.planets.challenge.model.PlanetVisitationStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@ApiModel
@Data
@Accessors(chain = true)
public class PlanetDiscoveredDTO {

    private String description;

    private PlanetVisitationStatus status;

    private Set<String> robots;

    private long captainId;

}

