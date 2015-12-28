package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import formbean.userform;
import util.DBUtil;

//��Ա��Ϣ�Ĳ���
public class userdao {
	  private Connection connection = null; //�������ӵĶ���
	  private PreparedStatement ps = null; //����Ԥ׼��sql������
	  private DBUtil jdbc = null; //�������ݿ����Ӷ���
	  public userdao() {
	    jdbc = new DBUtil();
	    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
	  }
	  
	  
	  
//�����Ϣ
	  
	  public void insert(userform user){
		    try {
		        ps = connection.prepareStatement("insert into users values (?,?,?,?,?,?,?)");
		        ps.setInt(1, user.getID());
		        ps.setString(2,user.getNAME());
		        ps.setString(3, user.getPASSWORD());	
		        ps.setString(4, user.getSEX());
		        ps.setString(5, user.getPHONE());
		        ps.setString(6, user.getPOST());
		        ps.setInt(7, user.getCLASS());
		        ps.executeUpdate();
		        ps.close();
		      }
		      catch (SQLException ex) {
		      }
		  
		  
	  }
	  
//��IDΪ������ѯȫ���û���Ϣ
	  public userform select(int ID) {
		    userform user = null;
		    try {
		      ps = connection.prepareStatement("select * from users where ID=?");
		      ps.setInt(1, ID);
		      ResultSet rs = ps.executeQuery();
		      while (rs.next()) {
		        user =new userform();
		        user.setID(ID);
		        user.setNAME(rs.getString(2));
		        user.setPASSWORD(rs.getString(3));
		        user.setSEX(rs.getString(4));
		        user.setPHONE(rs.getString(5));
		        user.setPOST(rs.getString(6));
		        user.setCLASS(rs.getInt(7));
		      }
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		    return user;
		  }
	  
//��IDΪ�����޸���Ϣ	  
	  public void update(userform user) {
		    try {
		      ps = connection.prepareStatement("update medicine set NAME=?,PASSWORD=?,SEX=?,PHONE=?,POST=?,CLASS=? where studentid=?");
		      ps.setString(1, user.getNAME());
		      ps.setString(2, user.getPASSWORD());
		      ps.setString(3, user.getSEX());
		      ps.setString(4, user.getPHONE());
		      ps.setString(5, user.getPOST());
		      ps.setInt(6, user.getCLASS());
		      //ps.setString(5, student.getPicture());
		      ps.setInt(7, user.getID());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		  }

//��ѯID�Ƿ��Ѿ�ռ��
	  public boolean check(int ID){
		  try {
			ps=connection.prepareStatement("select * from users where ID=?");
			ps.setInt(1, ID);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return false;
	  }
  
}