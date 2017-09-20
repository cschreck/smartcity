package de.ines.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ines.domain.GpsPoint;
import de.ines.domain.Route;
import de.ines.services.GpsPointService;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.graphdb.GraphDatabaseService;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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
        CachingConnectionFactory test = new CachingConnectionFactory();
        test.setHost("127.0.0.1");
        test.setPassword("guest");
        gpsPointService.connectionFactory = test;
        RabbitTemplate t = new RabbitTemplate(gpsPointService.connectionFactory);
        t.setMessageConverter(new Jackson2JsonMessageConverter());
        gpsPointService.template = t;
    }


    @RequestMapping(value = "/{name}/saveRoute", method = RequestMethod.POST)
    public String saveRoute(@RequestBody String jsonRoute, @PathVariable String name){
        return gpsPointService.saveRoute(jsonRoute, name);

    }

    @RequestMapping(value = "/procedures", method = RequestMethod.GET)
    public Iterable<Map<String,Object>> callProcedures(){
        return gpsPointService.callProcedures();
    }

    @RequestMapping(value="/withinDistanceCall", method = RequestMethod.GET)
    public Iterable<Map<String,Object>> withinDistanceCall(@RequestParam(value="latitude")double latitude, @RequestParam(value="longitude")double longitude, @RequestParam(value="distance")int distance){
        return gpsPointService.withinDistanceCall(latitude, longitude, distance);
    }

}
