package com.pdftotext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.PropertySource;

/**
 * @author BhargavRajJinka
 *
 */
@SpringBootApplication
@EnableEurekaServer
@PropertySource("classpath:application.yml")
public class PdfToTextEurekaRegistryApplication {

	/**
	 * @param args for passing arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(PdfToTextEurekaRegistryApplication.class, args);
	}

}
