数据库连接函数在com.hand.ConnectionFactory中：如下我的数据库设置密码为123456。
 conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila","root","123456");

 在项目中打开控制台：
 编译运行启动服务器：
	mvn clean compile jetty:run

启动成功！

在浏览器中输入：
http://127.0.0.1:8080/index.jsp  （进入index主页面）

点击登陆:进入登陆页面

点击显示film页面：进入显示页面，显示所有电影信息

点击添加film页面：进入添加电影页面