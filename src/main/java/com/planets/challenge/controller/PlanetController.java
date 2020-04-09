package com.planets.challenge.controller;

import com.planets.challenge.api.dto.PlanetDTO;
import com.planets.challenge.api.dto.PlanetDiscoveredDTO;
import com.planets.challenge.model.Planet;
import com.planets.challenge.service.PlanetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "PlanetController")
@RestController
@RequestMapping("/planet")
@AllArgsConstructor
public class PlanetController {

    private PlanetService planetService;

    @GetMapping
    @ApiOperation(value = "AttendanceController.findAll", notes = "Find all requests")
    public Page<PlanetDTO> findAll(Pageable pageable) {
        return planetService.findAll(pageable);
    }

    @GetMapping("/{x}/{y}/{z}")
    @ApiOperation(value = "AttendanceController.findTheClosestPlanet", notes = "Find the closest planet by x,y,z")
    public long findTheClosestPlanet(@PathVariable long x, @PathVariable long y, @PathVariable long z) {
        return planetService.findTheClosestPlanet(x, y, z);
    }

    @GetMapping("{id}/{x}/{y}/{z}")
    @ApiOperation(value = "AttendanceController.findTheClosestPlanetForThisShuttle", notes = "Find the closest planet for a shuttle by it's x,y,z")
    public long findTheClosestPlanetForThisShuttle(@PathVariable long id,@PathVariable long x,
                                                   @PathVariable long y, @PathVariable long z)
    {
        return planetService.findTheClosestPlanetForThisShuttle(id,x, y, z);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "PlanetController.update", notes = "Update an existent planet")
    public ResponseEntity<PlanetDiscoveredDTO> update(@Valid @RequestBody final PlanetDiscoveredDTO planetDiscoveredDTO,
                         @PathVariable("id") final long id) {
        return ResponseEntity.ok(planetService.updatePlanet(id,planetDiscoveredDTO));
    }
}
