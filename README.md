数据库连接函数在com.hand.ConnectionFactory中：
数据库配置文件dbconfig.propertities(路径：src/main/resources)如下：
driver=com.mysql.jdbc.Driver
dburl=jdbc\:mysql\://localhost\:3306/sakila
user=root
password=123456

我的数据库账号：root  ,密码：123456
老师根据自己本地账号修改配置文件


 在项目中打开控制台：
 编译运行启动服务器：
	mvn clean compile jetty:run

启动成功！

在浏览器中输入：
http://127.0.0.1:8080/index.jsp  （进入index主页面）

1、点击登陆:进入登陆页面
	(1)为空提示输入不跳转
	(2)不为空到数据库查询是否存在账号

2、退出登录：在登陆成功的情况下，点击退出，会退出登录账号。

3、点击显示film页面：在登陆情况下，进入显示页面，显示所有电影信息

3、点击添加film页面：在登陆情况下，进入添加电影页面

4、权限校验：只有在登陆情况下才能进入显示和添加界面
	  


