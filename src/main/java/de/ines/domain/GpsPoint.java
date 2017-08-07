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

    @Relationship(type="nextPoint")
    public GpsPoint nextPoint;

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
    public String uniqueID;







    @Property
    public int realID;


    public GpsPoint(){
    }

    public GpsPoint(GpsPoint lastPoint, GpsPoint nextPoint, int realID){
        this.nextPoint = nextPoint;
        this.realID = realID;
    }

}
