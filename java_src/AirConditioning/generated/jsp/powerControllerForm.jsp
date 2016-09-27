<%@ include file="/common/taglibs.jsp"%>

<ww:form name="powerControllerForm" action="savePowerController" method="POST">
  <ww:hidden name="powerController.id" value="${powerController.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="powerController.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="powerController.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="powerController.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="powerController.name"/></td>
        <td class="cInputColumn">
            <ww:textfield name="powerController.name" value="%{powerController.name}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerController.ip"/></td>
        <td class="cInputColumn">
            <ww:textfield name="powerController.ip" value="%{powerController.ip}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerController.port"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="powerController.port" value="%{powerController.port}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('powerController.port')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerController.deviceId"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="powerController.deviceId" value="%{powerController.deviceId}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('powerController.deviceId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="powerController.createdDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerController.building"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="powerController.buildingId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="buildingList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('powerController.buildingId')"/></span>
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="powerController.deviceType"/></td>
        <td class="cInputColumn">
            <ww:select name="powerController.deviceTypeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="deviceTypeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerController.reader"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="readerIds" 
               list="readerList"
               listKey="id"
               listValue="caption_"
               value = "%{readerIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="powerController.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="powerController.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
