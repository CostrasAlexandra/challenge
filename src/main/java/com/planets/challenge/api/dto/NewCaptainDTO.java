package com.planets.challenge.api.dto;


import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

@ApiModel
@Data
@Accessors(chain = true)
public class NewCaptainDTO {
    private long id;

    private String username;

    private String name;

    private long teamId;

    private String password;
}
