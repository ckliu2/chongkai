<%@ include file="/common/taglibs.jsp"%>

<table border="0" cellspacing="1" >
      <tr>
        <td class="cContentTitle" ><fmt:message key="smsMailRec.list"/></td>
      </tr>

      <tr>
        <td>
<c:set var="count" value="1" />
<display:table name="smsMailRecList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="30" sort="list">

    <display:column titleKey="common.id">
       <c:out value="${count}"/>
    </display:column>
    <display:column property="member" sortable="true" titleKey="mail.sender" style="text-align:left"/>
    <display:column property="target.caption_" sortable="true" titleKey="smsMailRec.target" style="text-align:left"/>
    <display:column property="email" sortable="true" titleKey="member.email" style="text-align:left"/>
    <display:column property="email1" sortable="true" titleKey="member.email1" style="text-align:left"/>
    
    <display:column property="msg" sortable="true" titleKey="smsMailRec.msg" style="text-align:left"/>
    <display:column property="sendDate" sortable="true" titleKey="smsMailRec.sendDate" format="{0,date,yyyy/MM/dd  HH:MM:SS}" style="text-align:left" />

    <c:set var="count" value="${count+1}" />
</display:table>
        </td>
    </tr>

</table>

