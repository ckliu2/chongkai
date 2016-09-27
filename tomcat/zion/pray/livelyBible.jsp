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


<div id="signup"align="center"> 
  <div data-role="navbar">
    <ul>
      <li><a href="javascript:bible(1);"><span id="bible1"><span></a></li>      
      <li><a href="javascript:bible(2);"><span id="bible2"><span></a></li> 
      <li><a href="javascript:bible(3);"><span id="bible3"><span></a></li> 
      <li><a href="javascript:bible(4);"><span id="bible4"><span></a></li> 
    </ul>
  </div>
</div>

<iframe id="mobileIframe" width="100%" height="250" frameBorder="0"></iframe>        



<jsp:include page="../layout/footer.jsp"/>


<script>
volume();
bible(1);
//alert("$(window).height()="+$(window).height());	

function bible(id){	 
  var divHeight = document.getElementById('signup').clientHeight + 20; 
  
 
  var pageHeight = ($(window).height() - document.body.clientHeight - divHeight);
  
  //alert("window="+$(window).height()+"***clientHeight="+document.body.clientHeight+"***divHeight="+divHeight+"***pageHeight="+pageHeight);	
  
  //pageHeight=572;
  
	var elem = document.getElementById('mobileIframe');	
	elem.style.height =  pageHeight.toString() + 'px';	
	elem.src = "lection.do?classify="+id;
	

}


function volume(){
 $.getJSON("volume.do", function(data) {
  $.each(data, function(i, item) {  	
 	switch(parseInt(item.classify))
  	{
  		case 1:
  		 $("#bible1").text(item.bible+'-'+item.volume);
  		break;
  		
  		case 2:
  		 $("#bible2").text(item.bible+'-'+item.volume);
  		break;
  		
  		case 3:
  		 $("#bible3").text(item.bible+'-'+item.volume);
  		break;
  		
  		case 4:
  		 $("#bible4").text(item.bible+'-'+item.volume);
  		break;  		
  	}  
     //alert(i+"--"+item.classify+"--"+item.bible+'--'+item.volume);	
   });
 });	
}



    
</script>	

</body>
</html>