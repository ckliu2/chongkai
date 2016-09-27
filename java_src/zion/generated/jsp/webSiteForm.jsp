<%@ include file="/common/taglibs.jsp"%>

<ww:form name="webSiteForm" action="saveWebSite" method="POST">
  <ww:hidden name="webSite.id" value="${webSite.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="webSite.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="webSite.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="webSite.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="webSite.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="webSite.name" value="%{webSite.name}" maxlength="40" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('webSite.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="webSite.title"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="webSite.title" value="%{webSite.title}" maxlength="40" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('webSite.title')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="webSite.header"/></td>
        <td class="cInputColumn">
            <ww:textarea name="webSite.header" value="%{webSite.header}" cssClass="cInputTextArea" cols="45" rows="8" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="webSite.meta"/></td>
        <td class="cInputColumn">
            <ww:textarea name="webSite.meta" value="%{webSite.meta}" cssClass="cInputTextArea" cols="45" rows="8" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="webSite.footer"/></td>
        <td class="cInputColumn">
            <ww:textarea name="webSite.footer" value="%{webSite.footer}" cssClass="cInputTextArea" cols="45" rows="8" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="webSite.domain"/></td>
        <td class="cInputColumn">
            <ww:textfield name="webSite.domain" value="%{webSite.domain}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="webSite.language"/></td>
        <td class="cInputColumn">
            <ww:select name="webSite.languageId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="languageList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="webSite.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="webSite.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
