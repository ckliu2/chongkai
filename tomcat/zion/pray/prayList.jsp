<%@ include file="/common/taglibs.jsp"%>


<form name="form2" action="prayList.do">
<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="pray.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        
        <ww:select name="classifyId" onchange="classify();"
               headerKey=""
               headerValue="請選擇代禱分類..."
               list="classifyList"
               listKey="id"
               listValue="valueTw"
               cssClass="cInputListField"
            />
            
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="prayList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="content" sortable="true" titleKey="pray.content" style="text-align:left" />
    <display:column property="classify.caption_" sortable="true" titleKey="pray.classify" style="text-align:left"/>
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="lastModifiedUser" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left"/>
    <display:column property="createdUser" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editPray.do?pray.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.content}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'pray.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editPray.do?pray.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
          <a href="editPray.do"><fmt:message key="common.new"/></a>
        </td>
      </tr>
</table>

</form>

<form name="form1" action="savePray.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="pray.id" value="">
    <select name="selectedPrayIds" multiple="true" style="display:none"></select>
</form>

<script>
 function classify()
 {
 	 form2.submit();
 }
</script>



