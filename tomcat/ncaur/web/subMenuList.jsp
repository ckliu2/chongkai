<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="subMenu.list"/>         
         </td>
      </tr>      
      <tr>
        <td>
        <form name="qform"  method="post" action="subMenuList.do">          
          <img src="images/search.jpg">
           <span class="cLabel2"><fmt:message key="common.search"/><fmt:message key="menu.name"/>:</span>   
                <ww:select name="QuerySubMenu" onchange="javascript:qform.submit()"
                headerKey=""
                headerValue="%{getText('common.pleaseSelect')+getText('menu.name')}..."
                list="menuList"
                listKey="id"
                listValue="name"
                cssClass="cQueryFieldList"
                />
          <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
        </form> 
        </td>
      </tr>
            
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editSubMenu.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="subMenuList.size()"/>, 'selectedSubMenuId', 'copySubMenu.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
            
        </ww:if>
        <ww:else>
            <button onclick="location.href='editSubMenu.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="subMenuList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedSubMenuId_<c:out value="${count}"/>" name="selectedSubMenuId" value="<c:out value="${row.id}"/>">
    </display:column>
    
    <display:column property="menu.name" sortable="true" titleKey="subMenu.menu" style="text-align:left"/>
    
    <display:column property="name" sortable="true" titleKey="subMenu.name" style="text-align:left" />
    <display:column property="seqNo" sortable="true" titleKey="subMenu.seqNo" />
    <display:column property="status" sortable="true" titleKey="subMenu.status" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="lastModifiedUser" sortable="true" titleKey="common.lastModifiedUser" style="text-align:left"/>
    
  
    

    
    
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editSubMenu.do?subMenu.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.name}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'subMenu.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editSubMenu.do?subMenu.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    
    <%--
    <display:column titleKey="common.action">            
            <a href="javascript:goUrl(<c:out value="${row.id}"/>);" ><fmt:message key="common.enter"/></a>
    </display:column>
    --%>
  
    
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editSubMenu.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="subMenuList.size()"/>, 'selectedSubMenuId', 'copySubMenu.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editSubMenu.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>

<form name="form1" action="saveSubMenu.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="subMenu.id" value="">
    <select name="selectedSubMenuIds" multiple="true" style="display:none"></select>
</form>


<form name="form2" action="subItemList.do" method="post">
    <input type="hidden" name="QuerySubItem" >
</form>

<script>
  function goUrl(id){
  	 form2.QuerySubItem.value=id;
  	 form2.submit();  	 
  }
</script>
