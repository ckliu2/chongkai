<%@ include file="/common/taglibs.jsp"%>

<ww:form name="prayStreetForm" action="savePrayStreet" method="POST" enctype="multipart/form-data">
  <ww:hidden name="prayStreet.id" value="${prayStreet.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="prayStreet.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="prayStreet.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="prayStreet.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="prayStreet.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textarea name="prayStreet.name" value="%{prayStreet.name}" cssClass="cInputTextArea" cols="45" rows="8" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayStreet.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.latitude"/></td>
        <td class="cInputColumn">
            <ww:textfield name="prayStreet.latitude" value="%{prayStreet.latitude}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.longitude"/></td>
        <td class="cInputColumn">
            <ww:textfield name="prayStreet.longitude" value="%{prayStreet.longitude}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.zoom"/></td>
        <td class="cInputColumn">
            <ww:textfield name="prayStreet.zoom" value="%{prayStreet.zoom}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayStreet.zoom')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.map"/></td>
        <td class="cInputColumn">
        <ww:if test="prayStreet.map != null">
            <input type="checkbox" name="removeMap" onclick="if (this.checked == true) document.prayStreetForm.fileMap.style.display='inline'; else document.prayStreetForm.fileMap.style.display='none';" value="<ww:property value="prayStreet.map.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayStreet.uploadMap.relativeUrl"/>/<ww:property value="prayStreet.id"/>/<ww:property value="prayStreet.map.fileName"/>"><ww:property value="prayStreet.map.fileName" /> (<ww:property value="prayStreet.map.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileMap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayStreet.mapId" value="${prayStreet.map.id}"/>
            <ww:hidden name="prayStreet.mapFileName" value="${prayStreet.map.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileMap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.photo1"/></td>
        <td class="cInputColumn">
        <ww:if test="prayStreet.photo1 != null">
            <input type="checkbox" name="removePhoto1" onclick="if (this.checked == true) document.prayStreetForm.filePhoto1.style.display='inline'; else document.prayStreetForm.filePhoto1.style.display='none';" value="<ww:property value="prayStreet.photo1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayStreet.uploadPhoto1.relativeUrl"/>/<ww:property value="prayStreet.id"/>/<ww:property value="prayStreet.photo1.fileName"/>"><ww:property value="prayStreet.photo1.fileName" /> (<ww:property value="prayStreet.photo1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayStreet.photo1Id" value="${prayStreet.photo1.id}"/>
            <ww:hidden name="prayStreet.photo1FileName" value="${prayStreet.photo1.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.photo2"/></td>
        <td class="cInputColumn">
        <ww:if test="prayStreet.photo2 != null">
            <input type="checkbox" name="removePhoto2" onclick="if (this.checked == true) document.prayStreetForm.filePhoto2.style.display='inline'; else document.prayStreetForm.filePhoto2.style.display='none';" value="<ww:property value="prayStreet.photo2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayStreet.uploadPhoto2.relativeUrl"/>/<ww:property value="prayStreet.id"/>/<ww:property value="prayStreet.photo2.fileName"/>"><ww:property value="prayStreet.photo2.fileName" /> (<ww:property value="prayStreet.photo2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayStreet.photo2Id" value="${prayStreet.photo2.id}"/>
            <ww:hidden name="prayStreet.photo2FileName" value="${prayStreet.photo2.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.photo3"/></td>
        <td class="cInputColumn">
        <ww:if test="prayStreet.photo3 != null">
            <input type="checkbox" name="removePhoto3" onclick="if (this.checked == true) document.prayStreetForm.filePhoto3.style.display='inline'; else document.prayStreetForm.filePhoto3.style.display='none';" value="<ww:property value="prayStreet.photo3.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayStreet.uploadPhoto3.relativeUrl"/>/<ww:property value="prayStreet.id"/>/<ww:property value="prayStreet.photo3.fileName"/>"><ww:property value="prayStreet.photo3.fileName" /> (<ww:property value="prayStreet.photo3.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayStreet.photo3Id" value="${prayStreet.photo3.id}"/>
            <ww:hidden name="prayStreet.photo3FileName" value="${prayStreet.photo3.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayStreet.praytw"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="prayStreet.praytwId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="praytwList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayStreet.praytwId')"/></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="prayStreet.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="prayStreet.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
