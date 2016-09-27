<%@ include file="/common/taglibs.jsp"%>

<ww:form name="smsForm" action="saveMail.do" method="POST"  onsubmit="onSubmit()">

  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><ww:text name='mail.smsmail'/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type="submit"  class="cButton" value="<ww:text name='mail.send'/>" />
      </td>
      
       <td colspan="2">
         <a href="smsMailRecList.do" target="_blank"><ww:text name='smsMailRec.list'/></a>
       </td>
       
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="mail.sender"/></td>
        <td class="cInputColumn">
           <ww:property value="#session['user'].name"/>        </td>
    </tr>
    
    
   <tr><td class="cInputCaption"><fmt:message key="mail.subject"/></td>
        <td class="cInputColumn">
            <ww:textfield name="subject" value="%{subject}"  cssClass="cInputTextFieldLong" /></span>  
 
            </td>
    </tr>
   

   
    <tr><td class="cInputCaption"><fmt:message key="mail.msg"/></td>
        <td class="cInputColumn">     
            <FCK:editor instanceName="msg">
			         	<jsp:attribute name="value">
				           <c:out value="${msg}" escapeXml="false"/>
				        </jsp:attribute>
				        <jsp:body>
					          <FCK:config SkinPath="skins/office2003/"/>
				        </jsp:body>
			      </FCK:editor> 
           <div class="cInputValidationError" id="info"></div> 
           </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="mail.other"/></td>
        <td class="cInputColumn">
            <ww:textfield name="othermail" value="%{othermail}"  cssClass="cInputTextFieldLong" /></span>  
            <br>      
            <input type="button" value="+"  class="cSelectButton" onclick="addOne(othermail, otherIds);">
            <input type="button" value="-"  class="cSelectButton" onclick="disOne(otherIds);">
                
            </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="mail.otherlist"/></td>
      <td class="cInputColumn">
            <select name="otherIds"  size="8" multiple="multiple" class="cQueryFieldList" id="otherIds">
            </select>
            
            <select name="memberIds"  size="8" multiple="multiple" class="cQueryFieldList" id="memberIds">
            </select>
            <input class="cOpenWindowButton" type=button value="<fmt:message key="common.insert"/>" onclick="myInsertFromNewWindow('queryMemberListTop.do', 'memberIds', '');">
            <input class="cOpenWindowButton" type=button value="<fmt:message key="common.delete"/>" onclick="myDeleteFromSelectMany(document.smsForm.memberIds);">
        
            
            </td>
    </tr>
    
    


       <tr><td class="cInputCaption"><fmt:message key="grade.name"/></td>
        <td class="cInputColumn">
        
     <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="grade.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="grade.name"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allGrade"
                list="gradeList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />                
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allGrade, selectedGrade);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allGrade, selectedGrade);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedGrade, allGrade);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedGrade, allGrade);"><br>
            </td>
            
            <td align="center">
                <select name="gradeIds"  size="8" multiple="multiple" class="cQueryFieldList" id="selectedGrade"></select>
                </td>
            </tr>
       </table>
            
        </td>
    </tr>
    

    
    
   <tr><td class="cInputCaption"><fmt:message key="team.name"/></td>
        <td class="cInputColumn">
        
         <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="team.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="team.name"/></style></th>
            </tr><tr>
            <td >
            
               <ww:select id="allTeam"
                list="teamList"
                listKey="id"
                listValue="name"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />   
                
             
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allTeam, selectedTeam);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allTeam, selectedTeam);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedTeam, allTeam);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedTeam, allTeam);"><br>
            </td>            
            <td align="center">
                <select name="teamIds"  size="8" multiple="multiple" class="cQueryFieldList" id="selectedTeam">
                </select>
              </td>
            </tr>
        </table>
            
            
        </td>
    </tr>
    
    
        <tr>
          <td class="cInputCaption"><fmt:message key="group.groupNameCh"/>&nbsp;</td>
          <td class="cInputColumn">
          <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="group.groupNameCh"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="group.groupNameCh"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allGroup"
                list="groupList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                /></td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allGroup, selectedGroup);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allGroup, selectedGroup);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedGroup, allGroup);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedGroup, allGroup);"><br>
            </td>
            
            <td align="center"><select name="groupIds"  size="8" multiple="multiple" class="cQueryFieldList" id="selectedGroup">
            </select>
            </td>
            </tr>
            </table>          </td>
        </tr>
        
        
     <!--
     **Unit
     --> 
             <tr>
          <td class="cInputCaption"><fmt:message key="unit.name"/>&nbsp;</td>
          <td class="cInputColumn">
          <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="unit.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="unit.name"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allUnit"
                list="unitList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                /></td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allUnit, selectedUnit);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allUnit, selectedUnit);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedUnit, allUnit);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedUnit, allUnit);"><br>
            </td>
            
            <td align="center"><select name="unitIds"  size="8" multiple="multiple" class="cQueryFieldList" id="selectedUnit">
            </select>
            </td>
            </tr>
            </table>          </td>
        </tr>  
        
        
    <!--
     **Industry
     --> 
             <tr>
          <td class="cInputCaption"><fmt:message key="industry.name"/>&nbsp;</td>
          <td class="cInputColumn">
          <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="industry.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="industry.name"/></style></th>
            </tr><tr>
            <td >
                <ww:select id="allIndustry"
                list="industryList"
                listKey="id"
                listValue="caption_"
                multiple="true"
                size="8"
                cssClass="cQueryFieldList"
                />
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll(allIndustry, selectedIndustry);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne(allIndustry, selectedIndustry);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne(selectedIndustry, allIndustry);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll(selectedIndustry, allIndustry);"><br>
            </td>
            
            <td align="center"><select name="industryIds"  size="8" multiple="multiple" class="cQueryFieldList" id="selectedIndustry">
            </select>
            </td>
            </tr>
            </table>          </td>
        </tr>
        
     
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type="submit"  class="cButton" value="<ww:text name='mail.send'/>" />        </td>
    </tr>
  </table>
</ww:form>

<script>
function onSubmit() {
mySelectAll(document.smsForm.memberIds);
mySelectAll(document.smsForm.groupIds);
mySelectAll(document.smsForm.gradeIds);
mySelectAll(document.smsForm.teamIds);
mySelectAll(document.smsForm.otherIds);
mySelectAll(document.smsForm.serviceteamIds);
mySelectAll(document.smsForm.industryIds);
mySelectAll(document.smsForm.unitIds);
    return true;
}

<%
  String msg=request.getParameter("msg");
    if (msg != null && msg.equals("1")) {
%>
  alert("<ww:text name='mail.send.success'/>");
  window.location="mail.do";
<%
}
%>

<%
    if (msg != null && msg.equals("2")) {
%>
  alert("<ww:text name='mail.send.error'/>");
  window.location="mail.do";
<%
}
%>

	function count(value){
		var x=smsForm.msg.value.length;
        var text=parseInt( (x/70)+1 ); 
		document.getElementById("info").innerdo=x+' texts:['+text+']';
	}

</script>
