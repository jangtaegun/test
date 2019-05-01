function fn_submit(obj, action, method,type) {
	
	if(type=='deCode'){
		
		if($("#cmmnGbCd").val()==''){
			alert('코드구분을 입력해 주세요.');
			return;
		}else if($("#cmmnGbNm").val()==''){
			alert('코드구분명을 입력해 주세요.');
			return;
		}
		
		
	}else if(type=='soCode'){
		
		if($("#cmmnCd").val()==''){
			alert('공통코드를 입력해 주세요.');
			return;
		}else if($("#cmmnCdNm").val()==''){
			alert('공통코드명을 입력해 주세요.');
			return;
		}
		
	}
	
	obj.action = action;
	obj.method = method;
	obj.submit();
}

function isValue(obj, msg) {
	var objReg = /\s+/g;
	var objValue = obj.value.replace(objReg, '');
	if (objValue == "" || objValue.length == 0) {
		alert(msg);
		obj.focus();
		return false;
	}
	return true;
}

function linkPage(pageNo){
 location.href =   "/deCodeList.do?currentPageNo="+pageNo;
}