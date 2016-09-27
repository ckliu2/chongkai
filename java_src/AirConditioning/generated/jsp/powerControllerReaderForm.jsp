<%@ include file="/common/taglibs.jsp"%>

<ww:form name="powerControllerReaderForm" action="savePowerControllerReader" method="POST">
  <ww:hidden name="powerControllerReader.id" value="${powerControllerReader.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="powerControllerReader.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="powerControllerReader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="powerControllerReader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="powerControllerReader.name"/></td>
        <td class="cInputColumn">
            <ww:textfield name="powerControllerReader.name" value="%{powerControllerReader.name}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerControllerReader.deviceNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="powerControllerReader.deviceNo" value="%{powerControllerReader.deviceNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('powerControllerReader.deviceNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerControllerReader.powerController"/></td>
        <td class="cInputColumn">
            <ww:select name="powerControllerReader.powerControllerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="powerControllerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerControllerReader.reader"/></td>
        <td class="cInputColumn">
            <ww:select name="powerControllerReader.readerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="readerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerControllerReader.classRoom"/></td>
        <td class="cInputColumn">
            <ww:select name="powerControllerReader.classRoomId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="classRoomList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="powerControllerReader.course"/></td>
        <td class="cInputColumn">
            <ww:select name="powerControllerReader.courseId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="courseList"
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
            <ww:if test="powerControllerReader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="powerControllerReader.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
