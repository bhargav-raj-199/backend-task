package com.pdftotext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author BhargavRajJinka
 *
 */
@SpringBootApplication
@EnableEurekaClient
public class PdfToTextCloudGatewayApplication {

	/**
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PdfToTextCloudGatewayApplication.class, args);
	}

	/**
	 * @param builder is of type RouteLocatorBuilder
	 * @return RouteLocator object
	 */
	@Bean
	@LoadBalanced
	public RouteLocator customRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				. route( "PDF-TO-TEXT-SERVICE",ps ->ps.path ("/converter/**").uri("lb://PDF-TO-TEXT-SERVICE"))
				.build();
	}
}
