package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static void main(String[] args) {
		DBUtil util=new DBUtil();
		Connection conn=util.connection;
		System.out.print(conn);
	}
	private String dbDriver = "com.mysql.jdbc.Driver"; // ���ݿ������

	private String url = "jdbc:mysql://localhost:3306/medicine"; // URL��ַ

	public Connection connection = null;

	public DBUtil() {
		try {
			Class.forName(dbDriver).newInstance(); // �������ݿ�����
			connection = DriverManager.getConnection(url, "root", "123456"); // �������ݿ�
		} catch (Exception ex) {
			System.out.println("���ݿ����ʧ��");
		}
	}
}