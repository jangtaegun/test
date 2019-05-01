<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jfastmenu.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$.jFastMenu("#menu");
});
</script>
<div id="menu">
	<ul>
		<li><a href="/mainPage.do">HOME</a></li>
		<li><a href="#">MASTER</a>
			<ul>
				<li><a href="/compay.do">업체관리</a></li>
				<li><a href="/ship.do">선박관리</a></li>
				<li><a href="#">선박별업체관리</a></li>
				<li><a href="#">표준제품관리</a></li>
				<li><a href="#">선박별공급제품관리</a></li>
				<li><a href="#">BOM관리</a></li>
				<li><a href="#">표준절차서</a></li>
				<li><a href="#">사원관리</a></li>
				<li><a href="#">검사항목관리</a></li>
			</ul>	
		</li>
		<li><a href="#">PROJECT</a>
			<ul>
				<li><a href="#">고객요청사항접수</a></li>
				<li><a href="#">수리/교체결과</a></li>
				<li><a href="#">검사결과</a></li>
				<li><a href="#">협력등록/처리</a></li>
				<li><a href="#">협력신청</a></li>
			</ul>	
		</li>
		<li><a href="#">자재관리</a>
			<ul>
				<li><a href="#">자재별수리관리</a></li>
				<li><a href="#">자재별교체관리</a></li>
				<li><a href="#">자재별검사관리</a></li>
			</ul>	
		</li>
		<li><a href="#">Marketing</a>
			<ul>
				<li><a href="#">사전교체정보조회</a></li>
				<li><a href="#">사전검사정보</a></li>
			</ul>	
		</li>
		<li><a href="#">Sample</a>
			<ul>
				<li><a href="/code.do">코드관리</a></li>
			</ul>	
		</li>
	</ul>
</div>