<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{calculateProfitJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>