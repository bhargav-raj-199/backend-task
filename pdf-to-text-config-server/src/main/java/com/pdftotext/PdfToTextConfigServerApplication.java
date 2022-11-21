package com.pdftotext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.PropertySource;

/**
 * @author BhargavRajJinka
 *
 */
@SpringBootApplication
@EnableConfigServer
@PropertySource("classpath:application.yml")
public class PdfToTextConfigServerApplication {

	/**
	 * @param args arrays of command line argumnets
	 */
	public static void main(String[] args) {
		SpringApplication.run(PdfToTextConfigServerApplication.class, args);
	}

}
