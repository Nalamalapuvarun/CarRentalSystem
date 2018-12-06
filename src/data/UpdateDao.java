package data;

import java.sql.*;

public class UpdateDao {
	
	static Connection con;
	static PreparedStatement ps;
	public String role;
	public int UpdateDao1(String name, String email, String phone, String addr, String newpassword, String username) {
		// TODO Auto-generated constructor stub
		int status = 0 ;
		String query="UPDATE CARRENTAL.USER SET NAME=?,EMAIL=?,PHONE=?,ADDRESS=?,PASSWORD=? WHERE USERNAME=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			java.sql.Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/carrental","root",""); 	      
			          PreparedStatement preparedStmt = con.prepareStatement(query);
				      preparedStmt.setString (1, name);
				      preparedStmt.setString   (2, email); 
				      preparedStmt.setString   (3, phone);
				      preparedStmt.setString   (4, addr);
				      preparedStmt.setString   (5, newpassword);
				      preparedStmt.setString   (6, username);		      
				      //if(newpassword==conpassword) {
					      preparedStmt.execute();					        
				      //}
				      //else {
				    	//  System.out.println("New password doesn't match");
				      //}
				      status=1;
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
