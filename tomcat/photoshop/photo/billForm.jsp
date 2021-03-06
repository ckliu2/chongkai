<%@ include file="/common/taglibs.jsp"%>

<ww:form name="billForm" action="saveBill1" method="POST">
<ww:hidden name="bill.id" value="${bill.id}"/>
<ww:hidden name="bill.customerId" value="${bill.customerId}"/>
  
  
  
  
  <table border="0" cellspacing="1" class="cContentTable">
    <tr><td class="cContentTitle" colspan="2" ><fmt:message key="bill.form"/></td></tr>
    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="bill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="bill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
    <tr><td class="cInputCaption">訂單編號</td>
        <td class="cInputColumn">
            ${bill.no}
        </td>
    </tr>

    <tr><td class="cInputCaption">訂單時間</td>
        <td class="cInputColumn">      
            <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${bill.createdDate}" />
        </td>
    </tr>

    <tr><td class="cInputCaption">客戶</td>
        <td class="cInputColumn">
            ${bill.customer.name}
        </td>
    </tr>

    <tr><td class="cInputCaption">手機</td>
        <td class="cInputColumn">
            ${bill.customer.cellphone}
        </td>
    </tr>
    
    <tr><td class="cInputCaption">產品</td>
        <td class="cInputColumn">
            ${bill.product.name}
        </td>
    </tr>
    
    <tr><td class="cInputCaption">產品已製作完成</td>
        <td class="cInputColumn">
            <ww:checkbox name="bill.complete" cssClass="cCheckboxField" />
        </td>
    </tr>

    <tr><td class="cInputCaption"><fmt:message key="bill.noteTime"/></td>
        <td class="cInputColumn">
        
            <span class="cLabel">  
             
            </span>
            
            <span class="cLabel">           
             <fmt:formatDate pattern="yyyy-MM-dd hh:mm" value="${bill.noteTime}" />
            </span>
            
          </td>
    </tr>
    

    <tr><td class="cInputCaption">沖洗照片</td>
        <td class="cInputColumn">
        <ww:set name="pictureList" value="%{getPictureListByBillId(${bill.id})}"/>
        
        
        <a href="billZip.html?bill.id=${bill.id}" target="_blank">下載ZIP</a>
        
        <display:table name="pictureList" class="list" cellspacing="1" requestURI="" id="row" export="false" pagesize="${GLOBAL_pagesize}" sort="list">
          <display:column property="sn" sortable="true" title="照片編號" style="text-align:left"/>
          <display:column title="沖洗尺寸">
            ${row.size.width}X${row.size.height}
          </display:column>          
          <display:column property="copies" sortable="true" title="沖洗數量" style="text-align:left"/>
          <display:column property="sty.name" sortable="true" title="沖洗樣式" style="text-align:left"/>
          <display:column title="沖洗檔名">
            <font color="blue">${row.rename}</font>
          </display:column>
          
         <c:set var="count" value="${count+1}" />
        </display:table>
        
          
        </td>
    </tr>

    

    <tr class="cActionButtonLine">
      <td colspan="2">
        <input type=button onclick="javascript:history.back()" class="cButton" value="<fmt:message key="common.back"/>" >
        <ww:if test="recordEditable == true">
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton">&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton">&nbsp;
            <ww:if test="bill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>" class="cButton">
            </ww:if>
        </ww:if>
        <ww:else>
            <input type="submit" value="<fmt:message key="common.save"/>" class="cButton" DISABLED>&nbsp;
            <input type="reset" value="<fmt:message key="common.reset"/>" class="cButton" DISABLED>&nbsp;
            <ww:if test="bill.id != null">
              <input type="submit" name="delete" onClick="javascript:return confirm('<fmt:message key="common.confirmDelete"/>')" value="<fmt:message key="common.delete"/>"  class="cButton" DISABLED>
            </ww:if>
        </ww:else>
      </td>
    </tr>
  </table>
  
</ww:form>

