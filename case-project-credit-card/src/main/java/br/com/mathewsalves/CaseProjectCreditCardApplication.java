package br.com.mathewsalves;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CaseProjectCreditCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaseProjectCreditCardApplication.class, args);
	}

}
