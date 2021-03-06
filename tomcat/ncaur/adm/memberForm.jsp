<%@ include file="/common/taglibs.jsp"%>


<ww:form name="memberForm" action="${actionUrl}" method="POST" enctype="multipart/form-data" onsubmit="onSubmit()">
  <ww:hidden name="member.id" value="${member.id}"/>
  <table border="0" cellspacing="1" >
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="member.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
 
    <tr><td class="cInputCaption"><fmt:message key="member.photo"/></td>
        <td class="cInputColumn">
        <ww:if test="member.photo != null">
            <input type="checkbox" name="removePhoto" onclick="if (this.checked == true) document.memberForm.filePhoto.style.display='inline'; else document.memberForm.filePhoto.style.display='none';" value="<ww:property value="member.photo.fileName"/>"><fmt:message key="common.delete"/>
            <a href="${ctx}/<fmt:message key="member.uploadPhoto.relativeUrl"/>/<ww:property value="member.id"/>/<ww:property value="member.photo.fileName"/>"><ww:property value="member.photo.fileName" /> (<ww:property value="member.photo.size" /> bytes)</a><br>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px;display:none" name="filePhoto" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" />
            <ww:hidden name="member.photoId" value="${member.photo.id}"/>
            <ww:hidden name="member.photoFileName" value="${member.photo.fileName}"/>
        </ww:if>
        <ww:else>
            <ww:file cssClass="cInputTextFieldLong" cssStyle="height:20px" name="filePhoto" accept="application/pdf,application/msword,application/vnd.ms-excel,application/vnd.ms-powerpoint,image/gif,image/jpeg,image/bmp,image/png,image/tiff" /><br>
        </ww:else>

        </td>
    </tr>   
    
    
    
    <tr><td class="cInputCaption"><fmt:message key="member.cname"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="member.cname" value="%{member.cname}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.cname')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.ename"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.ename" value="%{member.ename}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.rgno"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.rgno" value="%{member.rgno}" maxlength="0" cssClass="cInputTextField" />
        </td>
    </tr>

   

    <tr><td class="cInputCaption"><fmt:message key="member.sex"/></td>
        <td class="cInputColumn">       
            <ww:radio name="member.sex" 
               list="sexList"
               listKey="id"
               listValue="value"
            />
            <span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.sex')"/></span>
       </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.birthday"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="birthday" id="birthday" value="%{birthday}" language="zh" format="%Y/%m/%d"/><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('birthday')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.idNo"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.idNo" value="%{member.idNo}" maxlength="50" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.idNo')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.homePhone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.homePhone" value="%{member.homePhone}" maxlength="50" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.homePhone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.homeZip"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.homeZip" value="%{member.homeZip}" maxlength="10" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.homeZip')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.homeAddress"/></td>
        <td class="cInputColumn">
            <ww:textarea name="member.homeAddress" value="%{member.homeAddress}" cssClass="cInputTextArea" cols="45" rows="4" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.homeAddress')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.company"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.company" value="%{member.company}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.companyPhone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.companyPhone" value="%{member.companyPhone}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.companyFax"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.companyFax" value="%{member.companyFax}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.title"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.title" value="%{member.title}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.companyWeb"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.companyWeb" value="%{member.companyWeb}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.cellphone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="member.cellphone" value="%{member.cellphone}" maxlength="30" cssClass="cInputTextFieldShort" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.cellphone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.email"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="member.email" value="%{member.email}" maxlength="50" cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('member.email')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.line"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.line" value="%{member.line}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.facebook"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.facebook" value="%{member.facebook}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.companyZip"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.companyZip" value="%{member.companyZip}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.companyAddress"/></td>
        <td class="cInputColumn">
            <ww:textarea name="member.companyAddress" value="%{member.companyAddress}" cssClass="cInputTextArea" cols="45" rows="4" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.businessItem"/></td>
        <td class="cInputColumn">
            <ww:textarea name="member.businessItem" value="%{member.businessItem}" cssClass="cInputTextArea" cols="45" rows="8" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.receipt"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.receipt" value="%{member.receipt}" maxlength="50" cssClass="cInputTextField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.companyId"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.companyId" value="%{member.companyId}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.aliases"/></td>
        <td class="cInputColumn">
            <ww:textfield name="member.aliases" value="%{member.aliases}" maxlength="30" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.applyDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="applyDate" id="applyDate" value="%{applyDate}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>
    

    <tr><td class="cInputCaption"><fmt:message key="member.contacts"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="contactsIds"
                list="contactsList"
                listKey="id"  
                listValue="valueTw"      
                />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.experiences"/></td>
        <td class="cInputColumn">        
           <div id="experiences_table"/>  
           <input type="hidden" name="experiencesCount" id="experiencesCount"/> 
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="member.schools"/></td>
        <td class="cInputColumn">
        
        <div id="school_table"/>  
        <input type="hidden" name="schoolCount" id="schoolCount"/> 
            
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="common.lastModifiedDate"/></td>
        <td class="cInputColumn">  
        <span class="cLabel">         
            <fmt:formatDate value="${member.lastModifiedDate}" pattern="yyyy-MM-dd HH:mm"/>
        </span>    
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
        <span class="cLabel">
         <fmt:formatDate value="${member.createdDate}" pattern="yyyy-MM-dd HH:mm"/>
        </span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="member.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
  
  <ww:select name="groupIds" multiple="true" 
  list="object_groupList"
  listKey="id"
  listValue="caption_"
  /> 
                
