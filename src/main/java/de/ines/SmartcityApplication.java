package de.ines;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.ines.domain.GpsPoint;
import de.ines.domain.Route;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;

import java.io.CharArrayWriter;
import java.io.PrintWriter;

@SpringBootApplication
@EntityScan("de.ines.domain")
public class SmartcityApplication {

	public static void main(String[] args) {

		SpringApplication.run(SmartcityApplication.class, args);

	}

}
