<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" errorPage="/error.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/webwork" prefix="ww" %>
<c:set var="datePattern"><fmt:message key="date.format"/></c:set>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<%
    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-store");
    response.setHeader("Cache-control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("text/html;charset=UTF-8");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>  <c:out value="${website.title}"/>  </title>
<link rel="stylesheet" type="text/css" href="inc/css/base.css">
<link rel="stylesheet" type="text/css" href="inc/css/print.css">
<script type="text/javascript" src="inc/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="inc/js/base.js"></script>
<script type="text/javascript">

</script>
</head>

<body>
<div id="wrapper">
    <div id="header" name ="top">
        <div class="navBar">
        	<input type="text" class="search_txt"><a href="#" class="btn1">搜尋</a>
            |<a href="#" class="link1">回首頁</a>|<a href="#" class="link1">加入最愛</a>|<a href="#" class="link1">簡體</a></div>
        <div class="banner1"><img src="inc/img/layout/banner1.gif"></div>
    </div><!--header-->
    <div id="menu">
    	<a href="index.do"><span><b>教會簡介</b></span></a>
    	<a href="content.do" class="current"><span><b>公告事項</b></span></a>
    	<a href="#"><span><b>教育課程</b></span></a>
    	<a href="#"><span><b>什一奉獻</b></span></a>
    	<a href="#"><span><b>個別牧區</b></span></a>
    	<a href="#"><span><b>聖工單位</b></span></a>
    	<a href="#"><span><b>真道分會</b></span></a>
    	<a href="#" class="ft"><span><b>宣教事工</b></span></a>
    </div>
    <div id="menuSub" class="clearfix">
    	<ul class="current">
        	<li class="current"><a href="#">宗旨與異象</a></li>
        	<li><a href="#">聚會時間</a></li>
        	<li><a href="content.do">牧者介紹</a></li>
        	<li><a href="#">裝備中心</a></li>
        	<li><a href="#">牧區通訊</a></li>
        </ul>
    	<ul>
        	<li><a href="#">週報信息</a></li>
        	<li><a href="#">講道大綱</a></li>
        	<li><a href="#">教會消息</a></li>
        	<li><a href="#">主日早堂信息</a></li>
        </ul>
    	<ul>
        	<li><a href="#">小組教材4W</a></li>
        	<li><a href="#">成長裝備課程</a></li>
        	<li><a href="#">靈恩問題解答</a></li>
        	<li><a href="#">裝備中心</a></li>
        	<li><a href="#">聖經學院</a></li>
        	<li><a href="#">教牧輔導學</a></li>
        	<li><a href="#">靈恩實踐神學</a></li>
        	<li><a href="#">其他書信</a></li>
        	<li><a href="#">異端學</a></li>
        	<li><a href="#">線上圖書館</a></li>
        </ul>
    	<ul>
        	<li><a href="#">4宣教事工</a></li>
        </ul>
    	<ul>
        	<li><a href="#">第一牧區</a></li>
        	<li><a href="#">第二牧區</a></li>
        	<li><a href="#">第三牧區</a></li>
        	<li><a href="#">第四牧區</a></li>
        	<li><a href="#">青年牧區</a></li>
        	<li><a href="#">兒童牧區</a></li>
        	<li><a href="#">英文團契</a></li>
        </ul>
    	<ul>
        	<li><a href="#">禱告會工</a></li>
        	<li><a href="#">聖樂事工工</a></li>
        	<li><a href="#">喜樂人生協會</a></li>
        </ul>
    	<ul>
        	<li><a href="#">全球真道通訊錄</a></li>
        	<li><a href="#">中壢真道教會</a></li>
        	<li><a href="#">台中真道教會</a></li>
        	<li><a href="#">蘭陽真道教會</a></li>
        	<li><a href="#">新竹真道教會</a></li>
        	<li><a href="#">三峽真道教會</a></li>
        </ul>
    	<ul>
        	<li><a href="#">宣教事工</a></li>
    	</ul>
    </div>
    <div id="pageBody">
        <div id="content">
        	<div class="box3">
                <div class="hd"><b>真道最新消息</b></div>
                <div class="boxcont2">
                	<table class="tb3" width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="14%" class="td_hd">職  稱</td>
                            <td width="17%" class="td_hd">姓  名</td>
                            <td width="18%" class="td_hd">學  歷</td>
                            <td width="30%" class="td_hd">經  歷</td>
                            <td width="21%" class="td_hd">現  任</td>
                        </tr>
                        <tr>
                            <td>副主任牧師</td>
                            <td>張秉聰</td>
                            <td>香港真道聖經學院</td>
                            <td>香港真道教會傳道</td>
                            <td>台北真道教會副主任牧師</td>
                        </tr>
                    </table>

                	<table class="tb2" width="100%" border="0" cellspacing="0" cellpadding="0">
                        <tr>
                            <td width="13%" class="td_hd">職  稱</td>
                            <td width="63%">副主任牧師</td>
                            <td width="24%" rowspan="6" class="photo">
                            	<img src="inc/img/layout/man.gif">
                            </td>
                        </tr>
                        <tr>
                            <td class="td_hd">姓  名</td>
                            <td>張秉聰</td>
                        </tr>
                        <tr>
                            <td class="td_hd">學  歷</td>
                            <td>香港真道聖經學院Diploma；San Diego, CA, USA, Berean Bible College, B.Th.； 中華福音神學院 聖經碩士進修；聖德基督學院 教牧碩士； Lake Worth, Florida, USA, New Covenant International University, D.Th.</td>
                        </tr>
                        <tr>
                            <td class="td_hd">經  歷</td>
                            <td>香港真道教會傳道；台南真道教會傳道；神召神學院台北分院教務主任； 台北小組化教會牧者訓練中心教師；中壢聖德基督學院教師</td>
                        </tr>
                        <tr>
                            <td class="td_hd">現  任</td>
                            <td>台北真道教會副主任牧師；台北真道教會教育部主任；真道聖經學院副院長； 東馬來西亞和散那聖經學院教師</td>
                        </tr>
                        <tr>
                            <td colspan="2">目前在教會中專門負責策劃及推動基督徒教育裝備工作，著作包括已正式出版發行的「初信手冊」 、「淺談基督徒生活教育」、「靈宮建造—教會牧養手冊」書籍、台北真道教會「裝備系統教材」 整套，另有各樣教材包括「新舊約全書研讀指引」、「教牧書信研讀手冊」、「希伯來書信研讀手 冊」、「摩西五經研讀手冊」、「舊約歷史書研讀手冊」、「屬靈領導」、「聖地背景」、「小組 福音茶會手冊—聖誕節及母親節系列」等。</td>
                        </tr>
                    </table>

                </div>
                <div class="ft"><b>&nbsp;</b></div>
            </div>
        </div>
    </div>
    <div id="sideLeft">
    	<div class="lv3">
        	<dl>
            	<dt><b>牧者介紹</b> </dt>
                <dd><a href="#">主任牧師</a></dd>
                <dd class="current"><a href="#">副主任牧師 -張秉聰</a></dd>
                <dd><a href="#">張牧師</a></dd>
                <dd><a href="#">黃牧師</a></dd>
                <dd><a href="#">羅牧師</a></dd>
            </dl>
            <div class="banner_left">
            	<a href="#"><img src="inc/img/banner/left_ban1.gif"> </a>
                <a href="#"><img src="inc/img/banner/left_ban2.gif"> </a>
                <a href="#"><img src="inc/img/banner/left_ban3.gif"></a>
            </div>
        </div>
    </div>
    <div id="footer">CSS template by samrise</div>
</div>
</body>
</html>

