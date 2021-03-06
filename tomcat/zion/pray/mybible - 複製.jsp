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
body { margin: 0; padding: 0; line-height: 1.5em; font-family: "Times New Roman" Times, serif; font-size: 14px; color: #000000; background: #f2e7ca url(images/templatemo_body.jpg) top center no-repeat; } 
</style>
</head>

<ww:set name="todaybible" value="%{getTodayBibleByMember()}"/>  

<image src="/zion/images/cal.jpg">
<input type="text" data-role="date">

<fmt:formatDate pattern="yyyy-MM-dd" value="${todaybible.today}" />

<fmt:formatDate pattern="E" value="${todaybible.today}" />



<font color="blue"><strong>${todaybible.bible.fullName}-${todaybible.chapter}章</strong></font>

<div align="center">
 <a href="#setting" id="login" data-icon="custom" data-rel="popup" data-position-to="window" data-transition="fade">讀經設定</a>
</div>

<hr>



<c:forEach var="item" items="${todaybible.lection}" > 
     <font color="blue">${item.verse} .</font> ${item.lection}
     <br> <br>
</c:forEach>



<div data-role="popup" id="setting" data-overlay-theme="a" data-theme="d" data-corners="false">
		<a href="#" data-rel="back" data-role="button" data-theme="a" data-icon="delete" data-iconpos="notext" class="ui-btn-right">Close</a>
		請設定章節:<br>
		<form name="form1" >	
			 <ww:select name="bible.id" id="bibleId" onchange="mychapter();"
               headerKey=""
               headerValue="請選擇經..."
               list="bibleList"
               listKey="id"
               listValue="fullName"              
        /> 
        
        <select name="chapter" id="chapter">
          <option>請選擇章數</option>
        </select>
        
        <input type="submit" name="button" id="button" value="確定" />
        
     </form> 
      
</div>

<jsp:include page="../layout/footer.jsp"/>

<script>
 function mychapter(){
 	var bibleId = $('#bibleId').val();	
   alert("mychapter()..bibleId="+bibleId);	
   
   $.ajax({
        url: 'chapterNumber.do',
        type: "POST",        
        data: {"bible.id":bibleId},  
        dataType: "json",
        success: function(data) {
        	var returnValue=data.returnValue;  
        	
        	for(var i=1;i<=parseInt(returnValue);i++ ){
        		$("#chapter").append("<option value='"+i+"'>第"+i+"章</option>");
        	}
        	
        	alert("returnValue="+returnValue);
        }
      });
      
 }
</script>

