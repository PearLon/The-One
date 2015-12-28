package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static void main(String[] args) {
		DBUtil util=new DBUtil();
		Connection conn=util.connection;
		System.out.print(conn);
	}
	private String dbDriver = "com.mysql.jdbc.Driver"; // 数据库的驱动

	private String url = "jdbc:mysql://localhost:3306/medicine"; // URL地址

	public Connection connection = null;

	public DBUtil() {
		try {
			Class.forName(dbDriver).newInstance(); // 加载数据库驱动
			connection = DriverManager.getConnection(url, "root", "123456"); // 加载数据库
		} catch (Exception ex) {
			System.out.println("数据库加载失败");
		}
	}
}