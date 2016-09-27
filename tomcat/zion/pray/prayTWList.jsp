<%@ include file="/common/taglibs.jsp"%>

<form name="form1" method="post">

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="prayTW.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        
        <ww:select name="countyId" onchange="county();"
               headerKey=""
               headerValue="請選擇區域..."
               list="countryList1"
               listKey="id"
               listValue="valueCh"
               cssClass="cInputListField"
            />
        
        </td>
      </tr>
      <tr>
        <td>

<c:set var="count" value="0" />
<display:table name="countyList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="valueCh" sortable="true" title="區域名稱" style="text-align:left" />
    <display:column titleKey="common.action">
         <a href="editPrayTW.do?prayTW.areaId=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>

        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>

        </td>
      </tr>
</table>

<script>
  function county()
  {
  	form1.submit();
  }
</script>

</form>
