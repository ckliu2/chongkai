<%@ include file="/common/taglibs.jsp"%>		
<ww:form name="subMenuForm" action="saveSubMenu.do" method="post">
  <ww:hidden name="subMenu.id" value="${subMenu.id}"/>
  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="subMenu.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='subMenuList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="subMenu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="subMenu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
    
        <tr><td class="cInputCaption"><fmt:message key="subMenu.menu"/></td>
        <td class="cInputColumn">
            <ww:select name="subMenu.menuId"  
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="menuList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            />      
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="subMenu.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="subMenu.name" value="%{subMenu.name}" maxlength="20" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('subMenu.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="subMenu.seqNo"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="subMenu.seqNo" value="%{subMenu.seqNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('subMenu.seqNo')"/></span>
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="common.url"/></td>
        <td class="cInputColumn">
            <ww:textfield name="subMenu.url" value="%{subMenu.url}" maxlength="1000" cssClass="cInputTextFieldLong" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="common.linktype"/></td>
        <td class="cInputColumn">
            <ww:select name="subMenu.linkTypeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="linkTypeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="subMenu.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="subMenu.status" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="subMenu.content"/></td>
        <td class="cInputColumn">  
            <FCK:editor instanceName="subMenu.content">
			         	<jsp:attribute name="value">
				           <c:out value="${subMenu.content}" escapeXml="false"/>
				        </jsp:attribute>
				        <jsp:body>
					          <FCK:config SkinPath="skins/office2003/"/>
				        </jsp:body>
			       </FCK:editor>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subMenu.lastModifiedDate" /></span>
        </td>
    </tr>
    
       <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subMenu.lastModifiedUser" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subMenu.createdDate" /></span>
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="common.createdUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="subMenu.createdUser" /></span>
        </td>
    </tr>





    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='subMenuList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="subMenu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="subMenu.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
