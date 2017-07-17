package de.ines;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SmartcityApplication {


	public static void main(String[] args) {


		//SessionFactory test = new SessionFactory();
		SpringApplication.run(SmartcityApplication.class, args);


		/*Session session = factory.openSession();

		GPS_Plus ersterWert = new GPS_Plus(null, null,5);
		GPS_Plus zweiter = new GPS_Plus(ersterWert,null,15);
		GPS_Plus dritter = new GPS_Plus(zweiter, null,25);
		GPS_Plus vierter = new GPS_Plus(dritter, ersterWert, 35);

		session.save(ersterWert);
		session.save(zweiter);
		session.save(dritter);
		session.save(vierter);
		session.clear();*/


	}

}
