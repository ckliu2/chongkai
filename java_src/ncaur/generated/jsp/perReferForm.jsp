<%@ include file="/common/taglibs.jsp"%>

<ww:form name="perReferForm" action="savePerRefer" method="POST">
  <ww:hidden name="perRefer.id" value="${perRefer.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="perRefer.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="perRefer.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.name" value="%{perRefer.name}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.email"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.email" value="%{perRefer.email}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.email')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.phone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.phone" value="%{perRefer.phone}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.phone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.cellphone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.cellphone" value="%{perRefer.cellphone}" maxlength="0" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.cellphone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.memo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.memo" value="%{perRefer.memo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.note"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="perRefer.note" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="perRefer.createdDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.type"/></td>
        <td class="cInputColumn">
            <ww:select name="perRefer.typeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="typeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.qatype"/></td>
        <td class="cInputColumn">
            <ww:select name="perRefer.qatypeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="qatypeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.teacher"/></td>
        <td class="cInputColumn">
            <ww:select name="perRefer.teacherId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="teacherList"
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
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
