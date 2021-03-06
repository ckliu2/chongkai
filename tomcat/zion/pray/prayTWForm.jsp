<%@ include file="/common/taglibs.jsp"%>

<ww:form name="prayTWForm" action="savePrayTW" method="POST" enctype="multipart/form-data">
  <ww:hidden name="prayTW.id" value="${prayTW.id}"/>
  <ww:hidden name="prayTW.areaId" value="${prayTW.areaId}"/>
  
  
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
    
    
    <tr><td class="cInputCaption">區域</td>
        <td class="cInputColumn">
            <span class="cLabel4">${prayTW.area.valueCh}</span>
        </td>
    </tr>
    
    <tr><td class="cInputCaption">緯度</td>
        <td class="cInputColumn">
            <ww:textfield name="prayTW.latitude" value="%{prayTW.latitude}" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption">經度</td>
        <td class="cInputColumn">
            <ww:textfield name="prayTW.longitude" value="%{prayTW.longitude}" cssClass="cInputTextFieldLong" />
        </td>
    </tr>
    
    
    <tr><td class="cInputCaption"><fmt:message key="prayTW.descriptionUrl"/></td>
        <td class="cInputColumn">
            <ww:textfield name="prayTW.descriptionUrl" value="%{prayTW.descriptionUrl}" cssClass="cInputTextFieldLong" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('prayTW.descriptionUrl')"/></span>
        </td>
    </tr>
    
    <tr><td class="cInputCaption">zoom</td>
        <td class="cInputColumn">            
            <ww:select name="prayTW.zoom" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="zoomList"
               listKey="id"
               listValue="id"
               cssClass="cInputListField"
            />         
        </td>
    </tr>
    
    
     <tr><td class="cInputCaption">街道</td>
        <td class="cInputColumn">        
        <a href="javascript:openChild('editPrayStreet.do?prayStreet.praytwId=${prayTW.id}')">
        <img src="${ctx}/images/add.png"/>
        </a>
        
        <display:table name="streetList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
        <display:setProperty name="paging.banner.placement" value="bottom" />
        <display:column property="name" sortable="true" title="街道名稱" style="text-align:left" />
        
        <display:column titleKey="common.action">
           <a href="javascript:openChild('editPrayStreet.do?prayStreet.id=${row.id}&prayStreet.praytwId=${row.praytw.id}')"><fmt:message key="common.edit"/></a>
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

<script>
  function openChild(page){ 
	    window.open(page);
	 }
</script>
