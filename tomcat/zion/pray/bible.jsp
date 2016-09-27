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
      <li><a href="javascript:biblePanel();">每日讀經</a></li>      
      <li><a href="javascript:settingPanel();">聖經</a></li> 
    </ul>
  </div>
  
  
  
<iframe id="bibleIframe" width="100%" height="250" frameBorder="0" style="display:none">        
</iframe> 

<iframe id="settingIframe" width="100%" height="250" frameBorder="0" style="display:none">        
</iframe>


<jsp:include page="../layout/footer.jsp"/>


<script>
biblePanel();

function biblePanel(){
	$("#biblePanel").show(); 
	
	var bible = document.getElementById('bibleIframe');
	bible.src = "mybible.do?member.id=15";
	bible.style.display = '';
	
	var elem = document.getElementById('settingPanel');
	elem.style.display = 'none';
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