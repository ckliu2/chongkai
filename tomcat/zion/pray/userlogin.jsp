<%@ include file="/common/webtag.jsp"%>
<ww:set name="ls" value="%{userlogin()}"/>  
<c:out value="${ls}" escapeXml="false"/>