package de.ines.services;

import de.ines.domain.GpsPoint;
import de.ines.repositories.GpsPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Hambe on 16.07.2017.
 */

@Service
public class GpsPointService {

    @Autowired
    GpsPointRepository repository;

    public GpsPoint searchGpsPointByRealID(int realID){
        return repository.findByRealID(realID);
    }

    public void saveGpsPoint(GpsPoint gpsPoint){
        repository.save(gpsPoint);
    }
}
