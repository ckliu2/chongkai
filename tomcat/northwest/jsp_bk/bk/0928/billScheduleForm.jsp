<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billScheduleForm" action="saveBillSchedule" method="POST" enctype="multipart/form-data">
  <ww:hidden name="billSchedule.id" value="${billSchedule.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="billSchedule.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.isSend"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.isSendId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="isSendList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="billSchedule.fileName"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.fileName" value="%{billSchedule.fileName}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.completionTime"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="completionTime" id="completionTime" value="%{completionTime}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check1"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check1" id="check1" value="%{check1}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check2"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check2" id="check2" value="%{check2}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check3"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check3" id="check3" value="%{check3}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check4"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check4" id="check4" value="%{check4}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check5"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check5" id="check5" value="%{check5}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputDevice"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="billSchedule.outputDevice" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.outputTime"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="outputTime" id="outputTime" value="%{outputTime}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check6"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check6" id="check6" value="%{check6}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check7"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="check7" id="check7" value="%{check7}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.deliveryTime"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="deliveryTime" id="deliveryTime" value="%{deliveryTime}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.freightNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.freightNo" value="%{billSchedule.freightNo}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.costs"/></td>
        <td class="cInputColumn">
            <ww:textfield name="billSchedule.costs" value="%{billSchedule.costs}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('billSchedule.costs')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check4photo1"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.check4photo1 != null">
            <input type="checkbox" name="removeCheck4photo1" onclick="if (this.checked == true) document.billScheduleForm.fileCheck4photo1.style.display='inline'; else document.billScheduleForm.fileCheck4photo1.style.display='none';" value="<ww:property value="billSchedule.check4photo1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCheck4photo1.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.check4photo1.fileName"/>"><ww:property value="billSchedule.check4photo1.fileName" /> (<ww:property value="billSchedule.check4photo1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCheck4photo1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.check4photo1Id" value="${billSchedule.check4photo1.id}"/>
            <ww:hidden name="billSchedule.check4photo1FileName" value="${billSchedule.check4photo1.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCheck4photo1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.check4photo2"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.check4photo2 != null">
            <input type="checkbox" name="removeCheck4photo2" onclick="if (this.checked == true) document.billScheduleForm.fileCheck4photo2.style.display='inline'; else document.billScheduleForm.fileCheck4photo2.style.display='none';" value="<ww:property value="billSchedule.check4photo2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCheck4photo2.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.check4photo2.fileName"/>"><ww:property value="billSchedule.check4photo2.fileName" /> (<ww:property value="billSchedule.check4photo2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCheck4photo2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.check4photo2Id" value="${billSchedule.check4photo2.id}"/>
            <ww:hidden name="billSchedule.check4photo2FileName" value="${billSchedule.check4photo2.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCheck4photo2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.isSend"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.isSendId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="isSendList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.freight"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.freightId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="freightList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.worker"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.workerId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="workerList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.completionphoto1"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.completionphoto1 != null">
            <input type="checkbox" name="removeCompletionphoto1" onclick="if (this.checked == true) document.billScheduleForm.fileCompletionphoto1.style.display='inline'; else document.billScheduleForm.fileCompletionphoto1.style.display='none';" value="<ww:property value="billSchedule.completionphoto1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCompletionphoto1.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.completionphoto1.fileName"/>"><ww:property value="billSchedule.completionphoto1.fileName" /> (<ww:property value="billSchedule.completionphoto1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCompletionphoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.completionphoto1Id" value="${billSchedule.completionphoto1.id}"/>
            <ww:hidden name="billSchedule.completionphoto1FileName" value="${billSchedule.completionphoto1.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCompletionphoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.completionphoto2"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.completionphoto2 != null">
            <input type="checkbox" name="removeCompletionphoto2" onclick="if (this.checked == true) document.billScheduleForm.fileCompletionphoto2.style.display='inline'; else document.billScheduleForm.fileCompletionphoto2.style.display='none';" value="<ww:property value="billSchedule.completionphoto2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCompletionphoto2.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.completionphoto2.fileName"/>"><ww:property value="billSchedule.completionphoto2.fileName" /> (<ww:property value="billSchedule.completionphoto2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCompletionphoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.completionphoto2Id" value="${billSchedule.completionphoto2.id}"/>
            <ww:hidden name="billSchedule.completionphoto2FileName" value="${billSchedule.completionphoto2.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCompletionphoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.completionphoto3"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.completionphoto3 != null">
            <input type="checkbox" name="removeCompletionphoto3" onclick="if (this.checked == true) document.billScheduleForm.fileCompletionphoto3.style.display='inline'; else document.billScheduleForm.fileCompletionphoto3.style.display='none';" value="<ww:property value="billSchedule.completionphoto3.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCompletionphoto3.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.completionphoto3.fileName"/>"><ww:property value="billSchedule.completionphoto3.fileName" /> (<ww:property value="billSchedule.completionphoto3.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCompletionphoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.completionphoto3Id" value="${billSchedule.completionphoto3.id}"/>
            <ww:hidden name="billSchedule.completionphoto3FileName" value="${billSchedule.completionphoto3.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCompletionphoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.completionphoto4"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.completionphoto4 != null">
            <input type="checkbox" name="removeCompletionphoto4" onclick="if (this.checked == true) document.billScheduleForm.fileCompletionphoto4.style.display='inline'; else document.billScheduleForm.fileCompletionphoto4.style.display='none';" value="<ww:property value="billSchedule.completionphoto4.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCompletionphoto4.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.completionphoto4.fileName"/>"><ww:property value="billSchedule.completionphoto4.fileName" /> (<ww:property value="billSchedule.completionphoto4.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCompletionphoto4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.completionphoto4Id" value="${billSchedule.completionphoto4.id}"/>
            <ww:hidden name="billSchedule.completionphoto4FileName" value="${billSchedule.completionphoto4.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCompletionphoto4" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.completionphoto5"/></td>
        <td class="cInputColumn">
        <ww:if test="billSchedule.completionphoto5 != null">
            <input type="checkbox" name="removeCompletionphoto5" onclick="if (this.checked == true) document.billScheduleForm.fileCompletionphoto5.style.display='inline'; else document.billScheduleForm.fileCompletionphoto5.style.display='none';" value="<ww:property value="billSchedule.completionphoto5.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="billSchedule.uploadCompletionphoto5.relativeUrl"/>/<ww:property value="billSchedule.id"/>/<ww:property value="billSchedule.completionphoto5.fileName"/>"><ww:property value="billSchedule.completionphoto5.fileName" /> (<ww:property value="billSchedule.completionphoto5.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCompletionphoto5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="billSchedule.completionphoto5Id" value="${billSchedule.completionphoto5.id}"/>
            <ww:hidden name="billSchedule.completionphoto5FileName" value="${billSchedule.completionphoto5.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCompletionphoto5" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="billSchedule.billDetail"/></td>
        <td class="cInputColumn">
            <ww:select name="billSchedule.billDetailId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="billDetailList"
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
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="billSchedule.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
