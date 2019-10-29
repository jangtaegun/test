package com.dbcore.agent.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dbcore.agent.service.IAgentService;
import com.dbcore.agent.vo.AgentInfoVo;
import com.dbcore.code.service.CodeService;
import com.dbcore.common.ProjectConstant;
import com.dbcore.common.controller.BaseController;
import com.dbcore.model.CodeVO;
import com.dbcore.parm.common.CommonCodeParm;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class AgentController extends BaseController {
	
	@Autowired
    private CodeService codeService;
	
	@Autowired
	private IAgentService agentService;
	
	//90900000
	@RequestMapping("/agentList.do")
	public String getAgentList(@ModelAttribute("AgentVo") AgentInfoVo agentInfoVo,ModelMap model, HttpServletRequest request, HttpServletResponse response)throws Exception{
		
		if(agentInfoVo.getCurrentPageNo()==0){
			agentInfoVo.setCurrentPageNo(1);
		}
		
		CommonCodeParm commonCodeParm = new CommonCodeParm();
		commonCodeParm.setCodeType("AGENT");	//업체구분코드
		
		List<Object> comboCodeList=codeService.selectSoCodeComboItems(commonCodeParm);
		
	   List<Object>resultVOList = agentService.selectAgentInfo(agentInfoVo);
	   
	   agentInfoVo.setFirstRecordIndex((agentInfoVo.getCurrentPageNo() - 1) * ProjectConstant.RECORD_COUNT_PER_PAGE);
	   agentInfoVo.setRecordCountPerPage(ProjectConstant.RECORD_COUNT_PER_PAGE);
	   PaginationInfo paginationInfo = painationSetting(agentInfoVo.getCurrentPageNo(), ProjectConstant.RECORD_COUNT_PER_PAGE, ProjectConstant.PAGE_SIZE, agentService.getTotalCount(agentInfoVo));
		
		model.addAttribute("paginationInfo",paginationInfo);
		model.addAttribute("resultVOList",resultVOList);
		model.addAttribute("comboCodeList",comboCodeList);
		model.addAttribute("keyword", agentInfoVo.getKeyword());
		model.addAttribute("keyword2",agentInfoVo.getKeyword2());
		
		return "agentMngmnt";
	}
	
	public void insertAgentInfo(@ModelAttribute("DecodeDetail") AgentInfoVo agentInfoVo, ModelMap model,HttpServletRequest request,HttpServletResponse response){
		
		
	}
	
	

}
