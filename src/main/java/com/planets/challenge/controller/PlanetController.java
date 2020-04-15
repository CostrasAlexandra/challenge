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
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<PlanetDTO> findTheClosestPlanet(@PathVariable long x, @PathVariable long y, @PathVariable long z) {
        return ResponseEntity.ok(planetService.findTheClosestPlanet(x, y, z));
    }

    @GetMapping("{id}/{x}/{y}/{z}")
    @ApiOperation(value = "AttendanceController.findTheClosestPlanetForThisShuttle", notes = "Find the closest planet for a shuttle by it's x,y,z")
    public ResponseEntity<PlanetDTO> findTheClosestPlanetForThisShuttle(@PathVariable long id,@PathVariable long x,
                                                   @PathVariable long y, @PathVariable long z)
    {
        return ResponseEntity.ok( planetService.findTheClosestPlanetForThisShuttle(id,x, y, z));
    }

    @PatchMapping("/{id}")
    @ApiOperation(value = "PlanetController.update", notes = "Update an existent planet")
    public ResponseEntity<PlanetDiscoveredDTO> update(@RequestBody final PlanetDiscoveredDTO planetDiscoveredDTO,
                         @PathVariable("id") final long id) {
        return ResponseEntity.ok(planetService.updatePlanet(id,planetDiscoveredDTO));
    }

    @PostMapping
    @ApiOperation(value = "PlanetController.add", notes = "Add a new planet")
    public ResponseEntity<Void> add(@RequestBody final Planet planet){
        planetService.addPlanet(planet);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "PlanetController.delete", notes = "Delete a planet")
    public ResponseEntity<Void> delete(@PathVariable("id") final long id){
        planetService.deletePlanet(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
