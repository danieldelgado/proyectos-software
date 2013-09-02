package com.google.gcm.util;

import javax.servlet.http.HttpServletResponse;

public class HttpUtilConexion {

	public static void setSuccess(HttpServletResponse resp) {
		setSuccess(resp, 0);
	}

	public static void setSuccess(HttpServletResponse resp, int size) {
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("text/plain");
		resp.setContentLength(size);
	}
	
}
