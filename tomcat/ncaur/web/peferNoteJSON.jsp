<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{peferNoteJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>