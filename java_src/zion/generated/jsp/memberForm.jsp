<%@ include file="/common/taglibs.jsp"%>

<ww:form name="memberForm" action="saveMember" method="POST">
  <ww:hidden name="member.id" value="${member.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="member.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="member.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="member.name" value="%{member.name}" maxlength="10" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.nickname"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.nickname" value="%{member.nickname}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.email"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.email" value="%{member.email}" maxlength="60" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.cellphone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.cellphone" value="%{member.cellphone}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="member.lastModifiedDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="member.createdDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.groups"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="groupsIds" 
               list="groupsList"
               listKey="id"
               listValue="caption_"
               value = "%{groupsIds}"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.grades"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="gradesIds" 
               list="gradesList"
               listKey="id"
               listValue="caption_"
               value = "%{gradesIds}"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.teams"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="teamsIds" 
               list="teamsList"
               listKey="id"
               listValue="caption_"
               value = "%{teamsIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
