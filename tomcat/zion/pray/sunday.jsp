<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>

<!DOCTYPE html> 
<html>
	
	<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1"> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.js"></script>
	<script src="/zion/scripts/jquery.cookie.js"></script>
 </head>

<body> 

<jsp:include page="../layout/footer.jsp"/>
  
  <div id="prayitem" class="ui-body-d ui-content">
  	<ul data-role="listview" data-inset="true" data-filter="true" data-filter-placeholder="關鍵字查詢">
  	

  	<c:set var="count" value="1" />
  	<ww:set name="sundayInforList" value="%{getSundayInforList()}"/>	     
    <ww:iterator value="sundayInforList"> 
    
      <li><a href="https://${youtube}" target="_blank"><fmt:formatDate value="${messageDate}" pattern="yyyy-MM-dd"/> [${subject}] </a></li>
      
      
    
      <c:set var="count" value="${count+1}" />
    </ww:iterator>
    
    </ul>     
  </div>



</body>
</html>