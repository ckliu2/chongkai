<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.base.httpupload4j.SmartUpload"%>
<%@ page import="com.base.httpupload4j.PhotoMg"%>

<%
System.out.println("3..");
	String pageErrorInfo = null;
	SmartUpload su = null;
	
  PhotoMg db=new PhotoMg();
  
	try{
		su = new SmartUpload();
		su.initialize(pageContext);
		su.upload();
		//db.fileUpload2();

		out.print("successed");
	}catch(Exception e){
	
	}finally{
		su = null;
		if(pageErrorInfo!=null){
		
		}
	}
%>

