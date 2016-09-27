<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" class="cContentTable">
      <tr>
        <td class="cContentTitle" ><fmt:message key="course.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editCourse.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="courseList.size()"/>, 'selectedCourseId', 'copyCourse.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editCourse.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="courseList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedCourseId_<c:out value="${count}"/>" name="selectedCourseId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="stime" sortable="true" titleKey="course.stime" style="text-align:left" />
    <display:column property="no" sortable="true" titleKey="course.no" style="text-align:left" />
    <display:column property="courseName" sortable="true" titleKey="course.courseName" style="text-align:left" />
    <display:column property="teacher" sortable="true" titleKey="course.teacher" style="text-align:left" />
    <display:column property="description" sortable="true" titleKey="course.description" style="text-align:left" />
    <display:column property="registerBegin" sortable="true" titleKey="course.registerBegin" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="registerEnd" sortable="true" titleKey="course.registerEnd" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="fee" sortable="true" titleKey="course.fee" style="text-align:left" />
    <display:column property="note1" sortable="true" titleKey="course.note1" style="text-align:left" />
    <display:column property="note2" sortable="true" titleKey="course.note2" style="text-align:left" />
    <display:column property="note3" sortable="true" titleKey="course.note3" style="text-align:left" />
    <display:column property="note4" sortable="true" titleKey="course.note4" style="text-align:left" />
    <display:column property="noteDate1" sortable="true" titleKey="course.noteDate1" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="noteDate2" sortable="true" titleKey="course.noteDate2" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="noteDate3" sortable="true" titleKey="course.noteDate3" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="noteDate4" sortable="true" titleKey="course.noteDate4" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="times" sortable="true" titleKey="course.times" style="text-align:left" />
    <display:column property="emailDescript" sortable="true" titleKey="course.emailDescript" style="text-align:left" />
    <display:column property="lastModifiedDate" sortable="true" titleKey="common.lastModifiedDate" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" style="text-align:left"/>
    <display:column property="coursefile.caption_" sortable="true" titleKey="course.coursefile" style="text-align:left"/>
    <display:column property="emailfile.caption_" sortable="true" titleKey="course.emailfile" style="text-align:left"/>
    <display:column property="type.caption_" sortable="true" titleKey="course.type" style="text-align:left"/>
    <display:column property="filegroups" sortable="true" titleKey="course.filegroups" style="text-align:left" />
    <display:column property="photos" sortable="true" titleKey="course.photos" style="text-align:left" />
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editCourse.html?course.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.caption_}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'course.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editCourse.html?course.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editCourse.html'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="courseList.size()"/>, 'selectedCourseId', 'copyCourse.html', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editCourse.html'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveCourse.html">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="course.id" value="">
    <select name="selectedCourseIds" multiple="true" style="display:none"></select>
</form>
