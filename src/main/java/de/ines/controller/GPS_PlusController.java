package de.ines.controller;

import de.ines.domain.GPS_Plus;
import de.ines.services.GPS_PlusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Hambe on 16.07.2017.
 */

@RestController
@Component
public class GPS_PlusController {

    @Autowired
    GPS_PlusService gps_plusService;


    @RequestMapping(value = "/id", method = RequestMethod.GET)
    public int getGPS_PlusByRealID(@RequestParam("id") String id){
        System.out.println(gps_plusService);
        System.out.println(gps_plusService.searchGPS_PlusByRealID(id));
        return 10;
    }


}
