//Javscript
var lv2_key1 = false;
var lv2_key2 = false;
var lv2_key3 = false;
window.onload = function (){
	/*setHover('menua','LI');	*/
	createMenu();
	createSugMenu('lv3');
	if(gid('slideshow')){
		$('#slideshow').css('display','block')
		$('#slideshow').cycle({ 
			fx:    'scrollLeft', 
			speed:  '2000',
			pager:  '#nav',
			slideExpr: 'img'
		 });
	}
	if(gid('tb4')){colorHover('tb4',1,1);}
	resizeHeight('lv3','pageBody');
	//$('wp').style.width = $winwh()[0] +'px';
	/*setheight();*/
}
//tbDrop2(obj,往下展開幾個)
function tbDrop2(e,target,jclassName){
	current_row = jq.e.parentTag(e,'TR');
	next_row = jq.e.next(current_row);
	if(next_row.className == 'hide'){
		if(e.className == 'expand2'){e.className = 'collapse2';}
		if(e.className == 'expand3'){e.className = 'collapse3';}
		if(e.className == 'link6'){
			var  obj = current_row.getElementsByTagName('td')[0].getElementsByTagName('a')[0];
			if(obj.className == 'expand3'){obj.className = 'collapse3';}
		}
		/**/
		jq.table.switchs(current_row,target,jclassName);
	}else{
		if(e.className == 'collapse2'){e.className = 'expand2';}
		if(e.className == 'collapse3'){e.className = 'expand3';}
		if(e.className == 'link6'){
			var  obj = current_row.getElementsByTagName('td')[0].getElementsByTagName('a')[0];
			if(obj.className == 'collapse3'){obj.className = 'expand3';}
		}
		jq.table.switchs(current_row,target,'hide');
	}
}
//尋找字串
function is(word,key){return word.indexOf(key)>-1;}
function resizeHeight(box1,box2){
	if(!gid(box1) || !gid(box2)){return;}
	var box1 = gid(box1);
	var box2 = gid(box2);
	box1H = box1.clientHeight;	//內容高度
	box2H = box2.clientHeight;	//左邊選單高度
	if(box1H<box2H){
		box1.style.height = box2.clientHeight + 'px';
	}
}
function parentTag(obj,tag){
	var elem = obj;
	while(elem.tagName != tag){elem = elem.parentNode;}	
	return elem;
}
function createSugMenu(id){
	if(!gid(id)){return}
	var lv3s = gid(id).getElementsByTagName('DD');
	for(var i=0; i<lv3s.length; i++){
		var	tagA = lv3s[i].getElementsByTagName('A')[0];
		tagA.onmouseover = function (){
			cleanLv3('lv3');
			parentTag(this,'DD').className = 'current';
		}
		if(lv3s[i].getElementsByTagName('span')[0]){
			var lv4s = lv3s[i].getElementsByTagName('span')[0].getElementsByTagName('a');
			for(var j=0; j<lv4s.length; j++){
				lv4s[j].onclick = function (){
					cleanLv4('lv3');
					this.className = 'current';	
				}		
			}			
		}
	}
}
function cleanLv3(id){
	var lv3s = gid(id).getElementsByTagName('DD');
	for(var i=0; i<lv3s.length; i++){
		lv3s[i].className = '';	
	}
}
function cleanLv4(id){
	var lv4s = gid(id).getElementsByTagName('A');
	for(var j=0; j<lv4s.length; j++){
		lv4s[j].className = '';	
	}
}

function scrollByTop(){
	window.scrollBy(0,-10000);
}
function swirchBlock(_this,id){
	var name1 = _this.className == 'download_btn' ? 'download_btn_close':'download_btn';
	
	if(_this.className == 'download_btn'){
		_this.className = 'download_btn_close';
		gid(id).style.display = 'none';
	}else{
		_this.className = 'download_btn';
		gid(id).style.display = '';
	}
}
//加到書籤
function bookmark(){
	bookmarkurl="http://www.truth.org.tw/"	
	bookmarktitle="基督教台北真道教會"
	if (document.all){
		window.external.AddFavorite(bookmarkurl,bookmarktitle)
	}else if(window.sidebar){
		window.sidebar.addPanel(bookmarktitle, bookmarkurl, "");
	}
}
//設定相同高度
function setheight(){
	if(gid('sideLeft').clientHeight > gid('ct').clientHeight){
		gid('ct').style.height = gid('sideLeft').clientHeight + 'px';
	}else{gid('sideLeft').style.height = gid('ct').clientHeight + 'px';}
}
function $random(min, max){return Math.floor(Math.random() * (max - min + 1) + min);};
function filltext(words){
	var txt=["This is just some filler text", 
				   "this is sample text", 
				   "Demo content nothing to read here"];
	for (var i=0; i<words; i++){document.write(txt[$random(1,3)]+" ")}
}
function reSize(){
	var wi = 997;
	if (navigator.appName == "Netscape")
		wi = 333;
	else if (navigator.appName.indexOf("Microsoft") >= 0) {
		if (navigator.appVersion.indexOf("MSIE 7") >= 0) {
			wi = 1003;
		} else {
			wi = 997;
		}
	}
	
	var bodyWidth = $winwh();
	if (bodyWidth[0] > wi) {
		if (navigator.appName == "Netscape")
			wi = bodyWidth[0]-5;
		else if (navigator.appName.indexOf("Microsoft") >= 0) {
			if (navigator.appVersion.indexOf("MSIE 7") >= 0) {
				wi = bodyWidth[0]-5;
			} else {
				wi = bodyWidth[0]-4;
			}	
		}
	}
	wi =  $winwh()[0]
	return wi;
} 

