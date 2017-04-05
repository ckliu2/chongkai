<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{billJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>