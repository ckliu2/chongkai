<%@ include file="/common/webtag.jsp"%>
<ww:set name="ls" value="%{savePrayItem()}"/>  
<c:out value="${ls}" escapeXml="false"/>