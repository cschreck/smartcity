package de.ines.repositories;

import de.ines.domain.User;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Hambe on 13.07.2017.
 */
@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    User findByName(@Param("name") String name);
}
