package de.ines.repositories;

import de.ines.domain.GPS_Plus;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hambe on 11.07.2017.
 */

@Repository
public interface GPS_PlusRepository extends Neo4jRepository<GPS_Plus, Long> {

    GPS_Plus findByRealID(@Param("realID")String realID);



}
