<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="courseMember.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editCourseMember.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="courseMemberList.size()"/>, 'selectedCourseMemberId', 'copyCourseMember.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editCourseMember.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="courseMemberList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedCourseMemberId_<c:out value="${count}"/>" name="selectedCourseMemberId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="attendlog" sortable="true" titleKey="courseMember.attendlog" style="text-align:left" />
    <display:column property="course.no" sortable="true" titleKey="courseMember.course" style="text-align:left"/>
    <display:column property="course.name" sortable="true" titleKey="courseMember.member" style="text-align:left"/>
    <display:column titleKey="common.action">
     <a href="editCourseMember.html?courseMember.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>
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