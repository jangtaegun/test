function fn_submit(obj, action, method,type) {
	
	if(type=='deCode'){
		
		if($("#cmmnGbCd").val()==''){
			alert('�ڵ屸���� �Է��� �ּ���.');
			return;
		}else if($("#cmmnGbNm").val()==''){
			alert('�ڵ屸�и��� �Է��� �ּ���.');
			return;
		}
		
		
	}else if(type=='soCode'){
		
		if($("#cmmnCd").val()==''){
			alert('�����ڵ带 �Է��� �ּ���.');
			return;
		}else if($("#cmmnCdNm").val()==''){
			alert('�����ڵ���� �Է��� �ּ���.');
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