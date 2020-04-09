package com.planets.challenge.api.dto;

import com.planets.challenge.model.PlanetVisitationStatus;
import lombok.Data;
import lombok.experimental.Accessors;
import io.swagger.annotations.ApiModel;

import java.util.HashSet;
import java.util.Set;

@ApiModel
@Data
@Accessors(chain = true)
public class PlanetDTO {

    private String name;

    private byte[] image;

    private String description;

    private String captainName;

    private PlanetVisitationStatus status;

    private Set<String> robotsName = new HashSet<>();
}
