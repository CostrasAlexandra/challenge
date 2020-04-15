package com.planets.challenge.controller;

import com.planets.challenge.api.dto.ExplorationLogDTO;
import com.planets.challenge.api.dto.PlanetDTO;
import com.planets.challenge.model.ExplorationLog;
import com.planets.challenge.model.Planet;
import com.planets.challenge.service.ExplorationLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "ExplorationController")
@RestController
@RequestMapping("/explorationLog")
@AllArgsConstructor
public class ExplorationLogController {

    ExplorationLogService explorationLogService;

    @GetMapping
    @ApiOperation(value = "ExplorationLogController.findAll", notes = "Find all explorationLog")
    public Page<ExplorationLogDTO> findAll(Pageable pageable) {
        return explorationLogService.findAll(pageable);
    }

    @PostMapping
    @ApiOperation(value = "PlanetController.add", notes = "Add a new explorationLog")
    public ResponseEntity<Void> add(@RequestBody final ExplorationLogDTO explorationLogDTO){
        explorationLogService.save(explorationLogDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{idRobot}/{idPlanet}")
    @ApiOperation(value = "PlanetController.delete", notes = "Delete an explorationLog")
    public ResponseEntity<Void> delete(@PathVariable("idRobot") final long idRobot, @PathVariable("idPlanet") final long idPlanet){
        explorationLogService.deleteById(idRobot, idPlanet);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

//    @PutMapping("/{idRobot}/{idPlanet}")
//    @ApiOperation(value = "PlanetController.update", notes = "Update an ExplorationLog")
//    public ResponseEntity<Void> update(@PathVariable("idRobot") final long idRobot, @PathVariable("idPlanet") final long idPlanet,
//                                       @RequestBody final ExplorationLogDTO explorationLogDTO){
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
}
