<%@ include file="/common/taglibs.jsp"%>

<ww:form name="productForm" action="saveProduct" method="POST" enctype="multipart/form-data">
  <ww:hidden name="product.id" value="${product.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="product.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="product.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="product.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="product.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="product.name" value="%{product.name}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('product.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="product.seqNo"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="product.seqNo" value="%{product.seqNo}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('product.seqNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="product.num"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="product.num" value="%{product.num}" cssClass="cInputTextFieldTiny" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('product.num')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="product.status"/></td>
        <td class="cInputColumn">
            <ww:checkbox name="product.status" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="product.attachment"/></td>
        <td class="cInputColumn">
        <ww:if test="product.attachment != null">
            <input type="checkbox" name="removeAttachment" onclick="if (this.checked == true) document.productForm.fileAttachment.style.display='inline'; else document.productForm.fileAttachment.style.display='none';" value="<ww:property value="product.attachment.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="product.uploadAttachment.relativeUrl"/>/<ww:property value="product.id"/>/<ww:property value="product.attachment.fileName"/>"><ww:property value="product.attachment.fileName" /> (<ww:property value="product.attachment.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="fileAttachment" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="product.attachmentId" value="${product.attachment.id}"/>
            <ww:hidden name="product.attachmentFileName" value="${product.attachment.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="fileAttachment" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>
    
    
    <tr><td class="cInputCaption">價格設定</td>
        <td class="cInputColumn">
        
    <ww:set name="ps" value="%{getPricesByProduct()}"/>    
    
      
    <display:table name="ps" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:column title="尺寸">
      ${row.size.width}X${row.size.height}
    </display:column> 
    
    <display:column title="價格">
      <ww:textfield name="price${row.id}" value="${row.price}" cssClass="cInputTextFieldTiny" />
    </display:column>    
    </display:table>
 
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="product.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="product.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
