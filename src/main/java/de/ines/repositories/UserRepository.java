package de.ines.repositories;

import de.ines.domain.User;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

/**
 * Created by Hambe on 13.07.2017.
 */
public interface UserRepository extends Neo4jRepository<User, Long> {

    //@Query("MATCH (:Actor {name:{0}})-[:ACTED_IN]->(m:Movie) return m")
    List<User> findByName(String name);
}
