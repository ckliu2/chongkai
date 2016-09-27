<%@ include file="/common/taglibs.jsp"%>

<ww:form name="productClassForm" action="saveProductClass" method="POST">
  <ww:hidden name="productClass.id" value="${productClass.id}"/>
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="productClass.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;

        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;

        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption"><fmt:message key="productClass.className"/></td>
        <td class="cInputColumn">
                ${productClass.className}
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="productClass.expectionFlows"/></td>
        <td class="cInputColumn">
            <ww:checkboxlist name="expectionFlowsIds" 
               list="expectionFlowsList"
               listKey="id"
               listValue="caption_"
               value = "%{expectionFlowsIds}"
            />
        </td>
    </tr>

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;

        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;

        </ww:else>
      </td>
    </tr>
  </table>
</ww:form>
