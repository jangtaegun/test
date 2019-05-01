package com.dbcore.code.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbcore.code.service.CodeService;
import com.dbcore.common.CoreMessageSource;
import com.dbcore.common.ProjectConstant;
import com.dbcore.common.controller.BaseController;
import com.dbcore.model.CodeVO;
import com.dbcore.parm.common.CommonCodeParm;

@Controller
public class CodeController extends BaseController{
	
	@Autowired
    private CodeService codeService;

	@Resource(name="coreMessageSource")
	private CoreMessageSource coreMessageSource;
	
	@RequestMapping("/deCodeList.do")
	public String codePage(@ModelAttribute("frm_list") CodeVO codeVO,   ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(codeVO.getCurrentPageNo()==0){
			codeVO.setCurrentPageNo(1);
		}
	
		codeVO.setFirstRecordIndex((codeVO.getCurrentPageNo() - 1) * ProjectConstant.RECORD_COUNT_PER_PAGE);
		codeVO.setRecordCountPerPage(ProjectConstant.RECORD_COUNT_PER_PAGE);
		codeVO.setCmmnGbCd(codeVO.getKeyword2());
		codeVO.setCmmnGbNm(codeVO.getKeyword());
		
		model.addAttribute("paginationInfo", painationSetting(codeVO.getCurrentPageNo(), ProjectConstant.RECORD_COUNT_PER_PAGE, ProjectConstant.PAGE_SIZE, codeService.getTotalCount(codeVO)));		
		model.addAttribute("resultVOList", codeService.selectList(codeVO));
		model.addAttribute("codeVO", codeVO);
		model.addAttribute("keyword2", codeVO.getKeyword2());
		model.addAttribute("keyword", codeVO.getKeyword());
		
		return "deCodeList";
	}
	
	@RequestMapping("/soCodeList.do")
	public String soCodePage(@ModelAttribute("frm_list") CodeVO codeVO,   ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if(codeVO.getCurrentPageNo()==0){
			codeVO.setCurrentPageNo(1);
		}
	
		codeVO.setFirstRecordIndex((codeVO.getCurrentPageNo() - 1) * ProjectConstant.RECORD_COUNT_PER_PAGE);
		codeVO.setRecordCountPerPage(ProjectConstant.RECORD_COUNT_PER_PAGE);
		codeVO.setCmmnGbCd(codeVO.getKeyword2());
		codeVO.setCmmnGbNm(codeVO.getKeyword());
		
		CommonCodeParm commonCodeParm = new CommonCodeParm();
		List<Object> comboCodeList =  codeService.selectComboItems(commonCodeParm);
		
		model.addAttribute("paginationInfo", painationSetting(codeVO.getCurrentPageNo(), ProjectConstant.RECORD_COUNT_PER_PAGE, ProjectConstant.PAGE_SIZE, codeService.getSoCodeTotalCount(codeVO)));		
		model.addAttribute("comboCodeList", comboCodeList);
		model.addAttribute("resultVOList", codeService.selectSoCodeList(codeVO));
		model.addAttribute("codeVO", codeVO);
		model.addAttribute("keyword", codeVO.getKeyword());
		
		return "soCodeList";
	}
	
/*	@RequestMapping("/code_view.do")
	public ModelAndView viewPage(@RequestParam(value="keyword", defaultValue = "") String keyword,
												CodeVO codeVO, ModelMap model, HttpServletRequest request) throws Exception {	

		model.addAttribute("keyword", keyword);	
		model.addAttribute("codeVO", codeService.detailView(codeVO));	
		
		return new ModelAndView("sample/code/code_view");
	}*/
	
	@RequestMapping("/DecodeDetailView.do")
	public ModelAndView  viewPage(ModelMap model, HttpServletRequest request) throws Exception {	
		String chnlId =  request.getParameter("chnlId");
		String useInitId = request.getParameter("useInitId");
		String cmmnGbCd = request.getParameter("cmmnGbCd");
		
		 ModelAndView mav = new ModelAndView(); 
		
		CodeVO codeVO = new CodeVO();
		codeVO.setChnlId(chnlId);
		codeVO.setUseInitId(useInitId);
		codeVO.setCmmnGbCd(cmmnGbCd);
		
		//model.addAttribute("codeVO", codeService.detailView(codeVO));	
		
	    mav.addObject("codeVO", codeService.detailView(codeVO));
		mav.setViewName("jsonView");
        return mav;
	}
	
