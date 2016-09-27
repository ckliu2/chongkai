<%@ include file="/common/taglibs.jsp"%>

<ww:form name="appPropertyForm" action="saveAppProperty" method="POST">
  <ww:hidden name="appProperty.id" value="${appProperty.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="appProperty.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="appProperty.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="appProperty.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="appProperty.seqNo"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="appProperty.seqNo" value="%{appProperty.seqNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('appProperty.seqNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="appProperty.kind"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textarea name="appProperty.kind" value="%{appProperty.kind}" cssClass="cInputTextArea" cols="45" rows="8" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('appProperty.kind')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="appProperty.subKind"/></td>
        <td class="cInputColumn">
            <ww:textfield name="appProperty.subKind" value="%{appProperty.subKind}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="appProperty.valueTw"/></td>
        <td class="cInputColumn">
            <ww:textarea name="appProperty.valueTw" value="%{appProperty.valueTw}" cssClass="cInputTextArea" cols="45" rows="8" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="appProperty.valueUs"/></td>
        <td class="cInputColumn">
            <ww:textarea name="appProperty.valueUs" value="%{appProperty.valueUs}" cssClass="cInputTextArea" cols="45" rows="8" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="appProperty.value1"/></td>
        <td class="cInputColumn">
            <ww:textarea name="appProperty.value1" value="%{appProperty.value1}" cssClass="cInputTextArea" cols="45" rows="8" />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="appProperty.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="appProperty.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
