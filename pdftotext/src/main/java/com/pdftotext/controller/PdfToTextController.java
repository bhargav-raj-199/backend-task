package com.pdftotext.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pdftotext.model.FileContent;
import com.pdftotext.service.IPdfToTextService;

/**
 * @author BhargavRajJinka
 *
 */
@RestController
@RequestMapping("converter")
@PropertySource("classpath:application.yml")
public class PdfToTextController {
	
	private IPdfToTextService pdfToTextService;
	
	private Logger logger=LoggerFactory.getLogger(PdfToTextController.class);
	
	
	
	/**
	 * @param pdfToTextService this setter method for initialization
	 */
	@Autowired
	public void setService(IPdfToTextService pdfToTextService) {
		this.pdfToTextService = pdfToTextService;
	}





	/**
	 * @param filename is the input file from user
	 * @return ResponseEntity object
	 * @throws IOException if file cant handle/read/open
	 */
	@PostMapping("/pdfToText")
	public ResponseEntity<FileContent> convert(@RequestParam("filename") MultipartFile filename) throws IOException {
		logger.info("inside convert method");
		
		return ResponseEntity.ok().body(pdfToTextService.generateTxtFromPDF(filename));
		
	}
	
}
