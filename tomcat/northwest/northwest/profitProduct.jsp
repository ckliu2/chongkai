<%@ include file="/common/taglibs.jsp"%>



<div id="w" class="easyui-window" title="Modal Window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:600px;height:500px;padding:10px;"></div>
       
 

<form name="form1" method="post">
	


<table width="100%" border="0">
  <tr>
    <td><table width="100%" border="0">
      <tr>
        <td><table width="100%" border="0" cellspacing="1" class="cContentTable">
          <tr>
            <td class="cContentTitle" colspan="3" ><fmt:message key="product.analysis"/></td>
          </tr>
          <tr class="cActionButtonLine">
            <td colspan="3"><input type="submit" name="button"  value="<fmt:message key="product.analysis.query"/>" class="cButton" onClick="onSubmit();"/>
              &nbsp; </td>
          </tr>
          <tr>
            <td width="134" class="cInputCaption"><fmt:message key="product.analysis.timeduring"/></td>
            <td width="524" colspan="2" class="cInputColumn">
            	<%--
            	<input class="easyui-datebox" name="startDate" id="startDate" value="${startDate}" data-options="formatter:myformatter,parser:myparser" required="required"/>
            	--%>
            	
              <ww:datepicker cssClass="cInputTextFieldShort" name="startDate" id="startDate" value="%{startDate}" language="zh" format="%Y%m%d" />
              
              ~
              <ww:datepicker cssClass="cInputTextFieldShort" name="endDate" id="endDate" value="%{endDate}" language="zh" format="%Y%m%d" />            
            </td>
          </tr>
          <tr>
            <td nowrap class="cInputCaption">產品(s)</td>
            <td width="50%" class="cInputColumn"><table>
              <tr>
                <th colspan="3" align="center"><div align="left" class="cLabel"><fmt:message key="product.keyword"/>:
                   <input type="text" name="productKeyWord" value="${productKeyWord}" 
                    onPropertyChange="queryKeyWord2(this.value, 'allProduct', 'findProductByJSON.html', 'q');" 
                    oninput="queryKeyWord2(this.value, 'allProduct', 'findProductByJSON.html', 'q');"
                   />
                </div></th>
              </tr>
              <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="product.id"/>
                  </style></th>
                <th>&nbsp</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="product.id"/>
                  </style></th>
              </tr>
              <tr>
                <td>                
                   <select name="allProduct" id="allProduct" multiple="true" size="8" Class="cQueryFieldList"/>
                </td>
                <td><input type="button" value=">>" class="cSelectButton" onClick="moveAll(allProduct, selectedProduct);">
                    <br>
                    <input type="button" value=">"  class="cSelectButton" onClick="moveOne(allProduct, selectedProduct);">
                    <br>
                    <input type="button" value="<"  class="cSelectButton" onClick="moveOne(selectedProduct, allProduct);">
                    <br>
                    <input type="button" value="<<" class="cSelectButton" onClick="moveAll(selectedProduct, allProduct);">
                    <br>
                </td>
                <td align="center">           
                   <ww:select name="selectedProductIds" id="selectedProduct"
                   list="productList"
                   listKey="id"
                   listValue="id+'-'+productName"
                   multiple="true"
                   size="8"
                   cssClass="cQueryFieldList"
                />              
                </td>
              </tr>
            </table>
            
            </td>
            
            <td width="50%" class="cInputColumn">
            	
            	
            </td>
          </tr>
          
    <td>
    </td>
   </tr>
  </table>
  </td>
 </tr>
</table>    

<display:table name="profitProductList" class="list" cellspacing="1" id="row" requestURI="profitProduct.html" >
    

    <display:column property="beginDate"  sortable="true" titleKey="profit.beginDate" style="width:15%"  format="{0,date,yyyy/MM/dd}"/>
    <display:column property="endDate"  sortable="true" titleKey="profit.endDate" style="width:15%" format="{0,date,yyyy/MM/dd}"/>
    
    <display:column sortable="true" titleKey="product.name2" style="width:15%" >
      <font color='blue'>${row.product.id} </font> <br> ${row.product.productName}
    </display:column>   
    <display:column property="unit1"  sortable="true" title="單位(才)" style="width:15%" decorator="com.base.web.displaytag.ThousandsDecorator2"/>
    <display:column property="unit2"  sortable="true" title="單位(平方米)" style="width:15%" decorator="com.base.web.displaytag.ThousandsDecorator2"/>
    <display:column property="unit3"  sortable="true" title="單位(平方英吋)" style="width:15%" decorator="com.base.web.displaytag.ThousandsDecorator2"/>
    <display:column property="salesPrice"  sortable="true" title="售價總額" style="width:15%" decorator="com.base.web.displaytag.ThousandsDecorator1"/>
    <display:column property="purchasePrice"  sortable="true" title="採購總額" style="width:15%" decorator="com.base.web.displaytag.ThousandsDecorator1"/>
    <display:column property="salesCost"  sortable="true" title="標準成本總額" style="width:15%" decorator="com.base.web.displaytag.ThousandsDecorator1"/>
    <display:column property="profit"  sortable="true" title="利潤總額" style="width:15%" decorator="com.base.web.displaytag.ThousandsDecorator1"/>
    <display:column property="profitRate"  sortable="true" title="利潤率" style="width:15%" />
    	
    <display:column sortable="true" title="明細" style="width:15%" >
      <img src="${ctx}/images/GridView.gif" onclick="detail('${row.product.id}')">
    </display:column> 	
    	
    	
   </display:table>

</form>






<script>
 function onSubmit(){
   mySelectAll(document.form1.selectedProduct);	
   mySelectAll(document.form1.selectedCustomer);
 }
 
 function detail(productId){ 
  $('#w').window('open');      	
  $('#w').window('setTitle', productId+'明細');
  $('#w').window('refresh', 'profitProductDetail.html?startDate=${startDate}&endDate=${endDate}&product.id='+productId );
     
 }
 
</script>

