package de.ines.repositories;

import de.ines.domain.GpsPoint;
import de.ines.domain.Route;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Hambe on 26.07.2017.
 */

@Repository
public interface RouteRepository extends Neo4jRepository<Route, Long> {

}
