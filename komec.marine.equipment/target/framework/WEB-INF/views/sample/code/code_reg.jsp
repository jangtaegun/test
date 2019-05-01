<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import = "com.dbcore.common.ProjectConstant" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>코드관리</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common/base.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<script type="text/javascript">
	function saveContent(action){
	
		var iform = document.frm_reg;
		
		if (isValue(iform.chnlId, "CHNL_ID를 입력해주세요.") == false) { iform.chnlId.focus(); return;}
		if (isValue(iform.useInitId, "USE_INIT_ID를 입력해주세요.") == false) { iform.useInitId.focus(); return; }
		if (isValue(iform.cmmnGbCd, "CMMN_GB_CD를 입력해주세요.") == false) { iform.cmmnGbCd.focus(); return; }
		if (isValue(iform.cmmnGbNm, "CMMN_GB_NM을 입력해주세요.") == false) { iform.cmmnGbNm.focus(); return; }
		
		fn_submit(iform,action,'post');
	}
</script>
</head>
<body>
<form name="frm_reg"  enctype="multipart/form-data">
	<input type="hidden" name="<%=ProjectConstant.KEY_FORM_DOMAIN_UPLOAD_DIR %>" value="code" />	
	<div class="container">
		<div class="header">
			<jsp:include page="../../common/header.jsp" flush="false"/>
		</div>
		<div class="main">
			<div class="content" id="content">
				<c:choose>
					<c:when test="${action_param eq 'code_insert'}">				
						- CHNL_ID : <input type="text" name="chnlId" value=""/><br />	
						- USE_INIT_ID : <input type="text" name="useInitId" value=""/><br />	
						- CMMN_GB_CD : <input type="text" name="cmmnGbCd" value=""/><br />	
					</c:when>
					<c:otherwise>
						- CHNL_ID : ${codeVO.chnlId}<br />
						- USE_INIT_ID : ${codeVO.useInitId}<br />
						- CMMN_GB_CD : ${codeVO.cmmnGbCd}<br />	
						<input type="hidden" name="chnlId" value="${codeVO.chnlId}" />		
						<input type="hidden" name="useInitId" value="${codeVO.useInitId}" />	
						<input type="hidden" name="cmmnGbCd" value="${codeVO.cmmnGbCd}" />				
					</c:otherwise>					
				</c:choose>
				- CMMN_GB_NM : <input type="text" name="cmmnGbNm" value="${codeVO.cmmnGbNm}"/><br />	
				- NUMBER1_DC : <input type="text" name="number1Dc" value="${codeVO.number1Dc}"/><br />	
				- NUMBER2_DC : <input type="text" name="number2Dc" value="${codeVO.number2Dc}"/><br />	
				- NUMBER3_DC : <input type="text" name="number3Dc" value="${codeVO.number3Dc}"/><br />	
				- CHRCTR1_DC : <input type="text" name="chrctr1Dc" value="${codeVO.chrctr1Dc}"/><br />	
				- CHRCTR2_DC : <input type="text" name="chrctr2Dc" value="${codeVO.chrctr2Dc}"/><br />	
				- CHRCTR3_DC : <input type="text" name="chrctr3Dc" value="${codeVO.chrctr3Dc}"/><br />	
				- SORT_ORDR : <input type="text" name="sortOrdr" value="${codeVO.sortOrdr}"/><br />	
				- RM : <input type="text" name="rm" value="${codeVO.rm}"/><br />	
				- APPEND FILE : <input type="file" name="file1"/></br>
				<button class="arrow" onClick="javascript:fn_submit(document.frm_reg,'/code.do','post'); return false;">목록</button>
				<button class="arrow" onClick="javascript:saveContent('/${action_param}.do');">저장</button>
			</div>
		</div>
	</div>
</form>
</body>
</html>