<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{customerJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>