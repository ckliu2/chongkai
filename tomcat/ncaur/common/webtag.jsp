<%@ page contentType="text/html;charset=utf-8"%>
<%@ page language="java" errorPage="/error.jsp" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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

<script type="text/javascript" src="${ctx}/scripts/jquery.min.js"></script>

<!--easyui-->
<link rel="stylesheet" type="text/css" href="${ctx}/css/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctx}/css/icon.css">
<script type="text/javascript" src="${ctx}/scripts/jquery.easyui.min.js"></script>