</ww:form>


<script>

function initschool()
{	
	number=${fn:length(member.schools)} 
	$("#schoolCount").attr({"value":number});		
	var html = "";
	    html+='<table width="420px" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"><tr>';			
	    html+='<td align="left" width="20px"><img src="images/add.png" width="20px" onClick="add_new_school()"/></td>';
			html+='<td align="left" width="200px">學歷</td>';
			html+='<td align="left" width="200px">系所</td>';
			html+='</tr></table>';	
				
	<c:set var="count" value="0" />
	<c:forEach var="p" items="${member.schools}">  	
	    html+='<div id="school_number_${count}">  ';	 	
	    html+='<table width="420px" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"><tr>';			
	    html+='<td width="20px" align="center"><img src="images/off.jpg" height="20" onClick="delschool(${count})"/></td>';
			html+='<td align="left" width="200px"><input name="school" value="${p.school}" style="width:100%"/></td>';
			html+='<td align="left" width="200px"><input name="department" value="${p.department}" style="width:100%"/></td>';
			html+='</tr></table></div>';			
			<c:set var="count" value="${count+1}" />
	</c:forEach>
	$("#school_table").append(html);
}

function add_new_school()
{
			schoolCount=parseInt($("#schoolCount").html())+1;		
			school_num=parseInt(document.all.schoolCount.value)+1;	
			//alert(school_num);	
			var html = "";				
			html+='<div id="school_number_'+school_num+'">';
	    html+='<table width="420px" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"><tr>';			
	    html+='<td width="20px" align="center"><img src="images/off.jpg" height="20" onClick="delschool('+school_num+')"/></td>';
			html+='<td align="left" width="200px"><input name="school" style="width:100%"/></td>';
			html+='<td align="left" width="200px"><input name="department" style="width:100%"/></td>';
			html+='</tr></table></div>';				
			$("#school_table").append(html);
			$("#schoolCount").attr({"value":school_num});	
}

function delschool(row)
{
		lastID='#school_number_'+row;		
		$(lastID).remove();		
	  var a = $("#schoolCount").attr("value")-1;
	  $("#schoolCount").attr({"value":a});		 
}



function initexperiences()
{	
	number=${fn:length(member.experiences)} 
	$("#experiencesCount").attr({"value":number});		
	var html = "";
	    html+='<table width="420px" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"><tr>';			
	    html+='<td align="left" width="20px"><img src="images/add.png" width="20px" onClick="add_new_experiences()"/></td>';
			html+='<td align="left" width="400px">經歷描述</td>';
			html+='</tr></table>';	
				
	<c:set var="count" value="0" />
	<c:forEach var="p" items="${member.experiences}">  	
	    html+='<div id="experiences_number_${count}">  ';	 	
	    html+='<table width="420px" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"><tr>';			
	    html+='<td width="20px" align="center"><img src="images/off.jpg" height="20" onClick="delexperiences(${count})"/></td>';
			html+='<td align="center" width="400px">';
			html+='<textarea name="experiencesDescription" rows="3" cols="46%" >${p.description1}</textarea>';
			html+='</td>';
			html+='</tr></table></div>';			
			<c:set var="count" value="${count+1}" />
	</c:forEach>
	$("#experiences_table").append(html);
}

function add_new_experiences()
{
			experiencesCount=parseInt($("#experiencesCount").html())+1;		
			experiences_num=parseInt(document.all.experiencesCount.value)+1;	
			//alert(experiences_num);	
			var html = "";	
			html+='<div id="experiences_number_'+experiences_num+'">';
	    html+='<table width="420px" border="1" cellpadding="0" cellspacing="0" bordercolor="#CCCCCC"><tr>';			
	    html+='<td width="20px" align="center"><img src="images/off.jpg" height="20" onClick="delexperiences('+experiences_num+')"/></td>';
			html+='<td align="center" width="400px">';
			html+='<textarea name="experiencesDescription" rows="3" cols="46%"></textarea>';
			html+='</td>';
			html+='</tr></table></div>';	
			
			$("#experiences_table").append(html);
			$("#experiencesCount").attr({"value":experiences_num});	
}

function delexperiences(row)
{
		lastID='#experiences_number_'+row;		
		$(lastID).remove();		
	  var a = $("#experiencesCount").attr("value")-1;
	  $("#experiencesCount").attr({"value":a});		 
}

function onSubmit() {
	  mySelectAll(document.memberForm.groupIds);
    mySelectAll(document.memberForm.contactsIds);
    mySelectAll(document.memberForm.experiencesIds);
    mySelectAll(document.memberForm.schoolsIds);
    return true;
}

document.memberForm.groupIds.style.display = "none";
initexperiences();
initschool();

<%
String msg=request.getParameter("msg");
  if(msg!=null && !msg.equals("")){      
%>
	     alert("已更新完畢!");
<%
	  }
%>
	     

</script>


