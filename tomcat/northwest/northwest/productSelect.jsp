<%@ include file="/common/taglibs.jsp"%>

<form name="form1"  method="POST" action="productSelectPrint.html"  target="_blank">

  <table border="0" cellspacing="1" class="cContentTable">
    <tr class="cActionButtonLine">
      <td colspan="2">
      <textarea name=input  onPropertyChange="queryKeyWord(this.value, 'allProduct', 'findProduct.html', 'key');"  cols=20  rows=1></textarea> 
      &nbsp;&nbsp;&nbsp;
      
      <fmt:message key="billDetail.quantity"/>:<input type="text" name="quantity" class="cInputTextFieldShort2" />
      &nbsp;&nbsp;&nbsp;
      <fmt:message key="common.remark"/>:<input type="text" name="remark" class="cInputTextFieldLong" />
      
      
      &nbsp;&nbsp;&nbsp;
      <input type="button" value="<fmt:message key="common.print"/>" class="cButton" onClick="javascript:wprint();">
      &nbsp;&nbsp;&nbsp;
      <input type="button" value="<fmt:message key="common.clear"/>" class="cButton" onClick="javascript:wclear();">
      </td>
    </tr>
    
   

    
    
     <tr>

        <td class="cInputColumn">
            <table>
            <tr>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.available"/><fmt:message key="product.name"/></style></th>
                <th>&nbsp;</th>
                <th align="center"><span style="font-size:10pt"><fmt:message key="common.selected"/><fmt:message key="product.name"/></style></th>
            </tr><tr>
            <td>
               
                <ww:select id="allProduct" 
                list="productList"
                listKey="id"
                listValue="productName"
                multiple="true"
                size="50"
                cssClass="cQueryFieldList3"
                /> 
                       
                </td><td>
                <input type="button" value=">>" class="cSelectButton" onclick="moveAll1(allProduct, selectedProduct);"><br>
                <input type="button" value=">"  class="cSelectButton" onclick="moveOne1(allProduct, selectedProduct);"><br>
                <input type="button" value="<"  class="cSelectButton" onclick="sclear(selectedProduct);"><br>
                <input type="button" value="<<"  class="cSelectButton" onclick="sclearAll(selectedProduct);"><br>
            
                <!--
                <input type="button" value="<"  class="cSelectButton" onclick="moveOne1(selectedProduct, allProduct);"><br>
                <input type="button" value="<<" class="cSelectButton" onclick="moveAll1(selectedProduct, allProduct);"><br>
                -->
            </td>
            
            <td align="center">
            
                <ww:select name="productIds" id="selectedProduct"
                list="object_ProductList"
                listKey="id"
                listValue="productName"
                multiple="true"
                size="50"
                cssClass="cQueryFieldList3"
                />   
              
            </td>
            </tr>
            
            
            </table>
        </td>

    </tr>
    
    
     
   
   
   

    <tr class="cActionButtonLine">
      <td colspan="2">
      
      </td>
    </tr>
  </table>  
</form>


<script>
 function wprint(){
 	mySelectAll(document.form1.productIds);
 	form1.submit();
}

function wclear(){
	document.all.productIds.options.length = 0;
}

function sclear(xto){	
	xto.options.remove(xto.selectedIndex);	
}

function sclearAll(xto){	
  xto.options.length=0;
}

function moveOne1(xfrom, xto)
{
	var addText='';
	var quantity=document.all.quantity.value;
	var remark=document.all.remark.value;
	if(remark==''){
		remark='.';
	}
	
	if(quantity!=''){
		addText+=' * '+quantity;
	}else{
		alert("<fmt:message key='billDetail.quantity'/><fmt:message key='common.required'/>");
	  return false;
	}
	if(remark!=''){
		addText+=' ( '+remark +' ) ' ;
	}
		
	if (xfrom == null || xto == null) return;

	if (xfrom.selectedIndex < 0) return;
	var opt;
	var newOpt;
	var idx = 0;
	var next = true;

	while (next) {
		opt = xfrom.options[idx];
		if (opt.selected)
		{
			newOpt = document.createElement("OPTION");
			
		  newOpt.text = opt.text + addText;
		  //newOpt.text = opt.value + '#'+quantity+'#'+remark;
		  newOpt.value = opt.value + '#'+quantity+'#'+remark;
		  
			xto.add(newOpt);
			xfrom.options.remove(idx);
		}
		else
		{
			idx++;
		}

		if ((xfrom.options.length-1) < idx)
			next = false;
		else
			next = true;
	}
}


function moveAll1(xfrom, xto)
{
	var addText='';
	var quantity=document.all.quantity.value;
	var remark=document.all.remark.value;
  if(remark==''){
		remark='.';
	}
	if(quantity!=''){
		addText+=' * '+quantity;
	}
	if(remark!=''){
		addText+=' ( '+remark +' ) ' ;
	}
	
	if (xfrom == null || xto == null) return;

	var newOpt;
	var opt;
	var txt;
	var val;
	var idx = 0;
	var next = (xfrom.options.length > 0);

	while (next) {
		opt = xfrom.options[idx];
		newOpt = document.createElement("OPTION");
		
		newOpt.text = opt.text + addText;
		//newOpt.text = opt.value + '#'+quantity+'#'+remark;
		newOpt.value = opt.value + '#'+quantity+'#'+remark;
		xto.add(newOpt);
		xfrom.options.remove(idx);
		idx = 0;
		next = (xfrom.options.length > 0);
	}
}
</script>



