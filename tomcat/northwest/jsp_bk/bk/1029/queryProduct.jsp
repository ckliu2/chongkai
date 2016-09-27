<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />

<form method="POST" >
           <img src="images/search.jpg">
           <span class="cLabel2"><fmt:message key="common.keyin"/><fmt:message key="product.name"/> or <fmt:message key="product.id"/>:</span>          
           <ww:textfield name="product.productName" value="%{product.productName}" maxlength="40" cssClass="cInputTextFieldShort" /> 
           <ww:hidden name="product.id" value="${product.id}"/>
           <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
</form>




<table width="100%" border="0" align="left" >
  <tr>
    <td valign="top">    
        <table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="product.list"/></td>
      </tr>    

      <tr>
        <td>
<c:set var="count" value="1" />
<display:table name="productList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}"   sort="list" >
    <display:setProperty name="paging.banner.placement" value="bottom" />
     <display:column titleKey="common.action" style="text-align:left" sortable="true">     
        <a href="javascript:myReturnFunction('${row.id}','${row.productName}')"><fmt:message key="product.selected"/></a>
     </display:column>
    
     <display:column titleKey="common.id" style="text-align:left" sortable="true">     
        <c:out value="${count}"/>
     </display:column>
     <display:column property="id" sortable="true" titleKey="product.id" /> 
     <display:column property="productName" sortable="true" titleKey="billdetail.productName" /> 
     <display:column property="unit" sortable="true" titleKey="product.unit1" />
     <display:column property="productClass.className" sortable="true" titleKey="productClass.className" />
     <c:set var="count" value="${count+1}" />
</display:table> 
</td>
    </tr>
</table>
    </td>
  </tr>
</table>

<script>
function myReturnFunction(id,name)
{   
    window.parent.opener.document.all.productName.value=name;
    window.parent.opener.document.all.productId.value=id;
    window.close();
}

</script>







