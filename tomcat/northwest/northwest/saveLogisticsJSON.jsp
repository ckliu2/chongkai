<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{saveLogisticsJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>