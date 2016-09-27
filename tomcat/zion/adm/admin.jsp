<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" errorPage="/error.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="/webwork" prefix="ww" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<ww:set name="GLOBAL_pagesize" value="20" scope="session"/>
<ww:set name="RESULT_SIZE" value="20" scope="session"/>

<%
    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-store");
    response.setHeader("Cache-control", "no-cache");
    response.setDateHeader("Expires", 0);

    response.setContentType("text/html;charset=UTF-8");
%>
<html>

<head>
<title> <fmt:message key="common.title"/> </title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css" />

<style type="text/css">
<!--
body {
	background-image: url( ${ctx}/images/bg.jpg );
}
-->
</style></head>

<body bgcolor="#C3D9F9">

  <STYLE type=text/css>
    .tl {font-size:18px; line-height:24px; color: #000000}
    .tm {font-size:16px; line-height:18px; color: #000000}
    .ts {font-size:12px; line-height:18px; color: #ffffff}
    .none {font-size:6px}
    .nor {font-size:12px; line-height:18px; color: #656565}
    .nork {font-size:12px; line-height:24px; color: #000000}
    .norb {font-size:12px; line-height:18px; color: #0099CC}
    .nors {font-size:12px; line-height:18px; color: #cc0000}
    .date {font-size:12px; line-height:18px; color: #656565}
    A:link  {font-size:12px; color:#990000; font-style: normal; text-decoration: underline; cursor: hand}
    A:visited  {font-size:12px; color:#990000; font-style: normal; text-decoration: underline}
    A:active  {font-size:12px; color:#990000; font-style: normal; text-decoration: none}
    A:hover {font-size:12px; color:#FF6633; font-style: normal; text-decoration: none}
.cLoginButton {
    border-style: outset;
    border-width: 1px;
    font-size:13px;
    background: #EEEEEE;
    height: 50px;
}
    
  </STYLE>
<div align="center">  

</div>
<div align="center">
  <table border="0" cellspacing="0" style="border-collapse: collapse" id="table1">
    <tr>
      <td height="100" align="center" style="font-size:40px;">&nbsp;</td>
    </tr>
    
    <tr>
      <td style="font-size:40px;" align="center">
        368禱告後台管理系統
      </td>
    </tr>
    
    <tr>
      <td>
<table width="432" border="0" cellspacing="0" cellpadding="0" align="center" id="table2">

  <tr>
    <td width="428">
      <form action="login.do" method="post">
        <table class="nork" width="300" border="0" cellspacing="1" cellpadding="0" align="center" id="table3">
           <tr>
            <td colspan="2" width="414">            
           </td>
           
           
          <tr>
            <td colspan="2" width="414" align="center">
              <span style="font-size:10pt;color:#FF0000"><ww:property value="msg1"/></span>
              <p style="font-size:10pt;color:#FF0000">&nbsp;              </p>
              <p style="font-size:10pt;color:#FF0000">&nbsp;</p>
              <p style="font-size:10pt;color:#FF0000">&nbsp;</p>
              <p style="font-size:10pt;color:#FF0000">&nbsp; </p></td>
          </tr>
          
          
          <tr>
            <td width="150" bgcolor="#6666FF" NOWRAP align="right">
              <div align="center"><span style="font-size:11pt;color:#FFFFFF">手機號碼</span></div>            
            </td>
            <td bgcolor="#E8E8FF">
              <input type="text" tabindex="1" style="border-width:1px;border-style:inset;width:200pt;font-size:12pt;height:30pt" name="cellphone"   value="0958058735" />             
              </td>
            <td bgcolor="#FFFFFF" rowspan="2">
                <input class="cLoginButton" type="submit"  value="<fmt:message key="common.login"/>"/>            
            </td>
          </tr>
  
        </table>
      </form>    
     </td>
  </tr>
</table></td>
    </tr>
  </table>

</body>
</html>


<%
String msg=request.getParameter("msg");
 if(msg!=null){
%>
  <script>
    alert("手機號碼錯誤!");
  </script>
<% 
}
%>

