package com.sagittarius.donations.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Contains REST configuration...
 *
 * @author gagik_sargsyan
 */
@Configuration
public class RestConfig {
	
	public static final String REST_CLIENT_EXTERNAL = "externalRestClient";
	private static final int REST_CLIENT_TIMEOUT = 60000;


	@Bean
	@Qualifier(REST_CLIENT_EXTERNAL)
	public RestTemplate getExternalRestTemplate() {
		return new RestTemplate();
	}


	/**
	 * We need this to be able to make calls to PATCH api by using the rest template...
	 * @return
	 */
	private HttpComponentsClientHttpRequestFactory initRequestFactory() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		
		requestFactory.setConnectTimeout(REST_CLIENT_TIMEOUT);
		requestFactory.setReadTimeout(REST_CLIENT_TIMEOUT);
		
		return requestFactory;
	}
}