//---
function gid(e){return document.getElementById(e);}
function $random(min, max){return Math.floor(Math.random() * (max - min + 1) + min);};
function colorHover(id,start,hover){
	var tb = document.getElementById(id);
	var tr = tb.getElementsByTagName('tr');
	for(i=start;i<tr.length;i++){								
		if(i%2==0){tr[i].className+=" odd";}
		else{tr[i].className+=" even";}
		if(hover){
			tr[i].onmouseover = function (){this.className += ' hover';}
			tr[i].onmouseout = function (){this.className=this.className.replace("hover", "");}
		}
	}
}
function filltext(words){
	var txt=["This is just some filler text", 
				   "this is sample text", 
				   "Demo content nothing to read here"];
	for (var i=0; i<words; i++){
		document.write(txt[$random(1,3)]+" ")
	}
}
function $winwh(){
	if (parseInt(navigator.appVersion)>3) {
		if (navigator.appName=="Netscape") {
			winW = scrollMaxY ? window.innerWidth-17 : window.innerWidth;
			winH = scrollMaxX ? window.innerHeight-17 : window.innerHeight;
		}
		if (navigator.appName.indexOf("Microsoft")!=-1) {
			winW = document.body.clientWidth;
			winH = document.body.clientHeight;
		}
	}
	return [winW,winH]
}
function createMenu(){
	if(!gid('menuSub')){return;}
	var menu = document.getElementById('menu');
	var menuSub = gid('menuSub');
	var atag = menu.getElementsByTagName('a');
	for(var i=0; i<atag.length; i++){
		atag[i].ind = i;
		atag[i].onmouseover = function (){
			resetMenu();
			this.className = 'current';
			showSub(this.ind);
		}
	}
	menuSub.onmouseout = function (){
		lv2_key1 = true;
		if(lv2_key1 && lv2_key2 && lv2_key3){		
			showSub();	
		}		
	}
}
function setHover(id,tag){
	var e = document.getElementById(id).getElementsByTagName(tag);
	for (var i=0; i<e.length; i++) {
		e[i].onmouseover=function() {
			this.className+=" hover";
		}
		e[i].onmouseout=function() {
			this.className=this.className.replace(" hover", "");
		}
	}
}
function resetMenu(){
	var menu = document.getElementById('menu');
	var atag = menu.getElementsByTagName('a');
	for(var i=0; i<atag.length; i++){
		atag[i].className = '';	
	}
}
function showSub(n){
	var menuSub = document.getElementById('menuSub');
	var lv2 = menuSub.getElementsByTagName('ul');
	for(var i=0; i<lv2.length; i++){
		lv2[i].className = '';
	}
	n || n == 0 ? lv2[n].className = 'current':'';
}
var jq={
	e:{
		parentTag:function(obj,tag){
			var elem = obj;
			while(elem.tagName != tag){elem = elem.parentNode;}	
			return elem;
		},
		parent:function(obj){
			var elem = obj.parentNode;
			while(elem.tagName == undefined){elem = elem.parentNode;}	
			return elem;
		},
		next:function (obj){
			var elem = obj.nextSibling;
			while(elem.nodeType!=1 || elem.nodeType==3){elem = elem.nextSibling;}
			return elem;			
		},
		previous:function (obj){
			var elem = obj.previousSibling;			
			while(elem.tagName == undefined){elem = elem.previousSibling;}	
			return elem;			
		}
	},
	table:{
		show:function(name,ar){	
			if(document.getElementById(name)){
				tb = document.getElementById(name);
			}else{
				tb = name;
				while(tb.tagName != 'TABLE'){tb = tb.parentNode;}
			}
			//rowInd = name.parentNode.parentNode.parentNode.rowIndex;
			for(i=0; i<ar.length; i++){
				if(document.all){tb.rows[ar[i]].style.display = 'block';}
				else{tb.rows[ar[i]].style.display = 'table-row';}				
			}
		},
		hide:function(name,ar){
			if(document.getElementById(name)){
				tb = document.getElementById(name);
			}else{
				tb = name;
				while(tb.tagName != 'TABLE'){tb = tb.parentNode;}
			}			
			//rowInd = name.parentNode.parentNode.parentNode.rowIndex;
			for(i=0; i<ar.length; i++){
				tb.rows[ar[i]].style.display = 'none';				
			}			
		},
		switchs:function(obj,num,jclassName){
			//指定往下改變className
			if(document.getElementById(obj)){
				tb = document.getElementById(obj);
			}else{
				tb = obj;
				while(tb.tagName != 'TABLE'){tb = tb.parentNode;}
			}			
			var next_rows = obj.rowIndex+1;			
			var n = next_rows + num;			
			for(i=next_rows; i<n; i++){tb.rows[i].className = jclassName;}
		},
		view:function(name,ar){			
			if(document.getElementById(name)){
				tb = document.getElementById(name);
			}else{
				tb = name;
				while(tb.tagName != 'TABLE'){tb = tb.parentNode;}
			}			
			if(ar == 'all'){
				for(i=0; i<tb.rows.length; i++){
					if(document.all){tb.rows[i].style.display = 'block';}
					else{tb.rows[i].style.display = 'table-row';}
				}
			}else{
				for(j=0; j<tb.rows.length; j++){tb.rows[j].style.display = 'none';}
				for(k=0; k<ar.length; k++){
					if(document.all){tb.rows[ar[k]].style.display = 'block';}
					else{tb.rows[ar[k]].style.display = 'table-row';}
				}				
			}
		}
	}
}