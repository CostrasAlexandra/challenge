package com.planets.challenge.api.dto;

import com.planets.challenge.model.PlanetVisitationStatus;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@ApiModel
@Accessors(chain = true)
public class NewPlanetDTO {

    private String name;

    private byte[] image;

    private String description;

    private long x;

    private long y;

    private long z;

    private PlanetVisitationStatus status;

    private long shuttleId;

    private Set<String> robots;
}
