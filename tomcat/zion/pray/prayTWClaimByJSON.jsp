<%@ include file="/common/taglibs.jsp"%>
<ww:set name="ls" value="%{prayTWClaimByMember()}"/>  
<c:out value="${ls}" escapeXml="false"/>