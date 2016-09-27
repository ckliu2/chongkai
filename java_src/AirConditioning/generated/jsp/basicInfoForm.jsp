<%@ include file="/common/taglibs.jsp"%>

<ww:form name="basicInfoForm" action="saveBasicInfo" method="POST">
  <ww:hidden name="basicInfo.id" value="${basicInfo.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="basicInfo.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="basicInfo.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="basicInfo.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="basicInfo.sem"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.sem" value="%{basicInfo.sem}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.sem')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.onMinutes"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.onMinutes" value="%{basicInfo.onMinutes}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.onMinutes')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.offMinutes"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.offMinutes" value="%{basicInfo.offMinutes}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.offMinutes')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.scheduleStart"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="scheduleStart" id="scheduleStart" value="%{scheduleStart}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleStart')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.scheduleEnd"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="scheduleEnd" id="scheduleEnd" value="%{scheduleEnd}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleEnd')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.threshold"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.threshold" value="%{basicInfo.threshold}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.threshold')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.contract"/></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.contract" value="%{basicInfo.contract}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.contract')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.timingEveryMins"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.timingEveryMins" value="%{basicInfo.timingEveryMins}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.timingEveryMins')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.weeklyEveryMins"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.weeklyEveryMins" value="%{basicInfo.weeklyEveryMins}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.weeklyEveryMins')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.panelUpdateMins"/></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.panelUpdateMins" value="%{basicInfo.panelUpdateMins}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.panelUpdateMins')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.scheduleCheckMins"/></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.scheduleCheckMins" value="%{basicInfo.scheduleCheckMins}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.scheduleCheckMins')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="basicInfo.createdDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.flag"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.flag" value="%{basicInfo.flag}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('basicInfo.flag')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.shutdownTime"/></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.shutdownTime" value="%{basicInfo.shutdownTime}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="basicInfo.initializeTime"/></td>
        <td class="cInputColumn">
            <ww:textfield name="basicInfo.initializeTime" value="%{basicInfo.initializeTime}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="basicInfo.shutdownReaders"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="shutdownReadersIds" 
               list="shutdownReadersList"
               listKey="id"
               listValue="caption_"
               value = "%{shutdownReadersIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="basicInfo.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="basicInfo.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
