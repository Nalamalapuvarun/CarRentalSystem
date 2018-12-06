package data;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.scene.input.Mnemonic;
import model.ManagerModel;



public class transactionDAO {
    
	static PreparedStatement ps;
	public int isBlackListed(String uname){
		int status = 0;
		String query="select BlackListed from test.user where username = ?;";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				      "jdbc:mysql://localhost:3306/test","root","");  
			ps=con.prepareStatement(query);
		 
			ps.setString(1, uname);
		    ResultSet rs1 = ps.executeQuery();
		    rs1.next();
		    
		    if(rs1.getString(1).equalsIgnoreCase("YES")){
		    	status = 1 ;
		    	
		    }
		    con.close();
		    
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public int searchdates(String startdate,String enddate) throws ParseException 
	{
		int b=0;
		System.out.println("The input date is " + startdate );
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date d1= sd.parse(startdate);
		java.util.Date d2= sd.parse(enddate);
//		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//		java.util.Date d3= sd.parse(sttime);
//		java.util.Date d4= sd.parse(endtime);
		int compare = d2.compareTo(d1);
		System.out.println("The value of compare is " + compare);
		 if (compare == 1){
			b = 1 ;
		}
		else if(compare == 0){
			b = 1 ;
		}
		return b;
	}
	
	public int searchtime(String stdate,String enddate,String sttime,String endtime) throws ParseException 
	{
	int b=0;
	System.out.println("The input date is " + stdate );
	SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
	java.util.Date d1= sd.parse(stdate);
	java.util.Date d2= sd.parse(enddate);
//	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//	java.util.Date d3= sd.parse(sttime);
//	java.util.Date d4= sd.parse(endtime);
	int compare = d2.compareTo(d1);
	System.out.println("The value of compare is " + compare);
	 if (compare == 1){
		b = 1 ;
	}
	else if(compare == 0){
		b = 1 ;
	}
	return b;
	}
	public ArrayList searchcar(String startdate , String enddate , String starttime , String endtime , String capacity){
	   	 int status = 0 ;
	   	// String query="select * from reservedcars where startdate>=CAST(? AS DATE) and enddate<=CAST(? as DATE);";
	 	String query = " select cars.CarName from cars where capacity > ? and cars.CarName NOT IN (select CarName from test.reservedcars where Startdate >= ? and EndDate <= ? and Starttime >= ? and EndTime <= ?)" ;
	   		ArrayList<String> mm = null ;
	   		System.out.println("IN DAO");
	   		try {
	   			System.out.println(startdate + " " + enddate + " " + starttime + " " + endtime + " " + capacity);
	   			Class.forName("com.mysql.jdbc.Driver");  
	   			Connection con=DriverManager.getConnection(  
	   				      "jdbc:mysql://localhost:3306/test","root","");  
	   			PreparedStatement ps;
	   			ps=con.prepareStatement(query);
	   		  
	   		    ps.setString(1, capacity);
	   		    ps.setString(2, startdate);
	   		    ps.setString(3, enddate);
	   		    ps.setString(4, starttime);
	   		    ps.setString(5, endtime);
	   		    
	   		    ResultSet rs1 = ps.executeQuery();
	   		    
	   		    mm = new ArrayList<>();
	   		    while(rs1.next()) {
	   		    	System.out.println(rs1.getString(1));
	   		    	mm.add(rs1.getString(1));	

	   		    }
	   		    con.close();
	   		    
	   		} catch (Exception e) {
	   			System.out.println(e);
	   		}
	   		return mm;
	   	 }
	
	public boolean bookcar( String CarName , String Username ,String starttime, String startdate , String endtime ,String enddate){
		String query="INSERT INTO reservedcars(CarName,Username,Starttime,Startdate,Endtime,EndDate,Active) VALUES(?,?,?,?,?,?,?)";
		boolean status  = false ;;
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				      "jdbc:mysql://localhost:3306/test","root","");  
			System.out.println("The Car Name Inserted is " + CarName);
			ps=con.prepareStatement(query);
		    ps.setString(1, CarName);
		    ps.setString(2, Username);
		    ps.setString(3, starttime);
		    ps.setString(4, startdate);
		    ps.setString(5, endtime);
		    ps.setString(6, enddate);
		    ps.setString(7, "YES");
		    status = ps.execute();

		    con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return status;
	}
	
	public double calPrice(String startDate , String EndDate , String CarName11 , int gps , int onStar , int siriusXm) throws ParseException {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1= sd.parse(startDate);
		java.util.Date date2= sd.parse(EndDate);
		String query="select * from test.cars where CarName = ?;";
		Calendar startCal = Calendar.getInstance();
		String weedDP = null ;
		String weedEP = null ;
		String week = null ;
		String gpsp = null ;
		String onstarp = null ;
		String sirisuXmp = null ;
	    startCal.setTime(date1);        
	    int noOfWeekDay = 0  , noOfWeekEndDays = 0 ;
	    Calendar endCal = Calendar.getInstance();
	    endCal.setTime(date2);
	    
	    try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
				      "jdbc:mysql://localhost:3306/test","root","");  
			PreparedStatement ps;
			ps=con.prepareStatement(query);
			ps.setString(1, CarName11);
		    ResultSet rs1 = ps.executeQuery();
		    while (rs1.next()) {
		    	weedDP = rs1.getString("Weekday");
		    	weedEP = rs1.getString("Weekend");
		    	week = rs1.getString("Week");
		    	gpsp = rs1.getString("GPS");
		    	onstarp = rs1.getString("OnStar");
		    	sirisuXmp = rs1.getString("SiriusXm");
		    	
		    }
		    con.close();
		    
		} catch (Exception e) {
			System.out.println(e);
		}
	    System.out.println(weedDP + " " + weedEP + " " + week );
	    int diffInDays = (int)( (date2.getTime() - date1.getTime()) 
                / (1000 * 60 * 60 * 24) );
		
	   
	    int noofWeeks = diffInDays/7 ;
		
		
		startCal.add(Calendar.DATE, 7 * noofWeeks);
		
		do {
			 
		        if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
		            ++noOfWeekDay;
		        }
		        else
		        {
		        	++noOfWeekEndDays;
		        }
			
		        startCal.add(Calendar.DATE, 1);
		}while(startCal.getTimeInMillis() <= endCal.getTimeInMillis());
		
		
		double wd = Double.parseDouble(weedDP);
		double we = Double.parseDouble(weedEP);
		double wee = Double.parseDouble(week);
		double gpspp = Double.parseDouble(gpsp);
		double onstarpp = Double.parseDouble(onstarp);
		double siriusXmpp = Double.parseDouble(sirisuXmp);
		
		double grandPrice = noOfWeekDay * wd + noOfWeekEndDays * we + noofWeeks * wee + gpspp * gps + onstarpp * onStar + siriusXmpp * siriusXm  ;
		
		return grandPrice ;
	}
	

}