import java.sql.*;

public class JDBC {
	public static void main(String[] args) throws Exception {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://mysql.jae.jd.com:4066";
		String user = "3hgY9dW1";
		String pwd = "609j0dAIb7fX";
		Class.forName(driver);
		Connection connection = DriverManager.getConnection(url, user, pwd);
	}
}
