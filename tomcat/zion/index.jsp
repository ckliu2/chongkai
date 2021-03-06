<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>

<!DOCTYPE html> 
<html> 
<head> 
	<title>基督教溝子口錫安堂教會</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
	<script src="/zion/scripts/jquery.cookie.js"></script>
	
	
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
    #sunday .ui-icon { background:  url(images/bodypray.png) 50% 50% no-repeat;  background-size: 30px 30px; }
    #bible .ui-icon { background:  url(images/bodypray.png) 50% 50% no-repeat;  background-size: 30px 30px; }
    #login .ui-icon { background:  url(images/login.png) 50% 50% no-repeat;  background-size: 30px 30px; }
   	</style>
</head> 
<body> 
	
<div data-role="page" style="max-height:90px; min-height:90px;">
	
	
<div data-role="header"> 
	<h1>368禱告網-<span id="membername"/></h1> 
</div>

	<div data-role="content" > 
    	<div data-role="footer" class="nav-glyphish-example">
    		<div data-role="navbar" class="nav-glyphish-example" >
    		<ul>    			
    			<li><a href="prayall.do" id="prayall" data-icon="custom" >禱告368</a></li>
    			<li><a href="prayme.do" id="prayme" data-icon="custom">為我禱告</a></li>
    			<li><a href="body.do" id="bodypray" data-icon="custom">為你禱告</a></li>
    			<li><a href="sunday.do" id="sunday" data-icon="custom">主日信息</a></li>    			
    			
    			<!--
    			<li><a href="#userlogin" id="login" data-icon="custom" data-rel="popup" data-position-to="window" data-transition="fade">登入</a></li>
    		  -->
    		</ul>
    		</div>
    	</div>
	</div>
	
	

	
	<p>

  <ul data-role="listview"> 	
  
  
  	<!-------------------------------------------------------------------->
  	
  	
  	<c:set var="count" value="1" />
  	<ww:set name="classifyList" value="%{getClassifyList()}"/>	     
    <ww:iterator value="classifyList"> 
      
	   <li> 
       <h3>${valueTw}</h3>   
      <ul data-role="listview" data-inset="true"> 
      
      
     <div data-role="footer"> 
      <h4>
       <a href="index.do">| 首頁 </a>
       <a href="prayall.do">| 禱告368 </a>
       <a href="prayme.do">| 為我禱告 </a>
       <a href="body.do">| 為你禱告 </a> 
       <a href="sunday.do">| 主日信息 |</a>        
      </h4>
     </div>

      
      <ww:set name="prayList" value="%{getPrayListByClassify('${id}')}"/>	     
      <ww:iterator value="prayList">       
      
	       <li><a href="#church${count}" data-rel="popup" data-position-to="window" data-inline="Flow">${content}...(<fmt:formatDate value="${createdDate}" pattern="yyyy-MM-dd"/>)</a></li>
        
         <div data-role="popup" id="church${count}" class="ui-content" data-overlay-theme="a" data-corners="false" data-tolerance="30,15">
	         <a href="#" data-rel="back" data-role="button" data-theme="a" data-icon="delete" data-iconpos="notext" class="ui-btn-right">Close</a> 
	         <p>${content}。(<fmt:formatDate value="${createdDate}" pattern="yyyy-MM-dd"/>)<p>
         </div>
         
         <c:set var="count" value="${count+1}" />
       </ww:iterator>  
  
       </ul> 
     </li> 
   
    </ww:iterator>
      
   	<!-------------------------------------------------------------------->
     
     
	   
  </ul> 
  
   

  <br>
  
  
  <div data-role="popup" id="userlogin" data-overlay-theme="a" data-theme="d" data-corners="false">
			<a href="#" data-rel="back" data-role="button" data-theme="a" data-icon="delete" data-iconpos="notext" class="ui-btn-right">Close</a>
		 <form name="form1">	
			 <label for="basic">手機:</label>
       <input type="text" name="cellphone" id="cellphone"/>
       <input type="button" value="送出" onclick="javascript:login();"/>
  
       <a href="javascript:register();">註冊</a>
       <!--
       <a href="register.do">註冊</a>
       -->
     </form> 
      
  </div>
  
  

  
  
  <div data-role="footer"> 
	 <h4><a href="#userlogin"  data-icon="custom" data-rel="popup" data-position-to="window" data-transition="fade">登入</a></h4> 
	 <h4>基督教溝子口錫安堂</h4> 
  </div>
  
</div>


<script>

 function login(){
   var cellphone=form1.cellphone.value;	
   if(cellphone!=''){
     //alert(cellphone);
     var u='userlogin.do?cellphone='+cellphone;
     $.ajax({
        url: u,
        type: "GET",
        dataType: "json",
        success: function(data) {
        	var membername=$.cookie('membername'); 
        	var returnValue=data.returnValue;            	
          //alert('returnValue='+returnValue);  	
        	if(membername!=''&& returnValue=='login-success'){
        		alert(membername+',你好! 歡迎登入!');            
        		$("#membername").html(membername);         		    	
        		$("#userlogin").popup("close");
        	}else{
        		alert('找不到'+cellphone+'的手機，請註冊!'); 
        		$("#userlogin").popup("close");
        	}        	
        }
     });     
   }else{
   	 alert('請輸入手機號碼!');
   }
 }
 
 
 function register(){
   //alert('register...');	
   window.location='register.do';
 }
 
 
 //抓取cookie
 var membername=$.cookie('membername'); 
 $("#membername").html(membername);   
 


</script>






</body>
</html>