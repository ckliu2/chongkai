<%@ page contentType="text/html; charset=utf-8" language="java"  %>
<%@ include file="/common/webtag.jsp"%>

<head> 
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.3.0/jquery.mobile-1.3.0.min.css" />
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">	
	<style>
   body { margin: 0; padding: 0; line-height: 1.5em; font-family: "Times New Roman" Times, serif; font-size: 14px; color: #000000; background: #f2e7ca url(images/templatemo_body.jpg) top center no-repeat; } 
  </style>
</head>

<ww:set name="livelyBible" value="%{getLivelyBible()}"/>  

<fmt:formatDate pattern="yyyy-MM-dd" value="${livelyBible.today}" />

<fmt:formatDate pattern="E" value="${livelyBible.today}" />

<font color="blue"><strong>${livelyBible.bible.fullName}-${livelyBible.chapter}章</strong></font>

<hr>

<c:forEach var="item" items="${livelyBible.lection}" > 
     <font color="blue">${item.verse} .</font> ${item.lection}
     <br> <br>
</c:forEach>