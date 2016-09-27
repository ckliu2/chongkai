<%@ include file="/common/taglibs.jsp"%>

<ww:form name="scheduleDailyForm" action="saveScheduleDaily" method="POST">
  <ww:hidden name="scheduleDaily.id" value="${scheduleDaily.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="scheduleDaily.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="scheduleDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="scheduleDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.temp"/></td>
        <td class="cInputColumn">
            <ww:textfield name="scheduleDaily.temp" value="%{scheduleDaily.temp}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.temp')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.scheduledDate"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="scheduledDate" id="scheduledDate" value="%{scheduledDate}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduledDate')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.active"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="scheduleDaily.active" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="scheduleDaily.createdDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.ip"/></td>
        <td class="cInputColumn">
            <ww:textfield name="scheduleDaily.ip" value="%{scheduleDaily.ip}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="scheduleDaily.lastModifiedDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.groupCode"/></td>
        <td class="cInputColumn">
            <ww:textfield name="scheduleDaily.groupCode" value="%{scheduleDaily.groupCode}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.courseNum"/></td>
        <td class="cInputColumn">
            <ww:textfield name="scheduleDaily.courseNum" value="%{scheduleDaily.courseNum}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.courseNum')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.flag"/></td>
        <td class="cInputColumn">
            <ww:textfield name="scheduleDaily.flag" value="%{scheduleDaily.flag}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.flag')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.drive"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.driveId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="driveList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.driveId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.mode"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.modeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="modeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.modeId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.fanSpeed"/></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.fanSpeedId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="fanSpeedList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.lock"/></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.lockId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="lockList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.driveItem"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.driveItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="driveItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.driveItemId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.modeItem"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.modeItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="modeItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.modeItemId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.tempItem"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.tempItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="tempItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.tempItemId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.filterItem"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.filterItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="filterItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('scheduleDaily.filterItemId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.type"/></td>
        <td class="cInputColumn">
            <ww:select name="scheduleDaily.typeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="typeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="scheduleDaily.readers"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="readersIds" 
               list="readersList"
               listKey="id"
               listValue="caption_"
               value = "%{readersIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="scheduleDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="scheduleDaily.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
