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

    public String saveRoute(String jsonRoute){
        Date startTime = new Date();

        User user = userRepository.findByName("Felix");
        if(user == null){
            user = new User("Felix");
        }
        for(int j = 0; j < 50000; j++){
            ObjectMapper mapper = new ObjectMapper();
            Route route = null;
            try {
                route = mapper.readValue(jsonRoute, Route.class);
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
                }else {
                    route.getRoute()[i].setUser(user);
                }
                if(i > 0){
                    route.getRoute()[i].lastPoint = route.getRoute()[i-1];
                }else {

                    route.getRoute()[i].setUser(user);
                }
                //saveGpsPoint(route.getRoute()[i]);
            }
                routeRepository.save(route);

        }

        Date endTime = new Date();
        System.out.println((double)(endTime.getTime()-startTime.getTime())/1000);
        return "Succesfull";
    }


}
