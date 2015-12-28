package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import formbean.userform;
import util.DBUtil;

//会员信息的操作
public class userdao {
	  private Connection connection = null; //定义连接的对象
	  private PreparedStatement ps = null; //定义预准备sql语句对象
	  private DBUtil jdbc = null; //定义数据库连接对象
	  public userdao() {
	    jdbc = new DBUtil();
	    connection = jdbc.connection; //利用构造方法取得数据库连接
	  }
	  
	  
	  
//添加信息
	  
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
	  
//以ID为条件查询全部用户信息
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
	  
//以ID为条件修改信息	  
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

//查询ID是否已经占用
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