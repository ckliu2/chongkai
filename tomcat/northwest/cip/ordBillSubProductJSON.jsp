<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{getOrdBillSubProductJSON('${productNo}')}"/>  
<c:out value="${ls}" escapeXml="false"/>