<%@ include file="/common/taglibs.jsp"%>


<ww:form name="bolgForm" action="saveBolg.do" method="post" enctype="multipart/form-data" onsubmit="onSubmit()">
  <ww:hidden name="bolg.id" value="${bolg.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bolg.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='bolgList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="bolg.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="bolg.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
   <tr><td class="cInputCaption"><fmt:message key="bolgClass.name"/></td>
        <td class="cInputColumn">              
               <ww:select name="bolg.bolgClassId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="bolgClassList"
               listKey="id"
               listValue="name"
               cssClass="cInputListField"
            />      
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="bolg.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
           <ww:textfield name="bolg.name" value="%{bolg.name}" cssClass="cInputTextFieldLong"  id="bolg.name" /> 
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bolg.link"/></td>
        <td class="cInputColumn">
            <ww:textfield name="bolg.link" value="%{bolg.link}" maxlength="200" cssClass="cInputTextFieldLong" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="bolg.content"/></td>
        <td class="cInputColumn">           
            <FCK:editor instanceName="bolg.content">
			         	<jsp:attribute name="value">
				           <c:out value="${bolg.content}" escapeXml="false"/>
				        </jsp:attribute>
				        <jsp:body>
					          <FCK:config SkinPath="skins/office2003/"/>
				        </jsp:body>
			       </FCK:editor> 
        </td>
    </tr>


    
    <tr><td class="cInputCaption"><fmt:message key="bolg.seqNo"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="bolg.seqNo" value="%{bolg.seqNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bolg.seqNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bolg.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="bolg.status" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bolg.beginDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="beginDate" id="beginDate" value="%{beginDate}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bolg.endDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="endDate" id="endDate" value="%{endDate}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="bolg.memo"/></td>
        <td class="cInputColumn">
           
            <ww:textarea name="bolg.memo" value="%{bolg.memo}" cssClass="cInputTextArea" cols="45" rows="12" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bolg.file"/></td>
        <td class="cInputColumn">
        <ww:if test="bolg.myfile != null">
            <input type="checkbox" name="removeMyfile" onclick="if (this.checked == true) document.bolgForm.fileMyfile.style.display='inline'; else document.bolgForm.fileMyfile.style.display='none';" value="<ww:property value="bolg.myfile.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="bolg.uploadMyfile.relativeUrl"/>/<ww:property value="bolg.id"/>/<ww:property value="bolg.myfile.fileName"/>"><ww:property value="bolg.myfile.fileName" /> (<ww:property value="bolg.myfile.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileMyfile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="bolg.myfileId" value="${bolg.myfile.id}"/>
            <ww:hidden name="bolg.myfileFileName" value="${bolg.myfile.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileMyfile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
        </td>
    </tr>

    
    <tr><td class="cInputCaption"><fmt:message key="bolg.photo"/></td>
        <td class="cInputColumn">
        <ww:if test="bolg.photo != null">
            <input type="checkbox" name="removePhoto" onclick="if (this.checked == true) document.bolgForm.filePhoto.style.display='inline'; else document.bolgForm.filePhoto.style.display='none';" value="<ww:property value="bolg.photo.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="bolg.uploadPhoto.relativeUrl"/>/<ww:property value="bolg.id"/>/<ww:property value="bolg.photo.fileName"/>"><ww:property value="bolg.photo.fileName" /> (<ww:property value="bolg.photo.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="bolg.photoId" value="${bolg.photo.id}"/>
            <ww:hidden name="bolg.photoFileName" value="${bolg.photo.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>
        
          <ww:if test="bolg.photo != null">
             <img border="0" src="<fmt:message key="bolg.uploadPhoto.relativeUrl"/>/${bolg.id}/${bolg.photo.fileName}" width="150" />
          </ww:if>
        </td>
    </tr>   
    
   <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bolg.lastModifiedDate" /></span>
        </td>
    </tr>
    
       <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bolg.lastModifiedUser.cname" /></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bolg.createdDate" /></span>
        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="common.createdUser"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="bolg.createdUser.cname" /></span>
        </td>
    </tr>



    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='bolgList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="bolg.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="bolg.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>

<script>
function onSubmit() {
    return true;
}
</script>