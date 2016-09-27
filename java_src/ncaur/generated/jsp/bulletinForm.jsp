<%@ include file="/common/taglibs.jsp"%>

<ww:form name="bulletinForm" action="saveBulletin" method="POST" enctype="multipart/form-data">
  <ww:hidden name="bulletin.id" value="${bulletin.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bulletin.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="bulletin.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="bulletin.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="bulletin.bulletinDate"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="bulletinDate" id="bulletinDate" value="%{bulletinDate}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bulletinDate')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.subject"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.subject" value="%{bulletin.subject}" maxlength="50" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bulletin.subject')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.title"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.title" value="%{bulletin.title}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.description"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.description" value="%{bulletin.description}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.placeDesc"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.placeDesc" value="%{bulletin.placeDesc}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.timeDesc"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.timeDesc" value="%{bulletin.timeDesc}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.speaker"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.speaker" value="%{bulletin.speaker}" maxlength="20" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.flv"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.flv" value="%{bulletin.flv}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.worshipFlv"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.worshipFlv" value="%{bulletin.worshipFlv}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="bulletin.status" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bulletin.lastModifiedDate" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bulletin.createdDate" /></span>
        </td>
    </tr>



    <tr><td class="cInputCaption"><fmt:message key="bulletin.bulletinType"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="bulletin.bulletinTypeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="bulletinTypeList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bulletin.bulletinTypeId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.myfile"/></td>
        <td class="cInputColumn">
        <ww:if test="bulletin.myfile != null">
            <input type="checkbox" name="removeMyfile" onclick="if (this.checked == true) document.bulletinForm.fileMyfile.style.display='inline'; else document.bulletinForm.fileMyfile.style.display='none';" value="<ww:property value="bulletin.myfile.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="bulletin.uploadMyfile.relativeUrl"/>/<ww:property value="bulletin.id"/>/<ww:property value="bulletin.myfile.fileName"/>"><ww:property value="bulletin.myfile.fileName" /> (<ww:property value="bulletin.myfile.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileMyfile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="bulletin.myfileId" value="${bulletin.myfile.id}"/>
            <ww:hidden name="bulletin.myfileFileName" value="${bulletin.myfile.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileMyfile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.voice"/></td>
        <td class="cInputColumn">
        <ww:if test="bulletin.voice != null">
            <input type="checkbox" name="removeVoice" onclick="if (this.checked == true) document.bulletinForm.fileVoice.style.display='inline'; else document.bulletinForm.fileVoice.style.display='none';" value="<ww:property value="bulletin.voice.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="bulletin.uploadVoice.relativeUrl"/>/<ww:property value="bulletin.id"/>/<ww:property value="bulletin.voice.fileName"/>"><ww:property value="bulletin.voice.fileName" /> (<ww:property value="bulletin.voice.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileVoice" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="bulletin.voiceId" value="${bulletin.voice.id}"/>
            <ww:hidden name="bulletin.voiceFileName" value="${bulletin.voice.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileVoice" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.vedio"/></td>
        <td class="cInputColumn">
        <ww:if test="bulletin.vedio != null">
            <input type="checkbox" name="removeVedio" onclick="if (this.checked == true) document.bulletinForm.fileVedio.style.display='inline'; else document.bulletinForm.fileVedio.style.display='none';" value="<ww:property value="bulletin.vedio.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="bulletin.uploadVedio.relativeUrl"/>/<ww:property value="bulletin.id"/>/<ww:property value="bulletin.vedio.fileName"/>"><ww:property value="bulletin.vedio.fileName" /> (<ww:property value="bulletin.vedio.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileVedio" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="bulletin.vedioId" value="${bulletin.vedio.id}"/>
            <ww:hidden name="bulletin.vedioFileName" value="${bulletin.vedio.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileVedio" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.frontcover"/></td>
        <td class="cInputColumn">
        <ww:if test="bulletin.frontcover != null">
            <input type="checkbox" name="removeFrontcover" onclick="if (this.checked == true) document.bulletinForm.fileFrontcover.style.display='inline'; else document.bulletinForm.fileFrontcover.style.display='none';" value="<ww:property value="bulletin.frontcover.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="bulletin.uploadFrontcover.relativeUrl"/>/<ww:property value="bulletin.id"/>/<ww:property value="bulletin.frontcover.fileName"/>"><ww:property value="bulletin.frontcover.fileName" /> (<ww:property value="bulletin.frontcover.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileFrontcover" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="bulletin.frontcoverId" value="${bulletin.frontcover.id}"/>
            <ww:hidden name="bulletin.frontcoverFileName" value="${bulletin.frontcover.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileFrontcover" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="bulletin.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="bulletin.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
