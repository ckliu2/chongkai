<%@ include file="/common/taglibs.jsp"%>

<ww:form name="teamForm" action="saveTeam" method="POST" onsubmit="onSubmit()">
  <ww:hidden name="team.id" value="${team.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="team.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="team.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="team.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="team.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="team.name" value="%{team.name}" maxlength="100" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('team.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="team.place"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="team.place" value="%{team.place}" maxlength="100" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('team.place')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="team.unit"/></td>
        <td class="cInputColumn">
            <ww:select name="team.unitId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="unitList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="team.leader"/></td>
        <td class="cInputColumn">
            <ww:select name="team.leaderId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="leaderList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="team.register"/></td>
        <td class="cInputColumn">
            <ww:select name="team.registerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="registerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="team.members"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="team.members"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="team.members"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allMembers"
                list="membersList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                /></td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allMembers, selectedMembers);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allMembers, selectedMembers);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedMembers, allMembers);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedMembers, allMembers);"><br>
            </td><td align="center">
                <ww:select name="membersIds" id="selectedMembers"
                list="object_membersList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />
            </td>
            </tr>
            </table>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="team.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="team.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
<script>
function onSubmit() {
    mySelectAll(document.teamForm.membersIds);

    return true;
}
</script>
