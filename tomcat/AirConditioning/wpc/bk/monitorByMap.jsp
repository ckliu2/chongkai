<%@ include file="/common/unsecureTaglibs.jsp"%>

<script language="javascript">
	var http_request = false;
	var url="http://140.129.140.55:8080/wpc/upload/xml/status1.xml";
	function send_request() {//��ʼ����ָ������������������ĺ���
		http_request = false;
		//��ʼ��ʼ��XMLHttpRequest����
		if(window.XMLHttpRequest) { //Mozilla �����
			http_request = new XMLHttpRequest();
			if (http_request.overrideMimeType) {//����MiME���
				http_request.overrideMimeType('text/xml');
			}
		}
		else if (window.ActiveXObject) { // IE�����
			try {
				http_request = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					http_request = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {}
			}
		}
		if (!http_request) { // �쳣����������ʵ��ʧ��
			window.alert("XMLHttpRequest error..");
			return false;
		}
		http_request.onreadystatechange = processRequest;
		// ȷ����������ķ�ʽ��URL�Լ��Ƿ�ͬ��ִ���¶δ���
		http_request.open("GET", url, true);
		http_request.send(null);
	}
	// ��������Ϣ�ĺ���
    function processRequest() {
        if (http_request.readyState == 4) { // �ж϶���״̬
            if (http_request.status == 200) { // ��Ϣ�Ѿ��ɹ����أ���ʼ������Ϣ
				var returnObj = http_request.responseXML;
				var xmlobj = http_request.responseXML;
				var employees = xmlobj.getElementsByTagName("status");
				var feedbackStr = "";
				for(var i=0;i<employees.length;i++) {
					var employee = employees[i];
					feedbackStr += "sensor id= " + employee.getElementsByTagName("sensor")[0].firstChild.data;
					feedbackStr +=  "\r\n";
					  document.getElementById('xTable').rows[0].cells[0].style.backgroundColor="#FF0000";
				}
				alert(feedbackStr);
            } else { //ҳ�治����
                alert("processRequest error..");
            }
        }
    }
</script>

<html>
	<body>
    <p>
      <!--
    <input type="button" name="read" value="��ȡXML" onClick="send_request('http://140.129.140.55:8080/wpc/upload/xml/status1.xml')">
    -->
    </p>
    <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="20%">&nbsp;</td>
        <td width="80%"><input type="button" name="read" value="XML" onClick="send_request()"></td>
      </tr>
      <tr>
        <td align="left" valign="top">
        
        <table width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#0000FF" id="xTable">
          <tr>
            <td>id</td>
            <td>sensor</td>
          </tr>
          <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
          </tr>
        </table>
        
        
        
        </td>
        <td><img src="images/tnitMap.jpg" width="762" height="500"></td>
      </tr>
    </table>
    
    
    
    <p>&nbsp; </p>
	</body>
</html>

