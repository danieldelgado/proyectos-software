package com.vst.util;

import java.io.Serializable;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

public class BeanData implements Serializable, JSONAware{

	private static final long serialVersionUID = 1L;
	
	String key;
	Object val;
	

	public BeanData(String key, Object val) {
		super();
		this.key = key;
		this.val = val;
	}

	public String toJSONString() {
		  StringBuffer sb = new StringBuffer();          
          sb.append(JSONObject.escape(key));
          sb.append(":");
          sb.append(val);
          return sb.toString();
	}
	
	/*public static void main(String[] args) {
		System.out.println(new BeanData("2asda", "1asd").toJSONString());
	}
	*/
	
	
}
