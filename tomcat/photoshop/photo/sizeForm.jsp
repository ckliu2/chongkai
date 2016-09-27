<%@ include file="/common/taglibs.jsp"%>

<ww:form name="sizeForm" action="saveSize" method="POST" onsubmit="onSubmit()">
  <ww:hidden name="size.id" value="${size.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="size.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="size.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="size.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="size.width"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="size.width" value="%{size.width}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('size.width')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="size.height"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="size.height" value="%{size.height}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('size.height')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="size.products"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="size.products"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="size.products"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allProducts"
                list="productsList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                /></td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allProducts, selectedProducts);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allProducts, selectedProducts);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedProducts, allProducts);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedProducts, allProducts);"><br>
            </td><td align="center">
                <ww:select name="productsIds" id="selectedProducts"
                list="object_productsList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />
            </td>
            </tr>
            </table>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="size.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="size.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
<script>
function onSubmit() {
    mySelectAll(document.sizeForm.productsIds);

    return true;
}
</script>
