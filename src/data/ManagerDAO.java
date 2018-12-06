package data;

import java.sql.*;
import java.util.ArrayList;

import model.ManagerModel;

public class ManagerDAO {
	static Connection con;
	static PreparedStatement ps;
	ManagerModel viewMy=null;
public ArrayList ViewAllCarsRented(String startdate,String enddate) {
	String query="select * from reservedcars where startdate>=CAST(? AS DATE) and enddate<=CAST(? as DATE);";
	ArrayList<ManagerModel> mm = null ;
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
			      "jdbc:mysql://localhost:3306/test","root","");  
		ps=con.prepareStatement(query);
	    ps.setString(1, startdate);
	    ps.setString(2, enddate);
	    ResultSet rs1 = ps.executeQuery();
	    mm = new ArrayList<>();
	    while(rs1.next()) {
	    	viewMy = new ManagerModel();
	    	viewMy.setReservationid(rs1.getString("Confirmationid"));
	    	viewMy.setCarName(rs1.getString("CarName"));
	    	viewMy.setStartTime(rs1.getString("StartTime"));
	    	viewMy.setstartdate(rs1.getString("StartDate"));
	    	viewMy.setEndTime(rs1.getString("EndTime"));
	    	viewMy.setenddate(rs1.getString("EndDate"));
	    	mm.add(viewMy);

	    }
	    con.close();
	    
	} catch (Exception e) {
		System.out.println(e);
	}
	return mm;
}
public ArrayList<ManagerModel> ViewSpecificRental(String Reservationid){
	
String query="select * from reservedcars where Confirmationid=?";
ArrayList<ManagerModel> mm = null ;
try {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
		      "jdbc:mysql://localhost:3306/test","root","");  
	ps=con.prepareStatement(query);
    ps.setString(1, Reservationid);
    ResultSet rs1 = ps.executeQuery();
    mm = new ArrayList<>();
    while(rs1.next()) {
    	viewMy = new ManagerModel();
    	viewMy.setReservationid(rs1.getString("Confirmationid"));
    	viewMy.setCarName(rs1.getString("CarName"));
    	viewMy.setStartTime(rs1.getString("StartTime"));
    	viewMy.setstartdate(rs1.getString("StartDate"));
    	viewMy.setEndTime(rs1.getString("EndTime"));
    	viewMy.setenddate(rs1.getString("EndDate"));
    	 mm.add(viewMy);
//    	System.out.println(viewMy.getReservationid());
//    	System.out.println(viewMy.getCarName());
//    	System.out.println(viewMy.getStartTime());
//    	System.out.println(viewMy.getstartdate());
//    	System.out.println(viewMy.getEndTime());
//    	System.out.println(viewMy.getenddate());
    	
    }
    con.close();
   
} catch (Exception e) {
	System.out.println(e);
}
return mm;
}
public void AddCar(String CarName,String Capacity, String WeekDay,String WeekEnd,String Week, String Gps,String OnStar,String SiriusXM){
	
String query="INSERT INTO CARS VALUES(?,?,?,?,?,?,?,?)";
try {
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
		      "jdbc:mysql://localhost:3306/test","root","");  
	ps=con.prepareStatement(query);
    ps.setString(1, CarName);
    ps.setString(2, Capacity);
    ps.setString(3, WeekDay);
    ps.setString(4, WeekEnd);
    ps.setString(5, Week);
    ps.setString(6, Gps);
    ps.setString(7, OnStar);
    ps.setString(8, SiriusXM);
    ps.execute();
//    while(rs1.next()) {
//    	viewMy = new ManagerModel();
//    	viewMy.setReservationid(rs1.getString("Reservationid"));
//    	viewMy.setCarName(rs1.getString("CarName"));
//    	viewMy.setStartTime(rs1.getString("StartTime"));
//    	viewMy.setstartdate(rs1.getString("StartDate"));
//    	viewMy.setEndTime(rs1.getString("EndTime"));
//    	viewMy.setenddate(rs1.getString("EndDate"));
//    	System.out.println(viewMy.getReservationid());
//    	System.out.println(viewMy.getCarName());
//    	System.out.println(viewMy.getStartTime());
//    	System.out.println(viewMy.getstartdate());
//    	System.out.println(viewMy.getEndTime());
//    	System.out.println(viewMy.getenddate());
//    	
//    }
    con.close();
//    return rs;
} catch (Exception e) {
	System.out.println(e);
}
}
public void delete(String reservationid) {
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
			      "jdbc:mysql://localhost:3306/test","root","");  
		String query="delete from reservedcars where Confirmationid=?" ;
		ps=con.prepareStatement(query);
	    ps.setString(1,reservationid);
	    ps.execute();
	    
	    con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}

public int UpdateManager(String name, String email, String phone, String addr, String newpassword, String username) {
	
	int status = 0 ;
	String role;
	String query="UPDATE user SET NAME=?,EMAIL=?,PHONE=?,ADDRESS=?,PASSWORD=? WHERE USERNAME=?";
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		java.sql.Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/test","root",""); 	      
		          PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setString (1, name);
			      preparedStmt.setString   (2, email); 
			      preparedStmt.setString   (3, phone);
			      preparedStmt.setString   (4, addr);
			      preparedStmt.setString   (5, newpassword);
			      preparedStmt.setString   (6, username);		      
			      
			      System.out.println( preparedStmt.executeUpdate());					        
			     
			     status = 1 ;
			      con.close();
		 System.out.println("Database connection successful");		
	}
	
	catch(Exception e)
	{
		System.out.println(e);
		status=0;
		System.out.println("Database connection unsuccessful");
	}
	return status;
}
public int UpdateUserFromManager(String name, String email, String phone, String addr,  String username) {
	// TODO Auto-generated constructor stub
	int status = 0 ;
	String role;
	String query="UPDATE user SET NAME=?,EMAIL=?,PHONE=?,ADDRESS=? WHERE USERNAME=?";
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		java.sql.Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/test","root",""); 	      
		          PreparedStatement preparedStmt = con.prepareStatement(query);
			      preparedStmt.setString (1, name);
			      preparedStmt.setString   (2, email); 
			      preparedStmt.setString   (3, phone);
			      preparedStmt.setString   (4, addr);
			      preparedStmt.setString   (5, username);		      
			      
			      System.out.println( preparedStmt.executeUpdate());					        
			     
			     status = 1 ;
			      con.close();
		 System.out.println("Database connection successful");		
	}
	
	catch(Exception e)
	{
		System.out.println(e);
		status=0;
		System.out.println("Database connection unsuccessful");
	}
	return status;
}
}

