<%@ include file="/common/taglibs.jsp"%>
	     
     
<ww:form name="courseForm" action="saveCourse" method="POST" enctype="multipart/form-data" onsubmit="onSubmit()">
  <ww:hidden name="course.id" value="${course.id}"/>
  
  <div id="photos">

  <ww:select name="photosIds" id="photosIds"
               list="photosList"
               listKey="id"
               listValue="id"
               multiple="true"
            />	
           
  </div>          
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="course.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="course.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="course.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="course.type"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            
            <ww:select name="course.typeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="courseType"
               listKey="id"
               listValue="valueTw"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('course.typeId')"/></span>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="course.stime"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="course.stime" value="%{course.stime}" maxlength="50" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('course.stime')"/></span>
        </td>
    </tr>

    
    <tr><td class="cInputCaption"><fmt:message key="course.no"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="course.no" value="%{course.no}" maxlength="50" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('course.no')"/></span>
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="course.times"/></td>
        <td class="cInputColumn">
           <ww:textfield  id="times" name="course.times" value="%{course.times}" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    

    <tr><td class="cInputCaption"><fmt:message key="course.courseName"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="course.courseName" value="%{course.courseName}" maxlength="100" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('course.courseName')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="course.teacher"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="course.teacher" value="%{course.teacher}" maxlength="100" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('course.teacher')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="course.description"/></td>
        <td class="cInputColumn">
		       
        <FCK:editor instanceName="course.description">
			         	<jsp:attribute name="value">
				           <c:out value="${course.description}" escapeXml="false"/>
				        </jsp:attribute>
				        <jsp:body>
					          <FCK:config SkinPath="skins/office2003/"/>
				        </jsp:body>
			  </FCK:editor>  
       
        </td>
    </tr>
    
    
    
    <tr><td class="cInputCaption"><fmt:message key="course.emailDescript"/></td>
        <td class="cInputColumn">
      
        <FCK:editor instanceName="course.emailDescript">
			         	<jsp:attribute name="value">
				           <c:out value="${course.emailDescript}" escapeXml="false"/>
				        </jsp:attribute>
				        <jsp:body>
					          <FCK:config SkinPath="skins/office2003/"/>
				        </jsp:body>
			  </FCK:editor>  
        
        </td>
    </tr>

<tr><td class="cInputCaption"><fmt:message key="course.emailfile"/></td>
        <td class="cInputColumn">
        <ww:if test="course.emailfile != null">
            <input type="checkbox" name="removeEmailfile" onclick="if (this.checked == true) document.courseForm.fileEmailfile.style.display='inline'; else document.courseForm.fileEmailfile.style.display='none';" value="<ww:property value="course.emailfile.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="course.uploadEmailfile.relativeUrl"/>/<ww:property value="course.id"/>/<ww:property value="course.emailfile.fileName"/>"><ww:property value="course.emailfile.fileName" /> (<ww:property value="course.emailfile.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileEmailfile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="course.emailfileId" value="${course.emailfile.id}"/>
            <ww:hidden name="course.emailfileFileName" value="${course.emailfile.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileEmailfile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
</tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="course.registerBegin"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="registerBegin" id="registerBegin" value="%{registerBegin}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('registerBegin')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="course.registerEnd"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="registerEnd" id="registerEnd" value="%{registerEnd}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('registerEnd')"/></span>
        </td>
    </tr>

    

    <tr><td class="cInputCaption"><fmt:message key="course.fee"/></td>
        <td class="cInputColumn">
            <ww:textfield name="course.fee" value="%{course.fee}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="course.file"/></td>
        <td class="cInputColumn">
        
        <ww:if test="course.coursefile != null">
            <input type="checkbox" name="removeCoursefile" onclick="if (this.checked == true) document.courseForm.fileCoursefile.style.display='inline'; else document.courseForm.fileCoursefile.style.display='none';" value="<ww:property value="course.coursefile.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="course.uploadFile.relativeUrl"/>/<ww:property value="course.id"/>/<ww:property value="course.coursefile.fileName"/>"><ww:property value="course.coursefile.fileName" /> (<ww:property value="course.coursefile.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileCoursefile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="course.coursefileId" value="${course.coursefile.id}"/>
            <ww:hidden name="course.coursefileFileName" value="${course.coursefile.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileCoursefile" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="course.filegroups"/></td>
        <td class="cInputColumn">
        
        <ww:checkboxlist name="filegroupsIds"
                list="filegroupsList"
                listKey="id"  
                listValue="groupNameCh"      
                />
     
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">
         <span class="cLabel">
          <fmt:formatDate value="${course.lastModifiedDate}" pattern="yyyy-MM-dd HH:mm"/>
         </span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
        <span class="cLabel">
          <fmt:formatDate value="${course.createdDate}" pattern="yyyy-MM-dd HH:mm"/>
         </span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="course.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="course.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>

         
               



<script>






$('#photos').hide();			  

function onSubmit() {
    mySelectAll(document.courseForm.photosIds);
    return true;
}
  
</script>



