<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{todayBibleByMemberByJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>