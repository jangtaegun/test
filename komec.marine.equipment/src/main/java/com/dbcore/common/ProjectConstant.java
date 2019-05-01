package com.dbcore.common;

public class ProjectConstant {
	
	public static final String DEFAULT_WEB_APP_ROOT_KEY = "dbcore.root";
	
	//페이지경로
	public static final String CONTEXT_LOGIN_PATH = "login/login"; //로그인페이지경로
	public static final String CONTEXT_MAIN_PATH = "main/main"; // 메인페이지경로 
	public static final String MAIN_WELCOME_PATH = "welcome";
	
	public static final String KEY_INTERCEPTOR_VALUES_POSTFIX 			= "_LIST";
	public static final String KEY_INTERCEPTOR_STRING_VALUES_POSTFIX 	= "_LIST_STRING";
	public static final String KEY_INTERCEPTOR_QUOTE_POSTFIX 			= "_QUOTE";
	
	// 페이지에서 넘어오는 인코딩 
	public static final String ENCODING_PAGE  = "UTF-8";
	
	// 서버에서 처리되는 인코딩 
	public static final String ENCODING_SERVER = "UTF-8";
	
	// 모드 
	//public static final String DATABASE_MODE = "oracle"; //데이터베이스모드 (oracle, mysql, mssql)
	public static final String DATABASE_MODE = "mysql"; //데이터베이스모드 (oracle, mysql, mssql)

	public static final int RECORD_COUNT_PER_PAGE = 10; //한 페이지에 게시되는 게시물 건수
	public static final int PAGE_SIZE = 10; //페이징 리스트의 사이즈
	
	//파일업로드
	public static final String KEY_FORM_DOMAIN_UPLOAD_DIR 	= "upload_dir";	// 업로드폴더명 키
	public static final String KEY_FORM_DOMAIN_UPLOAD_DIR_SUB = "upload_dir_sub";	// 업로드서브폴더명 키
	public static final String KEY_FORM_DOMAIN_UPLOAD_FILE_ORIGIN_YN = "intc_file_origin_yn"; // 업로드 파일명 그대로 쓸지여부 체크 	
	public static final String KEY_FORM_FILE = "file"; // 폼에서 넘길때의 일괄적인 파일키값 (file1, file2, file3, .... )
	public static final String FILE_UPLOAD_DIR 	= "upload";	// 업로드할 기본 디렉토리
	public static final String FILE_UPLOAD_TEMP_DIR	= "upload_temp";	// 업로드할 TEMP 디렉토리
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");	
	public static final String PATH_WEBROOT = System.getProperty(DEFAULT_WEB_APP_ROOT_KEY);
	public static final String ALLOW_EXTENSION[][] = { // 파일업로드시, 허용되는 확장자 
			  {".jpg", ".gif", ".png", ".bmp", ".mov", ".mid", ".avi", ".flv", ".swf", ".mp3", ".mp4", ".wav", ".mpg", ".mpeg", ".wmv", ".smi", ".ogg", ".flac"}	// MEDIA FILE
			, {".doc", ".docx", ".hwp", ".xls", ".xlsx", ".ppt", ".pptx", ".rtf", ".pdf", ".txt"}																	// DOCUMENT FILE
			, {".zip", ".rar", ".alz", ".tar", ".7zip"}																												// COMPRESS FILE
	};
	
	
}
