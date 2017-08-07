package de.ines.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ines.domain.Route;
import de.ines.services.GpsPointService;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.gis.spatial.SpatialDatabaseService;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Map;

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


    @RequestMapping(value = "/{name}/saveRoute", method = RequestMethod.POST)
    public String saveRoute(@RequestBody String jsonRoute, @PathVariable String name){
        return gpsPointService.saveRoute(jsonRoute, name);

    }

    @RequestMapping(value = "/procedures", method = RequestMethod.GET)
    public Iterable<Map<String,Object>> callProcedures(){
        return gpsPointService.callProcedures();
    }


}
