package com.fjulca.reserva;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ConfigurationPropertiesScan("com.fjulca.reserva.util")
public class AplicativoReservaCasaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AplicativoReservaCasaApplication.class, args);
	}

	@Bean
	  public RestTemplate restTemplate() {

	    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
	    factory.setConnectTimeout(5000); // 5 seconds
	    factory.setReadTimeout(5000);   // 5 seconds
	    return new RestTemplate(factory);
	  }
}
