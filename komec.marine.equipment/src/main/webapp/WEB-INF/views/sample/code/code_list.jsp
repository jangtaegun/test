<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>코드관리</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common/base.css" />
<script type="text/javascript" src="<%=request.getContextPath()%>/js/common.js"></script> 
<script type="text/javascript">

	function fn_detailView(chnlId, useInitId, cmmnGbCd) {
		var lform = document.frm_list;
		
		lform.chnlId.value = chnlId;
		lform.useInitId.value = useInitId;
		lform.cmmnGbCd.value = cmmnGbCd;
		fn_submit(lform,'/code_view.do','post');
	}

	function Enter_Check(){
		var form = document.frm_list;

		if(event.keyCode == 13){
			fn_submit(form,'/codeList.do','post');
		}
	}
</script>
</head>
<body>
<form name="frm_list">
	<input type="hidden" name="chnlId" value="" />		
	<input type="hidden" name="useInitId" value="" />	
	<input type="hidden" name="cmmnGbCd" value="" />		
	<div class="container">
		<div class="header">
			<jsp:include page="../../common/header.jsp" flush="false"/>
		</div>
		<div class="main">
			<div class="content" id="content">
				<div>
					<dl>
						<dt>
							<font style="font-size: small;">코드명 : </font>
							<input name="keyword" size="25" type="text" value="${keyword}" onKeyDown="javascript:Enter_Check();"/>
							<button class="arrow" onClick="javascript:fn_submit(document.frm_list,'/codeList.do','post'); return false;">검색</button>
							<button class="arrow" onClick="javascript:fn_submit(document.frm_list,'/code_insert_page.do','post'); return false;">신규입력</button>
						</dt>
					</dl>
				</div>
				<table>
					<!-- 리스트 헤드 -->
					<thead>
						<tr>
							<th>CHNL_ID</th>
							<th>USE_INIT_ID</th>
							<th>CMMN_GB_CD</th>
							<th>CMMN_GB_NM</th>
							<th>NUMBER1_DC</th>
							<th>CHRCTR1_DC</th>
							<th>SORT_ORDR</th>
							<th>RM</th>
						</tr>
					</thead>
					<!-- 리스트 내용 -->
					<tbody>
						<c:forEach var="vo" items="${resultVOList}">
							<tr onclick="fn_detailView('${vo.chnlId}','${vo.useInitId}','${vo.cmmnGbCd}');" style="cursor: pointer;">
								<td>${vo.chnlId}</td>
								<td>${vo.useInitId}</td>
								<td>${vo.cmmnGbCd}</td>
								<td>${vo.cmmnGbNm}</td>
								<td>${vo.number1Dc}</td>
								<td>${vo.chrctr1Dc}</td>
								<td>${vo.sortOrdr}</td>
								<td>${vo.rm}</td>						
							</tr>			
						</c:forEach>
					</tbody>
				</table>	
				<br/>
				<table style="width: 100%;">
					<tr>
						<td style="text-align: center;">
							<ui:pagination paginationInfo = "${paginationInfo}"
									type="text"
									jsFunction="linkPage"/>
						</td>
					</tr>
				</table>			
			</div>
		</div>
	</div>
</form>
</body>
</html>