<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="course.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="courseList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="no" sortable="true" titleKey="course.no" style="text-align:left" />
    <display:column property="courseName" sortable="true" titleKey="course.courseName" style="text-align:left" />
    <display:column property="teacher" sortable="true" titleKey="course.teacher" style="text-align:left" />
    <display:column property="times" sortable="true" titleKey="course.times" style="text-align:left" />
    <display:column titleKey="common.action"> 
        <a href="courseRegisterList.do?course.id=<c:out value="${row.id}"/>">報名人員</a>
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

