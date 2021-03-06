<%@ include file="/common/taglibs.jsp"%>


<ww:form name="bolgForm" action="saveBanner.do" method="post" enctype="multipart/form-data" onsubmit="onSubmit()">
  <ww:hidden name="bolg.id" value="${bolg.id}"/>
  <ww:hidden name="bolg.bolgClassId" value="1"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bolg.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:window.location='bannerList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
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
    
  
    
    
    <tr><td class="cInputCaption">Banner名稱<span class="cRequired">*</span></td>
        <td class="cInputColumn">
           <ww:textfield name="bolg.name" value="%{bolg.name}" cssClass="cInputTextFieldLong"  id="bolg.name" /> 
        </td>
    </tr>

    
    <tr><td class="cInputCaption">Banner排序<span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="bolg.seqNo" value="%{bolg.seqNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('bolg.seqNo')"/></span>
        </td>
    </tr>
 

    <tr><td class="cInputCaption">Banner圖片上傳</td>
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
    
    
     <tr><td class="cInputCaption">Banner Link</td>
        <td class="cInputColumn">
            <ww:textfield name="bolg.link" value="%{bolg.link}" maxlength="200" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="bolg.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="bolg.status" cssClass="cCheckboxField" />
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
        <input type=button onclick="javascript:window.location='bannerList.do'" class="cButton" value="<fmt:message key="common.back"/>" >
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