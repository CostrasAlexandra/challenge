package com.planets.challenge.controller;

import com.planets.challenge.api.dto.CaptainDTO;
import com.planets.challenge.api.dto.ExplorationLogDTO;
import com.planets.challenge.api.dto.NewCaptainDTO;
import com.planets.challenge.api.dto.UpdateCaptainDTO;
import com.planets.challenge.service.CaptainService;
import com.planets.challenge.service.ExplorationLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "CaptainController")
@RestController
@RequestMapping("/captains")
@AllArgsConstructor
public class CaptainController {
    CaptainService captainService;

    @GetMapping
    @ApiOperation(value = "CaptainController.findAll", notes = "Find all captains")
    public Page<CaptainDTO> findAll(Pageable pageable) {
        return captainService.findAll(pageable);
    }

    @PostMapping
    @ApiOperation(value = "CaptainController.add", notes = "Add a new captain")
    public ResponseEntity<Void> add(@RequestBody final NewCaptainDTO newCaptainDTO){
        captainService.save(newCaptainDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "CaptainController.delete", notes = "Delete a captain")
    public ResponseEntity<Void> delete(@PathVariable("id") final long id){
        captainService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/id")
    @ApiOperation(value = "CaptainController.update", notes = "Update a captain")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody final UpdateCaptainDTO updateCaptainDTO){
        captainService.update(id,updateCaptainDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
