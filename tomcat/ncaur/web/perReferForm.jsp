<%@ include file="/common/taglibs.jsp"%>

<ww:form name="perReferForm" action="savePerRefer" method="POST">
  <ww:hidden name="perRefer.id" value="${perRefer.id}"/>
  <ww:hidden name="perRefer.note" value="${perRefer.note}"/>
  	
  
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="perRefer.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    
    <tr><td class="cInputCaption">諮商來源</td>
        <td class="cInputColumn">
           <font color='blue'> ${perRefer.qatype.valueTw} </font>
        </td>
    </tr>
    
    <tr><td class="cInputCaption"><fmt:message key="perRefer.name"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.name" value="%{perRefer.name}"  cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.name')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.email"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.email" value="%{perRefer.email}"  cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.email')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.phone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.phone" value="%{perRefer.phone}"  cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.phone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.cellphone"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
            <ww:textfield name="perRefer.cellphone" value="%{perRefer.cellphone}"  cssClass="cInputTextField" /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.cellphone')"/></span>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="perRefer.memo"/></td>
        <td class="cInputColumn">
        	  <ww:textarea name="perRefer.memo" value="%{perRefer.memo}" cssClass="cInputTextArea" cols="45" rows="12" />
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="perRefer.type"/><span class="cRequired">*</span></td>
        <td class="cInputColumn">
        	
            <ww:select name="perRefer.typeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="typeList"
               listKey="id"
               listValue="valueTw"
               cssClass="cInputListField"
            /><span class="cInputValidationError"><ww:property value="showHtmlErrorMessage('perRefer.typeId')"/></span>
       
        </td>
    </tr>


    <tr><td class="cInputCaption"><fmt:message key="perRefer.teacher"/></td>
        <td class="cInputColumn">
        
            <ww:select name="perRefer.teacherId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="teacherList"
               listKey="id"
               listValue="cname"
               cssClass="cInputListField"
            />
            <br>
         
           <ww:if test="perRefer.teacher != null">
          	 
               <ww:if test="${perRefer.note == true}">
            	    <font color='blue'>已通知教師</font>
               </ww:if>
               <ww:else>
            	    <font color='red'>尚未通知教師</font>
               </ww:else>		          
           
               <br>
            
               <input type="button" onClick="javascript:sendMail()" value="Email通知教師"/>
            
           </ww:if>
          
            
        </td>
    </tr>
    
   
    
    <tr><td class="cInputCaption"><fmt:message key="common.createdDate"/></td>
        <td class="cInputColumn">
            <span class="cLabel"><ww:property value="perRefer.createdDate" /></span>
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="perRefer.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>

<script>
	function sendMail(){
	
		$.ajax({
        url: 'peferNoteJSON.do',
        type: "POST",        
        data: {"perRefer.id":${perRefer.id}},  
        dataType: "json",
        success: function(data) {
        	var returnValue=data.returnValue;          	
        	if(returnValue=='success'){
        		   alert('已Email通知教師!');        		 	   
        	}else{        		  
        		   alert('系統發送失敗,請洽管理者!');           		  
        	}          	
        }
      });
      
	}
</script>	
