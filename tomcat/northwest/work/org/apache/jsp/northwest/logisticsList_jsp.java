package org.apache.jsp.northwest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import net.fckeditor.*;
import javax.servlet.http.HttpSession;

public final class logisticsList_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/common/taglibs.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_c_005fset_005f1(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

    response.addHeader("Pragma", "no-cache");
    response.setHeader("Cache-control", "no-store");
    response.setHeader("Cache-control", "no-cache");
    response.setDateHeader("Expires", 0);

    response.setContentType("text/html;charset=UTF-8");

	com.common.util.Util.IMAGE_CONTEXT_ROOT_PATH = "/northwest";

	
//	java.io.File f = new java.io.File(request.getSession().getServletContext().getRealPath("/"));
//	String ff = f.getAbsolutePath();

   //System.out.println("........" + request.getSession().getServletContext().getServletContextName());     
   
      
    if (request.getSession().getAttribute("user") == null) 
    {
       // response.sendRedirect(com.common.util.Util.IMAGE_CONTEXT_ROOT_PATH );
    }

      out.write('\r');
      out.write('\n');

if (false) {

      out.write("\r\n");
      out.write("<script language=\"JavaScript\">\r\n");
      out.write("<!--\r\n");
      out.write("   // alert before session end\r\n");
      out.write("   var remainingseconds=");
      out.print( request.getSession().getMaxInactiveInterval());
      out.write(";\r\n");
      out.write("   var url = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/common/timeout.jsp\";\r\n");
      out.write("   var tid;\r\n");
      out.write("   var hWnd;\r\n");
      out.write("   var warn=0;\r\n");
      out.write("\r\n");
      out.write("   function timeoutcheck () {\r\n");
      out.write("      remainingseconds=remainingseconds-1;\r\n");
      out.write("      if (remainingseconds>0) {\r\n");
      out.write("         tid=setTimeout(\"timeoutcheck()\", 1*1000);\r\n");
      out.write("         if (remainingseconds<65) {\r\n");
      out.write("            if (remainingseconds>6) {\r\n");
      out.write("               window.defaultStatus=\"Session 時間 : 倒數 \"+ (remainingseconds-5) +\" 秒\";\r\n");
      out.write("            } else if (remainingseconds>=5) {\r\n");
      out.write("               window.defaultStatus=\"Session 時間 : 倒數 \"+ (remainingseconds-5) +\" 秒\";\r\n");
      out.write("            }\r\n");
      out.write("            if (!warn) {\r\n");
      out.write("               warn=1;\r\n");
      out.write("               \r\n");
      out.write("               hWnd = window.open(url,\"_timeoutwarning\",\"width=400,height=140,resizable=no,scrollbars=no\");\r\n");
      out.write("               hWnd.focus();\r\n");
      out.write("            }\r\n");
      out.write("         }\r\n");
      out.write("      } else {\r\n");
      out.write("         window.defaultStatus=\"Session 時間結束\";\r\n");
      out.write("         clearTimeout(tid);\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("   function sessioncheck () {\r\n");
      out.write("      if (remainingseconds>0) {\r\n");
      out.write("         return true;\r\n");
      out.write("      } else {\r\n");
      out.write("         alert(\"很抱歉, 您的作業階段已經逾時, 請重新登入\");\r\n");
      out.write("         return false;\r\n");
      out.write("      }\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("   timeoutcheck();\r\n");
      out.write("//-->\r\n");
      out.write("</script>\r\n");
 
}

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<table id=\"dg\" class=\"easyui-datagrid\" title=\"快遞單一覽表(至多顯示300筆)\" style=\"width:100%;height:auto\" toolbar=\"#toolbar\" showFooter=\"true\" \r\n");
      out.write("       rownumbers=\"true\"\r\n");
      out.write("       data-options=\"singleSelect:false,collapsible:true,url:'logisticsListJSON.html',method:'get'\"       \r\n");
      out.write("       >\r\n");
      out.write("       <thead>\r\n");
      out.write("         <tr>      \r\n");
      out.write("         \t<th data-options=\"field:'ck',checkbox:true,width:30\"></th>   \r\n");
      out.write("         \t<th data-options=\"field:'code'\" sortable=\"true\">條碼</th>      \r\n");
      out.write("          <th data-options=\"field:'billno'\">訂單編號</th>      \r\n");
      out.write("          <th data-options=\"field:'customer'\">客戶</th>   \r\n");
      out.write("          <th data-options=\"field:'saleman'\">業務</th>   \r\n");
      out.write("          <th data-options=\"field:'sender'\">寄件人</th> \r\n");
      out.write("          <th data-options=\"field:'senderPhone'\">寄件人電話</th>     \r\n");
      out.write("          <th data-options=\"field:'senderAddress'\">寄件人地址</th>             \r\n");
      out.write("          <th data-options=\"field:'recipient'\">收件人</th>  \r\n");
      out.write("          <th data-options=\"field:'recipientPhone'\">收件人電話</th>   \r\n");
      out.write("          <th data-options=\"field:'recipientAddress'\">收件人地址</th>   \r\n");
      out.write("          <th data-options=\"field:'serviceDate'\">送達日期</th>   \r\n");
      out.write("          <th data-options=\"field:'time'\">送達時段</th>   \r\n");
      out.write("          <th data-options=\"field:'member'\">建檔人</th> \r\n");
      out.write("        </tr>\r\n");
      out.write("       </thead> \r\n");
      out.write("      </table> \r\n");
      out.write("      \r\n");
      out.write("<div id=\"toolbar\">       \r\n");
      out.write("\t  <input name=\"keyword\" id=\"keyword\" class=\"easyui-textbox\" data-options=\"prompt:'輸入訂單、條碼編號'\" style=\"width:200px\" />\r\n");
      out.write("\t  \r\n");
      out.write("\t  <input id=\"startDate\" type=\"text\" class=\"easyui-datebox\" editable=\"true\" data-options=\"formatter:myformatter,parser:myparser,prompt:'送達日(開始)'\" />\r\n");
      out.write("\t  <input id=\"endDate\" type=\"text\" class=\"easyui-datebox\"  editable=\"true\" data-options=\"formatter:myformatter,parser:myparser,prompt:'送達日(結束)'\" />\r\n");
      out.write("\t  \r\n");
      out.write("    <a href=\"#\" class=\"easyui-linkbutton\" iconcls=\"icon-search\" plain=\"true\" onclick=\"doSearch()\">查詢</a>                    \r\n");
      out.write("\t\t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"edit()\">新增/編輯</a>\r\n");
      out.write("\t  <a href=\"#\" class=\"easyui-linkbutton\" iconcls=\"icon-remove\" plain=\"true\" onclick=\"del()\">刪除</a> \t\t     \r\n");
      out.write("\t  <a href=\"#\" class=\"easyui-linkbutton\" iconcls=\"icon-print\" plain=\"true\" onclick=\"printx()\">列印</a> \t         \r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"myevent2\" class=\"easyui-window\" data-options=\"resizable:false,modal:true,closed:true,shadow:false,iconCls:'icon-view',border:'thin',cls:'c6'\" style=\"width:50%;height:auto;padding:10px;top:1px\"></div>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("<script>  \r\n");
      out.write("\t\r\n");
      out.write(" function printx(){   \t\r\n");
      out.write(" \tvar id=getSel().toString();\r\n");
      out.write(" \twindow.open('http://127.0.0.1:8888/?rpt=14&id='+id);\r\n");
      out.write(" }  \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" function edit(){   \t\r\n");
      out.write(" \tvar id=getSel().toString();\r\n");
      out.write(" \t//alert('id='+id);\r\n");
      out.write("  $('#myevent2').window('open');\r\n");
      out.write("  $('#myevent2').window('setTitle', '快遞單'); \r\n");
      out.write("  $('#myevent2').window('refresh', 'editLogistics.html?logistics.id='+id);       \r\n");
      out.write(" }   \r\n");
      out.write(" \r\n");
      out.write(" \r\n");
      out.write(" function del(){   \t\r\n");
      out.write(" \tvar ids=getSel().toString();\r\n");
      out.write(" \tif (getSel().length ===0) {\r\n");
      out.write("        $.messager.alert('系統訊息', '至少選擇一項，進行編輯!', 'error');\r\n");
      out.write("        return false;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   $.ajax({\r\n");
      out.write("    url: 'deleteLogisticsJSON.html',\r\n");
      out.write("    type: 'GET',\r\n");
      out.write("    data: {\r\n");
      out.write("      'ids': ids\r\n");
      out.write("    },\r\n");
      out.write("    error: function(xhr) {\r\n");
      out.write("    \t$.messager.alert('系統訊息', '刪除失敗!', 'error');\r\n");
      out.write("    },\r\n");
      out.write("    success: function(response) {\r\n");
      out.write("       \tdoSearch();   \r\n");
      out.write("    }\r\n");
      out.write("  });\r\n");
      out.write("  \r\n");
      out.write(" }  \r\n");
      out.write(" \r\n");
      out.write(" function doSearch() {\r\n");
      out.write("            \t  var keyword=$('#keyword').textbox('getText');\r\n");
      out.write("            \t  var startDate=$('#startDate').datebox('getValue');\r\n");
      out.write("            \t  var endDate=$('#endDate').datebox('getValue');\r\n");
      out.write("            \t  var myurl='logisticsListJSON.html?keyword='+keyword+'&startDate='+startDate+'&endDate='+endDate;\r\n");
      out.write("            \t  //alert(myurl);\r\n");
      out.write("            \t  \r\n");
      out.write("                $('#dg').datagrid({\r\n");
      out.write("                \t  url:myurl\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write(" \r\n");
      out.write(" function getSel() {\r\n");
      out.write("                var checkedItems = $('#dg').datagrid('getChecked');\r\n");
      out.write("                var names = [];\r\n");
      out.write("                $.each(checkedItems, function(index, item) {\r\n");
      out.write("                    names.push(item.id);\r\n");
      out.write("                    names.join(\",\");\r\n");
      out.write("                });\r\n");
      out.write("                return names;\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("</script>        ");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    try {
      _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f0.setParent(null);
      // /common/taglibs.jsp(12,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f0.setVar("datePattern");
      int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
      if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_c_005fset_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_c_005fset_005f0.doInitBody();
        }
        do {
          if (_jspx_meth_fmt_005fmessage_005f0(_jspx_th_c_005fset_005f0, _jspx_page_context))
            return true;
          int evalDoAfterBody = _jspx_th_c_005fset_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_c_005fset_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.reuse(_jspx_th_c_005fset_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_fmt_005fmessage_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fset_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  fmt:message
    org.apache.taglibs.standard.tag.rt.fmt.MessageTag _jspx_th_fmt_005fmessage_005f0 = (org.apache.taglibs.standard.tag.rt.fmt.MessageTag) _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.get(org.apache.taglibs.standard.tag.rt.fmt.MessageTag.class);
    try {
      _jspx_th_fmt_005fmessage_005f0.setPageContext(_jspx_page_context);
      _jspx_th_fmt_005fmessage_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fset_005f0);
      // /common/taglibs.jsp(12,25) name = key type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_fmt_005fmessage_005f0.setKey("date.format");
      int _jspx_eval_fmt_005fmessage_005f0 = _jspx_th_fmt_005fmessage_005f0.doStartTag();
      if (_jspx_th_fmt_005fmessage_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.reuse(_jspx_th_fmt_005fmessage_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fset_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f1 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    try {
      _jspx_th_c_005fset_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fset_005f1.setParent(null);
      // /common/taglibs.jsp(13,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setVar("ctx");
      // /common/taglibs.jsp(13,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fset_005f1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
      int _jspx_eval_c_005fset_005f1 = _jspx_th_c_005fset_005f1.doStartTag();
      if (_jspx_th_c_005fset_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f1);
    }
    return false;
  }
}
