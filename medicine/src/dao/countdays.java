package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class countdays {

	
	public static void main(String[] args)throws ParseException{
		SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		Date d1=sdf.parse("2015-09-08 10:10:10");
		Date d2=sdf.parse("2015-09-20 00:00:00");
		System.out.println(daysBetween(d1,d2));
		System.out.println(sdf.format(new Date()));
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
}
