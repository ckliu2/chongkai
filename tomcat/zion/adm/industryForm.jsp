<%@ include file="/common/taglibs.jsp"%>

<ww:form name="industryForm" action="saveIndustry" method="POST" onsubmit="onSubmit()">
  <ww:hidden name="industry.id" value="${industry.id}"/>
  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="industry.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="industry.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="industry.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="industry.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="industry.name" value="%{industry.name}" maxlength="100" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showdoErrorMessage('industry.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="industry.createdDate" /></span>
        </td>
    </tr>



    <tr><td class="cInputCaption"><fmt:message key="common.members"/></td>
        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="member.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="member.name"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allMember"
                list="memberList"
                listKey="id"
                listValue="name"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />                
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allMember, selectedMember);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allMember, selectedMember);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedMember, allMember);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedMember, allMember);"><br>
            </td>
            
            <td align="center">
       
                <ww:select name="membersIds" id="selectedMember"
                list="object_memberList"
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
            <ww:if test="industry.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="industry.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>


<script>
function onSubmit() {
mySelectAll(document.industryForm.membersIds);
    return true;
}
mySelectAll(document.industryForm.membersIds);

</script>
