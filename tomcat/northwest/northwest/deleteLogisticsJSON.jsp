<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{deleteLogisticsJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>