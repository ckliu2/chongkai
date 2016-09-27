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
  	<ww:set name="prayMeList" value="%{getPrayMeList()}"/>	     
    <ww:iterator value="prayMeList"> 
    
      <li><a href="#prayitem${count}" data-rel="popup" data-position-to="window" data-inline="Flow"><fmt:formatDate value="${createdDate}" pattern="yyyy-MM-dd"/> [${member.nickname}] <br>${content}</a></li>
      
      <div data-role="popup" id="prayitem${count}" class="ui-content" data-overlay-theme="a" data-corners="false" data-tolerance="30,15">
	      <a href="#" data-rel="back" data-role="button" data-theme="a" data-icon="delete" data-iconpos="notext" class="ui-btn-right">Close</a> 
        
	      <fmt:formatDate value="${createdDate}" pattern="yyyy-MM-dd"/> 	     
	      ~[${member.nickname}]
	      
	      <br>
	      
	      ${content}	      
	      
  	    <textarea cols="40" rows="8" name="content" id="content${id}"></textarea> 
        <input type="button" value="送出" onclick="javascript:save(${id});"/> 
        
      </div>
    
      <c:set var="count" value="${count+1}" />
    </ww:iterator>
    
    </ul>     
  </div>


  
  
<script>
 function save(id){ 	

 	 var memberId=$.cookie('memberId');	
 	
   if (typeof(memberId) == "undefined")
   {
     alert('您尚未登入，請先登入，謝謝!');	
     window.location='index.do';
   }   
   
   var content = $('#content'+id).val();   
 	 //alert('save='+id+'---content='+content+'---memberId='+memberId);
 	 $.ajax({
        url: 'savePrayYou.do',
        type: "POST",        
        data: {"content":content,"member.id":memberId,"prayme.id":id},  
        dataType: "json",
        success: function(data) {
        	var returnValue=data.returnValue;  
        	if(returnValue=='success'){
        		   alert('我們已收到您的回覆代禱事項，會已Email轉寄給對方');
        		   $('#content'+id).val('');        		   
        		 }else{
        		 	 alert('Sorry!請聯繫管理人員');
        		 }  
        }
      });
 	 
 }
</script>




</body>
</html>