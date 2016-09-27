<%@ include file="/common/taglibs.jsp"%>

<ww:form name="prayTWForm" action="savePrayTW" method="POST" enctype="multipart/form-data">
  <ww:hidden name="prayTW.id" value="${prayTW.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="prayTW.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="prayTW.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="prayTW.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="prayTW.descriptionUrl"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textarea name="prayTW.descriptionUrl" value="%{prayTW.descriptionUrl}" cssClass="cInputTextArea" cols="45" rows="8" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayTW.descriptionUrl')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.latitude"/></td>
        <td class="cInputColumn">
            <ww:textfield name="prayTW.latitude" value="%{prayTW.latitude}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.longitude"/></td>
        <td class="cInputColumn">
            <ww:textfield name="prayTW.longitude" value="%{prayTW.longitude}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.zoom"/></td>
        <td class="cInputColumn">
            <ww:textfield name="prayTW.zoom" value="%{prayTW.zoom}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayTW.zoom')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.map"/></td>
        <td class="cInputColumn">
        <ww:if test="prayTW.map != null">
            <input type="checkbox" name="removeMap" onclick="if (this.checked == true) document.prayTWForm.fileMap.style.display='inline'; else document.prayTWForm.fileMap.style.display='none';" value="<ww:property value="prayTW.map.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayTW.uploadMap.relativeUrl"/>/<ww:property value="prayTW.id"/>/<ww:property value="prayTW.map.fileName"/>"><ww:property value="prayTW.map.fileName" /> (<ww:property value="prayTW.map.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileMap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayTW.mapId" value="${prayTW.map.id}"/>
            <ww:hidden name="prayTW.mapFileName" value="${prayTW.map.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileMap" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.photo1"/></td>
        <td class="cInputColumn">
        <ww:if test="prayTW.photo1 != null">
            <input type="checkbox" name="removePhoto1" onclick="if (this.checked == true) document.prayTWForm.filePhoto1.style.display='inline'; else document.prayTWForm.filePhoto1.style.display='none';" value="<ww:property value="prayTW.photo1.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayTW.uploadPhoto1.relativeUrl"/>/<ww:property value="prayTW.id"/>/<ww:property value="prayTW.photo1.fileName"/>"><ww:property value="prayTW.photo1.fileName" /> (<ww:property value="prayTW.photo1.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayTW.photo1Id" value="${prayTW.photo1.id}"/>
            <ww:hidden name="prayTW.photo1FileName" value="${prayTW.photo1.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto1" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.photo2"/></td>
        <td class="cInputColumn">
        <ww:if test="prayTW.photo2 != null">
            <input type="checkbox" name="removePhoto2" onclick="if (this.checked == true) document.prayTWForm.filePhoto2.style.display='inline'; else document.prayTWForm.filePhoto2.style.display='none';" value="<ww:property value="prayTW.photo2.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayTW.uploadPhoto2.relativeUrl"/>/<ww:property value="prayTW.id"/>/<ww:property value="prayTW.photo2.fileName"/>"><ww:property value="prayTW.photo2.fileName" /> (<ww:property value="prayTW.photo2.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayTW.photo2Id" value="${prayTW.photo2.id}"/>
            <ww:hidden name="prayTW.photo2FileName" value="${prayTW.photo2.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto2" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.photo3"/></td>
        <td class="cInputColumn">
        <ww:if test="prayTW.photo3 != null">
            <input type="checkbox" name="removePhoto3" onclick="if (this.checked == true) document.prayTWForm.filePhoto3.style.display='inline'; else document.prayTWForm.filePhoto3.style.display='none';" value="<ww:property value="prayTW.photo3.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="prayTW.uploadPhoto3.relativeUrl"/>/<ww:property value="prayTW.id"/>/<ww:property value="prayTW.photo3.fileName"/>"><ww:property value="prayTW.photo3.fileName" /> (<ww:property value="prayTW.photo3.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="prayTW.photo3Id" value="${prayTW.photo3.id}"/>
            <ww:hidden name="prayTW.photo3FileName" value="${prayTW.photo3.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto3" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="prayTW.area"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="prayTW.areaId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="areaList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayTW.areaId')"/></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="prayTW.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="prayTW.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
