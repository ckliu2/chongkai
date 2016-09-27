<%@ include file="/common/unsecureTaglibs.jsp"%>
<ww:set name="ls" value="%{billZip()}"/>  
<a href='${ctx}/upload/tempdir/${bill.no}.zip'>下載${bill.no}</a>
