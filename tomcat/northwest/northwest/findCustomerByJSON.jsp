<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{findCustomerByJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>