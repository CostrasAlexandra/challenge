package com.planets.challenge.service;

import com.planets.challenge.api.dto.CaptainDTO;
import com.planets.challenge.api.dto.NewCaptainDTO;
import com.planets.challenge.api.dto.UpdateCaptainDTO;
import com.planets.challenge.api.exception.NotFoundException;
import com.planets.challenge.dao.CaptainDAO;
import com.planets.challenge.dao.TeamDAO;
import com.planets.challenge.model.Captain;
import com.planets.challenge.model.Team;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CaptainService {

    CaptainDAO captainDAO;
    TeamDAO teamDAO;
    CaptainConverter captainConverter;

    public Page<CaptainDTO> findAll(Pageable pageable) {
        Page<Captain> captainPage = captainDAO.findAll(pageable);
        return captainPage.map(captain -> captainConverter.convert(captain));
    }

    public void  save(NewCaptainDTO newCaptainDTO) {
        Captain captain = captainDAO.save(captainConverter.convert(newCaptainDTO));
        Team team = teamDAO.findById(newCaptainDTO.getTeamId())
                .orElseThrow(() -> new NotFoundException("Team with id" + newCaptainDTO.getTeamId() + "not found"))
                .setCaptainId(captain.getId());
        teamDAO.save(team);
    }

    public void deleteById(Long aLong) {
        Captain captain = captainDAO.findById(aLong)
                .orElseThrow(() -> new NotFoundException("Captain with id" + aLong + "not found"));
        captainDAO.deleteById(aLong);
        Team team = teamDAO.findById(captain.getTeamId())
                .orElseThrow(() -> new NotFoundException("Team with id" + captain.getTeamId() + "not found"));
    }

    public void update(long id, UpdateCaptainDTO updateCaptainDTO){
        Captain captain = captainDAO.findById(id)
                .orElseThrow(() -> new NotFoundException("Captain with id" + id + "not found"));
        captainDAO.save(captainConverter.update(captain, updateCaptainDTO));
    }
}
