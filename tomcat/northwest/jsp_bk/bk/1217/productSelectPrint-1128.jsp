<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="/webwork" prefix="ww" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<%
    com.base.value.SessionUser u = (com.base.value.SessionUser) request.getSession().getAttribute("user");
%>



<form name="form1" method="post">

<table width="100%" border="0">
    <tr>
      <td><div id="printinfo" class="cLabel"/></td>
    </tr>
    <tr>
      <td>
        <select name="selectedProduct" id="selectedProduct" multiple="true" class="cQueryFieldList4"/>
    </td>
    </tr>
  </table>

</form>


<script>
 var obj = eval('window.opener.document.all.productIds') ; 
 //document.write(obj.length+'<br>');
 for(i=0;i<=obj.length-1;i++){
   //alert(obj.options[i].value); 
   var newOpt = document.createElement("option");
   newOpt.text =  obj.options[i].text;
   newOpt.value = obj.options[i].value;
   //document.write(obj.options[i].text+'---'+obj.options[i].value+'<br>');
   document.all.selectedProduct.options.add(newOpt);   
 }
 document.all.selectedProduct.size=obj.length;  
 
 var now=new Date();
 document.all.printinfo.innerHTML='<%= u.getName() %>'+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+now.toLocaleString();

 
 print();
</script>