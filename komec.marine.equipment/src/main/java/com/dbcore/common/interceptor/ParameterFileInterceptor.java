package com.dbcore.common.interceptor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dbcore.common.ProjectConstant;
import com.dbcore.common.controller.BaseController;
import com.dbcore.common.util.CommonUtil;
import com.dbcore.common.util.FileUtil;
import com.dbcore.common.util.StringUtil;
import com.dbcore.common.vo.MultipartFileWrapper;

@org.springframework.stereotype.Controller("parameterFileInterceptor")
public class ParameterFileInterceptor  extends HandlerInterceptorAdapter {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if(logger.isDebugEnabled()) {
			logger.debug("-------------- [ core intercepter - ParameterFileInterceptor ] " + getClass().getName() + " 수행합니다. -----------------");
		}
		
		if(ServletFileUpload.isMultipartContent(request)) {
			logger.info("-------------- [core intercepter] 파일을 저장하고 파라미터에  파일관련 정보 저장을 수행합니다. -----------------");
			
			// 파일을 저장할 경로를 자동셋팅
			// rootpath 가 없을 경우 user.home 에 셋팅
			String rootPath = System.getProperty(ProjectConstant.DEFAULT_WEB_APP_ROOT_KEY);
			if(rootPath == null) {
				rootPath = System.getProperty("user.home");
				logger.info("project.root가 셋팅되지 않아 user.home 경로가  파일경로로 설정됨.");
			}
			
//			HttpSession session = request.getSession();
//			String loginUserId = ((CoreUserInfoVO)session.getAttribute("LoginUserVO")).getUser_id();
			
			// upload 폴더명 가져오기
			String uploadDir = request.getParameter(ProjectConstant.KEY_FORM_DOMAIN_UPLOAD_DIR);
			if(uploadDir != null && !"".equals(uploadDir)) {
				// 업로드 폴더명에 특수문자 제거
				uploadDir = StringUtil.removeSpecialFileChar(uploadDir);
			}
			
			// upload 하위폴더명 가져오기
			String uploadDirSub = request.getParameter(ProjectConstant.KEY_FORM_DOMAIN_UPLOAD_DIR_SUB);
			if(uploadDirSub != null && !"".equals(uploadDirSub)) {
				// 업로드 폴더명에 특수문자 제거
				uploadDirSub = StringUtil.removeSpecialFileChar(uploadDirSub);
			}
			
			// 파일명 그대로 저장할지, 랜덤키 파일로 저장할 지 선택
			String originYN = request.getParameter(ProjectConstant.KEY_FORM_DOMAIN_UPLOAD_FILE_ORIGIN_YN);
			if(originYN == null) {
				originYN = "Y";
			}
			
			// 파일개수를 가져온다.
			MultipartRequest multipartReq = (MultipartRequest) request;
			Map fileSizeMap =  multipartReq.getFileMap();
			int fileCount = 0;
			for(int i=1 ; i <= fileSizeMap.size() ; i++){
				MultipartFile fileTemp = multipartReq.getFile(ProjectConstant.KEY_FORM_FILE + i);
				if(fileTemp != null) fileCount++;
			}
			
			MultipartFile[] files = new CommonsMultipartFile[fileCount];
			for(int i = 1 ; i <= fileCount ; i++){
				files[i-1] = multipartReq.getFile(ProjectConstant.KEY_FORM_FILE + i);
			}
			
			String path = "";
			String url = "";
			// ex => C:/temp/project/upload/
			// 파일업로드 디렉토리를 선택하지 않았을 경우
			if(uploadDir == null || "".equals(uploadDir)) {
				path = rootPath + ProjectConstant.FILE_UPLOAD_DIR + ProjectConstant.FILE_SEPARATOR;
				url = CommonUtil.getURLroot(request) + ProjectConstant.FILE_UPLOAD_DIR + "/";
			} else {
				// 하위폴더가 존재하지 않는다면
				if(uploadDirSub == null || "".equals(uploadDirSub)) {
					path = rootPath + ProjectConstant.FILE_UPLOAD_DIR + ProjectConstant.FILE_SEPARATOR + uploadDir + ProjectConstant.FILE_SEPARATOR;
					url = CommonUtil.getURLroot(request) + ProjectConstant.FILE_UPLOAD_DIR + "/" + uploadDir + "/";
				// 하위폴더가 존재할 경우
				} else {
					path = rootPath + ProjectConstant.FILE_UPLOAD_DIR + ProjectConstant.FILE_SEPARATOR + uploadDir + ProjectConstant.FILE_SEPARATOR + uploadDirSub + ProjectConstant.FILE_SEPARATOR;
					url = CommonUtil.getURLroot(request) + ProjectConstant.FILE_UPLOAD_DIR + "/" + uploadDir + "/" + uploadDirSub + "/";
				}
			}
			
			// 허용하지 않는 확장자일 경우
			for(int idx = 0; idx < fileCount ; idx++) {
				if(files[idx] != null && !files[idx].isEmpty()) {
					if(!file_chk(files[idx].getOriginalFilename())) {
						response.sendRedirect("/common/error/message_back.do?message=file.not.allow.extension");
						return false;
					}
				}
			}
			
			// 업로드 용량제한이 들어올 경우
			if(request.getParameter("intc_file_max_size") != null && !request.getParameter("intc_file_max_size").equals("") && !request.getParameter("intc_file_max_size").equals("0")){
				long uploadSize = Long.parseLong(request.getParameter("intc_file_max_size"));
				long totalSize = 0;

				for(int idx = 0; idx < fileCount; idx++) {
					if(files[idx] != null && !files[idx].isEmpty()) totalSize += files[idx].getSize();
				}
				if(uploadSize < totalSize){
					response.sendRedirect("/common/error/message_back.do?message=file.max.allow.size");
					return false;
				}
			}
			
			ArrayList<MultipartFileWrapper> fileWrapper = new ArrayList<MultipartFileWrapper>();
			for(int i = 0 ; i < fileCount ; i++){
				MultipartFileWrapper fileWrapper_temp =saveFile(files[i], path, url, originYN);
				fileWrapper.add(fileWrapper_temp);				
			}
			
			// paramMap 에 파일리스트를 저장한다.
			Map fileMap = new HashMap();
			for(int i = 0 ; i < fileCount ; i++){
				addFileMap(fileMap, ProjectConstant.KEY_FORM_FILE+(i+1), fileWrapper.get(i));
			}

			if(handler instanceof BaseController) {
				if(fileMap != null && !fileMap.isEmpty()) {
					BaseController controller = (BaseController) handler;
					Map paramMap = controller.getParamMap();
					MultipartFileWrapper file = (MultipartFileWrapper) fileMap.get("file1");
					paramMap.put("file_path",file.getFileURL());
					paramMap.put("file_name",file.getFileName());
				}
			}
		}		
		
