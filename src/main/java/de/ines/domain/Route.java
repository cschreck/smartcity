package de.ines.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;

/**
 * Created by Hambe on 23.07.2017.
 */

public class Route {

    public Long id;

    //@Relationship(type="routePoint", direction = Relationship.OUTGOING)
    public GpsPoint[] route;

    @JsonCreator
    public Route(){

    }

    public GpsPoint[] getRoute(){
        return this.route;
    }

    public void setRoute(GpsPoint[] route){
        this.route = route;
    }

}
