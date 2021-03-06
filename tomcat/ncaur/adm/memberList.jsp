<%@ include file="/common/taglibs.jsp"%>



<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="member.list"/></td>
      </tr>
      <tr class="cActionButtonLine">
        <td>
        <form action="memberList.do" method="post">
        
        請輸入中英文姓名關鍵字:
        <ww:textfield name="keyword" value="%{keyword}" cssClass="cInputTextField" />
        
        <input type="submit" value="查詢"/>
        </form>
        
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="memberList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column property="cname" sortable="true" titleKey="member.cname" style="text-align:left" />
    <display:column property="ename" sortable="true" titleKey="member.ename" style="text-align:left" />
    <display:column property="sex" sortable="true" titleKey="member.sex" style="text-align:left" decorator="com.base.web.displaytag.SexDecorator"/>
    <display:column property="cellphone" sortable="true" titleKey="member.cellphone" style="text-align:left" />
    <display:column property="homePhone" sortable="true" titleKey="member.homePhone" style="text-align:left" />
    
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editMember.do?member.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.cname}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'member.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editMember.do?member.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
          <button onclick="location.href='editMember.do'" class="cButton"><fmt:message key="common.new"/></button>
        </td>
      </tr>
</table>



<form name="form1" action="saveMember.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="member.id" value="">
    <select name="selectedMemberIds" multiple="true" style="display:none"></select>
</form>
