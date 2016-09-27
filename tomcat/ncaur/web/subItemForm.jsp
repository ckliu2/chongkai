<%@ include file="/common/taglibs.jsp"%>

<ww:form name="subItemForm" action="saveSubItem.do" method="post">
  <ww:hidden name="subItem.id" value="${subItem.id}"/>
  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="subItem.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='subItemList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="subItem.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="subItem.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
        <tr><td class="cInputCaption"><fmt:message key="subMenu.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="subItem.subMenuId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="subMenuList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('subItem.subMenuId')"/></span>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="subItem.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="subItem.name" value="%{subItem.name}" maxlength="20" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('subItem.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="subItem.seqNo"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="subItem.seqNo" value="%{subItem.seqNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('subItem.seqNo')"/></span>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="common.url"/></td>
        <td class="cInputColumn">
            <ww:textfield name="subItem.url" value="%{subItem.url}" maxlength="50" cssClass="cInputTextFieldLong" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="common.linktype"/></td>
        <td class="cInputColumn">
            <ww:select name="subItem.linkTypeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="linkTypeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="subItem.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="subItem.status" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="subItem.content"/></td>
        <td class="cInputColumn">   
			       <FCK:editor instanceName="subItem.content">
			         	<jsp:attribute name="value">
				           <c:out value="${subItem.content}" escapeXml="false"/>
				        </jsp:attribute>
				        <jsp:body>
					          <FCK:config SkinPath="skins/office2003/"/>
				        </jsp:body>
			       </FCK:editor>   
        </td>
    </tr>
    
        <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subItem.lastModifiedDate" /></span>
        </td>
    </tr>
    
       <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subItem.lastModifiedUser" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subItem.createdDate" /></span>
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="common.createdUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subItem.createdUser" /></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='subItemList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="subItem.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="subItem.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
