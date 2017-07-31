package de.ines.domain;

import org.neo4j.ogm.annotation.*;

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
    String realID;


    public User(){

    }

    public User(String name){
        this.name = name;
    }
}
