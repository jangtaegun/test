<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<form:form  name="frm_list" commandName="frm_list">
<div class="top">
	<input type="hidden" name="chnlId" 				id="chnlId" 			value="" />		
	<input type="hidden" name="useInitId" 			id="useInitId" 			value="" />	
	<ul class="search_input">
		<li><b:codelist items="${comboCodeList}" name="keyword" path="" lable="commonCode.ui.gubun" type="combobox"></b:codelist></li>
		<li><label>코드명</label><input class="search_box01" name="keyword2" id="keyword2" value="${keyword}" style="text" /></li>
	</ul>
	<div class="btn_wrap">
		<p class="btn01"><a href="" onClick="javascript:fn_submit(document.frm_list,'/soCodeList.do','post'); return false;">검색</a></p>
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
		<col width="15%" />
		<col width="60%" />
		</colgroup>
		<thead>
			<tr>
				<th scope="col">번호</th>
				<th scope="col">구분명</th>
				<th scope="col">공통코드</th>
				<th scope="col">공통코드 명</th>
				<th scope="col">비고</th>
			</tr>
		</thead>
		<tbody>
		<c:choose>
			<c:when test="${empty resultVOList}">
				<tr style="background: #fff;">
					<td style="padding: 25px 0;" colspan="5"><img src="<c:url value='images/contents/not_find.gif'/>" alt="검색결과가없습니다." /></td>
				</tr>
			</c:when>
			<c:otherwise>
			<c:forEach var="resultVOList" items="${resultVOList}" varStatus="status" >
				<tr  onclick="deCode_detailView('${resultVOList.chnlId}','${resultVOList.useInitId}','${resultVOList.cmmnCd}');" style="cursor: pointer;">
					<td><c:out value="${(codeVO.currentPageNo-1) * codeVO.recordCountPerPage + status.count}"/></td>
					<td>${resultVOList.cmmnGbCd}</td>
					<td>${resultVOList.cmmnCd}</td>
					<td class="left">${resultVOList.cmmnCdNm}</td>
					<td class="left">${resultVOList.rm}</td>						
				</tr>		
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
		<div class="pagin_wrap">
						<ui:pagination paginationInfo = "${paginationInfo}"
								type="text"
								jsFunction="soCodelinkPage"/>
		</div>	
	</div>
</form:form>
	<!-- 작성폼 -->
<form:form  name="DecodeDetail" commandName="DecodeDetail">
	<input type="hidden" name="insertUpdateFlage" 	id="insertUpdateFlage" 	value="" />	
