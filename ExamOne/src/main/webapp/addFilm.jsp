<%@ page language="java" import="java.util.*,java.sql.*,com.hand.dao.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加film页面</title>
    <style>
    	.content {
			width: 800px;
			margin: 0px auto;
		}
		
		h2 {
			text-align: center;
			padding: 20px 0px;
			border-bottom: 2px solid #ccc;
		}
		.addForm{
			width:400px;
		}
		.addForm input,.addForm textarea,.addForm select{
			width:400px;
			margin-bottom:20px; 
		}
		.addForm input,.addForm select{
			height:30px;
		}
		.addForm .submit{
			height:40px;
			font-size:16px;
			background:#337AB7;
			color:white;
			border:0px;
		}
		.addForm .submit:hover{
			background:#337Aff;	
		}
		.addForm span{
			color:red;
			font-weight:600;
		}
    </style>
  </head>
 
  <body>
    <div class="content">
    	<h2>添加电影</h2>
    	<form action="/AddServlet" method="post" class="addForm" name="addForm">
    		<span>*</span>title:<input type="text" name="title"/><br>
    		<span>*</span>description:<textarea rows="4" cols="6" name="description"></textarea><br>
    		<span>*</span>language:<select  name="language">
    			<%
	    			Connection conn = (Connection) ConnectionFactory.getInstance().makeConnection();
	    			Statement statement = conn.createStatement();
	    			String sql = "SELECT name FROM language";
	    			ResultSet rs = statement.executeQuery(sql);
	    			while (rs.next()) {
    			%>
					  <option>
						<%
						out.print(rs.getString(1));
						%>
					  </option>
				 <%
					}
				%>
					</select>
				<input type="submit" name="submit" class="submit"  onclick="return check(this);"  value="添  加" />
    	</form>
     </div>
     
   <script type="text/javascript">
    function check(form) {
		//document.forms.form1.username.value取得form1中Username的值 并判断是否为空
		if (document.forms.addForm.title.value == "") {
			//如果 为""则弹出提示
			alert("请输入电影名称！");
			//将输入焦点定位到没有输入的地方
			document.forms.addForm.title.focus();
			//返回错误
			return false;
		}
		if (document.forms.addForm.description.value == "") {
			alert("请输入电影描述信息！");
			document.forms.addForm.description.focus();
			return false;
		}
	}
   </script>
  </body>
</html>
