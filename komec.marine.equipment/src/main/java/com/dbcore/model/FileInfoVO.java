package com.dbcore.model;

public class FileInfoVO {
	
	private String file_path;
	private String file_name;
	
	public String getFile_path() {
		return file_path;
	}
	
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	
	public String getFile_name() {
		return file_name;
	}
	
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	
	@Override
	public String toString() {
		return "FileInfoVO [file_path=" + file_path + ", file_name="
				+ file_name + "]";
	}
	
	

}
