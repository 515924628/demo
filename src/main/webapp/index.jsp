<%@ page import="java.sql.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>JDBC</title>
</head>
<body>
<%
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://mysql.jae.jd.com:4066";
	String user = "3hgY9dW1";
	String pwd = "609j0dAIb7fX";

	Class.forName(driver);
	Connection connection = DriverManager.getConnection(url, user, pwd);
	String sql = "CREATE TABLE person (number INT(11),name VARCHAR(255),birthday DATE);";
	Statement statement = connection.createStatement();
	statement.execute(sql);

%>
</body>
</html>
