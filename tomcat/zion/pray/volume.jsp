<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{volumeByJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>