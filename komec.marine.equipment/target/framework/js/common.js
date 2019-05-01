function fn_submit(obj, action, method) {
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
 location.href =   "/codeList.do?currentPageNo="+pageNo;
}