<%@ include file="/common/taglibs.jsp"%>
    <script language="javascript">
<!--
	var __widget='<c:out value="${param.widgetId}"/>';
	function getWidgetId()
	{
		return __widget;
	}
-->
  </script>
  
</div>



<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="equipment.list"/></td>
        <td align="left" width="7%">
        <div align="left">
        <a href="javascript:try{ window.parent.close(); } catch (e) {}"><span class="cLabel"><fmt:message key="common.window.close"/></span></a>
        </div>
        </td>
      </tr>    
      
      <tr>
        <td>
        <form name="qform"  method="post" >
          <span class="cLabel2"> <fmt:message key="common.keyword"/>:</span>
          <ww:textfield name="keyword" value="%{keyword}" maxlength="40" cssClass="cInputTextFieldShort" />            
          <ww:hidden name="widgetId" value="${param.widgetId}"/>           
          <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
        </form> 
        </td>
      </tr>
      
      
      <tr>
        <td class="cMenuItem">         </td>         
      </tr>      

      <tr>
        <td>
   
<form name="form" method="post">
       
<c:set var="count" value="0" />
<display:table name="equipmentList1" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.action">
         <a href="#" onclick="getQuantity(<c:out value="${row.id}"/>,'<c:out value="${row.name}"/>')"><fmt:message key="common.insert"/></a>
    </display:column>
    <display:column property="name" sortable="true" titleKey="equipment.name" style="text-align:left" />
    <display:column property="quantity" sortable="true" titleKey="equipment.allquantity" />
    <display:column titleKey="equipment.quantity1">
         <c:out value="${row.borrow}"/>
    </display:column>       
    
     <display:column titleKey="equipment.quantity2">  
           <select name="q<c:out value="${row.id}"/>">
               <c:forEach var="x" begin="1" end="${row.surplus}" step="1">
                  <option value="<c:out value="${x}"/>"><c:out value="${x}"/></option>                  
               </c:forEach>
           </select> 
           <input type="hidden" name="category<c:out value="${row.id}"/>">      
     </display:column>
    
    <display:column property="department.caption_" sortable="true" titleKey="department.name" style="text-align:left"/>
    <display:column property="meno" sortable="true" titleKey="common.remark" style="text-align:left" />
    <c:set var="count" value="${count+1}" />
</display:table> 

 
</form>

</td>
    </tr>

</table>


<script>
  function getQuantity(i,name){
    var s = eval('form.q'+i+'.selectedIndex');    
	  var a = eval('form.q'+i+'.value');
	  //alert(a+"___"+name);
	  //1#1  Àï¤h¹ª * 2
	  var id=i+"#"+a;
	  var data=name +"*"+a;
	  
	  myReturnFunction(id,data);

  }
</script>





