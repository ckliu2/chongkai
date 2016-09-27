<%@ include file="/common/webtag.jsp"%>
<ww:set name="ls" value="%{registerCustomer()}"/>  
<c:out value="${ls}" escapeXml="false"/>