<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{check()}"/>  
<c:out value="${ls}" escapeXml="false"/>