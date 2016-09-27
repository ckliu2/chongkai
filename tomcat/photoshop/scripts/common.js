function highlightTableRows(tableId) 
{
    var previousClass = null;
    var table = document.getElementById(tableId);
    var tbody = table.getElementsByTagName("tbody")[0];
    var rows = tbody.getElementsByTagName("tr");
    // add event handlers so rows light up and are clickable
    for (var i=0; i < rows.length; i=i+1) {
        rows[i].onmouseover = function() { previousClass=this.className;this.className = this.className + ' over'; };
        rows[i].onmouseout = function() { this.className=previousClass; };
        /*
        rows[i].onclick = function() {
            var cell = this.getElementsByTagName("td")[0];
            if (cell.getElementsByTagName("a").length > 0) {
                var link = cell.getElementsByTagName("a")[0];
                if (link.onclick) {
                    call = link.getAttributeValue("onclick");
                    // this will not work for links with onclick handlers that return false
                    eval(call);
                } else {
                  location.href = link.getAttribute("href");
                }
                this.style.cursor="wait";
            }
        }
        */
    }
}

function myConfirm(msg, frm, name, val)
{
	var y = confirm(msg);
	if (y == true) {
		var f = eval("document." + frm);
		var o = f[name];
		o.value = val;
		f.submit();
		return true;
	}
	return false;
}

function mySelectAll(selectObj)
{
    if (selectObj == null) {
    	return;
    }

    var opt; 
    for (var i=0; i < selectObj.options.length; i=i+1) {
        opt = selectObj.options[i];
        opt.selected = true;
    }
}

function myCheckExist(selectObj, selectManyObj)
{
    if (selectObj == null || selectManyObj == null) {
    	return;
	}
	if (selectObj.selectedIndex < 0) {return;}
	
	var obj = selectObj.options[selectObj.selectedIndex];
    var opt;
    for (var i=0; i < selectManyObj.options.length; i=i+1) {
        opt = selectManyObj.options[i];
        if (opt.value == obj.value) {
        	return true;
        }
    }
    
    return false;
}

function myInsertFromNewWindow(action, ids, otherQueryString)
{
    try {
		var qs = '';
		if (otherQueryString !== null) {
			qs = '&' + otherQueryString;
		}
		var ul = action + '?widgetId=' + ids + qs + '&' + (new Date()).getTime();
        window.open(ul, ids.replace(/\./gi, '_'), "titlebar=no,width=800,height=600,toolbar=no,resizable=yes,left=180,top=100");
    } catch(e) {
        alert('Error!!! Please contact system administrator.');
    }
    return;
}

function myDeleteFromSelectMany(obj)
{
	if (obj == null) {
		return;
	}
	
	if (obj.selectedIndex < 0)
		return;
			
	obj.options.remove(obj.selectedIndex);	
}
	
function myGetOpener()
{
	return window.parent.opener;
}

function myAddToSelectWidget(selObj, val, txt, doc)
{
	
	if (doc == null)
		doc = window.document;
	var idx = 0;
	while (idx < selObj.options.length) {
		var opt = selObj.options[idx];
		if (opt.value == val) {
			alert('Duplicate Item!');
			return;
		}
		idx=idx+1;
	}
	var newOpt = doc.createElement("OPTION");
	newOpt.text = txt;
	newOpt.value = val;
	selObj.add(newOpt);

	switch (selObj.type) {
		case "select-one":
			selObj.selectedIndex = selObj.options.length - 1;
			break;
		case "select-multiple":
  			break;
	}
}

function myReturnFunction(id, name)
{
    var obj = myGetOpener().document.getElementById(parent.getWidgetId());
    if (obj != null){
    	myAddToSelectWidget(obj, id, name, myGetOpener().document);
    }
    window.close();
}

function myCheckSubmitCopy(frmName, cnt, objId, action, msg1, msg2) 
{
	var c = 0;
	var frm = eval("document." + frmName);
	var selObj = eval("document." + frmName + "['" + objId + "s']");
	selObj.options.length = 0;
	//for (var i=0; i < <c:out value="${count}"/>; i++) {
	for (var i=0; i < cnt; i=i+1) {
		var o = document.getElementById(objId + '_' + i);
		if (o == null)
		    continue;
		if (o.checked == true) {
			myAddToSelectWidget(selObj, o.value, o.value);
			c=c+1;
		}
	}
	if (c == 0) {
		alert(msg1); //'<fmt:message key="common.mustSelectOne"/>');
		return;
	}
	if (c > 1) {
		alert(msg2); //'<fmt:message key="common.mustSelectOnlyOne"/>');
		return;
	}
	frm.action = action; //"editCustomLanyard.html";
	
	mySelectAll(selObj);
	frm.submit();
}

function findPos(obj) {
	var curleft = curtop = 0;
	if (obj.offsetParent) {
		curleft = obj.offsetLeft
		curtop = obj.offsetTop
		while (obj = obj.offsetParent) {
			curleft += obj.offsetLeft
			curtop += obj.offsetTop
		}
	}
	//alert(curleft + "," + curtop);
	return [curleft,curtop];
}


function showHighlightImage(obj, id, img, alt, imgWidth)
{   
    var aleft = findPos(obj)[0];
    var atop = findPos(obj)[1];
    var aobj = document.getElementById(id);
    if (aobj != null) {
        aobj.style.setAttribute("display", "inline"); 
        atop = atop - aobj.offsetHeight-2;

        aobj.style.setAttribute("display", "none"); 
        aobj.style.setAttribute("left",(aleft + "px"));   
        aobj.style.setAttribute("top", (atop + "px")); 
        aobj.style.setAttribute("display", "inline");   
        return;   
    } 
    
	var	div = document.createElement("div");
	div.id              = id;
    div.style.position  = "absolute";   
    div.style.setAttribute("border","0   solid   #ff0000"); 
    div.innerHTML = "<table bgcolor=ffc73c style='width:" + (imgWidth+2) + "px;border-right:2px solid #888888;border-bottom:2px solid #888888'><tr><td style='background-color:#e68b2c;color:#ffffff'>" + alt + "</td></tr><tr><td align=center>" + img + "</td></tr></table>";    
    div.style.setAttribute("z-index","3");  
    
    document.body.appendChild(div); 
    aobj = document.getElementById(id);
  
    atop = atop - aobj.offsetHeight-2;

    div.style.setAttribute("display", "none"); 
    div.style.setAttribute("left",(aleft + "px"));   
    div.style.setAttribute("top", (atop + "px")); 
    div.style.setAttribute("display", "inline");   
    
}   

function hideHighlightImage(obj, id)
{   
    var aobj = document.getElementById(id);
    if (aobj != null) {
        aobj.style.setAttribute("display", "none"); 
        return;   
    } 
} 
  
function copyUrl(uri)
{
    alert(document.location.href);

}
// Show the document's title on the status bar
//window.defaultStatus=document.title;