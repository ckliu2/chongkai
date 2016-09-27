<%@ include file="/common/taglibs.jsp"%>

<ww:form name="livelyBibleForm" action="saveLivelyBible" method="POST">
  <ww:hidden name="livelyBible.id" value="${livelyBible.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="livelyBible.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="livelyBible.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="livelyBible.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="livelyBible.date"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="livelyBible.date" value="%{livelyBible.date}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('livelyBible.date')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="livelyBible.volume"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="livelyBible.volume" value="%{livelyBible.volume}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('livelyBible.volume')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="livelyBible.chapter"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="livelyBible.chapter" value="%{livelyBible.chapter}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('livelyBible.chapter')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="livelyBible.excep"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="livelyBible.excep" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="livelyBible.content"/></td>
        <td class="cInputColumn">
            <ww:textfield name="livelyBible.content" value="%{livelyBible.content}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="livelyBible.classify"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="livelyBible.classify" value="%{livelyBible.classify}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('livelyBible.classify')"/></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="livelyBible.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="livelyBible.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
