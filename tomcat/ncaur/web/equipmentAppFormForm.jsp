<%@ include file="/common/taglibs.jsp"%>

<ww:form name="equipmentAppFormForm" action="saveEquipmentAppForm.do" method="post" onsubmit="onSubmit()">
  <ww:hidden name="equipmentAppForm.id" value="${equipmentAppForm.id}"/>
  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="equipmentAppForm.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="equipmentAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="equipmentAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.date"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="date" id="date" value="%{date}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('date')"/></span>
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.meeting"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="equipmentAppForm.meetingId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="meetingList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('equipmentAppForm.meetingId')"/></span>
             &nbsp;&nbsp;&nbsp;&nbsp;
             <ww:textfield name="equipmentAppForm.otherMeeting" value="%{equipmentAppForm.otherMeeting}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.room"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">         
             <ww:select name="equipmentAppForm.roomId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="roomList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.borrowDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="borrowDate" id="borrowDate" value="%{borrowDate}" language="zh" format="%Y/%m/%d"/>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <fmt:message key="roomAppForm.applyBeginClock"/>:
             <ww:select name="equipmentAppForm.applyBeginClockId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="applyBeginClockList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('equipmentAppForm.applyBeginClockId')"/></span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <fmt:message key="roomAppForm.applyEndClock"/>:
            <ww:select name="equipmentAppForm.applyEndClockId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="applyEndClockList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('equipmentAppForm.applyEndClockId')"/></span>
        
           
        </td>
    </tr>
    
     <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.returnDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="returnDate" id="returnDate" value="%{returnDate}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.equipment"/></td>
        <td class="cInputColumn">
            
            <ww:select name="equipmentIds" 
               list="equipmentList"
               listKey="name"
               listValue="value"
               multiple="true"
               size="15"
               cssClass="cQueryFieldList"
            /> 
            
            <br>      
            <input class="cOpenWindowButton" type=button value="<fmt:message key="common.insert"/><fmt:message key="equipmentAppForm.eq"/>" onclick="myInsertFromNewWindow('queryEquipment.do', 'equipmentIds', '');">
            <input class="cOpenWindowButton" type=button value="<fmt:message key="common.delete"/><fmt:message key="equipmentAppForm.eq"/>" onclick="myDeleteFromSelectMany(document.equipmentAppFormForm.equipmentIds);">
            </td>
    </tr>
 
    <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.meno"/></td>
        <td class="cInputColumn">
            <ww:textarea name="equipmentAppForm.meno" value="%{equipmentAppForm.meno}" cssClass="cInputTextArea" cols="45" rows="4" />
        </td>
    </tr>    
    
    <tr><td class="cInputCaption"><fmt:message key="common.checkingState"/></td>
        <td class="cInputColumn">
            <ww:select name="equipmentAppForm.state"
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="checkingStateList"
               listKey="name"
               listValue="value"
               cssClass="cInputListField"
               viewonly="true"
            />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="equipmentAppForm.lastModifiedDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="equipmentAppForm.createdDate" /></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="equipmentAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="equipmentAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>

<script>
function onSubmit() {
mySelectAll(document.equipmentAppFormForm.equipmentIds);
return true;
}
</script>