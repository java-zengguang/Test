package com.student.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

public class ConfigReader {
	public static Properties read(String path){
		Properties ps=new Properties();
		Reader in=null;
		try {
			in=new InputStreamReader(new FileInputStream(path),"GBK");
		ps.load(in);
		} catch (Exception e) {
				e.printStackTrace();
		}
		return ps;
	}
}
