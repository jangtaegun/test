package com.dbcore.common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.dbcore.common.ProjectConstant;

public class FileUtil {

	public String saveFile(String path, MultipartFile sourceFile) throws IllegalStateException, IOException {
		if ((sourceFile == null) || (sourceFile.isEmpty()))
			return null;
		
		File saveFolder = new File(path);
        if(!saveFolder.exists() || saveFolder.isFile()){
            saveFolder.mkdirs();
        }
        String fileName = createTimeKey() + "." + getFileExt(sourceFile.getOriginalFilename());
		String targetFilePath = path + fileName;
		sourceFile.transferTo(new File(targetFilePath));
		
		return fileName;
	}
	
	/**
	 * 파일명 그대로 저장 
	 * @param path
	 * @param sourceFile
	 * @return
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	public String saveFileOrigin(String path, MultipartFile sourceFile) throws IllegalStateException, IOException {
		if ((sourceFile == null) || (sourceFile.isEmpty()))
			return null;
		
		File saveFolder = new File(path);
        if(!saveFolder.exists() || saveFolder.isFile()){
            saveFolder.mkdirs();
        }
        
        String fileName = sourceFile.getOriginalFilename();
		String targetFilePath = path + fileName;
		sourceFile.transferTo(new File(targetFilePath));
		
		return fileName;
	}
	
	public String createTimeKey() {
		UUID uuid = UUID.randomUUID();
		
		return uuid.toString(); 
	}
	
	public List saveFiles(String path, MultipartFile[] sourceFiles) throws IllegalStateException, IOException {
		if(sourceFiles == null) return null;
		
		List fileNameList = new ArrayList();
		for(int i=0; i < sourceFiles.length; i++) {
			String fileName = saveFile(path, sourceFiles[i]);
			fileNameList.add(fileName);
		}
		
		return fileNameList; 
	}
	
	public String getFileWithoutExt(String fileFullName) {
		return  fileFullName.substring(0, fileFullName.lastIndexOf("."));

	}
	
	public String getFileExt(String fileFullName) {
		return  fileFullName.substring(fileFullName.lastIndexOf(".")+1, fileFullName.length());

	}
	
	public void writeFile(String path, String content) {
		File f = new File(path);
        if(!f.exists() || f.isFile()){
            try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
        
        FileWriter fw = null;
        BufferedWriter buf = null;
        try {
			fw = new FileWriter(f);
			buf = new BufferedWriter(fw);
			buf.write(content);
			buf.flush();
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			try {buf.close();} catch (IOException e) {e.printStackTrace();}
			try {fw.close();} catch (IOException e) {e.printStackTrace();}
		}
        
	}
	
	public void copyFile(File srcFile, File destFile) throws IOException {
		FileUtils.copyFile(srcFile, destFile);
	}
	
	/**
	 * 메뉴의 파일경로에 있는 파일내용을 불러온다. (파일경로가 웹루트부터 시작된다)
	 * @param path 페이지명(경로포함)
	 * @return
	 * @throws IOException
	 */
	public String readFileProject(String path) {
		String rootPath = ProjectConstant.PATH_WEBROOT;
		String fullPath = rootPath + StringUtils.replace(path, "/", ProjectConstant.FILE_SEPARATOR);
		File f = new File(fullPath);
		System.out.println("############### Read File Path : " + fullPath + " #################");
		StringBuffer buff = new StringBuffer();
		try {
			buff.append(FileUtils.readFileToString(f, "UTF-8"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buff.toString();
	}
	
	/**
	 * 선택한 파일에 내용을 입력한다. (파일경로가 웹루트부터 시작된다)
	 * @param path 인크루드할 페이지명 (경로포함)
	 * @param content 입력할 내용 
	 */
	public void writeFileProject(String path, String content) {
		if(path != null && path.startsWith("/")) {
			path = path.substring(1);
		}
		String rootPath = ProjectConstant.PATH_WEBROOT;
		String fullPath = rootPath + StringUtils.replace(path, "/", ProjectConstant.FILE_SEPARATOR);
		try {
			FileUtils.writeStringToFile(new File(fullPath), StringUtils.chomp(content), "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	    java.util.Date date = new java.util.Date();
		FileUtil fileUtil = new FileUtil();
	}
}
