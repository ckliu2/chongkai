<%@ include file="/common/taglibs.jsp"%>

<ww:set name="logistics" value="%{getLogisticsById()}"/> 

        <form id="ff" method="post">
            <table cellpadding="5">
            	
            	  <tr>
                    <td>條碼編號:</td>
                    <td>
                        <input class="easyui-textbox" type="text" id="code"  data-options="required:true" value="${logistics.code}" style="width:400px"></input>
                    </td>
                </tr>
                
            	  <tr>
                    <td>訂單編號:</td>
                    <td>
                        <input id="billId" class="easyui-combobox" data-options="prompt:'訂單編號'" style="width:400px"  />
                    </td>
                </tr>
                <tr>
                    <td>客戶:</td>
                    <td><span id='customer'/></td>
                </tr>
                <tr>
                    <td>業務:</td>
                    <td><span id='saleman'/></td>
                </tr>
                <tr>
                    <td>寄件人:</td>
                    <td>
                    	<input id="sender" class="easyui-combogrid" data-options="prompt:'請輸入寄件人...'" style="width:400px" value="${logistics.sender}" />
                    </td>
                </tr>
                <tr>
                    <td>寄件人電話:</td>
                    <td><input class="easyui-textbox" type="text" id="senderPhone" data-options="required:true" value="${logistics.senderPhone}" style="width:400px"></input></td>
                </tr>    
                <tr>
                    <td>寄件人地址:</td>
                    <td><input class="easyui-textbox" type="text" id="senderAddress"  data-options="required:true" value="${logistics.senderAddress}" style="width:400px"></input></td>
                </tr>          
                
                <tr>
                    <td>收件人:</td>
                    <td><input class="easyui-textbox" type="text" id="recipient"  data-options="required:true" value="${logistics.recipient}" style="width:400px"></input></td>
                </tr>
                <tr>
                    <td>收件人電話:</td>
                    <td><input class="easyui-textbox" type="text" id="recipientPhone"  data-options="required:true" value="${logistics.recipientPhone}" style="width:400px"></input></td>
                </tr>    
                <tr>
                    <td>收件人地址:</td>
                    <td><input class="easyui-textbox" type="text" id="recipientAddress"  data-options="required:true" value="${logistics.recipientAddress}" style="width:400px"></input></td>
                </tr>       
                
                <tr>
                    <td>指定送達日:</td>
                    <td>
                     <input class="easyui-datebox" name="serviceDate" id="serviceDate" value="${logistics.serviceDate}"   style="width:100px" editable="false" data-options="formatter:myformatter,parser:myparser" /> 
    	             </td>
                </tr>   
                <tr>
                    <td>指定送達時段:</td>
                    <td>
                    	 <ww:select name="logistics.timeId" id="timeId" 
                        list="logisticsTimeList"
                        listKey="id"
                        listValue="valueTw"
                        cssClass="cInputListField"
                      />
                    </td>
                </tr>  
                    
            </table>
        </form>        
        <div style="text-align:left;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-save" onclick="submitForm()">儲存</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-clear" onclick="clearForm()">清除</a>
        </div>

<script>
	
$('#customer').html('${logistics.bill.customer.name}');
$('#saleman').html('${logistics.bill.customer.saleman.name}');	

$('#sender').combogrid({      
                idField:'id',
                textField:'text',
                mode:'remote',         
                fitColumns:true,          
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:'sender',title:'寄件人'},
                    {field:'senderPhone',title:'寄件人電話'},
                    {field:'senderAddress',title:'寄件人地址',align:'right'}
                ]]  
                , 
                onChange:function(oldVal, newVal) {                  	         
                    var url="senderDBJSON.html?keyword="+oldVal;                                  
                    $('#sender').combogrid('grid').datagrid('reload',url);                              
                },
                onSelect: function(index,row){
                     //alert(row.sender);
                     $('#sender').textbox('setValue',row.sender);
                     $('#senderPhone').textbox('setValue',row.senderPhone);
                     $('#senderAddress').textbox('setValue',row.senderAddress);                   
                }               
            });


function submitForm(){
	 var code=$('#code').textbox('getValue');
	 var billId=$('#billId').combobox('getValue');
	 var sender=$('#sender').textbox('getValue');	 
	 var senderPhone=$('#senderPhone').textbox('getValue');
	 var senderAddress=$('#senderAddress').textbox('getValue');	 
	 var recipient=$('#recipient').textbox('getValue');
	 var recipientPhone=$('#recipientPhone').textbox('getValue');
	 var recipientAddress=$('#recipientAddress').textbox('getValue');
	 var serviceDate=$('#serviceDate').datebox('getValue');
	 var timeId=$('#timeId').val();
	 
	 //if()
	 var c=0,error='';
	 if(code ===''){
         error+='條碼編號為必填欄位<br>';
         c++;
   }
   
   if(billId ===''){
         error+='訂單編號為必填欄位<br>';
         c++;
   }
   
   if(sender ===''){
         error+='寄件人為必填欄位<br>';
         c++;
   }
   
   if(senderPhone ===''){
         error+='寄件人電話為必填欄位<br>';
         c++;
   }
   
   if(senderAddress ===''){
         error+='寄件人地址為必填欄位<br>';
         c++;
   }
   
   if(recipient ===''){
         error+='收件人為必填欄位<br>';
         c++;
   }
   
   if(recipientPhone ===''){
         error+='收件人電話為必填欄位<br>';
         c++;
   }
   
   if(recipientAddress ===''){
         error+='收件人地址為必填欄位<br>';
         c++;
   }
   
   if(serviceDate ===''){
         error+='指定送達日為必填欄位<br>';
         c++;
   }
   
 	  if(error !=='')
 	  {
 	  	$.messager.alert('系統訊息','以下請修正下列資訊<br>'+error,'error').window({  
         width:400      
      });  
      return false;
 	  }
	 
	  $.ajax({
             url: 'saveLogisticsJSON.html',
             type: "POST",        
             data: {
             	"logistics.id":'${logistics.id}',"logistics.code":code,"logistics.billId":billId,"logistics.sender":sender,"logistics.senderPhone":senderPhone,
             	"logistics.senderAddress":senderAddress,"logistics.recipient":recipient,"logistics.recipientPhone":recipientPhone,
             	"logistics.recipientAddress":recipientAddress,"serviceDate":serviceDate,"logistics.timeId":timeId,
             	}, 
             success: function(data) { 
             	doSearch();    
             	$('#myevent2').window('close');                      	     	
            }
    });	
}

function clearForm(){
            $('#ff').form('clear');
}



$("#billId").combobox({
	      url: 'billJSON.html?billNo=${logistics.billId}',     
      	method: 'get',   
        valueField:'id',
        textField:'text',   
        delay:1500,    
        onChange:function(oldVal, newVal) {             	
           var murl="billJSON.html?billNo="+oldVal;   
           //alert(murl);        
           $('#billId').combobox('reload', murl);                                 
        },
        onSelect:function(item) {  
        	//alert(item.customer);       
        	$('#customer').html(item.customer);     
        	$('#saleman').html(item.saleman);    
          //  $('#salemanId').val(item.salemanId);
        }           
    });



</script>

