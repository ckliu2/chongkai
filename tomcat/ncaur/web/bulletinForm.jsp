<%@ include file="/common/taglibs.jsp"%>

<ww:form name="bulletinForm" action="saveBulletin.do" method="POST" enctype="multipart/form-data">
  <ww:hidden name="bulletin.id" value="${bulletin.id}"/>
  <table border="0" align="left" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bulletin.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='bulletinList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
        <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
        <ww:if test="bulletin.id != null">
          <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
        </ww:if>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="bulletin.bulletinDate"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
           
            <ww:datepicker cssClass="cInputTextFieldShort" name="bulletinDate" id="bulletinDate" value="%{bulletinDate}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bulletinDate')"/></span>
            
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="bulletin.bulletinType"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:select name="bulletin.bulletinTypeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="bulletinTypeList"
               listKey="id"
               listValue="valueTw"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bulletin.bulletinTypeId')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.subject"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="bulletin.subject" value="%{bulletin.subject}" maxlength="50" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bulletin.subject')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.description"/></td>
        <td class="cInputColumn">
        
   <script type="text/javascript">
			function FCKeditor_OnComplete(bulletin.description) {
				var oCombo = document.getElementById('cmbSkins') ;	
				// Get the active skin.
				var sSkin = editorInstance.Config['SkinPath'] ;
				sSkin = sSkin.match( /[^\/]+(?=\/$)/g ) ;	
				oCombo.value = sSkin ;
				oCombo.style.visibility = '' ;
			}
		</script>        
             <FCK:editor instanceName="bulletin.description">
			         	<jsp:attribute name="value">
				           <c:out value="${bulletin.description}" escapeXml="false"/>
				        </jsp:attribute>
				        <jsp:body>
					          <FCK:config SkinPath="skins/office2003/"/>
				        </jsp:body>
			       </FCK:editor>         
        </td>
    </tr>
    





    <tr><td class="cInputCaption"><fmt:message key="bulletin.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="bulletin.status" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bulletin.file"/> <br> <fmt:message key="common.filelimit"/></td>
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

    <tr><td class="cInputCaption"><fmt:message key="bulletin.voice"/> <br> <fmt:message key="common.filelimit"/></td>
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

    <tr><td class="cInputCaption"><fmt:message key="bulletin.vedio"/> <br> <fmt:message key="common.filelimit"/></td>
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
    

    
   <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bulletin.lastModifiedDate" /></span>
        </td>
    </tr>
    
       <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bulletin.lastModifiedUser.cname" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bulletin.createdDate" /></span>
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="common.createdUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bulletin.createdUser.cname" /></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='bulletinList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
        <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
        <ww:if test="bulletin.id != null">
          <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
        </ww:if>
      </td>
    </tr>
  </table>
</ww:form>
