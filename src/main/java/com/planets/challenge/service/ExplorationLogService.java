package com.planets.challenge.service;

import com.planets.challenge.api.dto.ExplorationLogDTO;
import com.planets.challenge.api.exception.NotFoundException;
import com.planets.challenge.dao.ExplorationLogDAO;
import com.planets.challenge.model.ExplorationLog;
import com.planets.challenge.model.Planet;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;


@Service
@AllArgsConstructor
public class ExplorationLogService {

    private ExplorationLogDAO explorationLogDAO;
    private ExplorationLogConverter explorationLogConverter;

    public Page<ExplorationLogDTO> findAll(Pageable pageable) {

        final Page<ExplorationLog> explorationLogPage = explorationLogDAO.findAll(pageable);
        return explorationLogPage.map(explorationLog -> explorationLogConverter.convert(explorationLog));

    }

    public void deleteById(long idRobot, long idPlanet) {
        ExplorationLog.ExplorationLogId explorationLogId = new ExplorationLog.ExplorationLogId()
                .setPlanetId(idPlanet).setRobotId(idRobot);
        explorationLogDAO.deleteById(explorationLogId);
    }

    public ExplorationLogDTO save(ExplorationLogDTO explorationLogDTO) {
         ExplorationLog explorationLog = explorationLogDAO.save(explorationLogConverter.convert(explorationLogDTO));
         return explorationLogDTO;
    }

//    public void update(long idRobot, long idPlanet, ExplorationLogDTO explorationLogDTO){
//        ExplorationLog.ExplorationLogId explorationLogId = new ExplorationLog.ExplorationLogId()
//                .setPlanetId(idPlanet).setRobotId(idRobot);
//        ExplorationLog explorationLog = explorationLogDAO.findById(explorationLogId)
//                .orElseThrow(() -> new NotFoundException("ExplorationLog with idRobot" + idRobot + " and "+ idPlanet +" not found"));;
//
//        explorationLogDAO.save(explorationLogConverter.convert(explorationLogDTO));
//    }
}
