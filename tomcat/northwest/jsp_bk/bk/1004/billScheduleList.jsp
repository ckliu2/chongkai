<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="billSchedule.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBillSchedule.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="billScheduleList.size()"/>, 'selectedBillScheduleId', 'copyBillSchedule.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBillSchedule.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="billScheduleList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBillScheduleId_<c:out value="${count}"/>" name="selectedBillScheduleId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="fileName" sortable="true" titleKey="billSchedule.fileName" style="text-align:left" />
    <display:column property="completionTime" sortable="true" titleKey="billSchedule.completionTime" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check1" sortable="true" titleKey="billSchedule.check1" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check2" sortable="true" titleKey="billSchedule.check2" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check3" sortable="true" titleKey="billSchedule.check3" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check4" sortable="true" titleKey="billSchedule.check4" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check5" sortable="true" titleKey="billSchedule.check5" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="outputDevice" sortable="true" titleKey="billSchedule.outputDevice" style="text-align:left" />
    <display:column property="outputTime" sortable="true" titleKey="billSchedule.outputTime" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check6" sortable="true" titleKey="billSchedule.check6" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="check7" sortable="true" titleKey="billSchedule.check7" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="deliveryTime" sortable="true" titleKey="billSchedule.deliveryTime" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="freightNo" sortable="true" titleKey="billSchedule.freightNo" style="text-align:left" />
    <display:column property="costs" sortable="true" titleKey="billSchedule.costs" />
    <display:column property="check4photo1.caption_" sortable="true" titleKey="billSchedule.check4photo1" style="text-align:left"/>
    <display:column property="check4photo2.caption_" sortable="true" titleKey="billSchedule.check4photo2" style="text-align:left"/>
    <display:column property="isSend.caption_" sortable="true" titleKey="billSchedule.isSend" style="text-align:left"/>
    <display:column property="freight.caption_" sortable="true" titleKey="billSchedule.freight" style="text-align:left"/>
    <display:column property="worker.caption_" sortable="true" titleKey="billSchedule.worker" style="text-align:left"/>
    <display:column property="completionphoto1.caption_" sortable="true" titleKey="billSchedule.completionphoto1" style="text-align:left"/>
    <display:column property="completionphoto2.caption_" sortable="true" titleKey="billSchedule.completionphoto2" style="text-align:left"/>
    <display:column property="completionphoto3.caption_" sortable="true" titleKey="billSchedule.completionphoto3" style="text-align:left"/>
    <display:column property="completionphoto4.caption_" sortable="true" titleKey="billSchedule.completionphoto4" style="text-align:left"/>
    <display:column property="completionphoto5.caption_" sortable="true" titleKey="billSchedule.completionphoto5" style="text-align:left"/>
    <display:column property="billDetail.caption_" sortable="true" titleKey="billSchedule.billDetail" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBillSchedule.html?billSchedule.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'billSchedule.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBillSchedule.html?billSchedule.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBillSchedule.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="billScheduleList.size()"/>, 'selectedBillScheduleId', 'copyBillSchedule.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBillSchedule.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBillSchedule.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="billSchedule.id" value="">
    <select name="selectedBillScheduleIds" multiple="true" style="display:none"></select>
</form>
