package br.com.mathewsalves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CaseProjectServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseProjectServerApplication.class, args);
	}

}