<div id="deCodeDetail" style="display: none;">
		<div class="top">
			<div class="btn_wrap">
				<p class="btn01">
					<input type="button" value="저장"  onclick="javascript:fn_submit(document.DecodeDetail,'/soCode_insert.do','post','soCode');" />
				</p>
				<input type="button" value="삭제"  onclick="javascript:fn_submit(document.DecodeDetail,'/soCode_delete.do','post','');" />
			</div>
		</div>
		<div class="content">
		<table class="table_write01" summary="">
			<caption></caption>
			<colgroup>
			<col width="13%" />
			<col width="13%" />
			<col width="13%" />
			<col width="20%" />
			<col width="13%" />
			<col width="20%" />
			</colgroup>
			<tbody>
				<tr>
					<th scope="col">구분코드</th>
					<td><b:codelist items="${comboCodeList}" name="cmmnGbCd" path="" lable="blank" type="combobox"></b:codelist></td>
					<th scope="col">공통코드</th>
					<td><input class="text_box01" id="cmmnCd" name="cmmnCd" style="text"/></td>
					<th scope="col">공통코드명</th>
					<td><input class="text_box01" id="cmmnCdNm" name="cmmnCdNm" style="text"/></td>
				</tr>
				<tr>
					<th scope="col">문자1</th>
					<td><input class="text_box01" id="chrctr1Dc" name="chrctr1Dc" style="text" /></td>
					<th scope="col">문자2</th>
					<td><input class="text_box01" id="chrctr2Dc" name="chrctr2Dc" style="text" /></td>
					<th scope="col">문자3</th>
					<td><input class="text_box01" id="chrctr3Dc" name="chrctr3Dc" style="text" /></td>
				</tr>
				<tr>
					<th scope="col">숫자1</th>
					<td><input class="text_box01" id="number1Dc" name="number1Dc" style="text" /></td>
					<th scope="col">숫자2</th>
					<td><input class="text_box01" id="number2Dc" name="number2Dc" style="text" /></td>
					<th scope="col">숫자3</th>
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
<script type="text/javascript" src="<c:url value='/js/common.js'/>" charset='euc-kr'></script> 
<link rel="stylesheet" type="text/css" href="<c:url value='/css/contents/sub_contents.css'/>" />
<script type="text/javascript">
	showFlag=0;
	function deCode_detailView(chnlId, useInitId, cmmnCd) {
		 $.get("<c:url value='/soCodeDetailView.do'/>", { chnlId : chnlId, useInitId : useInitId, cmmnCd : cmmnCd }, function(res, code) {
		    var items = res.codeVO;
		 if(code=='success'){
			 	showFlag=1;
				$('#deCodeDetail').fadeIn(200);
			 	//대코드 상세정보
			    $("#cmmnGbCd").val(items.cmmnGbCd);
			    $("#cmmnCd").val(items.cmmnCd);
			    $("#cmmnCdNm").val(items.cmmnCdNm);
			    $("#chrctr1Dc").val(items.chrctr1Dc);
			    $("#chrctr2Dc").val(items.chrctr2Dc);
			    $("#chrctr3Dc").val(items.chrctr3Dc);
			    $("#number1Dc").val(items.number1Dc); 
			    $("#number2Dc").val(items.number2Dc); 
			    $("#number3Dc").val(items.number3Dc); 
			    $("#sortOrdr").val(items.sortOrdr); 
			    $("#rm").val(items.rm);
			    $("#insertUpdateFlage").val("U"); //기존코드 리스트를 클릭후 저장시 기존정보를 updatae하기 위한 플레그 설정
			    $("#cmmnCd").attr("readonly",true);
			    $("#cmmnCd").attr('title', '코드는 수정할수 없습니다.');
			    $('#cmmnCd').poshytip({
					className: 'tip-yellowsimple',
					showOn: 'focus',
					alignTo: 'target',
					alignX: 'inner-left',
					offsetX: 0,
					offsetY: 5,
					showTimeout: 100
				});
		 	}else{
		 		alert("코드를 가져오지 못했습니다.");
		 	}
		  }, "json");
	}

	function Enter_Check(){
		var form = document.frm_list;

		if(event.keyCode == 13){
			fn_submit(form,'/soCodeList.do','post');
		}
	}
	$(document).ready(function(){
		$('#addDeCode').click(
			function(){ 
				if(showFlag==0){
					$('#deCodeDetail').fadeIn(200);
					showFlag=1;
					 	$("#cmmnGbCd").val("");
					 	$("#cmmnCd").val("");
					    $("#cmmnCdNm").val("");
					    $("#chrctr1Dc").val("");
					    $("#chrctr2Dc").val("");
					    $("#chrctr3Dc").val("");
					    $("#number1Dc").val(""); 
					    $("#number2Dc").val(""); 
					    $("#number3Dc").val(""); 
					    $("#sortOrdr").val(""); 
					    $("#rm").val(""); 
					    $("#insertUpdateFlage").val("C");  //새로은 코드 저장시 정보를 저장할 플레그 설정
					    $("#cmmnCd").attr("readonly",false);
					    $("#cmmnCd").attr('title', '');
					    $('#cmmnCd').poshytip({
							className: 'tip-yellowsimple',
							showOn: 'focus',
							alignTo: 'target',
							alignX: 'inner-left',
							offsetX: 0,
							offsetY: 5,
							showTimeout: 100
						});
				}else if(showFlag==1){
					$('#deCodeDetail').fadeOut(200);
					showFlag=0;
						$("#cmmnGbCd").val("");
						$("#cmmnCd").val("");
					    $("#cmmnCdNm").val("");
					    $("#chrctr1Dc").val("");
					    $("#chrctr2Dc").val("");
					    $("#chrctr3Dc").val("");
					    $("#number1Dc").val(""); 
					    $("#number2Dc").val(""); 
					    $("#number3Dc").val(""); 
					    $("#sortOrdr").val(""); 
					    $("#rm").val(""); 
					    $("#insertUpdateFlage").val("C"); 
					    $("#cmmnCd").attr("readonly",false);
					    $("#cmmnCd").attr('title', '');
				}
			}
		);
	
	});

	function soCodelinkPage(pageNo){
		 location.href =   "/soCodeList.do?currentPageNo="+pageNo;
	}
</script>