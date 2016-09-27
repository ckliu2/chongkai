<%@ include file="/common/taglibs.jsp"%>

<ww:form name="smsMailRecForm" action="saveSmsMailRec" method="POST">
  <ww:hidden name="smsMailRec.id" value="${smsMailRec.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="smsMailRec.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="smsMailRec.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="smsMailRec.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.cellphone"/></td>
        <td class="cInputColumn">
            <ww:textfield name="smsMailRec.cellphone" value="%{smsMailRec.cellphone}" maxlength="10" cssClass="cInputTextFieldShort" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.email"/></td>
        <td class="cInputColumn">
            <ww:textfield name="smsMailRec.email" value="%{smsMailRec.email}" maxlength="100" cssClass="cInputTextFieldLong" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.msg"/></td>
        <td class="cInputColumn">
            <ww:textarea name="smsMailRec.msg" value="%{smsMailRec.msg}" cssClass="cInputTextArea" cols="45" rows="12" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.sendDate"/></td>
        <td class="cInputColumn">
            <ww:datepicker cssClass="cInputTextFieldShort" name="sendDate" id="sendDate" value="%{sendDate}" language="zh" format="%Y/%m/%d"/>
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.target"/></td>
        <td class="cInputColumn">
            <ww:select name="smsMailRec.targetId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="targetList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="smsMailRec.member"/></td>
        <td class="cInputColumn">
            <ww:select name="smsMailRec.memberId" 
               headerKey=""
               headerValue="%{getText('common.pleaseSelect')}..."
               list="memberList"
               listKey="id"
               listValue="caption_"
               cssClass="cInputListField"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="smsMailRec.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="smsMailRec.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
