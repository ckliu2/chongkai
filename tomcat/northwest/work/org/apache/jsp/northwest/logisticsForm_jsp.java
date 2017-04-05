package org.apache.jsp.northwest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import net.fckeditor.*;
import javax.servlet.http.HttpSession;

public final class logisticsForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fcssClass_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fcssClass_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar.release();
    _005fjspx_005ftagPool_005ffmt_005fmessage_0026_005fkey_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.release();
    _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fcssClass_005fnobody.release();
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
      if (_jspx_meth_ww_005fset_005f0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\r\n");
      out.write("        <form id=\"ff\" method=\"post\">\r\n");
      out.write("            <table cellpadding=\"5\">\r\n");
      out.write("            \t\r\n");
      out.write("            \t  <tr>\r\n");
      out.write("                    <td>條碼編號:</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input class=\"easyui-textbox\" type=\"text\" id=\"code\"  data-options=\"required:true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.code}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:400px\"></input>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                \r\n");
      out.write("            \t  <tr>\r\n");
      out.write("                    <td>訂單編號:</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input id=\"billId\" class=\"easyui-combobox\" data-options=\"prompt:'訂單編號'\" style=\"width:400px\"  />\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>客戶:</td>\r\n");
      out.write("                    <td><span id='customer'/></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>業務:</td>\r\n");
      out.write("                    <td><span id='saleman'/></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>寄件人:</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                    \t<input id=\"sender\" class=\"easyui-combogrid\" data-options=\"prompt:'請輸入寄件人...'\" style=\"width:400px\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.sender}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>寄件人電話:</td>\r\n");
      out.write("                    <td><input class=\"easyui-textbox\" type=\"text\" id=\"senderPhone\" data-options=\"required:true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.senderPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:400px\"></input></td>\r\n");
      out.write("                </tr>    \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>寄件人地址:</td>\r\n");
      out.write("                    <td><input class=\"easyui-textbox\" type=\"text\" id=\"senderAddress\"  data-options=\"required:true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.senderAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:400px\"></input></td>\r\n");
      out.write("                </tr>          \r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>收件人:</td>\r\n");
      out.write("                    <td><input class=\"easyui-textbox\" type=\"text\" id=\"recipient\"  data-options=\"required:true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.recipient}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:400px\"></input></td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>收件人電話:</td>\r\n");
      out.write("                    <td><input class=\"easyui-textbox\" type=\"text\" id=\"recipientPhone\"  data-options=\"required:true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.recipientPhone}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:400px\"></input></td>\r\n");
      out.write("                </tr>    \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>收件人地址:</td>\r\n");
      out.write("                    <td><input class=\"easyui-textbox\" type=\"text\" id=\"recipientAddress\"  data-options=\"required:true\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.recipientAddress}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:400px\"></input></td>\r\n");
      out.write("                </tr>       \r\n");
      out.write("                \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>指定送達日:</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                     <input class=\"easyui-datebox\" name=\"serviceDate\" id=\"serviceDate\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.serviceDate}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"   style=\"width:100px\" editable=\"false\" data-options=\"formatter:myformatter,parser:myparser\" /> \r\n");
      out.write("    \t             </td>\r\n");
      out.write("                </tr>   \r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>指定送達時段:</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                    \t ");
      if (_jspx_meth_ww_005fselect_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>  \r\n");
      out.write("                    \r\n");
      out.write("            </table>\r\n");
      out.write("        </form>        \r\n");
      out.write("        <div style=\"text-align:left;padding:5px\">\r\n");
      out.write("            <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconcls=\"icon-save\" onclick=\"submitForm()\">儲存</a>\r\n");
      out.write("            <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconcls=\"icon-clear\" onclick=\"clearForm()\">清除</a>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\t\r\n");
      out.write("$('#customer').html('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.bill.customer.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("');\r\n");
      out.write("$('#saleman').html('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.bill.customer.saleman.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("');\t\r\n");
      out.write("\r\n");
      out.write("$('#sender').combogrid({      \r\n");
      out.write("                idField:'id',\r\n");
      out.write("                textField:'text',\r\n");
      out.write("                mode:'remote',         \r\n");
      out.write("                fitColumns:true,          \r\n");
      out.write("                columns:[[\r\n");
      out.write("                    {field:'ck',checkbox:true},\r\n");
      out.write("                    {field:'sender',title:'寄件人'},\r\n");
      out.write("                    {field:'senderPhone',title:'寄件人電話'},\r\n");
      out.write("                    {field:'senderAddress',title:'寄件人地址',align:'right'}\r\n");
      out.write("                ]]  \r\n");
      out.write("                , \r\n");
      out.write("                onChange:function(oldVal, newVal) {                  \t         \r\n");
      out.write("                    var url=\"senderDBJSON.html?keyword=\"+oldVal;                                  \r\n");
      out.write("                    $('#sender').combogrid('grid').datagrid('reload',url);                              \r\n");
      out.write("                },\r\n");
      out.write("                onSelect: function(index,row){\r\n");
      out.write("                     //alert(row.sender);\r\n");
      out.write("                     $('#sender').textbox('setValue',row.sender);\r\n");
      out.write("                     $('#senderPhone').textbox('setValue',row.senderPhone);\r\n");
      out.write("                     $('#senderAddress').textbox('setValue',row.senderAddress);                   \r\n");
      out.write("                }               \r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function submitForm(){\r\n");
      out.write("\t var code=$('#code').textbox('getValue');\r\n");
      out.write("\t var billId=$('#billId').combobox('getValue');\r\n");
      out.write("\t var sender=$('#sender').textbox('getValue');\t \r\n");
      out.write("\t var senderPhone=$('#senderPhone').textbox('getValue');\r\n");
      out.write("\t var senderAddress=$('#senderAddress').textbox('getValue');\t \r\n");
      out.write("\t var recipient=$('#recipient').textbox('getValue');\r\n");
      out.write("\t var recipientPhone=$('#recipientPhone').textbox('getValue');\r\n");
      out.write("\t var recipientAddress=$('#recipientAddress').textbox('getValue');\r\n");
      out.write("\t var serviceDate=$('#serviceDate').datebox('getValue');\r\n");
      out.write("\t var timeId=$('#timeId').val();\r\n");
      out.write("\t \r\n");
      out.write("\t //if()\r\n");
      out.write("\t var c=0,error='';\r\n");
      out.write("\t if(code ===''){\r\n");
      out.write("         error+='條碼編號為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(billId ===''){\r\n");
      out.write("         error+='訂單編號為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(sender ===''){\r\n");
      out.write("         error+='寄件人為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(senderPhone ===''){\r\n");
      out.write("         error+='寄件人電話為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(senderAddress ===''){\r\n");
      out.write("         error+='寄件人地址為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(recipient ===''){\r\n");
      out.write("         error+='收件人為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(recipientPhone ===''){\r\n");
      out.write("         error+='收件人電話為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(recipientAddress ===''){\r\n");
      out.write("         error+='收件人地址為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   if(serviceDate ===''){\r\n");
      out.write("         error+='指定送達日為必填欄位<br>';\r\n");
      out.write("         c++;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write(" \t  if(error !=='')\r\n");
      out.write(" \t  {\r\n");
      out.write(" \t  \t$.messager.alert('系統訊息','以下請修正下列資訊<br>'+error,'error').window({  \r\n");
      out.write("         width:400      \r\n");
      out.write("      });  \r\n");
      out.write("      return false;\r\n");
      out.write(" \t  }\r\n");
      out.write("\t \r\n");
      out.write("\t  $.ajax({\r\n");
      out.write("             url: 'saveLogisticsJSON.html',\r\n");
      out.write("             type: \"POST\",        \r\n");
      out.write("             data: {\r\n");
      out.write("             \t\"logistics.id\":'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("',\"logistics.code\":code,\"logistics.billId\":billId,\"logistics.sender\":sender,\"logistics.senderPhone\":senderPhone,\r\n");
      out.write("             \t\"logistics.senderAddress\":senderAddress,\"logistics.recipient\":recipient,\"logistics.recipientPhone\":recipientPhone,\r\n");
      out.write("             \t\"logistics.recipientAddress\":recipientAddress,\"serviceDate\":serviceDate,\"logistics.timeId\":timeId,\r\n");
      out.write("             \t}, \r\n");
      out.write("             success: function(data) { \r\n");
      out.write("             \tdoSearch();    \r\n");
      out.write("             \t$('#myevent2').window('close');                      \t     \t\r\n");
      out.write("            }\r\n");
      out.write("    });\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function clearForm(){\r\n");
      out.write("            $('#ff').form('clear');\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(\"#billId\").combobox({\r\n");
      out.write("\t      url: 'billJSON.html?billNo=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${logistics.billId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("',     \r\n");
      out.write("      \tmethod: 'get',   \r\n");
      out.write("        valueField:'id',\r\n");
      out.write("        textField:'text',   \r\n");
      out.write("        delay:1500,    \r\n");
      out.write("        onChange:function(oldVal, newVal) {             \t\r\n");
      out.write("           var murl=\"billJSON.html?billNo=\"+oldVal;   \r\n");
      out.write("           //alert(murl);        \r\n");
      out.write("           $('#billId').combobox('reload', murl);                                 \r\n");
      out.write("        },\r\n");
      out.write("        onSelect:function(item) {  \r\n");
      out.write("        \t//alert(item.customer);       \r\n");
      out.write("        \t$('#customer').html(item.customer);     \r\n");
      out.write("        \t$('#saleman').html(item.saleman);    \r\n");
      out.write("          //  $('#salemanId').val(item.salemanId);\r\n");
      out.write("        }           \r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
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

  private boolean _jspx_meth_ww_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:set
    com.opensymphony.webwork.views.jsp.SetTag _jspx_th_ww_005fset_005f0 = (com.opensymphony.webwork.views.jsp.SetTag) _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.get(com.opensymphony.webwork.views.jsp.SetTag.class);
    try {
      _jspx_th_ww_005fset_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fset_005f0.setParent(null);
      // /northwest/logisticsForm.jsp(3,0) name = name type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f0.setName("logistics");
      // /northwest/logisticsForm.jsp(3,0) name = value type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fset_005f0.setValue("%{getLogisticsById()}");
      int _jspx_eval_ww_005fset_005f0 = _jspx_th_ww_005fset_005f0.doStartTag();
      if (_jspx_th_ww_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fset_0026_005fvalue_005fname_005fnobody.reuse(_jspx_th_ww_005fset_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_ww_005fselect_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  ww:select
    com.opensymphony.webwork.views.jsp.ui.SelectTag _jspx_th_ww_005fselect_005f0 = (com.opensymphony.webwork.views.jsp.ui.SelectTag) _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fcssClass_005fnobody.get(com.opensymphony.webwork.views.jsp.ui.SelectTag.class);
    try {
      _jspx_th_ww_005fselect_005f0.setPageContext(_jspx_page_context);
      _jspx_th_ww_005fselect_005f0.setParent(null);
      // /northwest/logisticsForm.jsp(66,22) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setName("logistics.timeId");
      // /northwest/logisticsForm.jsp(66,22) name = id type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setId("timeId");
      // /northwest/logisticsForm.jsp(66,22) name = list type = null reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setList("logisticsTimeList");
      // /northwest/logisticsForm.jsp(66,22) name = listKey type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setListKey("id");
      // /northwest/logisticsForm.jsp(66,22) name = listValue type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setListValue("valueTw");
      // /northwest/logisticsForm.jsp(66,22) name = cssClass type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_ww_005fselect_005f0.setCssClass("cInputListField");
      int _jspx_eval_ww_005fselect_005f0 = _jspx_th_ww_005fselect_005f0.doStartTag();
      if (_jspx_th_ww_005fselect_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } finally {
      _005fjspx_005ftagPool_005fww_005fselect_0026_005fname_005flistValue_005flistKey_005flist_005fid_005fcssClass_005fnobody.reuse(_jspx_th_ww_005fselect_005f0);
    }
    return false;
  }
}
