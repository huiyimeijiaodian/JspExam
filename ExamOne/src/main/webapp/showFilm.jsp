<%@ page language="java" import="java.util.*,java.sql.*,com.hand.dao.*"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>显示film页面</title>
<style type="text/css">
.content {
	width: 900px;
	margin: 0px auto;
}

h2 {
	text-align: center;
	padding: 20px 0px;
	border-bottom: 2px solid #ccc;
}

.showList tr a{
	width: 60px;
	display: inline-block;
	text-align: center;
	text-decoration: none;
}
.showList tr a:hover{
	color:red;
	text-decoration: underline;
}
</style>
</head>

<body>
	<div class="content">
		<h2>显示所有电影名单</h2>
		<%
			Connection conn = (Connection) ConnectionFactory.getInstance().makeConnection();
			Statement statement = conn.createStatement();
			String sql = "SELECT film_id,title,description,language.name FROM film,language where film.language_id=language.language_id";
			ResultSet rs = statement.executeQuery(sql);
		%>

		<table align="center" border="1px" class="showList">
			<tr>
				<th>
					<%
						out.print("film_id");
					%>
				</th>
				<th>
					<%
						out.print("title");
					%>
				</th>
				<th>
					<%
						out.print("description");
					%>
				</th>
				<th>
					<%
						out.print("language");
					%>
				</th>
				<th>
					<%
						out.print("操作");
					%>
				</th>
			</tr>
			<%
				while (rs.next()) {
			%>
			<tr>
				<td>
					<%
						out.print(rs.getInt(1));
					%>
				</td>
				<td>
					<%
						out.print(rs.getString(2));
					%>
				</td>
				<td>
					<%
						out.print(rs.getString(3));
					%>
				</td>
				<td>
					<%
						out.print(rs.getString(4));
					%>
				</td>
				<td>
					<a href="#">删除</a>
				</td>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>
