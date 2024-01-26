package config;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

public class StreamData {

	public static  String dataChange(HttpServletRequest  request) {
		
		StringBuffer strbuf = new StringBuffer();
	    String line = null;
	 
	    try {
	        BufferedReader reader = request.getReader();
	        while((line = reader.readLine()) != null) {
	        	strbuf.append(line);
	        }
	 
	    }catch(Exception e) {
	        System.out.println("Error reading JSON string: " + e.toString());
	    }
	   // String reqdata =  strbuf.toString();
	    String reqdata =  String.valueOf(strbuf);
		 
	    System.out.println("reqdata : " + reqdata);
	    
	    
	    return reqdata;
	}
}
