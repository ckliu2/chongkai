<%@ include file="/common/unsecureTaglibs.jsp"%>
<!DOCTYPE html> 
<html> 
<head>
  <meta charset="UTF-8">	
	<title>沖洗照片</title> 	
	<meta name="viewport" content="width=device-width, initial-scale=1">     
  <link rel="stylesheet" href="${ctx}/css/jquery.mobile.structure-1.0.1.css" />
	<link rel="stylesheet" href="${ctx}/css/jquery.mobile-1.0.1.css" />   
	<link rel="stylesheet" href="${ctx}/css/custom.css" />  
	<script src="${ctx}/scripts/jquery-1.7.1.min.js"></script>
	<script src="${ctx}/scripts/jquery.mobile-1.0.1.min.js"></script>
</head>  
<body> 

<div data-role="page">

	
<div data-role="content" data-theme="a">
		<h3>設定</h3>
		<a href="login.jsp" data-role="button" data-rel="dialog" data-transition="slidedown" data-theme="b">登入</a>     
		<a href="register.jsp" data-role="button" data-rel="dialog" data-transition="slidedown" data-theme="b" rel="external">註冊</a>     
		    
		
		<!--
		
		<a href="register.jsp" >註冊</a>   
		--> 
		<!--
		<a href="history.jsp" data-role="button" data-rel="dialog" data-transition="slidedown" data-theme="b" >歷史記錄</a>       
		-->
		<a href="index.html" data-role="button" data-rel="back" data-theme="a">Cancel</a>    
	</div>
</div>






</body>
</html>