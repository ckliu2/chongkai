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
	
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
	
	
	
	
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
   
   label.error {
    color: red;
    font-size: 16px;
    font-weight: normal;
    line-height: 1.4;
    margin-top: 0.5em;
    width: 100%;
    float: none;
}

@media screen and (orientation: portrait){
    label.error { margin-left: 0; display: block; }
}

@media screen and (orientation: landscape){
    label.error { display: inline-block; margin-left: 22%; }
}

em { color: red; font-weight: bold; padding-right: .25em; }

   
   	</style>
</head> 
<body> 
	
<div data-role="page" style="max-height:90px; min-height:90px;">
	
	
<div data-role="header"> 
	<h1>368禱告網</h1> 
</div>

	<div data-role="content" > 
    	<div data-role="footer" class="nav-glyphish-example">
    		<div data-role="navbar" class="nav-glyphish-example" >
    		<ul>    			
    			<li><a href="prayall.do" id="prayall" data-icon="custom" >禱告368</a></li>
    			<li><a href="prayme.do" id="prayme" data-icon="custom">為我禱告</a></li>
    			<li><a href="body.do" id="bodypray" data-icon="custom">為你禱告</a></li>
    			<li><a href="#userlogin" id="login" data-icon="custom" data-rel="popup" data-position-to="window" data-transition="fade">登入</a></li>
    		</ul>
    		</div>
    	</div>
    	
    	
    	<form id="frmLogin" class="validate">
    	
    	      <div data-role="fieldcontain">
                <label for="membername"><em>* </em> 真實姓名: </label>
                <input type="text" id="membername" name="membername" 
                    class="required membername" />
            </div>
            
            
            <div data-role="fieldcontain">
                <label for="nickname"><em>* </em> 暱稱: </label>
                <input type="text" id="nickname" name="nickname" 
                    class="required nickname" />
            </div>
    	     
            
            <div data-role="fieldcontain">
                <label for="email"><em>* </em> Email: </label>
                <input type="text" id="email" name="email" 
                    class="required email" />
            </div>
            
            
            <div data-role="fieldcontain">
                <label for="cellphone"><em>* </em> 手機: </label>
                <input type="text" id="cellphone" name="cellphone" 
                    class="required cellphone" />
            </div>
            
            <div class="ui-body ui-body-b">
                <button class="btnLogin" type="submit"  data-theme="a">加入我們</button>
            </div>
            
        </form>
        
	</div>
  
  
  <div data-role="footer"> 
	 <h4>基督教溝子口錫安堂</h4> 
  </div>
  
</div>


<script>


$( "#frmLogin" ).validate({
    submitHandler: function( form ) {
        alert( "Call Login Action" );
    }
});

 function register(){
   var cellphone=form1.cellphone.value;	
   if(cellphone!=''){
     alert(cellphone);
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
</script>









</body>
</html>