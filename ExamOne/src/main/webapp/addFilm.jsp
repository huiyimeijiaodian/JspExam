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
			width:200px;
		}
		.addForm input,.addForm textarea,.addForm select{
			width:200px;
		}
		.addForm input,.addForm select{
			height:30px;
		}
    </style>
  </head>
 
  <body>
    <div class="content">
    	<h2>添加电影</h2>
    	<form action="/AddServlet" method="post" class="addForm">
    		title:<input type="text" name="title"/><br>
    		description:<textarea rows="4" cols="6" name="description"></textarea><br>
    		language:<select  name="language">
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
				<input type="submit" name="添加" >
    	</form>
     </div>
  </body>
</html>
