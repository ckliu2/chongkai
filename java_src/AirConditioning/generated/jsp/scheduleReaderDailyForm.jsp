<%@ include file="/common/taglibs.jsp"%>

<ww:form name="scheduleReaderDailyForm" action="saveScheduleReaderDaily" method="POST">
  <ww:hidden name="scheduleReaderDaily.id" value="${scheduleReaderDaily.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="scheduleReaderDaily.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="scheduleReaderDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="scheduleReaderDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="scheduleReaderDaily.scheduledDate"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="scheduledDate" id="scheduledDate" value="%{scheduledDate}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduledDate')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleReaderDaily.active"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="scheduleReaderDaily.active" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleReaderDaily.reader"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleReaderDaily.readerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="readerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleReaderDaily.readerId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleReaderDaily.scheduleDaily"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleReaderDaily.scheduleDailyId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="scheduleDailyList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleReaderDaily.scheduleDailyId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleReaderDaily.type"/></td>
        <td class="cInputColumn">
            <ww:select name="scheduleReaderDaily.typeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="typeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleReaderDaily.powerController"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleReaderDaily.powerControllerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="powerControllerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleReaderDaily.powerControllerId')"/></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="scheduleReaderDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="scheduleReaderDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
