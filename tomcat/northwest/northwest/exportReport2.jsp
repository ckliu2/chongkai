<%@ page session = "false" %><%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %><%@ page contentType="text/html;charset=utf-8"%><%@ taglib uri="/webwork" prefix="ww" %>
<ww:set name="list" value="%{exportExcel2()}"/>

<a href="/northwest/upload/export/report2.xls">DownLoad</a>

<script>
  window.open("/northwest/upload/export/report2.xls");
</script>