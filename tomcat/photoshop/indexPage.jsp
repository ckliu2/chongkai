<%@ include file="/common/unsecureTaglibs.jsp"%>

<!doctype html>
<head>
<!--[if lt IE 7]> <html class="ie6 oldie"> <![endif]-->
<!--[if IE 7]>    <html class="ie7 oldie"> <![endif]-->
<!--[if IE 8]>    <html class="ie8 oldie"> <![endif]-->
<!--[if gt IE 8]><!-->
<!--<![endif]-->
<!--[if gte IE 9]>
  <style type="text/css">
    .gradient {
       filter: none;
    }
  </style>
<![endif]-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登入</title>
<style type="text/css">
html{
	width: 100%;
	font-family: "微軟正黑體";
	-webkit-text-size-adjust: none;
	background-color: #1e69de;
	background-image: url(images/login.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: left top; /*固定住左下邊不要被裁切*/
	background-size: cover; /*滿版出血 裁切掉一小邊邊*/
}
</style>



<link href="${ctx}/css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/jquery.cookie.js"></script>


</head>

<body>
<div class="login">
    <div class="login_cen">    	  
          <input name="cellphone" id="cellphone" type="text" class="input" id="target" placeholder="請輸入手機號碼登入" />
          <div class="btn">
          <a href="javascript:userlogin();">登入</a> 
          </div>
          <div class="btn2">
          <a href="home.html">Facebook帳號登入</a> 
          </div>
          <div class="btn3">
          <a href="register.jsp">註冊</a> 
          </div> 
          <div class="line"></div>
          <div class="text">
          隨心所欲拍照沖洗。
          </div>                   
    </div>      
</div>

<script> 
	
 if (typeof $.cookie('userId') != 'undefined')
 { 	  
 	  window.location='index.html';
 }
 
 function userlogin(){
 	   	 var cellphone= $("#cellphone").val(); 	   	 
      //ajax
      $.ajax({
        url: 'loginCellphone.html',
        type: "POST",        
        data: {"cellphone":cellphone},  
        dataType: "json",
        success: function(data) {
        	var returnValue=parseInt(data.returnValue); 
        	if(returnValue==1){
        		var userId=parseInt(data.userId); 
        		var customername=data.customername; 
        		alert(customername + ' 您好!歡迎登入');
        		window.location='index.html';
        	}else{
        		alert('Sorry!登入失敗!');
        	}
        	
          }
      });        
 }
 

  
</script>


</body>
</html>

<!--

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>登入</title>
<style type="text/css">
html{
	width: 100%;
	font-family: "微軟正黑體";
	-webkit-text-size-adjust: none;
	background-color: #1e69de;
	background-image: url(images/login.jpg);
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: left top; /*固定住左下邊不要被裁切*/
	background-size: cover; /*滿版出血 裁切掉一小邊邊*/
}
</style>


<link href="${ctx}/css/css.css" rel="stylesheet" type="text/css">
<script src="${ctx}/scripts/jquery.js"></script>
<script src="${ctx}/scripts/jquery.cookie.js"></script>

</head>

<body>
<div class="login">
    <div class="login_cen">    	  
          <input name="cellphone" id="cellphone" type="text" class="input" id="target" placeholder="請輸入手機號碼登入" />
          <div class="btn">
          <a href="javascript:userlogin();">登入</a> 
          </div>
          <div class="btn2">
          <a href="home.html">Facebook帳號登入</a> 
          </div>
          <div class="btn3">
          <a href="register.jsp">註冊</a> 
          </div> 
          <div class="line"></div>
          <div class="text">
          隨心所欲拍您想要的照片，並且立即上傳至我們的雲端沖洗館。
          </div>                   
    </div>      
</div>


<script> 
	
 if (typeof $.cookie('userId') != 'undefined')
 { 	  
 	  window.location='index.html';
 }
 
 function userlogin(){
 	   	 var cellphone= $("#cellphone").val(); 	   	 
      //ajax
      $.ajax({
        url: 'loginCellphone.html',
        type: "POST",        
        data: {"cellphone":cellphone},  
        dataType: "json",
        success: function(data) {
        	var returnValue=parseInt(data.returnValue); 
        	if(returnValue==1){
        		var userId=parseInt(data.userId); 
        		var customername=data.customername; 
        		alert(customername + ' 您好!歡迎登入');
        		window.location='index.html';
        	}else{
        		alert('Sorry!登入失敗!');
        	}
        	
          }
      });        
 }
 

  
</script>
-->

</body>
</html>