		return true;
	}
	
	public boolean file_chk(String fileName) {
		String allowExt[][] = ProjectConstant.ALLOW_EXTENSION;

		String ext = "";
		int idx = fileName.lastIndexOf(".");

		if(idx != -1) ext = fileName.substring(fileName.lastIndexOf("."), fileName.length());
		if(!"".equals(ext)) {
			for(int i = 0; i < allowExt.length; i++) {
				for(int j = 0; j < allowExt[i].length; j++) {
					if(allowExt[i][j].equals(ext.toLowerCase())) return true;
				}
			}
		}
		return false;
	}
	
	private MultipartFileWrapper saveFile(MultipartFile multipartFile, String path, String url, String originYN) throws IllegalStateException, IOException {
		if(multipartFile != null && !multipartFile.isEmpty()) {
			logger.info("파일필드명 : " + multipartFile.getName());
			logger.info("파일명 : " + multipartFile.getOriginalFilename());
			logger.info("파일사이즈 : " + multipartFile.getSize());
			logger.info("originYN : " + originYN);

			String fileName = "";
			FileUtil fileUtil = new FileUtil();
			if("Y".equals(originYN)) {
				fileName = fileUtil.saveFileOrigin(path, multipartFile);
			} else {
				fileName = fileUtil.saveFile(path, multipartFile);
			}
			String fileURL = url + fileName;

			return new MultipartFileWrapper(multipartFile, fileName, fileURL, path);
		}
		return null;
	}
	
	private void addFileMap(Map fileMap, String key, MultipartFileWrapper multipartFileWrapper) {
		if(multipartFileWrapper != null && !multipartFileWrapper.isEmpty()) {
			fileMap.put(key, multipartFileWrapper);
		}
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request,	HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		// BaseController 일 경우에만 수행
		if(handler instanceof BaseController) {
			logger.info("-------------- [core intercepter] controller에 파일맵(fileMap)을 해제합니다 -----------------");
			BaseController controller = (BaseController) handler;
			Map paramMap = controller.getParamMap();
			if(paramMap != null) {
				Map fileMap = (Map) paramMap.get(ProjectConstant.KEY_FORM_FILE + ProjectConstant.KEY_INTERCEPTOR_VALUES_POSTFIX);
				if(fileMap != null) {
					fileMap.clear();
					fileMap = null;
				}
			}
		}

		super.afterCompletion(request, response, handler, ex);
	}
}
