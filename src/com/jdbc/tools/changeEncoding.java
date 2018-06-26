package com.jdbc.tools;

import java.io.UnsupportedEncodingException;

public class changeEncoding {
	public static String isoToGbk(String s) throws UnsupportedEncodingException{
		String s1=new String(s.getBytes("ISO-8859-1"),"GBK");
		return s1;
	}
}

