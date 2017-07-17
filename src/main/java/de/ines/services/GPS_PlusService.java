package de.ines.services;

import de.ines.domain.GPS_Plus;
import de.ines.repositories.GPS_PlusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Hambe on 16.07.2017.
 */

@Service
@Component
public class GPS_PlusService {

    @Autowired GPS_PlusRepository repository;

    public GPS_Plus searchGPS_PlusByRealID(String realID){
        System.out.println(repository);
        return repository.findByRealID(realID);
    }
}
