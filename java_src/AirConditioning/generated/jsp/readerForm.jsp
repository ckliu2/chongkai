<%@ include file="/common/taglibs.jsp"%>

<ww:form name="readerForm" action="saveReader" method="POST">
  <ww:hidden name="reader.id" value="${reader.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="reader.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="reader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="reader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="reader.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="reader.name" value="%{reader.name}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('reader.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.seqName"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="reader.seqName" value="%{reader.seqName}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('reader.seqName')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.readerId"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="reader.readerId" value="%{reader.readerId}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('reader.readerId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="reader.createdDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.temp"/></td>
        <td class="cInputColumn">
            <ww:textfield name="reader.temp" value="%{reader.temp}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('reader.temp')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.active"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="reader.active" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.sync"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="reader.sync" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.clearDaily"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="reader.clearDaily" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.powerstatus"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="reader.powerstatus" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.information"/></td>
        <td class="cInputColumn">
            <ww:textfield name="reader.information" value="%{reader.information}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="reader.lastModifiedDate" /></span>
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="reader.drive"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.driveId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="driveList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.mode"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.modeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="modeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.fanSpeed"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.fanSpeedId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="fanSpeedList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.driveItem"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.driveItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="driveItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.modeItem"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.modeItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="modeItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.tempItem"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.tempItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="tempItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.filterItem"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.filterItemId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="filterItemList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.lock"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.lockId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="lockList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.state"/></td>
        <td class="cInputColumn">
            <ww:select name="reader.stateId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="stateList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="reader.scheduleDailys"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="scheduleDailysIds" 
               list="scheduleDailysList"
               listKey="id"
               listValue="caption_"
               value = "%{scheduleDailysIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="reader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="reader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
