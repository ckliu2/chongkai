<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{findMemberJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>