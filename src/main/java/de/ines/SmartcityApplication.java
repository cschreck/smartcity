package de.ines;


import com.fasterxml.jackson.databind.ObjectMapper;
import de.ines.domain.GpsPoint;
import de.ines.domain.Route;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.CharArrayWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EntityScan("de.ines.domain")
@EnableScheduling
public class SmartcityApplication {


	public static void main(String[] args) {

		SpringApplication.run(SmartcityApplication.class, args);

        CachingConnectionFactory test = new CachingConnectionFactory();
		test.setHost("127.0.0.1");
		test.setPassword("guest");
		ConnectionFactory connectionFactory = test;//new CachingConnectionFactory();

		System.out.println(connectionFactory.getHost()+ " " + connectionFactory.getUsername()+ " "+ connectionFactory.getPort());
		AmqpAdmin admin = new RabbitAdmin(connectionFactory);
		Map<String, Object> arg = new HashMap<String, Object>();
		arg.put("x-max-length", 10000);

		admin.declareQueue(new Queue("myqueue2",true,false,false, arg));

	}

}
