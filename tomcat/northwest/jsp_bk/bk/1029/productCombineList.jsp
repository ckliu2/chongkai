<%@ include file="/common/taglibs.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/css/displaytag.css" />
<script type="text/javascript" src="${ctx}/scripts/list.js"></script>
<script type="text/javascript" src="${ctx}/scripts/common.js"></script>

<table border="0" cellspacing="1" class="cContentTable1">
      <tr>
        <td class="cContentTitle" ><fmt:message key="productCombine.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>

        </td>
      </tr>
      <tr>
        <td>
        
<c:set var="count" value="1" />
<display:table name="productCombineList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.id">
         ${count}
    </display:column>
    <display:column property="product.id" sortable="true" titleKey="product.id" style="text-align:left"/>
    <display:column property="product.productName" sortable="true" titleKey="product.name1" style="text-align:left"/>
    <display:column property="product.unit" sortable="true" titleKey="product.unit1" style="text-align:left"/>
    
    
    <display:column property="amount" sortable="true" titleKey="product.amount" />
    
 
    <c:set var="count" value="${count+1}" />
</display:table>


        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>

        </td>
      </tr>
</table>
<form name="form1" action="saveProductCombine.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="productCombine.id" value="">
    <select name="selectedProductCombineIds" multiple="true" style="display:none"></select>
</form>
