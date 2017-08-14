package de.ines.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.ArrayList;

/**
 * Created by Hambe on 23.07.2017.
 */

public class Route {

    public Long id;

    @Transient
    public GpsPoint[] route;

    public int routeID;

    @Relationship(type="nextPoint", direction = Relationship.OUTGOING)
    private GpsPoint firstPoint;

    @Relationship(type="lastPoint", direction = Relationship.OUTGOING)
    private GpsPoint lastPoint;

    @Relationship(type="belongs_to", direction = Relationship.OUTGOING)
    public User user;

    @JsonCreator
    public Route(){
    }

    public GpsPoint[] getRoute(){
        return this.route;
    }

    public void setRoute(GpsPoint[] route){
        this.route = route;
    }

    public void setFirstPoint(GpsPoint firstPoint) {
        this.firstPoint = firstPoint;
    }

    public void setLastPoint(GpsPoint lastPoint) {
        this.lastPoint = lastPoint;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public int getRouteID() {
        return routeID;
    }

    public void setRouteID(int routeID) {
        this.routeID = routeID;
    }

}
