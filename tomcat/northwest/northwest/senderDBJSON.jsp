<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{senderDBJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>