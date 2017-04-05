<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{logisticsListJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>