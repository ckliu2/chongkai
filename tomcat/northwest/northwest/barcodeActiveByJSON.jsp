<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{barcode()}"/>  
<c:out value="${ls}" escapeXml="false"/>