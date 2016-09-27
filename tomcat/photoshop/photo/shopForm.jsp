<%@ include file="/common/taglibs.jsp"%>

<ww:form name="shopForm" action="saveShop" method="POST">
  <ww:hidden name="shop.id" value="${shop.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="shop.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="shop.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="shop.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="shop.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="shop.name" value="%{shop.name}" maxlength="50" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('shop.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.address"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="shop.address" value="%{shop.address}" maxlength="100" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('shop.address')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.contact"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="shop.contact" value="%{shop.contact}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('shop.contact')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.title"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="shop.title" value="%{shop.title}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('shop.title')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.phone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="shop.phone" value="%{shop.phone}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('shop.phone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.ip"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="shop.ip" value="%{shop.ip}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('shop.ip')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.mac"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="shop.mac" value="%{shop.mac}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('shop.mac')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.beginDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="beginDate" id="beginDate" value="%{beginDate}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="shop.endDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="endDate" id="endDate" value="%{endDate}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="shop.lastModifiedDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="shop.createdDate" /></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="shop.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="shop.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
