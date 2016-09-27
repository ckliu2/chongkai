<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="bulletin.list"/></td>
      </tr>
      
     <tr>
        <td>
        <form name="qform"  method="post" action="bulletinList.do">      
        
          <span class="cLabel2"><strong><fmt:message key="bulletin.bulletinType"/></strong></span>:			        
             <ww:select name="bulletinTypeId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="bulletinTypeList"
               listKey="id"
               listValue="valueTw"
               cssClass="cInputListField"
            />            	
            &nbsp;&nbsp;   
            
			    <span class="cLabel2"><strong><fmt:message key="common.during"/></strong></span>:			        
            	<span class="cLabel2"><fmt:message key="common.begindate"/>:</span>
            	<ww:datepicker cssClass="cInputTextFieldShort" name="begindate" id="begindate" value="%{begindate}" language="zh" format="%Y/%m/%d"/>    
                &nbsp;&nbsp;
               <span class="cLabel2"><fmt:message key="common.enddate"/>:</span>                
            	 <ww:datepicker cssClass="cInputTextFieldShort" name="enddate" id="enddate" value="%{enddate}" language="zh" format="%Y/%m/%d"/>
			         &nbsp;&nbsp;
			         <span class="cLabel2"><strong><fmt:message key="bulletin.subject"/></strong>:</span> 
               <ww:textfield name="subject" value="%{subject}" maxlength="50" cssClass="cInputTextFieldShort" />
               <input type="submit" value="<fmt:message key="common.search"/>" class="cButton">
        </form> 
        </td>
      </tr>       
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBulletin.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bulletinList.size()"/>, 'selectedBulletinId', 'copyBulletin.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBulletin.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
      <tr>
        <td>
<c:set var="count" value="0" />
<display:table name="bulletinList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
    <display:setProperty name="paging.banner.placement" value="bottom" />
    <display:column titleKey="common.select">
        <input type="checkbox" id="selectedBulletinId_<c:out value="${count}"/>" name="selectedBulletinId" value="<c:out value="${row.id}"/>">
    </display:column>
    <display:column property="bulletinType.valueTw" sortable="true" titleKey="bulletin.bulletinType" style="text-align:left"/>
    <display:column property="bulletinDate" sortable="true" titleKey="bulletin.bulletinDate" format="{0,date,yyyy/MM/dd}" style="text-align:left" />
    <display:column property="subject" sortable="true" titleKey="bulletin.subject" style="text-align:left" />
    <display:column property="status" sortable="true" titleKey="bulletin.status" style="text-align:left" />
    <display:column property="createdUser.cname" sortable="true" titleKey="common.createdUser" style="text-align:left"/>
    <display:column property="createdDate" sortable="true" titleKey="common.createdDate" format="{0,date,yyyy/MM/dd hh:mm}" style="text-align:left"/>
    <display:column titleKey="common.action">
        <ww:if test="recordEditable == true">
            <a href="editBulletin.do?bulletin.id=<c:out value="${row.id}"/>"><fmt:message key="common.edit"/></a>&nbsp;&nbsp;
            <a href="#" onClick="javascript:return myConfirm('<fmt:message key="common.confirmDelete1"/><c:out value="${row.subject}" /><fmt:message key="common.confirmDelete2"/>', 'form1', 'bulletin.id', '${row.id}')"><fmt:message key="common.delete"/></a>
        </ww:if>
        <ww:else>
           <a href="editBulletin.do?bulletin.id=<c:out value="${row.id}"/>"><fmt:message key="common.view"/></a>&nbsp;&nbsp;
        </ww:else>
    </display:column>
    <c:set var="count" value="${count+1}" />
</display:table>

        </td>
    </tr>
      <tr class="cActionButtonLine">
        <td>
        <ww:if test="recordEditable == true">
            <button onclick="location.href='editBulletin.do'" class="cButton"><fmt:message key="common.new"/></button>
            <ww:if test="functionOpenPeriodMessage != null">
                <span class="cLabel2">(<fmt:message key="common.function.openPeriod"/>: <ww:property value="functionOpenPeriodMessage"/>)</span>
            </ww:if>
            &nbsp;&nbsp;&nbsp;&nbsp;<button onclick="myCheckSubmitCopy('form1', <ww:property value="bulletinList.size()"/>, 'selectedBulletinId', 'copyBulletin.do', '<fmt:message key="common.mustSelectOne"/>', '<fmt:message key="common.mustSelectOnlyOne"/>')" class="cButton"><fmt:message key="common.copy"/></button>
        </ww:if>
        <ww:else>
            <button onclick="location.href='editBulletin.do'" DISABLED class="cButton"><fmt:message key="common.new"/></button><span class="cLabel2">(<fmt:message key="common.function.openPeriodExceed"/> )</span>
        </ww:else>
        </td>
      </tr>
</table>
<form name="form1" action="saveBulletin.do">
    <input type="hidden" name="delete" value="yes">
    <input type="hidden" name="bulletin.id" value="">
    <select name="selectedBulletinIds" multiple="true" style="display:none"></select>
</form>
