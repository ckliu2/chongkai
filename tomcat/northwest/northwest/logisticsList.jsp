<%@ include file="/common/taglibs.jsp"%>

<table id="dg" class="easyui-datagrid" title="快遞單一覽表(至多顯示300筆)" style="width:100%;height:auto" toolbar="#toolbar" showFooter="true" 
       rownumbers="true"
       data-options="singleSelect:false,collapsible:true,url:'logisticsListJSON.html',method:'get'"       
       >
       <thead>
         <tr>      
         	<th data-options="field:'ck',checkbox:true,width:30"></th>   
         	<th data-options="field:'code'" sortable="true">條碼</th>      
          <th data-options="field:'billno'">訂單編號</th>      
          <th data-options="field:'customer'">客戶</th>   
          <th data-options="field:'saleman'">業務</th>   
          <th data-options="field:'sender'">寄件人</th> 
          <th data-options="field:'senderPhone'">寄件人電話</th>     
          <th data-options="field:'senderAddress'">寄件人地址</th>             
          <th data-options="field:'recipient'">收件人</th>  
          <th data-options="field:'recipientPhone'">收件人電話</th>   
          <th data-options="field:'recipientAddress'">收件人地址</th>   
          <th data-options="field:'serviceDate'">送達日期</th>   
          <th data-options="field:'time'">送達時段</th>   
          <th data-options="field:'member'">建檔人</th> 
        </tr>
       </thead> 
      </table> 
      
<div id="toolbar">       
	  <input name="keyword" id="keyword" class="easyui-textbox" data-options="prompt:'輸入訂單、條碼編號'" style="width:200px" />
	  
	  <input id="startDate" type="text" class="easyui-datebox" editable="true" data-options="formatter:myformatter,parser:myparser,prompt:'送達日(開始)'" />
	  <input id="endDate" type="text" class="easyui-datebox"  editable="true" data-options="formatter:myformatter,parser:myparser,prompt:'送達日(結束)'" />
	  
    <a href="#" class="easyui-linkbutton" iconcls="icon-search" plain="true" onclick="doSearch()">查詢</a>                    
		<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="edit()">新增/編輯</a>
	  <a href="#" class="easyui-linkbutton" iconcls="icon-remove" plain="true" onclick="del()">刪除</a> 		     
	  <a href="#" class="easyui-linkbutton" iconcls="icon-print" plain="true" onclick="printx()">列印</a> 	         
</div>

<div id="myevent2" class="easyui-window" data-options="resizable:false,modal:true,closed:true,shadow:false,iconCls:'icon-view',border:'thin',cls:'c6'" style="width:50%;height:auto;padding:10px;top:1px"></div>
  
  
<script>  
	
 function printx(){   	
 	var id=getSel().toString();
 	window.open('http://127.0.0.1:8888/?rpt=14&id='+id);
 }  
 
 
 function edit(){   	
 	var id=getSel().toString();
 	//alert('id='+id);
  $('#myevent2').window('open');
  $('#myevent2').window('setTitle', '快遞單'); 
  $('#myevent2').window('refresh', 'editLogistics.html?logistics.id='+id);       
 }   
 
 
 function del(){   	
 	var ids=getSel().toString();
 	if (getSel().length ===0) {
        $.messager.alert('系統訊息', '至少選擇一項，進行編輯!', 'error');
        return false;
   }
   
   $.ajax({
    url: 'deleteLogisticsJSON.html',
    type: 'GET',
    data: {
      'ids': ids
    },
    error: function(xhr) {
    	$.messager.alert('系統訊息', '刪除失敗!', 'error');
    },
    success: function(response) {
       	doSearch();   
    }
  });
  
 }  
 
 function doSearch() {
            	  var keyword=$('#keyword').textbox('getText');
            	  var startDate=$('#startDate').datebox('getValue');
            	  var endDate=$('#endDate').datebox('getValue');
            	  var myurl='logisticsListJSON.html?keyword='+keyword+'&startDate='+startDate+'&endDate='+endDate;
            	  //alert(myurl);
            	  
                $('#dg').datagrid({
                	  url:myurl
                })
            }
 
 function getSel() {
                var checkedItems = $('#dg').datagrid('getChecked');
                var names = [];
                $.each(checkedItems, function(index, item) {
                    names.push(item.id);
                    names.join(",");
                });
                return names;
            }
            
</script>        