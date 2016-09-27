<%@ include file="/common/taglibs.jsp"%>


<table width="100%" border="0">
  <tr>
    <td><table width="100%" border="0">
      <tr>
        <td><table width="100%" border="0" cellspacing="1" class="cContentTable">
          <tr>
            <td class="cContentTitle" colspan="2" ><fmt:message key="workEfficiency"/></td>
          </tr>
          <tr class="cActionButtonLine">
            <td colspan="2"><input type="submit" name="button"  value="<fmt:message key="product.analysis.query"/>" class="cButton" onClick="onSubmit();"/>
              &nbsp; </td>
          </tr>
          
<form name="form1" method="post" action="workEfficiency.html">
          <tr>
            <td width="110" nowrap="nowrap" class="cInputCaption"><fmt:message key="product.analysis.timeduring"/></td>
            <td width="620" >  
              <script type="text/javascript" src="/northwest/webwork/jscalendar/calendar.js"></script>
              <script type="text/javascript" src="/northwest/webwork/jscalendar/lang/calendar-zh.js"></script>
              <script type="text/javascript" src="/northwest/webwork/jscalendar/calendar-setup.js"></script>
              <input type="text" name="startDate" id="startDate" class="cInputTextFieldTiny" maxlength="8" value="${startDate}"/>
              <a href="#" id="startDate_button"><img src="/northwest/webwork/jscalendar/img.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></a>
              <script type="text/javascript">
               Calendar.setup({
               inputField     :    "startDate",
               ifFormat       :    "%Y%m%d",
               button         :    "startDate_button",
               step           :    1
              });
              </script>

              ~
              <input type="text" name="endDate" id="endDate" class="cInputTextFieldTiny" maxlength="8" value="${endDate}"/>
              <a href="#" id="endDate_button"><img src="/northwest/webwork/jscalendar/img.gif" width="16" height="16" border="0" alt="Click Here to Pick up the date"></a>
              <script type="text/javascript">
               Calendar.setup({
               inputField     :    "endDate",
               ifFormat       :    "%Y%m%d",
               button         :    "endDate_button",
               step           :    1
              });
             </script>
              
            </td>
          </tr>
          
          <tr>
            <td nowrap="nowrap" class="cInputCaption"><fmt:message key="workEfficiency.member"/>:</td>
            <td> 
            
            <input type="text" 
             name="input"  
             oninput="queryKeyWord2(this.value, 'memberId', 'findMemberByJSON.html', 'q');"
             onPropertyChange="queryKeyWord2(this.value, 'memberId', 'findMemberByJSON.html', 'q');"  
             onClick="javascript:clearText();"
             Class="cInputTextFieldTiny"
            >            
            
            <ww:select name="memberId" id="memberId"
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="memberList"
               listKey="id"
                listValue="name+'('+id+')'"
               cssClass="cInputListField"
            />
            
            </td>
          </tr>
</form>          
         <tr>
            <td colspan="2" >  
            <ww:set name="ls" value="%{getWorkEfficiency()}"/> 
            <ww:if test="member.id != null">
                        
            <div align="center" class="cTitle">${startDate}~${endDate}<br>${member.id}/${member.name}</div>
            
            <c:set var="c" value="1" />
            <c:forEach var="w" items="${ls}">
            <c:set var="ss" value="${w.products}"/>
            <ww:if test="${fn:length(w.products)} != 0">
            
            <span class="cTitle">${w.group.groupNameCh}</span>
            <br>

                    
             
             
             
                      
             <c:set var="count" value="1" />
             
             
             
             <display:table name="${ss}" class="list" cellspacing="1" id="${c}" requestURI="workEfficiency.html" pagesize="30">
                <display:column titleKey="bill.flow" style="width:12%">
                   ${w.group.groupNameCh}           
                </display:column>
                <display:column titleKey="common.id" style="width:5px">
                  ${count} 
                </display:column>
                <display:column titleKey="member.name" style="width:12%">
                   ${w.member.id} / ${w.member.name}         
                </display:column>                
                <display:column property="productId"  sortable="true" titleKey="product.id" style="width:20%"  />
                <display:column property="productName"  sortable="true" titleKey="product.name2"   />
                
                <display:column property="sumNumber"  sortable="true" titleKey="product.sumNumber" style="width:5%" />
              
                <display:column property="sumQuantity"  sortable="true" titleKey="product.pages" style="width:5%" />
                <display:column property="sumBasicQuantity"  sortable="true" titleKey="product.quantity" style="width:5%"/>
                <display:column property="unit"  sortable="true" titleKey="product.unit1" style="width:5%" />
              
                <display:footer>
                <tr>
                 <td colspan="5">&nbsp;</td>
                 <td><span class="cLabel">${w.sumNumber}</span></td>
                 <c:set var="units" value="${w.productUnits}"/>
                 <td colspan="3"> 
                 <c:set var="i" value="1" /> 
                 <c:forEach var="u" items="${units}">
                   <span class="cLabel">${u.name}:${u.count}</span> <br>
                 <c:set var="i" value="${i+1}" />
                 </c:forEach>  
                 </td>
                </tr>
                
               
                </display:footer> 
                                               
                <c:set var="count" value="${count+1}" />
              </display:table> 
              <br>  
              <c:set var="c" value="${c+1}" />
              
             </ww:if>
              
              
            </c:forEach>
            
            </ww:if>
 
             </td>
            </tr>
          
          <tr class="cActionButtonLine">
            <td colspan="2"><input type="submit" name="button"  value="<fmt:message key="product.analysis.query"/>" class="cButton" onClick="onSubmit();"/>
              &nbsp; </td>
          </tr>
          
</table>    



<script>
 function onSubmit(){
  form1.submit();
 }
 
 function clearText(){ 
 	 //alert("clearText..");
   document.all.input.value="";
   document.all.input.onfocus();
   
   //$('input[name="input"]').val("text123");
   //$( "#input" ).focus();
 }
</script>