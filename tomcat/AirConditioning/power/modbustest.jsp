<%@ include file="/common/taglibs.jsp"%>
<script src="/AirConditioning/scripts/jquery-1.3.2.min.js"></script>


Modbus test
<hr>
<input type="button" value="室內溫度" onClick="ModbusValue(1);"/> 
<p>
<input type="button" value="開啟狀態" onClick="ModbusValue(2);"/> 
<p>
<input type="button" value="ON" onClick="ModbusValue(3);"/> 
<p>
<input type="button" value="OFF" onClick="ModbusValue(4);"/>
<p>
<input type="button" value="Lock" onClick="ModbusValue(5);"/>
<p>
<input type="button" value="UnLock" onClick="ModbusValue(6);"/>

<script>
  function ModbusValue(id){
  	var URLs="modbusfunctest.html?id="+id;  	
  	 $.ajax({
                url: URLs,
                type: "GET",
                dataType:'text',
                success: function(msg){
                    alert(msg);
                },
                 error:function(xhr, ajaxOptions, thrownError){ 
                    alert(xhr.status); 
                    alert(thrownError); 
                 }
            });
  }
  
</script>
