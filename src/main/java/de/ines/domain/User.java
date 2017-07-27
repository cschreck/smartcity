package de.ines.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
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
    @Index
    public String name;

    @Property
    String realID;

    public User(){

    }

    public User(String name){
        this.name = name;
    }
}
