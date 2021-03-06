<%@ include file="/common/taglibs.jsp"%>

<ww:set name="courseRegisterList" value="%{getCourseRegisterList()}"/>


       
<table border="0" cellspacing="1" class="cContentTable1">
      <tr>
        <td class="cContentTitle" >「${course.no}/${course.courseName}」報名人員一覽表</td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
          <a href="./upload/course/${course.id}.xls" alt="匯出檔案"><img src="./images/excel.gif" alt="匯出檔案"/></a>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="1" />
<display:table name="courseRegisterList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:column titleKey="common.id">
     ${count}
    </display:column>
    <display:column title="報名時間">
     <fmt:formatDate value="${row.createdDate}" pattern="yyyy-MM-dd HH:mm"/>
    </display:column>
    <display:column property="member.cname" sortable="true" title="姓名" style="text-align:left" />
    <display:column property="member.email" sortable="true" title="Email" style="text-align:left" />
    <display:column property="member.cellphone" sortable="true" title="行動電話" style="text-align:left" />
    <display:column title="刪除">    	
       <a href="javascript:del('${row.id}');"><img src="./images/delete.png" /></a>
    </display:column>    
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>          	 
          <a href="./upload/course/${course.id}.xls" alt="匯出檔案"><img src="./images/excel.gif" alt="匯出檔案"/></a>
        </td>
      </tr>
</table>

<script>
	
	function del(id)
	{	
		$.messager.confirm('系統提示', '您確定要刪除?', function(r){
      if (r){
        window.location="delCourseMember.do?course.id=${course.id}&courseMember.id="+id;		
      }
    });
    
	}
	
</script>	
