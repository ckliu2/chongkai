<%@ include file="/common/taglibs.jsp"%>

7
    <c:set var="count" value="0" />
    <display:table name="memberList" class="list" cellspacing="1" id="row" requestURI="test.html" pagesize="30">
      <display:column property="name"  sortable="true" title="name" style="width:20%"  />
      <display:column property="flag"  total="true" />  
      
      <display:footer>
        <tr class="odd">
        <td style="width:20%">any sum or custom code can go her</td>
        <td>${count}</td></tr>      
      </display:footer>  
           
     <c:set var="count" value="${count+row.flag}" />      
    </display:table>            
              
