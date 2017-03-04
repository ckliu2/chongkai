var req;
var secondBoxId;
var thirdBoxId;

function queryKeyWord2(keyword, box2Id, action, paramName)
{ 		  	
    var secondBoxId = box2Id;
    var urls=action + "?" + paramName + "=" + encodeURIComponent(keyword); 
    //var urls=action + "?" + paramName + "=" + keyword; 
    $('#'+secondBoxId).find('option').remove().end();	  
    
    $.getJSON( urls, function(data) {
    	
    $.each( data, function( key, val ) {
      //alert(val.id+"--"+val.name+"--"+val.email); 
		  var option = '<option value='+val.id+'>'+val.name+'('+val.email+')</option>';   
		  $('#'+secondBoxId).append(option);	
    });  
  });


}

function queryKeyWord1(keyword, box2Id, action, paramName)
{

    secondBoxId = box2Id;
    var u=action + "?" + paramName + "=" + encodeURIComponent(keyword);
    $.ajax({
            url: u,
            type: "GET",          
            success: function(data) {                           
             document.getElementById(secondBoxId).options.length = 0;
            //Split the document
            var returnElements = data.split(",");            
            //alert(returnElements.length); 
            
            //Process each of the elements
            for ( var i=0; i< returnElements.length; i++ ) {
                var valueLabelPair = returnElements[i].split("|");
                document.getElementById(secondBoxId).options[i] = new Option(trim(valueLabelPair[1]), trim(valueLabelPair[0]));
             }
         }
    });
          
}


function queryKeyWord(keyword, box2Id, action, paramName)
{
    secondBoxId = box2Id;
    var url=action + "?" + paramName + "=" + encodeURIComponent(keyword);
    if (window.XMLHttpRequest){
        req = new XMLHttpRequest();
        req.onreadystatechange = populateSecondBox;
        try {
            req.open("GET", url, true);
        } catch (e) {
            alert('<fmt:message key="msg.connectFailed"/>');
        }
        req.send(null);
    } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = populateSecondBox;
            try {
                req.open("GET", url, true);
            } catch (e) {

                alert('<fmt:message key="msg.connectFailed"/>');
            }
            req.send();
        }
    }
}


function retrieveSecondOptions(firstBox, box2Id, action, paramName)
{
    //alert("111");
    secondBoxId = box2Id;
    thirdBoxId = '';

    if(firstBox.selectedIndex < 0){
        return;
    }

	var d = new Date();
	
    var selectedOption = firstBox.options[firstBox.selectedIndex].value;
    var url=action + "?" + paramName + "=" + selectedOption+"&"+d.getTime();

    if (window.XMLHttpRequest){
        req = new XMLHttpRequest();
        req.onreadystatechange = populateSecondBox;
        try {
            req.open("GET", url, true);
        } catch (e) {
            alert('<fmt:message key="msg.connectFailed"/>');
        }
        req.send(null);
    } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = populateSecondBox;
            try {
                req.open("GET", url, true);
            } catch (e) {
                alert('<fmt:message key="msg.connectFailed"/>');
            }
            req.send();
        }
    }
}

  //Callback function
function populateSecondBox()
{

    if (req.readyState == 4) {
        if (req.status == 200) { // OK response
            var textToSplit = req.responseText;

            if(textToSplit == '') {
                alert("No select option available on the server");
                return;
            }
            document.getElementById(secondBoxId).options.length = 0;
            //Split the document
            var returnElements = textToSplit.split(",");

            //Process each of the elements
            for ( var i=0; i< returnElements.length; i++ ) {
                var valueLabelPair = returnElements[i].split("|");
                document.getElementById(secondBoxId).options[i] = new Option(trim(valueLabelPair[1]), trim(valueLabelPair[0]));
               
            }
            if (thirdBoxId != '') {
            	//保留第一個選項「請選擇...」
            	document.getElementById(thirdBoxId).options.length = 1;
            }
            
        } else {
           // alert("Bad response by the server");
        }
    }
}

function retrieve2and3Options(firstBox, box2Id, box3Id, action, paramName)
{
    secondBoxId = box2Id;
    thirdBoxId = box3Id;

    if(firstBox.selectedIndex < 0){
        return;
    }

	var d = new Date();
	
    var selectedOption = firstBox.options[firstBox.selectedIndex].value;
    var url=action + "?" + paramName + "=" + selectedOption+"&"+d.getTime();

    if (window.XMLHttpRequest){
        req = new XMLHttpRequest();
        req.onreadystatechange = populateSecondBox;
        try {
            req.open("GET", url, true);
        } catch (e) {
            alert('<fmt:message key="msg.connectFailed"/>');
        }
        req.send(null);
    } else if (window.ActiveXObject) { // IE
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = populateSecondBox;
            try {
                req.open("GET", url, true);
            } catch (e) {
                alert('<fmt:message key="msg.connectFailed"/>');
            }
            req.send();
        }
    }
}


//去除字串左邊的空白虛格
function ltrim(instr){
return instr.replace(/^[\s]*/gi,"");
}

//去除字串右邊的空白虛格
function rtrim(instr){
return instr.replace(/[\s]*$/gi,"");
}

//去除字串前後的空白虛格
function trim(instr){
instr = ltrim(instr);
instr = rtrim(instr);
return instr;
}

