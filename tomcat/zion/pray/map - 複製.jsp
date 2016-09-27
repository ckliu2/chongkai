<!DOCTYPE html> 

<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>


<html>
	
	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1" >
	<title>Navbar - jQuery Mobile Demos</title>	
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="http://demos.jquerymobile.com/1.4.0/css/themes/default/jquery.mobile-1.4.0.min.css">
	<link rel="stylesheet" href="http://demos.jquerymobile.com/1.4.0/_assets/css/jqm-demos.css">
	<script src="http://demos.jquerymobile.com/1.4.0/js/jquery.js"></script>
	<script src="http://demos.jquerymobile.com/1.4.0/_assets/js/index.js"></script>
	<script src="http://demos.jquerymobile.com/1.4.0/js/jquery.mobile-1.4.0.min.js"></script>
 </head>

<body> 



<div data-role="tabs" id="tabs">

  <div data-role="navbar">
    <ul>
      <li><a href="#mymap" data-ajax="false">地圖</a></li>
      <li id="wiki"><a href="#mymap" data-ajax="false">區域資料</a></li>      
      <li><a href="#prayitem" data-ajax="false">禱告事項</a></li> 
      <li><a href="#area" data-rel="popup" data-position-to="window" data-inline="Flow">地區認領</a></li>
   </ul>    
  </div>
  
  <div id="mymap" class="ui-body-d ui-content">
  
   <ww:if test="${praystreet.map!=null}">
     <p align="center"><img width="50%" src="${ctx}/<fmt:message key="prayStreet.uploadMap.relativeUrl"/>/${praystreet.id}/${praystreet.map.fileName}"></p>   
   </ww:if>
   <ww:else>      
      <ww:if test="${praytw.map!=null}">
       <p align="center"><img width="50%" src="${ctx}/<fmt:message key="prayTW.uploadMap.relativeUrl"/>/${praytw.id}/${praytw.map.fileName}"/></p>   
      </ww:if>
   </ww:else>
   
   
  
   <ww:if test="${praytw.photo1!=null}">
     <p align="center"><img width="50%" src="${ctx}/<fmt:message key="prayTW.uploadMap.relativeUrl"/>/${praytw.id}/${praytw.photo1.fileName}"/></p>   
   </ww:if>
   
   <ww:if test="${praytw.photo2!=null}">
     <p align="center"><img width="50%" src="${ctx}/<fmt:message key="prayTW.uploadMap.relativeUrl"/>/${praytw.id}/${praytw.photo2.fileName}"/></p>   
   </ww:if> 
   
   <ww:if test="${praytw.photo3!=null}">
     <p align="center"><img width="50%" src="${ctx}/<fmt:message key="prayTW.uploadMap.relativeUrl"/>/${praytw.id}/${praytw.photo3.fileName}"/></p>   
   </ww:if> 
  
  </div>
  
  
  <div id="prayitem" class="ui-body-d ui-content">  	
  	<ul data-role="listview">  	  	
  	 <ww:set name="globalList" value="%{getPrayTWGlobalList()}"/>	     
     <ww:iterator value="globalList">   
      <li>${content}</li>
     </ww:iterator>         
    </ul>   
  </div>
  
  
  <div id="area" class="ui-body-d ui-content">
  	<ul data-role="listview">    
  	  <li id="areaClaimYes"><a href="#area" data-ajax="false">認領 [ ${praytw.area.valueCh} ]</a></li>
  	  <li id="areaClaimNo"><a href="#area" data-ajax="false">取消認領 [ ${praytw.area.valueCh} ]</a></li>  	    
      <ww:set name="claimList" value="%{getPrayTWClaimListByPrayTW()}"/>	     
      <ww:iterator value="claimList">   
        <li><fmt:formatDate value="${createdDate}" pattern="yyyy-MM-dd"/>   ${member}</li>      
      </ww:iterator>  
      
    </ul> 
  </div>
    
</div>









<script>
	$("#wiki").click(function() {        
        window.location='${praytw.descriptionUrl}';
  });
  
  
  $("#areaClaimNo").click(function() { 
  	myclaim(false);
  });
  
  
  $("#areaClaimYes").click(function() { 
  	myclaim(true);
  });
  
  function myclaim(optionValue)
  {
  	<ww:set name="session" value="%{getSessionUserMember()}"/>	 
  	<c:if test="${session == null }">  
  	   alert('11');
  	</c:if>
  
  	//alert('optionValue='+optionValue);
  	
  	/*
  	var u="prayTWClaimByJSON.do?praytw.id=${praytw.id}";
	      $.ajax({
           url: u,
           type: "GET",
           dataType: "json",
           success: function(data) {  
        	   
        	 }	
    });
    */
  } 
  
       
    
</script>	



</body>
</html>