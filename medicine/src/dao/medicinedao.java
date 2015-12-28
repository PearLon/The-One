package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import formbean.medicineform;
import util.DBUtil;

//ҩƷ����ز���
public class medicinedao {
	  private Connection connection = null; //�������ӵĶ���
	  private PreparedStatement ps = null; //����Ԥ׼��sql������
	  private DBUtil jdbc = null; //�������ݿ����Ӷ���
	  public medicinedao() {
	    jdbc = new DBUtil();
	    connection = jdbc.connection; //���ù��췽��ȡ�����ݿ�����
	  }
	  
	  
	  
//���ҩƷ
	  
	  public void insert(medicineform medicine){
		    try {
		        ps = connection.prepareStatement("insert into medicine values (?,?,?,?,?,?,?,?)");
		        ps.setInt(1, medicine.getID());
		        ps.setString(2, medicine.getNAME());
		        ps.setInt(3, medicine.getCLASS1());
		        ps.setInt(4, medicine.getCLASS2());
		        ps.setDate(5, medicine.getDATE());
		        //ps.setString(6, student.getPicture());
		        //System.out.println(medicine.getNAME());
		        ps.setInt(6, medicine.getDAYS());
		        ps.setInt(7, medicine.getNUMBER());
		        ps.setString(8, medicine.getOTHERS());
		        ps.executeUpdate();
		        ps.close();
		      }
		      catch (SQLException ex) {
		      }
		  
		  
	  }
	  
//��ҩƷ����Ϊ������ѯҩƷ
	  public medicineform select(String name) {
		    medicineform medicine = null;
		    try {
		      ps = connection.prepareStatement("select * from medicine where NAME=?");
		      ps.setString(1, name);
		      ResultSet rs = ps.executeQuery();
		      while (rs.next()) {
		       medicine =new medicineform();
		       medicine.setID(rs.getInt(1));
		       medicine.setNAME(name);
		       medicine.setCLASS1(rs.getInt(3));
		       medicine.setCLASS2(rs.getInt(4));
		       medicine.setDATE(rs.getDate(5));
		       medicine.setDAYS(rs.getInt(6));
		       medicine.setNUMBER(rs.getInt(7));
		       medicine.setOTHERS(rs.getString(8));
		       
		      }
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		    return medicine;
		  }
	    
//��ҩƷ��������ҩΪ������ѯҩƷ
	  public medicineform select1(int class1) {
		    medicineform medicine = null;
		    try {
		      ps = connection.prepareStatement("select * from medicine where CLASS1=?");
		      ps.setInt(1, class1);
		      ResultSet rs = ps.executeQuery();
		      while (rs.next()) {
		       medicine =new medicineform();
		       medicine.setID(rs.getInt(1));
		       medicine.setNAME(rs.getString(2));
		       medicine.setCLASS1(class1);
		       medicine.setCLASS2(rs.getInt(4));
		       medicine.setDATE(rs.getDate(5));
		       medicine.setDAYS(rs.getInt(6));
		       medicine.setNUMBER(rs.getInt(7));
		       medicine.setOTHERS(rs.getString(8));
		       
		      }
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		    return medicine;
		  }	
	  
	  
//��ҩƷidΪ������ѯҩƷ
	  public medicineform select3(int ID) {
		    medicineform medicine = null;
		    try {
		      ps = connection.prepareStatement(" select * from medicine where ID=? ");
		      ps.setInt(1, ID);
		      ResultSet rs = ps.executeQuery();
		      while (rs.next()) {
		       medicine =new medicineform();
		       medicine.setID(ID);
		       medicine.setNAME(rs.getString(2));
		       medicine.setCLASS1(rs.getInt(3));
		       medicine.setCLASS2(rs.getInt(4));
		       medicine.setDATE(rs.getDate(5));
		       medicine.setDAYS(rs.getInt(6));
		       medicine.setNUMBER(rs.getInt(7));
		       medicine.setOTHERS(rs.getString(8));
		       
		      }
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		    return medicine;
		  }		  
	  
//��ҩƷ�����ͯҩΪ������ѯҩƷ
	  public medicineform select2(int class2) {
		    medicineform medicine = null;
		    try {
		      ps = connection.prepareStatement("select * from medicine where CLASS1=?");
		      ps.setInt(1, class2);
		      ResultSet rs = ps.executeQuery();
		      while (rs.next()) {
		       medicine =new medicineform();
		       medicine.setID(rs.getInt(1));
		       medicine.setNAME(rs.getString(2));
		       medicine.setCLASS1(rs.getInt(3));
		       medicine.setCLASS2(class2);
		       medicine.setDATE(rs.getDate(5));
		       medicine.setDAYS(rs.getInt(6));
		       medicine.setNUMBER(rs.getInt(7));
		       medicine.setOTHERS(rs.getString(8));
		       
		      }
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		    return medicine;
		  }	  

//��ҩƷIDΪ�����޸�ҩƷ	  
	  public void update(medicineform medicine) {
		    try {
		      ps = connection.prepareStatement("update medicine set NUMBER=? where ID=?");
		      ps.setInt(1, medicine.getNUMBER());
		      ps.setInt(2, medicine.getID());
		      ps.executeUpdate();
		      ps.close();
		    }
		    catch (SQLException ex) {
		    	ex.printStackTrace();
		    }
		  }

	  
	  
	  
	  
	  

//��ѯͬ����ҩƷ�Ƿ����
	  public boolean check(int ID){
		  try {
			ps=connection.prepareStatement("select * from medicine where ID=?");
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
//��ҩƷ����Ϊ������ѯ
	  public List selectname(String name){
		 List list=new ArrayList();
		 medicineform medicine=null;
		 try {
			ps=connection.prepareStatement("select * from medicine  where NAME=?");
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				medicine=new medicineform();
				medicine.setID(rs.getInt(1));
				medicine.setNAME(rs.getString(2));
				medicine.setCLASS1(rs.getInt(3));
				medicine.setCLASS2(rs.getInt(4));
				medicine.setDATE(rs.getDate(5));
				medicine.setDAYS(rs.getInt(6));
				medicine.setNUMBER(rs.getInt(7));
				medicine.setOTHERS(rs.getString(8));
				list.add(medicine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }	  
	  
//�Գ���ҩΪ������ѯ
	  public List selectc(int CLASS1){
		 List list=new ArrayList();
		 medicineform medicine=null;
		 try {
			ps=connection.prepareStatement("select * from medicine  where CLASS1='1'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				medicine=new medicineform();
				medicine.setID(rs.getInt(1));
				medicine.setNAME(rs.getString(2));
				medicine.setCLASS1(rs.getInt(3));
				medicine.setCLASS2(rs.getInt(4));
				medicine.setDATE(rs.getDate(5));
				medicine.setDAYS(rs.getInt(6));
				medicine.setNUMBER(rs.getInt(7));
				medicine.setOTHERS(rs.getString(8));
				list.add(medicine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }	
//�Գ���ҩΪ������ѯ
	  public List selectw(int CLASS1){
		 List list=new ArrayList();
		 medicineform medicine=null;
		 try {
			ps=connection.prepareStatement("select * from medicine  where CLASS1!='1'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				medicine=new medicineform();
				medicine.setID(rs.getInt(1));
				medicine.setNAME(rs.getString(2));
				medicine.setCLASS1(rs.getInt(3));
				medicine.setCLASS2(rs.getInt(4));
				medicine.setDATE(rs.getDate(5));
				medicine.setDAYS(rs.getInt(6));
				medicine.setNUMBER(rs.getInt(7));
				medicine.setOTHERS(rs.getString(8));
				list.add(medicine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }	
//�Զ�ͯҩΪ������ѯ
	  public List selectk(int CLASS2){
		 List list=new ArrayList();
		 medicineform medicine=null;
		 try {
			ps=connection.prepareStatement("select * from medicine  where CLASS2='1'");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				medicine=new medicineform();
				medicine.setID(rs.getInt(1));
				medicine.setNAME(rs.getString(2));
				medicine.setCLASS1(rs.getInt(3));
				medicine.setCLASS2(rs.getInt(4));
				medicine.setDATE(rs.getDate(5));
				medicine.setDAYS(rs.getInt(6));
				medicine.setNUMBER(rs.getInt(7));
				medicine.setOTHERS(rs.getString(8));
				list.add(medicine);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }	
	  
	  	
	  
//����ѯ
	  public List selectn(){
		 List list=new ArrayList();
		 medicineform medicine=null;
		 try {
			ps=connection.prepareStatement("SELECT NAME,sum(NUMBER) AS total FROM medicine GROUP BY NAME;");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				medicine=new medicineform();
				medicine.setID(null);
				medicine.setNAME(rs.getString(1));
				medicine.setCLASS1(null);
				medicine.setCLASS2(null);
				medicine.setDATE(null);
				medicine.setDAYS(null);
				medicine.setNUMBER(rs.getInt(2));
				medicine.setOTHERS(null);
				if(medicine.getNUMBER()<=80){
				list.add(medicine);}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }		
//��������������ѯ
	  public List selectd1(){
		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		 
		 List list=new ArrayList();
		 medicineform medicine=null;
		 try {
			 
			 Date d2=sdf.parse(sdf.format(new Date()));
			ps=connection.prepareStatement("select * from medicine");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				medicine=new medicineform();
				medicine.setID(rs.getInt(1));
				medicine.setNAME(rs.getString(2));
				medicine.setCLASS1(rs.getInt(3));
				medicine.setCLASS2(rs.getInt(4));
				medicine.setDATE(rs.getDate(5));
				medicine.setDAYS(rs.getInt(6));
				medicine.setNUMBER(rs.getInt(7));
				medicine.setOTHERS(rs.getString(8));
				Date d1=sdf.parse(sdf.format(medicine.getDATE()));
				if((medicine.getDAYS()*30-daysBetween(d1,d2))<=30&&(medicine.getDAYS()*30-daysBetween(d1,d2))>0){
					list.add(medicine);
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }	 

//�Ѿ�����������ѯ
	  public List selectd2(){
		 SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		 
		 List list=new ArrayList();
		 medicineform medicine=null;
		 try {
			 
			 Date d2=sdf.parse(sdf.format(new Date()));
			ps=connection.prepareStatement("select * from medicine");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				medicine=new medicineform();
				medicine.setID(rs.getInt(1));
				medicine.setNAME(rs.getString(2));
				medicine.setCLASS1(rs.getInt(3));
				medicine.setCLASS2(rs.getInt(4));
				medicine.setDATE(rs.getDate(5));
				medicine.setDAYS(rs.getInt(6));
				medicine.setNUMBER(rs.getInt(7));
				medicine.setOTHERS(rs.getString(8));
				Date d1=sdf.parse(sdf.format(medicine.getDATE()));
				if((medicine.getDAYS()*30-daysBetween(d1,d2))<=0){
					list.add(medicine);
				}	
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return list;
		  
	  }	
	  
    
	  public static int daysBetween(Date smdate,Date bdate)throws ParseException{
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));
			Calendar cal=Calendar.getInstance();
			cal.setTime(smdate);
			long time1=cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2=cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Integer.parseInt(String.valueOf(between_days));
		}


//���������Ϣ

   public void sale(String NAME,int ID1,int ID2,int NUMBER,String DATE){
	    try {
	        ps = connection.prepareStatement("insert into total values (null,?,?,?,?,?)");
	        ps.setString(1, NAME);
	        ps.setInt(2, ID1);
	        ps.setInt(3, ID2);
	        ps.setInt(4,NUMBER);
	        ps.setString(5,DATE);
	        ps.executeUpdate();
	        ps.close();
	      }
	      catch (SQLException ex) {
	      }
	  
	  
}
 //���������Ϣ

   public void imp(String NAME,int ID1,int ID2,int NUMBER,String DATE){
	    try {
	        ps = connection.prepareStatement("insert into import1 values (null,?,?,?,?,?)");
	        ps.setString(1, NAME);
	        ps.setInt(2, ID1);
	        ps.setInt(3, ID2);
	        ps.setInt(4,NUMBER);
	        ps.setString(5,DATE);
	        ps.executeUpdate();
	        ps.close();
	      }
	      catch (SQLException ex) {
	      }
	  
	  
}
}