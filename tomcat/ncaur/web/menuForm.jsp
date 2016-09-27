<%@ include file="/common/taglibs.jsp"%>

<ww:form name="menuForm" action="saveMenu.do" method="post">
  <ww:hidden name="menu.id" value="${menu.id}"/>
  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="menu.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="menu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="menu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="menu.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="menu.name" value="%{menu.name}" maxlength="20" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('menu.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="menu.seqNo"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="menu.seqNo" value="%{menu.seqNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('menu.seqNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="menu.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="menu.status" cssClass="cCheckboxField" />
        </td>
    </tr>

   <%--
    <tr><td class="cInputCaption"><fmt:message key="menu.content"/></td>
        <td class="cInputColumn">
            <ww:textarea name="menu.content" value="%{menu.content}" cssClass="cInputTextArea" cols="45" rows="12" />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="common.url"/></td>
        <td class="cInputColumn">
            <ww:textfield name="menu.url" value="%{menu.url}" cssClass="cInputTextFieldLong"  />
        </td>
    </tr>
    --%>
    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="menu.lastModifiedDate" /></span>
        </td>
    </tr>
    
       <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="menu.lastModifiedUser" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="menu.createdDate" /></span>
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="common.createdUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="menu.createdUser" /></span>
        </td>
    </tr>





    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="menu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="menu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
