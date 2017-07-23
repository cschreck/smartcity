package de.ines.controller;

import de.ines.domain.Route;
import de.ines.services.GpsPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Hambe on 16.07.2017.
 */

@RestController
public class GpsPointController {

    final GpsPointService gpsPointService;

    @Autowired
    public GpsPointController(GpsPointService gpsPointService) {
        this.gpsPointService = gpsPointService;
    }

    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public int getGPS_PlusByRealID(@RequestParam("id") String id){

        return 10;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public void saveGPS_Plus(@RequestParam("route") Route route){
        for(int i = 0; i < route.getRoute().size(); i++){
            gpsPointService.saveGpsPoint(route.getRoute().get(i));
        }
    }


}
