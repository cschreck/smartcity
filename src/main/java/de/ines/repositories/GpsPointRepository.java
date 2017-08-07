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

    @Query("MATCH (n:GpsPoint{latitude:{latitude}}) WITH n call spatial.addNode('GpsPoints', n) YIELD node return node")
    void addGpsPointToIndex(@Param("latitude") double latitude);


    @Query("CALL spatial.")
    GpsPoint findWithinDistance();

}
