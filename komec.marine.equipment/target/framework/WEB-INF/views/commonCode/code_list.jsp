<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<%-- <form:form commandName="frm_list">
	<input type="hidden" name="chnlId" value="" />		
	<input type="hidden" name="useInitId" value="" />	
	<input type="hidden" name="cmmnGbCd" value="" />		
	<div class="container">
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
</form:form>  --%>
<form:form  name="frm_list" commandName="frm_list">
<div class="top">
	<input type="hidden" name="chnlId" 				id="chnlId" 			value="" />		
	<input type="hidden" name="useInitId" 			id="useInitId" 			value="" />	
	<ul class="search_input">
		<li><label>구분</label><input class="search_box01"     style="text" /></li>
		<li><label>구분 명</label><input class="search_box01" name="keyword" id="keyword" value="${keyword}" style="text" /></li>
	</ul>
	<div class="btn_wrap">
		<p class="btn01"><a href="" onClick="javascript:fn_submit(document.frm_list,'/codeList.do','post'); return false;">검색</a></p>
		<p class="btn01"><a href="javascript://" id="addDeCode">추가</a></p>
	</div>
</div>
<div class="content">
	<table class="table_list01" summary="">
		<caption></caption>
		<colgroup>
		<col width="10%" />
		<col width="15%" />
		<col width="15%" />
		<col width="60%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">구분코드</th>
				<th scope="col">구분 명</th>
				<th scope="col">비고</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="resultVOList" items="${resultVOList}" varStatus="status" >
			<tr  onclick="deCode_detailView('${resultVOList.chnlId}','${resultVOList.useInitId}','${resultVOList.cmmnGbCd}');" style="cursor: pointer;">
				<td><c:out value="${(codeVO.currentPageNo-1) * codeVO.recordCountPerPage + status.count}"/></td>
				<td>${resultVOList.cmmnGbCd}</td>
				<td class="left">${resultVOList.cmmnGbNm}</td>
				<td class="left">${resultVOList.rm}</td>						
			</tr>		
			
			</c:forEach>
		</tbody>
	</table>
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
</form:form>
	<!-- 작성폼 -->
<form:form  name="DecodeDetail" commandName="DecodeDetail">
	<input type="hidden" name="insertUpdateFlage" 	id="insertUpdateFlage" 	value="" />	
<div id="deCodeDetail" style="display: none;">
		<div class="top">
			<div class="btn_wrap">
				<p class="btn01">
					<input type="button" value="저장"  onclick="javascript:fn_submit(document.DecodeDetail,'/code_insert.do','post');" />
				</p>
				<!-- <p class="btn01"><a href="">삭제</a></p> -->
				<input type="button" value="삭제"  onclick="javascript:fn_submit(document.DecodeDetail,'/code_delete.do','post');" />
			</div>
		</div>
		<div class="content">
		<table class="table_write01" summary="">
			<caption></caption>
			<colgroup>
			<col width="13%" />
			<col width="20%" />
			<col width="13%" />
			<col width="20%" />
			<col width="13%" />
			<col width="20%" />
			</colgroup>
			<tbody>
				<tr>
					<th scope="col">코드구분코드</th>
					<td><input class="text_box01" id="cmmnGbCd" name="cmmnGbCd" style="text"/></td>
					<th scope="col">코드구분 명</th>
					<td colspan="3"><input class="text_box01" id="cmmnGbNm" name="cmmnGbNm" style="text"/></td>
				</tr>
				<tr>
					<th scope="col">문자1설명</th>
					<td><input class="text_box01" id="chrctr1Dc" name="chrctr1Dc" style="text" /></td>
					<th scope="col">문자2설명</th>
					<td><input class="text_box01" id="chrctr2Dc" name="chrctr2Dc" style="text" /></td>
					<th scope="col">문자3설명</th>
					<td><input class="text_box01" id="chrctr3Dc" name="chrctr3Dc" style="text" /></td>
				</tr>
				<tr>
					<th scope="col">숫자1설명</th>
					<td><input class="text_box01" id="number1Dc" name="number1Dc" style="text" /></td>
					<th scope="col">숫자2설명</th>
					<td><input class="text_box01" id="number2Dc" name="number2Dc" style="text" /></td>
					<th scope="col">숫자3설명</th>
					<td><input class="text_box01" id="number3Dc" name="number3Dc" style="text" /></td>
				</tr>
				<tr>
					<th scope="col">정렬</th>
					<td><input class="text_box01" id="sortOrdr" name="sortOrdr" style="text" /></td>
					<td colspan="4"></td>
				</tr>
				<tr>
					<th scope="col">비고</th>
					<td colspan="5"><input class="text_box01" id="rm" name="rm" style="text" /></td>
				</tr>
			</tbody>
		</table>
		</div>
