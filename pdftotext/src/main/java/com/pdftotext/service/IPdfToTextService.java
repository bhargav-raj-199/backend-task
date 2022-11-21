package com.pdftotext.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.pdftotext.exceptions.CannotParseException;
import com.pdftotext.exceptions.InvalidFileException;
import com.pdftotext.model.FileContent;

/**
 * @author BhargavRajJinka
 *
 */
public interface IPdfToTextService {

	/**
	 * @param filename is the input file
	 * @return new File object
	 * @throws IOException when file is unable to load/read/handle
	 */
	public File createFile(MultipartFile filename) throws IOException;
	/**
	 * @param file is the input file
	 * @return  FileContent object
	 * @throws IOException when file is unable to load/read/handle
	 */
	FileContent generateTxtFromPDF(MultipartFile file)  throws IOException;
	/**
	 * @param file is the input file
	 * @return string of extension of a file
	 * @throws InvalidFileException if file is invalid
	 */
	public String checkExtension(String file) throws InvalidFileException;
	/**
	 * @param pdfFile only pdf file
	 * @return integer number of images present in a file
	 * @throws CannotParseException will be thrown if there are only images
	 * @throws IOException when file is unable to load/read/handle
	 */
	public int countImages(File pdfFile) throws CannotParseException, IOException;
	
}
