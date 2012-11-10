package com.vst.util.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

public class CargarContexto extends TagSupport {

	
	
	
	
	public int doStartTag() throws JspException {

		
		
		
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException {
		
		return EVAL_PAGE;
	}

}
