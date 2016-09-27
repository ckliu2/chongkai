<!DOCTYPE html>

<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ include file="/common/webtag.jsp"%>
 
<html> 
<head> 
	<title>基督教溝子口錫安堂教會</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css"/>
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	
	<style>
	html, body { padding: 0; margin: 0; }
	html, .ui-mobile, .ui-mobile body {
    	height: 85px;
	}
	.ui-mobile, .ui-mobile .ui-page {
    	min-height: 85px;
	}
	.ui-content{
		padding:10px 15px 0px 15px;
	}
    .nav-glyphish-example .ui-btn .ui-btn-inner { padding-top: 40px !important; }
    .nav-glyphish-example .ui-btn .ui-icon { width: 30px!important; height: 30px!important; margin-left: -15px !important; box-shadow: none!important; -moz-box-shadow: none!important; -webkit-box-shadow: none!important; -webkit-border-radius: 0 !important; border-radius: 0 !important; }
    #prayall .ui-icon { background:  url(images/368.png) 50% 50% no-repeat; background-size: 30px 30px; }
    #prayme .ui-icon { background:  url(images/prayme.png) 50% 50% no-repeat; background-size: 30px 30px;  }
    #bodypray .ui-icon { background:  url(images/bodypray.png) 50% 50% no-repeat;  background-size: 30px 30px; }
    #login .ui-icon { background:  url(images/login.png) 50% 50% no-repeat;  background-size: 30px 30px; }
   	</style>
</head> 
<body> 
  <div id="prayitem" >      
    <ul data-role="listview"  data-inset="true">
    
    <ww:set name="globalList" value="%{getPrayTWGlobalList()}"/>	     
     <ww:iterator value="globalList">   
      <li>${content}</li>
     </ww:iterator>     
     
    </ul>   
  </div>

  <br>
  

  










</body>
</html>
