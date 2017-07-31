package de.ines.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.ines.domain.GpsPoint;
import de.ines.domain.Route;
import de.ines.domain.User;
import de.ines.repositories.GpsPointRepository;
import de.ines.repositories.RouteRepository;
import de.ines.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

/**
 * Created by Hambe on 16.07.2017.
 */

@Service
public class GpsPointService {

    @Autowired
    GpsPointRepository gpsPointRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    UserRepository userRepository;

    public GpsPoint searchGpsPointByRealID(int realID){
        return gpsPointRepository.findByRealID(realID);
    }

    public void saveGpsPoint(GpsPoint gpsPoint){
        gpsPointRepository.save(gpsPoint);
    }

    public Iterable<Map<String,Object>> callProcedures(){
        return gpsPointRepository.findSpatialProcedures();
    }

    public String saveRoute(String jsonRoute){

        User user = userRepository.findByName("Felix");
        if(user == null){
            user = new User("Felix");
        }

            ObjectMapper mapper = new ObjectMapper();
            Route route = null;
            try {
                route = mapper.readValue(jsonRoute, Route.class);
                route.setFirstPoint(route.getRoute()[0]);
                route.setLastPoint(route.getRoute()[route.getRoute().length-1]);
                route.setUser(user);
            } catch (Exception e) {

                CharArrayWriter cw = new CharArrayWriter();
                PrintWriter w = new PrintWriter(cw);
                e.printStackTrace(w);
                w.close();
                System.out.println(cw.toString());
                return cw.toString();

            }

            for(int i = 0; i < route.getRoute().length; i++){
                if(i < route.getRoute().length-1){
                    route.getRoute()[i].nextPoint = route.getRoute()[i+1];
                }

                routeRepository.save(route);

        }

        return "Succesfull";
    }


}
