<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{saveCourseUserJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>