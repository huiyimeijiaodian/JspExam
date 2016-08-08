<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>result</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  
  <body>
  	操作结果提示：
   <%
   		request.setCharacterEncoding("utf-8");
	  	Object obj = request.getAttribute("msg");
		if(obj != null){
			out.println(obj.toString());
		}else{
			out.println("无");
		}
   %>
   <a href="/index.jsp">返回首页 </a>
  </body>
</html>
