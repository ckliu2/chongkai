<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{todayBibleJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>