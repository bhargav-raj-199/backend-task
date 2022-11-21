package com.pdftotext.model;

/**
 * @author BhargavRajJinka
 *
 */
public class FileContent {
	
	StringBuilder content;

	/**
	 * @return content instance
	 */
	public StringBuilder getContent() {
		return content;
	}


	/**
	 * @param content for intializing content instance
	 */
	public void setContent(StringBuilder content) {
		this.content = content;
	}

	/**
	 * @param content it accepts contents of a file as StringBuilder
	 */
	public FileContent(StringBuilder content) {
		super();
		this.content = content;
	}

	
	
}
