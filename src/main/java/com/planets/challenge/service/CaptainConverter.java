package com.planets.challenge.service;

import com.planets.challenge.api.dto.CaptainDTO;
import com.planets.challenge.api.dto.NewCaptainDTO;
import com.planets.challenge.api.dto.UpdateCaptainDTO;
import com.planets.challenge.model.Captain;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CaptainConverter {

    public CaptainDTO convert (Captain captain){
        return new CaptainDTO().setId(captain.getId())
                .setName(captain.getName())
                .setUsername(captain.getUsername())
                .setTeamId(captain.getTeamId());
    }

    public Captain convert (NewCaptainDTO captain){
        return new Captain().setId(captain.getId())
                .setName(captain.getName())
                .setUsername(captain.getUsername())
                .setTeamId(captain.getTeamId())
                .setPassword(captain.getPassword());
    }
    public Captain convert (CaptainDTO captainDTO){
        return new Captain()
                .setName(captainDTO.getName())
                .setTeamId(captainDTO.getTeamId())
                .setUsername(captainDTO.getUsername())
                .setId(captainDTO.getId());
    }

    public Captain update (Captain captain, UpdateCaptainDTO updateCaptainDTO){

        if(updateCaptainDTO.getUsername() != null){
            captain.setUsername(updateCaptainDTO.getUsername());
        }

        if(updateCaptainDTO.getPassword() != null){
            captain.setPassword(updateCaptainDTO.getPassword());
        }

        return captain;
    }
}
