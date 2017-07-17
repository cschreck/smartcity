package de.ines.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * Created by Hambe on 13.07.2017.
 */
@NodeEntity
public class User {

    @GraphId
    public Long id;

    @Property
    public String name;

    @Property
    String real_ID;

    public User(){

    }
}
