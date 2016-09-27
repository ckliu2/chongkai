<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/webwork" prefix="ww" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<%
    com.base.value.SessionUser u = (com.base.value.SessionUser) request.getSession().getAttribute("user");
%>



<form name="form1" method="post">

<table width="100%" border="0" >

    <tr>
     <td>

<table border="1"  align="center" border="0" cellspacing="1" >
  <tr>
    <td colspan="5"><div id="printinfo" class="printTitle"/></td>
  </tr>
  <tr>
    <td nowrap="nowrap" ><span class="printTitle"><fmt:message key="common.id"/></span></td>
    <td nowrap="nowrap"><span class="printTitle"><fmt:message key="product.id"/></span></td>
    <td nowrap="nowrap"><span class="printTitle"><fmt:message key="billdetail.productName"/></span></td>
    <td nowrap="nowrap"><span class="printTitle"><fmt:message key="billDetail.quantity"/></span></td>
    <td nowrap="nowrap"><span class="printTitle"><fmt:message key="common.remark"/></span></td>
  </tr>
  
<c:set var="count" value="0" />  
<ww:set name="list" value="%{getProductSelect()}"/>  
<ww:iterator value="list">    

  <tr>
    <td><span class="printContent">${count+1}</span></td>
    <td><span class="printContent">${list[count][0]}</span></td>
    <td><span class="printContent">${list[count][3]}</span></td>
    <td><span class="printContent">${list[count][1]}</span></td>
    <td><span class="printContent">${list[count][2]}</span></td>
  </tr>
  
<c:set var="count" value="${count+1}" />  
</ww:iterator>
  
</table>




    </td>
    </tr>
  </table>

</form>


<script> 
 var now=new Date();
 document.all.printinfo.innerHTML='<%= u.getName() %>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+now.toLocaleString();
 print();
</script>