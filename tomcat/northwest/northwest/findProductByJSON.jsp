<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{findProductByJSON()}"/>  
<c:out value="${ls}" escapeXml="false"/>