	@RequestMapping("/soCodeDetailView.do")
	public ModelAndView  DecodeDetailView(ModelMap model, HttpServletRequest request) throws Exception {	
		String chnlId =  request.getParameter("chnlId");
		String useInitId = request.getParameter("useInitId");
		String cmmnCd = request.getParameter("cmmnCd");
		
		 ModelAndView mav = new ModelAndView(); 
		
		CodeVO codeVO = new CodeVO();
		codeVO.setChnlId(chnlId);
		codeVO.setUseInitId(useInitId);
		codeVO.setCmmnCd(cmmnCd);
		
	    mav.addObject("codeVO", codeService.detailSoCdedView(codeVO));
		mav.setViewName("jsonView");
        return mav;
	}
	
	
	@RequestMapping("/code_insert_page.do")
	public ModelAndView insertPage(ModelMap model, HttpServletRequest request) throws Exception {

		model.addAttribute("action_param","code_insert");
		
		return new ModelAndView("sample/code/code_reg");
	}
	
	/*@RequestMapping("/code_insert.do")
	public ModelAndView insert(CodeVO codeVO, BindingResult result, ModelMap model) throws Exception {
		
		codeVO.setChrctr3Dc((String) paramMap.get("file_path"));
		codeVO.setRm((String) paramMap.get("file_name"));
		codeService.insert(codeVO);		
		
		model.addAttribute("message", coreMessageSource.getMessage("success.common.insert"));
		return new ModelAndView("sample/code/code_complete");
	}*/
	
	
	@RequestMapping("/code_insert.do")
	public void insert(@ModelAttribute("DecodeDetail") CodeVO codeVO, BindingResult result, ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("euc-kr");
		PrintWriter writer=response.getWriter();
		
		try {
			String CUfalse=request.getParameter("insertUpdateFlage"); //insert or update
			if(StringUtils.equals(CUfalse, "C")){
				codeService.insert(codeVO);		
			}else if(StringUtils.equals(CUfalse, "U")){
				codeService.modify(codeVO);		
			}else{
				throw new Exception("insert or update error");
			}
			writer.println("<script>alert('저장하였습니다.'); location.href='/deCodeList.do';</script>"); 
		} catch (Exception e) {
			logger.info("insert or update error");
			writer.println("<script>alert('저장하지못했습니다.'); location.href='/deCodeList.do';</script>"); 
		}
	}
	
	@RequestMapping("/soCode_insert.do")
	public void insertSoCode(@ModelAttribute("DecodeDetail") CodeVO codeVO, BindingResult result, ModelMap model,HttpServletRequest request,HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("euc-kr");
		PrintWriter writer=response.getWriter();
		
		try {
			String CUfalse=request.getParameter("insertUpdateFlage"); //insert or update
			if(StringUtils.equals(CUfalse, "C")){
				codeService.insertSoCode(codeVO);		
			}else if(StringUtils.equals(CUfalse, "U")){
				codeService.modifySoCode(codeVO);		
			}else{
				throw new Exception("insert or update error");
			}
			writer.println("<script>alert('저장하였습니다.'); location.href='/soCodeList.do';</script>"); 
		} catch (Exception e) {
			logger.info("insert or update error");
			writer.println("<script>alert('저장하지못했습니다.'); location.href='/soCodeList.do';</script>"); 
		}
	}
	
	
	@RequestMapping("/code_modify_page.do")
	public ModelAndView modifyPage(CodeVO codeVO, ModelMap model, HttpServletRequest request) throws Exception {
		
		model.addAttribute("action_param","code_modify");
		model.addAttribute("codeVO",codeService.detailView(codeVO));
		
		return new ModelAndView("sample/code/code_reg");
	}
	
	@RequestMapping("/code_modify.do")
	public ModelAndView modify( ModelMap model, HttpServletRequest request, HttpServletResponse response,
										    CodeVO codeVO) throws Exception {

		codeService.modify(codeVO);		
		
		model.addAttribute("message", coreMessageSource.getMessage("success.common.update"));
		
		return new ModelAndView("sample/code/code_complete");
	}
	
/*	@RequestMapping("/code_delete.do")
	public ModelAndView delete(CodeVO codeVO, ModelMap model,
		                                   HttpServletRequest request, HttpServletResponse response) throws Exception {

		codeService.delete(codeVO);
		
		model.addAttribute("message", coreMessageSource.getMessage("success.common.delete"));
		
		return new ModelAndView("sample/code/code_complete");
	}*/
	
	@RequestMapping("/code_delete.do")
	public void delete(@ModelAttribute("DecodeDetail") CodeVO codeVO, ModelMap model,
		                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter writer=response.getWriter();
		try {
			codeService.delete(codeVO);
			writer.println("<script>alert('삭세하였습니다.'); location.href='/deCodeList.do';</script>"); 
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("delete error");
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/soCode_delete.do")
	public void deleteSoCode(@ModelAttribute("DecodeDetail") CodeVO codeVO, ModelMap model,
		                                   HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("euc-kr");
		PrintWriter writer=response.getWriter();
		try {
			codeService.deleteSoCode(codeVO);
			writer.println("<script>alert('삭세하였습니다.'); location.href='/soCodeList.do';</script>"); 
			
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("delete error");
			e.printStackTrace();
		}
	}
		
}
