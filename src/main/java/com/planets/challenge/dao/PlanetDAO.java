package com.planets.challenge.dao;

import com.planets.challenge.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface PlanetDAO extends JpaRepository<Planet, Long> {

    @Query(nativeQuery = true, value = "select planet.id " +
            "from planets planet " +
            "where planet.status = 'TO_DO' " +
            "order by sqrt((:x - planet.x) ^ 2 + (:y - planet.y) ^ 2 + (:z - planet.z) ^ 2) " +
            "limit 1;")
    long findByShortestDistance(long x, long y, long z);

    @Query(nativeQuery = true, value = "select planet.id " +
            "from planets planet " +
            "where planet.status = 'TO_DO' and planet.shuttle_id = :shuttleId " +
            "order by sqrt((:x - planet.x) ^ 2 + (:y - planet.y) ^ 2 + (:z- planet.z) ^ 2) " +
            "limit 1;")
    long findClosestPlanetFromCurrentShuttle(long shuttleId, long x, long y, long z);


}
