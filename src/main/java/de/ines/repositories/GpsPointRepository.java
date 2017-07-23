package de.ines.repositories;

import de.ines.domain.GpsPoint;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Hambe on 11.07.2017.
 */

@Repository
public interface GpsPointRepository extends Neo4jRepository<GpsPoint, Long> {

    GpsPoint findByRealID(@Param("realID")int realID);




}
