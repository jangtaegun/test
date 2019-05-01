package com.dbcore.common.vo;

import org.springframework.web.multipart.MultipartFile;

public class MultipartFileWrapper {

	private MultipartFile file;	
	private String fileURL;
	private String filePath;
	private String fileName;
	
	
	public MultipartFileWrapper(MultipartFile file) {
		this.file = file;
	}
	
	public MultipartFileWrapper(MultipartFile file, String fileName, String fileURL, String path) {
		this.file = file;
		this.fileName = fileName;
		this.fileURL = fileURL;
		this.filePath = path;
	}

	public long getSize() {
		return file.getSize();
	}
	
	public String getName() {
		return file.getName();
	}
	
	public String getOriginalFilename() {
		return file.getOriginalFilename();
	}
	
	public boolean isEmpty() {
		return file.isEmpty();
	}
	
	public String getContentType() {
		return file.getContentType();
	}
	
	//*-------------- 사용자 정의 setter/getter -------------- *//
	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "MultipartFileWrapper [file=" + file + ", fileURL=" + fileURL
				+ ", filePath=" + filePath + ", fileName=" + fileName + "]";
	}
	
}

