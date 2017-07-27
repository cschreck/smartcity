package de.ines.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.*;

/**
 * Created by Hambe on 11.07.2017.
 */
@NodeEntity
public class GpsPoint {

    @GraphId
    public Long id;

    @Relationship(type="lastPoint", direction = Relationship.INCOMING)
    public GpsPoint lastPoint;

    @Relationship(type="nextPoint", direction = Relationship.INCOMING)
    public GpsPoint nextPoint;

    @Relationship(type="user", direction = Relationship.INCOMING)
    public User user;

    @Property
    public long date;

    @Property
    public double latitude;

    @Property
    public double longitude;

    @Property
    public double heading;

    @Property
    public double speed;

    @Property
    public double acceleration;




    @Property
    @Index
    public int realID;


    public GpsPoint(){

    }

    public GpsPoint(GpsPoint lastPoint, GpsPoint nextPoint, int realID){
        this.nextPoint = nextPoint;
        this.lastPoint = lastPoint;
        this.realID = realID;
    }


    public void setUser(User user) {
        this.user = user;
    }
}
