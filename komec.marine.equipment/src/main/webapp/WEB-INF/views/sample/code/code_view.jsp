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

</script>
</head>
<body>
<form name="frm_view">
	<input type="hidden" name="chnlId" value="${codeVO.chnlId}" />		
	<input type="hidden" name="useInitId" value="${codeVO.useInitId}" />	
	<input type="hidden" name="cmmnGbCd" value="${codeVO.cmmnGbCd}" />		
	<div class="container">
		<div class="header">
			<jsp:include page="../../common/header.jsp" flush="false"/>
		</div>
		<div class="main">
			<div class="content" id="content">
				- CHNL_ID : ${codeVO.chnlId}<br />
				- USE_INIT_ID : ${codeVO.useInitId}<br />
				- CMMN_GB_CD : ${codeVO.cmmnGbCd}<br />	
				- CMMN_GB_NM : ${codeVO.cmmnGbNm}<br />	
				- NUMBER1_DC : ${codeVO.number1Dc}<br />	
				- NUMBER2_DC : ${codeVO.number2Dc}<br />	
				- NUMBER3_DC : ${codeVO.number3Dc}<br />	
				- CHRCTR1_DC : ${codeVO.chrctr1Dc}<br />	
				- CHRCTR2_DC : ${codeVO.chrctr2Dc}<br />	
				- CHRCTR3_DC : ${codeVO.chrctr3Dc}<br />	
				- SORT_ORDR : ${codeVO.sortOrdr}<br />	
				- RM : <c:if test="${codeVO.rm != null || !codeVO.rm eq ''}">				
							<a href="/common/fileDownload.do?param=${codeVO.chnlId}${codeVO.useInitId}${codeVO.cmmnGbCd}&<%=ProjectConstant.KEY_FORM_DOMAIN_UPLOAD_DIR %>=code" title="${codeVO.rm}">
								${codeVO.rm}
							</a>
						</c:if></br>				
				<button class="arrow" onClick="javascript:fn_submit(document.frm_view,'/code.do','post'); return false;">목록</button>
				<button class="arrow" onClick="javascript:fn_submit(document.frm_view,'/code_modify_page.do','post'); return false;">수정</button>
				<button class="arrow" onClick="javascript:fn_submit(document.frm_view,'/code_delete.do','post'); return false;">삭제</button>
			</div>
		</div>
	</div>
</form>
</body>
</html>