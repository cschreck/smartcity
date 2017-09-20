package de.ines.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ines.domain.GpsPoint;
import de.ines.domain.Route;
import de.ines.domain.User;
import de.ines.repositories.GpsPointRepository;
import de.ines.repositories.RouteRepository;
import de.ines.repositories.UserRepository;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.amqp.core.*;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Hambe on 16.07.2017.
 */

@Service
public class GpsPointService{

    CachingConnectionFactory test = new CachingConnectionFactory();
    public ConnectionFactory connectionFactory;
    public AmqpTemplate template;


    @Autowired
    GpsPointRepository gpsPointRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    UserRepository userRepository;



    SessionFactory sessionFactory;





    public Iterable<Map<String,Object>> callProcedures(){
        return gpsPointRepository.findSpatialProcedures();
    }

    public String saveRoute(String jsonRoute, String name){
        sessionFactory = new SessionFactory("de.ines.domain");

        /*User user = userRepository.findByName(name);
        if(user == null){
            user = new User(name);
        }*/

            ObjectMapper mapper = new ObjectMapper();
            Route route = null;
            try {
                route = mapper.readValue(jsonRoute, Route.class);
                route.setFirstPoint(route.getRoute()[0]);
                route.setLastPoint(route.getRoute()[route.getRoute().length-1]);
                //route.setUser(user);
            } catch (Exception e) {

                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                System.out.println(cw.toString());
                return cw.toString();

            }



            for(int i = 0; i < route.getRoute().length; i++){
                GpsPoint gpsPoint = route.getRoute()[i];

                route.getRoute()[i]=gpsPoint;
                if(i < route.getRoute().length-1){
                    route.getRoute()[i].nextPoint = route.getRoute()[i+1];
                }

        }

        //routeRepository.save(route);
        Session session = sessionFactory.openSession();

        ArrayList<GpsPoint> gpsPoints = new ArrayList<GpsPoint>();
        for(int i = 0; i<route.getRoute().length; i++){
            route.getRoute()[i].nextPoint = null;
            gpsPoints.add(route.getRoute()[i]);
        }






        template.convertAndSend("myqueue2",route);
        //Route r = (Route)template.receiveAndConvert("myqueue2");


        return "Succesfull";
    }

    public Iterable<Map<String,Object>> withinDistanceCall(double latitude, double longitude, int distance){
        return gpsPointRepository.withinDistanceCall(latitude, longitude, distance);
    }


}
