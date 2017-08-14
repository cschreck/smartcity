package de.ines.repositories;

import de.ines.domain.GpsPoint;
import de.ines.domain.Route;
import de.ines.domain.User;
import org.neo4j.driver.v1.GraphDatabase;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by Hambe on 11.07.2017.
 */

@Repository
public interface GpsPointRepository extends Neo4jRepository<GpsPoint, Long> {

    GpsPoint findByRealID(@Param("realID")int realID);

    @Query("CALL spatial.procedures")
    Iterable<Map<String,Object>> findSpatialProcedures();

    @Query("match(n:Route{routeID:{routeID}})-[:nextPoint*]->(g:GpsPoint) with collect( g) as nodes call spatial.addNodes('GpsPoints', nodes) YIELD count return nodes")
    void addGpsPointToIndex(@Param("routeID") int routeID);

    @Query("call spatial.withinDistance('GpsPoints',{latitude:{latitude}, longitude:{longitude}},{distance}) YIELD node return node")
    Iterable<Map<String,Object>> withinDistanceCall(@Param("latitude")double latitude, @Param("longitude")double longitude, @Param("distance")int distance);

}
