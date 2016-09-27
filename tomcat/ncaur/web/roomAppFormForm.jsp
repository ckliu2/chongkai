<%@ include file="/common/taglibs.jsp"%>

<ww:form name="roomAppFormForm" action="saveRoomAppForm.do" method="post">
  <ww:hidden name="roomAppForm.id" value="${roomAppForm.id}"/>
  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="roomAppForm.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="roomAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="roomAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="roomAppForm.date"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="date" id="date" value="%{date}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('date')"/></span>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="equipmentAppForm.meeting"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="roomAppForm.meetingId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="meetingList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('roomAppForm.meetingId')"/></span>
         <ww:textfield name="roomAppForm.otherMeeting" value="%{roomAppForm.otherMeeting}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="room.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
           <ww:checkboxlist name="roomIds" 
               list="roomList"
               listKey="id"
               listValue="name"              
            />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="roomAppForm.borrowDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="borrowDate" id="borrowDate" value="%{borrowDate}" language="zh" format="%Y/%m/%d"/>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
             <fmt:message key="roomAppForm.applyBeginClock"/>:
             <ww:select name="roomAppForm.applyBeginClockId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="applyBeginClockList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('roomAppForm.applyBeginClockId')"/></span>
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <fmt:message key="roomAppForm.applyEndClock"/>:
            <ww:select name="roomAppForm.applyEndClockId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="applyEndClockList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('roomAppForm.applyEndClockId')"/></span>
        
           
        </td>
    </tr>
    




    <tr><td class="cInputCaption"><fmt:message key="common.remark"/></td>
        <td class="cInputColumn">
            <ww:textarea name="roomAppForm.meno" value="%{roomAppForm.meno}" cssClass="cInputTextArea" cols="45" rows="4" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="roomAppForm.state"/></td>
        <td class="cInputColumn">
            <ww:property value="roomAppForm.state"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="roomAppForm.lastModifiedDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="roomAppForm.createdDate" /></span>
        </td>
    </tr>


    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="roomAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="roomAppForm.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
