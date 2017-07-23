package de.ines.domain;

import java.util.ArrayList;

/**
 * Created by Hambe on 23.07.2017.
 */

public class Route {

    private ArrayList<GpsPoint> route;

    public Route(ArrayList<GpsPoint> route){
        this.route = route;
    }

    public ArrayList<GpsPoint> getRoute(){
        return this.route;
    }

}
