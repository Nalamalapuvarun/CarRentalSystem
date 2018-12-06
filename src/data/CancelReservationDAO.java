package data;

import java.sql.*;

public class CancelReservationDAO {
	static Connection con;
	static PreparedStatement ps;
	public void Cancel(String confirmation) {
	try {
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
			      "jdbc:mysql://localhost:3306/carrental","root","");  
		String query="delete from reservedcars where Reservationid=?" ;
		ps=con.prepareStatement(query);
	    ps.setString(1,confirmation);
	    boolean b=ps.execute();
	    if(b) {
	    	System.out.println("executed the query");
	    }
	    else {
	    	System.out.println("Havenot executed the query");
	    }
	    con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}
}
