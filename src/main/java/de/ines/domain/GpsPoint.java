package de.ines.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Created by Hambe on 11.07.2017.
 */
@NodeEntity
public class GpsPoint {

    @GraphId
    public Long id;

    @Relationship(type="Test", direction = Relationship.INCOMING)
    public GpsPoint lastPoint;

    @Relationship(type="Test", direction = Relationship.OUTGOING)
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
    public int realID;


    public GpsPoint(){

    }

    public GpsPoint(GpsPoint lastPoint, GpsPoint nextPoint, int realID){
        this.nextPoint = nextPoint;
        this.lastPoint = lastPoint;
        this.realID = realID;
    }
}
