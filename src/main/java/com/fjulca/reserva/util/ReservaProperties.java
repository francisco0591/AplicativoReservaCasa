package com.fjulca.reserva.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationProperties(prefix = "api.reserva")
@ConfigurationPropertiesScan 
public class ReservaProperties {

		private String url_api_discount;

		public String getUrl_api_discount() {
			return url_api_discount;
		}

		public void setUrl_api_discount(String url_api_discount) {
			this.url_api_discount = url_api_discount;
		}

		
}
