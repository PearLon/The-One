package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import formbean.totalform;
import util.DBUtil;

public class totaldao {
	  private Connection connection = null; //�������ӵĶ���
	  private PreparedStatement ps = null; //����Ԥ׼��sql������
	  private DBUtil jdbc = null; //�������ݿ����Ӷ���
	  public totaldao() {
	    jdbc = new DBUtil();
	    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
	  }
	
	
//��ѯ���۶���
	  public List salelist(){
		 List list=new ArrayList();
		 totalform std=null;
		 try {
			ps=connection.prepareStatement("select * from total ");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				std=new totalform();
				std.setID(rs.getInt(1));
				std.setNAME(rs.getString(2));
				std.setID1(rs.getInt(3));
				std.setID2(rs.getInt(4));
				//ps=connection.prepareStatement("select NAME from users,total where users.ID=total.ID2");
				//ResultSet qs=ps.executeQuery();
				//std.setNAME2
				std.setNUMBER(rs.getInt(5));
				std.setDATE(rs.getDate(6));
				list.add(std);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }	
}