</div>
</form:form>
<script type="text/javascript" src="<c:url value='/js/common.js'/>" ></script> 
<link rel="stylesheet" type="text/css" href="<c:url value='/css/contents/sub_contents.css'/>" />
<script type="text/javascript">
	showFlag=0;
	function deCode_detailView(chnlId, useInitId, cmmnGbCd) {
		$.get("<c:url value='/DecodeDetailView.do'/>", { chnlId : chnlId, useInitId : useInitId, cmmnGbCd : cmmnGbCd }, function(res, code) {
		    var items = res.codeVO;
		 if(code=='success'){
			 	showFlag=1;
				$('#deCodeDetail').fadeIn(200);
			 	//대코드 상세정보
			    $("#cmmnGbCd").val(items.cmmnGbCd);
			    $("#cmmnGbNm").val(items.cmmnGbNm);
			    $("#chrctr1Dc").val(items.chrctr1Dc);
			    $("#chrctr2Dc").val(items.chrctr2Dc);
			    $("#chrctr3Dc").val(items.chrctr3Dc);
			    $("#number1Dc").val(items.number1Dc); 
			    $("#number2Dc").val(items.number2Dc); 
			    $("#number3Dc").val(items.number3Dc); 
			    $("#sortOrdr").val(items.sortOrdr); 
			    $("#rm").val(items.rm); 
			    $("#insertUpdateFlage").val("U"); //기존코드 리스트를 클릭후 저장시 기존정보를 updatae하기 위한 플레그 설정
		 	}else{
		 		alert("코드를 가져오지 못했습니다.");
		 	}
		  }, "json");
	}

	function Enter_Check(){
		var form = document.frm_list;

		if(event.keyCode == 13){
			fn_submit(form,'/codeList.do','post');
		}
	}
	$(document).ready(function(){
		$('#addDeCode').click(
			function(){ 
				if(showFlag==0){
					$('#deCodeDetail').fadeIn(200);
					showFlag=1;
					 	$("#cmmnGbCd").val("");
					    $("#cmmnGbNm").val("");
					    $("#chrctr1Dc").val("");
					    $("#chrctr2Dc").val("");
					    $("#chrctr3Dc").val("");
					    $("#number1Dc").val(""); 
					    $("#number2Dc").val(""); 
					    $("#number3Dc").val(""); 
					    $("#sortOrdr").val(""); 
					    $("#rm").val(""); 
					    $("#insertUpdateFlage").val("C");  //새로은 코드 저장시 정보를 저장할 플레그 설정
				}else if(showFlag==1){
					$('#deCodeDetail').fadeOut(200);
					showFlag=0;
						$("#cmmnGbCd").val("");
					 	$("#cmmnGbNm").val("");
					    $("#chrctr1Dc").val("");
					    $("#chrctr2Dc").val("");
					    $("#chrctr3Dc").val("");
					    $("#number1Dc").val(""); 
					    $("#number2Dc").val(""); 
					    $("#number3Dc").val(""); 
					    $("#sortOrdr").val(""); 
					    $("#rm").val(""); 
					    $("#insertUpdateFlage").val("C"); 
				}
			}
		);
	});
	
</script>