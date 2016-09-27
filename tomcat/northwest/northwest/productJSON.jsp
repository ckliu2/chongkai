<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{productJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>