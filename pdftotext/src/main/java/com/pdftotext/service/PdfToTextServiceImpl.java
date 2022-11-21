package com.pdftotext.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.pdftotext.exceptions.CannotParseException;
import com.pdftotext.exceptions.EmptyFileException;
import com.pdftotext.exceptions.InvalidFileException;
import com.pdftotext.model.FileContent;

/**
 * @author BhargavRajJinka
 *
 */
@Service
public class PdfToTextServiceImpl implements IPdfToTextService{
	/**
	 *
	 */
	
	private Logger logger=LoggerFactory.getLogger(PdfToTextServiceImpl.class);
	
	@Override
	public File createFile(MultipartFile filename) throws IOException{

		logger.info("inside create file method");
		File myFile=new File("temp.pdf");
		myFile.createNewFile();
		FileOutputStream fos=new FileOutputStream(myFile);
		fos.write(filename.getBytes());
		fos.close();
		logger.info("file created successfully");
		return myFile;
	}

	
	/**
	 *
	 */
	@Override
	public FileContent generateTxtFromPDF(MultipartFile file) throws IOException{
		logger.info("inside generateTxtFromPDF method");
		//checking for input 
		//if it is empty field then throwing exception
		if(file.isEmpty()) {
			logger.warn("input field is empty");
			throw new EmptyFileException("you forgot to provide file as input");
		}
		
		//checking foe extension of file
		//if it is other than ".pdf" then throwing exception
		String extension=checkExtension(file.getOriginalFilename());
		if(!extension.equals("pdf")) {
			logger.warn("input file mismatch");
			throw new InvalidFileException("given file with ."+extension+" is invalid ");
		}
		
		
		
		//creating a new temporary pdf file
		logger.warn("creating temporary file");
		File pdfFile=createFile(file);
		
		//counting images in pdf file
		logger.info("reading file for images");
		int images=countImages(pdfFile);
		//System.out.println(images);
		
		//extracting text from pdf file
		logger.info("reading file for text");
		PDFTextStripper stripper=new PDFTextStripper();
		PDDocument document=PDDocument.load(pdfFile);
		StringBuilder content=new StringBuilder();
		content.append(stripper.getText(document));
		
		
		//boolean matcher=Pattern.matches("\r\n*", content);
		
		//throwing exception if pdf contains blank pages
				if(content.toString().equals("\r\n")||images==1) {
					logger.warn("file is empty");
					throw new EmptyFileException("check the file ---<file does not contains any text>");
				}
		
		//throwing exception if pdf contains only images
		if(images>=1 && Pattern.matches("(\r\n)+", content)==true) {
			logger.warn("file contains only images");
			throw new CannotParseException("do not provide pdf which only contains images");
		}
		
		
		
		return new FileContent(content);
		
		
	}

	/**
	 *
	 */
	@Override
	public String checkExtension(String file) throws InvalidFileException {
		
		logger.info("inside checkExtension method");
		return Files.getFileExtension(file);
		//return FilenameUtils.getExtension(file);
		
	}

	/**
	 *
	 */
	@Override
	public int countImages(File pdfFile) throws CannotParseException, IOException {
		
		logger.info("inside countImages method");
		List<BufferedImage> images=new ArrayList<BufferedImage>();
	    PDDocument doc = PDDocument.load(pdfFile);

	    
	    int pages=doc.getPages().getCount();
	   for(int i=0;i<pages;i++) {
		   PDFRenderer renderer = new PDFRenderer(doc);

		      //Rendering an image from the PDF document
		       images.add(renderer.renderImage(i));
	   }
	    
	    doc.close();
	    
	    return images.size();
		
	}

	
	
}
