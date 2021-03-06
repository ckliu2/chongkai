<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>

<!DOCTYPE html> 
<html> 
<head> 
	<title>基督教溝子口錫安堂教會</title> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html" charset=utf-8">
</head> 
<body> 



  <ul data-role="listview" data-filter="true" data-filter-placeholder="關鍵字查詢"> 
  
 <ww:set name="countryList1" value="%{getCountryList1()}"/>  
 <ww:iterator value="countryList1">  
 <c:set var="count" value="${codeName}.${keyName}" /> 	
 <ww:set name="county" value="%{getCounty('${id}')}"/> 
 
  	<c:set var="countyname" value="${valueCh}" />
  	
	   <li> 
      <h3>${valueCh}</h3> 
      <p><font color="blue"><strong>${county}</strong></font>人認領</p> 
      <ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="關鍵字查詢">      
      
      <ww:set name="countryList2" value="%{getMiscCodeList('${count}')}"/>	     
      <ww:iterator value="countryList2">         
      <ww:set name="isStreet" value="%{isPrayStreetByPrayTW('${id}')}"/>       
      <ww:set name="praytw" value="%{getPrayTWById('${id}')}"/>        
      <c:set var="areaId" value="${praytw.id}" />       
          
      <ww:set name="township" value="%{getTownShip('${praytw.id}')}"/> 
       
      <ww:if test="${isStreet == true}">
       
        <li><div>${valueCh}</div>
        <span class="ui-li-count"><font color="blue"><strong>${township}</strong></font>人認領</span>
        	   <ww:set name="streetList" value="%{getPrayStreetListByPrayTW('${id}')}"/> 
              <ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="關鍵字查詢">
                <ww:iterator value="streetList">  
                <li><a href="map.do?praytw.id=${praytw.id}&praystreet.id=${id}">${name}</a></li>
                </ww:iterator>  
              </ul>  	
	      </li>
	      
      </ww:if>
      <ww:else> 	      
	      <li>
	      <a href="map.do?praytw.id=${areaId}">
	        <div>${valueCh}</div>
          <span class="ui-li-count"><font color="blue"><strong>${township}</strong></font>人認領</span>   
        	</a>     
	      </li>      
      </ww:else>

      
	    </ww:iterator>
	       
	     </ul> 
     </li> 
     
 </ww:iterator>	  
	   
  </ul>
  
<jsp:include page="../layout/footer.jsp"/>



</body>
</html>