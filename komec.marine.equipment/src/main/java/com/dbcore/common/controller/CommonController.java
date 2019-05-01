package com.dbcore.common.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dbcore.common.CoreMessageSource;
import com.dbcore.common.ProjectConstant;
import com.dbcore.common.service.CommonService;
import com.dbcore.common.vo.LoginInfoVo;
import com.dbcore.model.CodeVO;
import com.dbcore.model.FileInfoVO;

@Controller
public class CommonController extends BaseController {
	
	@Resource(name = "commonService")
    private CommonService commonService;
	
	@Resource(name="coreMessageSource")
    CoreMessageSource coreMessageSource;
	
	/*@RequestMapping("/mainPage.do")
	public ModelAndView mainPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {

		return new ModelAndView(ProjectConstant.CONTEXT_MAIN_PATH);
	}*/
	
	@RequestMapping("/mainPage.do")
	public String mainPage(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		/*String a = LoginInfoVo.getChnlId();
		String b = LoginInfoVo.getUseInitId();*/
		
		
		logger.debug("===================================");
		logger.debug(CodeVO.getChnlIdInfo());
		logger.debug(CodeVO.getUseInitIdInfo());
		
		
		return "mainPage";
	}
	
	@RequestMapping("/common/error/message_back.do")
	public ModelAndView message_back(@RequestParam(value="message", defaultValue = "") String message) throws Exception {
		return new ModelAndView("common/message_back","message", coreMessageSource.getMessage(message));
	}
	
	@RequestMapping("/common/fileDownload.do")
	public void getFileDownloadInfo(@RequestParam(value="param", defaultValue = "") String param,
											     HttpServletRequest request, HttpServletResponse response) throws Exception {
		FileInfoVO fileVO =  commonService.getFileDownloadInfo(param);
		download(request, response, fileVO);		
	}
	
	private void download (HttpServletRequest request, HttpServletResponse response, FileInfoVO fileVO)
       throws ServletException, IOException {    			
		String rootPath = System.getProperty(ProjectConstant.DEFAULT_WEB_APP_ROOT_KEY);
		String uploadDir = request.getParameter(ProjectConstant.KEY_FORM_DOMAIN_UPLOAD_DIR);
    	String filePath = rootPath + ProjectConstant.FILE_UPLOAD_DIR + ProjectConstant.FILE_SEPARATOR + uploadDir + ProjectConstant.FILE_SEPARATOR;
    	
    	if(uploadDir == null || "".equals(uploadDir)) {
    		filePath = rootPath + ProjectConstant.FILE_UPLOAD_DIR + ProjectConstant.FILE_SEPARATOR;
		}
		
    	File file = new File(filePath, fileVO.getFile_name());

    	boolean flag = false;
        setHeader(response, file, fileVO.getFile_name(), flag);
        
        transport(new FileInputStream(file), response.getOutputStream());
    }

    private void setHeader(HttpServletResponse response, File file, String fileName, boolean flag) throws UnsupportedEncodingException {

		response.setContentType("application/octet-stream");
		response.setContentLength((int) file.length());
		response.setHeader("Content-Type", "application/octet-stream; charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename=" + java.net.URLEncoder.encode(fileName, "UTF-8") + ";");
		response.setHeader("Content-Type", "application/x-msdownload");
    	response.setHeader("Content-Transfer-Encoding", "binary;");
    	response.setHeader("Pragma", "no-cache;");
    	response.setHeader("Expires", "-1;");
   }

    private void transport(InputStream in, OutputStream out)
        throws IOException {

        BufferedInputStream bin = null;
        BufferedOutputStream bos = null;

        try {
            bin = new BufferedInputStream( in );
            bos = new BufferedOutputStream( out );

            byte[] buf = new byte[4096]; //buffer size 2K.
            int read = 0;
            while ((read = bin.read(buf)) != -1) {
                bos.write(buf,0,read);
                bos.flush();
            }
        } finally {
            bos.close();
            bin.close();
        }
    }
}
