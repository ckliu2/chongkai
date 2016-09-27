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
	<script src="/zion/scripts/jquery.metadata.js"></script>	
	<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.7/jquery.validate.min.js"></script>
</head> 
<body> 
	
  	
    	
    	<form id="frmLogin" class="validate">
    	
    	      <div data-role="fieldcontain">
                <label for="membername"><em>* </em> 真實姓名: </label>
                <input type="text" id="membername" name="member.name" 
                    class="required membername"                     
                />
            </div>
            
            
            <div data-role="fieldcontain">
                <label for="nickname"><em>* </em> 暱稱: </label>
                <input type="text" id="nickname" name="member.nickname" 
                    class="required nickname" />
            </div>
    	     
            
            <div data-role="fieldcontain">
                <label for="email"><em>* </em> Email: </label>
                <input type="text" id="email" name="member.email" 
                    class="required email" />
            </div>
            
            
            <div data-role="fieldcontain">
                <label for="cellphone"><em>* </em> 手機: </label>
                <input type="text" id="cellphone" name="member.cellphone" 
                    class="required cellphone" />
            </div>
            
            <div class="ui-body ui-body-b">
                <button class="btnLogin" type="submit"  data-theme="a">加入我們</button>
            </div>
            
        </form>
        

 <div data-role="footer"> 
  <h4>
    <a href="index.do">| 首頁 |</a>
    <a href="prayall.do">| 禱告368 |</a>
    <a href="prayme.do">| 為我禱告 |</a>
    <a href="body.do">| 為你禱告 |</a>    
   </h4>
</div> 



<script>


$( "#frmLogin" ).validate({
    submitHandler: function( form ) {
        //alert("Call Login Action...");
        
        var membername = $('#membername').val();  
        var nickname = $('#nickname').val(); 
        var cellphone = $('#cellphone').val()
        var email = $('#email').val(); 
       
        $.ajax({
        url: 'registerSave.do',
        type: "POST",        
        data: {"member.name":membername,"member.nickname":nickname,"member.cellphone":cellphone,"member.email":email},  
        dataType: "json",
        success: function(data) {
        	var returnValue=parseInt(data.returnValue);     
        	//alert('returnValue='+returnValue);     	
        	switch(returnValue)
          {
            case 1:
              alert(membername+',你好 歡迎加入我們!'); 
              window.location='index.do';
            break;
            case 2:
              alert('手機號碼'+cellphone+'已被註冊，請選擇其他手機號碼'); 
            break;
            case 3: 
             alert('Sorry!請聯繫管理人員');
            break; 
          }
        	
        }
      });
      
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