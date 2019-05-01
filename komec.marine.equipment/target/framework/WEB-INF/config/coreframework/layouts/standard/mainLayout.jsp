<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=9">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta http-equiv="X-UA-Compatible" content="IE=7">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/common/main.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/common/base.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/contents/base.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/contents/skip.css'/>" />
<link rel="stylesheet" type="text/css" href="<c:url value='/css/contents/sub_contents.css'/>" />
<style type="text/css">
            * {margin:0; padding:0; font-size:12px;}
            ul, li, ol {list-style-type : none;}
            a {color:#333; text-decoration:none; font-family:"돋움";}
            a:hover{text-decoration:underline}
            a:link, a:visited, a:active, a:hover {color:#333}
            
            #nav {width:203px;border:1px solid #dbdbdb;border-bottom:none; background:#f1f6f9; border-bottom:1px solid #dbdbdb;}
            #nav li ul {display:none;}
            #nav li ul li {background:url(/images/menu/bulet.gif) 10px 10px no-repeat;padding:4px 0 3px 17px}
            #nav li ul li a {color:#666668; text-indent:0;}
            #nav li a {display:block; width:195px; padding:5px 0 5px 8px; text-decoration:none; background:url(/images/menu/bg_menu_off.gif) no-repeat 0 0;}
            #nav li a:hover {font-weight:bold;}
            #nav li a.stay {background:url(/images/menu/bg_menu_stay.gif) no-repeat 0 0 !important;}
        	#nav li ul li a {width:188px; padding:1px 0 0 15px; margin-left:-17px; background:none;}
        	#nav li .active {background:url(/images/menu/bg_menu_on.gif) no-repeat 0 0 !important; font-weight:bold;}
</style>
<script src="<c:url value='/js/jquery/jquery-1.6.4.min.js'/>" type="text/javascript"></script>
 <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
 <script type="text/javascript">
            // 2010.12.29 sunsang.yoon (ssaeju@naver.com)
            $(document).ready(function(){
                var lastEvent = null;
                var slide  = "#nav > li > ul";
                var alink  = "#nav > li > a";
           
            	function accordion(){
            	    if (this == lastEvent) return false;
            		lastEvent = this;
            		setTimeout(function() {lastEvent = null}, 200);
            		
            		if ($(this).attr('class') != 'active') {
            			$(slide).slideUp();
            			$(this).next(slide).slideDown();
            			$(alink).removeClass('active');
                        $(this).addClass('active');
            		} else if ($(this).next(slide).is(':hidden')) {
            			$(slide).slideUp();
            			$(this).next(slide).slideDown();
            		} else {
            			$(this).next(slide).slideUp();
            		}
            	}
            	$(alink).click(accordion).focus(accordion);
            	$('#nav > li:last > a').addClass('stay');
             }); 
        </script>
</head>
<body>
<body>
   <div id="wrapper">
		  <!-- Begin Header -->
		  <div id="header">
		       <tiles:insertAttribute name='header'/>		 
		 </div>
		 <!-- End Header -->
         <!-- Begin Faux Columns -->
		 <div id="faux">
		  		<!-- Begin Left Column -->
			   <div id="leftcolumn">
			    	<tiles:insertAttribute name='menu'/>
			   </div>
				<!-- End Left Column -->
		       <!-- Begin Right Column -->
		       <div id="rightcolumn">
	                <tiles:insertAttribute name='contents'/>
		       </div>
		       <!-- End Right Column -->
			   
			   <div class="clear"></div>
			   
         </div>	   
         <!-- End Faux Columns --> 
		   <!-- Begin Footer -->
			<div id="footer">
      			<tiles:insertAttribute name="footer"/>
   			</div>
			<!-- End Footer -->
   </div>
   <!-- End Wrapper -->
</body>
</html>
