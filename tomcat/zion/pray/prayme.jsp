<!DOCTYPE html> 

<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>

<html>

 <head>
	<title>基督教溝子口錫安堂教會</title> 
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
	<script src="/zion/scripts/jquery.cookie.js"></script>

 </head>
  
<body> 

<div data-role="tabs">

  <div data-role="navbar">
    <ul>
      <li><a href="javascript:myneedPanel();">我的需要</a></li>      
      <li><a href="javascript:prayitem();">我的代禱事項</a></li> 
    </ul>
  </div>
  
  <div id="myneedPanel" class="ui-body-d ui-content">
   <form name="form1">
    <textarea cols="40" rows="8" name="content" id="content"></textarea>   
    <input type="button" value="送出" onclick="javascript:myneed();"/>
   </form> 
  </div>
  
 

<iframe id="mobileIframe" width="100%" height="250" frameBorder="0" style="display:none">        
</iframe>


<jsp:include page="../layout/footer.jsp"/>


<script>

function myneedPanel(){
	$("#myneedPanel").show(); 
	var elem = document.getElementById('mobileIframe');
	elem.style.display = 'none';
}

function myneed() 
{
	var memberId=$.cookie('memberId');     
	var content = $('#content').val();	
  //alert(memberId+'--'+content);
	    	$.ajax({
        url: 'savePrayItem.do',
        type: "POST",        
        data: {"content":content,"member.id":memberId},  
        dataType: "json",
        success: function(data) {
        	var returnValue=data.returnValue;  
        	if(returnValue=='success'){
        		   alert('我們已收到您的代禱事項');
        		   $('#content').val('');
        		 }else{
        		 	 alert('Sorry!請聯繫管理人員');
        		 }  
        }
      });
      
      
}
    
  function prayitem() 
	 {
	 	 var myneedPanel = document.getElementById('myneedPanel');
	 	 myneedPanel.style.display = 'none';
	 	
	 	 var memberId=$.cookie('memberId');   
	 	 var elem = document.getElementById('mobileIframe');
	   elem.src = "myprayme.do?member.id="+memberId;
	   elem.style.display = '';
   }	
   
 function whoami(){      
   var memberId=$.cookie('memberId');	
   if (typeof(memberId) == "undefined")
   {
     alert('您尚未登入，請先登入，謝謝!');	
     window.location='index.do';
   }
 }   
   
  whoami();

    
</script>	

</body>
</html>