package com.dbcore.common.util;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
	
	private CommonUtil() {}
	
	public static String getURLroot(HttpServletRequest request) {
		String contextPath = "";
		if (!"/".equals(request.getContextPath())) {
			contextPath = request.getContextPath();
		}
		String port = "";
		if (request.getServerPort() != 80) {
			port = ":" + request.getServerPort();
		}

		String protocol = "http://";
		if (request.isSecure())
			protocol = "https://";

		return protocol + request.getServerName() + port + contextPath + "/";
	}
}
