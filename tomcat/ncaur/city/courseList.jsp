<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="course.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
           
         <form name="form2" method="post">
         	
           <ww:select name="course.typeId" id="course.typeId"
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}課程分類..."
               list="courseType"
               listKey="id"
               listValue="valueTw"
               cssClass="cInputListField"
            />
          
          <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="query()">查詢課程</a>
      
           
         </form>
         	  
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="courseList" class="list" cellspacing="1" requestURI="" id="row"  pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="type.valueTw" sortable="true" titleKey="course.type" style="text-align:left" />
    <display:column property="no" sortable="true" titleKey="course.no" style="text-align:left" />
    <display:column property="courseName" sortable="true" titleKey="course.courseName" style="text-align:left" />
    <display:column property="teacher" sortable="true" titleKey="course.teacher" style="text-align:left" />
    <display:column property="times" sortable="true" titleKey="course.times" style="text-align:left" />
    <display:column title="照片上傳">
     	 <a href="coursePhotos.do?course.id=${row.id}" target="_blank"><img src="${ctx}/images/photo.gif"></a>
    </display:column>    
    <display:column title="報名人員">
     	 <a href="courseRegisterList.do?course.id=${row.id}" target="_blank"><img src="${ctx}/images/members.gif"></a>
    </display:column>
    
    <display:column titleKey="common.action">    	
    	<a href="editCourse.do?course.id=<c:out value="${row.id}"/>" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">編輯</a> &nbsp;&nbsp;
    	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-remove'" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.no}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'course.id', '${row.id}')">刪除</a> &nbsp;&nbsp;
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
          <a href="editCourse.do" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增課程</a>
        </td>
      </tr>
</table>

            
<form name="form1" action="saveCourse.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="course.id" value="">
    <select name="selectedCourseIds" multiple="true" style="display:none"></select>
</form>

<script>
 function query()
 { 	
   form2.submit();
 }
</script>	
	
	



