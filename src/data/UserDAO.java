package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import controller.rentalcontrol;
import model.ManagerModel;
import model.user;


public class UserDAO {
	
	static Connection con;
	static PreparedStatement ps;
	public String role;
	public int editrole(String username , String role){
		int status = 0 ;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","");  
			String query = "update user set role = ? where username = ?";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString   (1, role);
		      preparedStmt.setString   (2, username);
		     

		      
		      status = preparedStmt.executeUpdate();
			
			 
			con.close();  
			}
		catch(Exception e){ System.out.println(e);
			} 
		
		
		return status ;
	}
	
	
	
	public static boolean finduser(String uname)
	{  String name1;
		boolean status=false;
		System.out.println(uname);
		String query = "select username from user where username = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/test","root","");  
               ps=con.prepareStatement(query);
			   ps.setString(1,uname);
			   ResultSet rs = ps.executeQuery();
			   boolean a  =   rs.next();
			   System.out.println("in result set  rs.nect" + a);
			  if(!a)
			  {
				status =true;  }
			  else
			  {
				  status=false;
			  }
		
			  
		}
		catch (Exception e) {
			System.out.println(e);
		 	
		}
		return status;        
		
	}

	public int revoke(String username){
		int status = 0 ;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","");  
			
			
			
			
		      String query = "update user set BlackListed = ? where username = ?";
		      PreparedStatement preparedStmt = con.prepareStatement(query);
		      preparedStmt.setString   (1, "YES");
		      preparedStmt.setString   (2, username);
		     

		      
		      status = preparedStmt.executeUpdate();
			
			 
			con.close();  
			}
		catch(Exception e){ System.out.println(e);
			} 
		return status ;
		
	}
	public int authentecateUser(String Username , String Password){
		int status = 0 ;
		System.out.println(Username);
		String query = "select password,Role from user where username = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","");
	    	  ps=con.prepareStatement(query);
	    	  ps.setString(1, Username);
	    	  
	      
	        ResultSet rs = ps.executeQuery();
	        
	        rs.next();
	        
	        role=rs.getString("Role");
	        //System.out.println(rs.getString(1));
	            
	      
			   if(Password.equals(rs.getString("password"))){
				   status = 1 ;
				   
			   }
			   con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
	return status ;
	}
	public  user getUserInfo(String username){
		user ns = new user();
		System.out.println("getting user info ");
		String query = "select * from user where username = ?";
		try
		{   Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/test","root","");
			ps=con.prepareStatement(query);
			System.out.println("In user INfo " + username);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			rs.next();
           ns.setRole(rs.getString("Role"));
           ns.setAddress(rs.getString("address"));
           ns.setAutoClub(rs.getString("Autoclubnumber"));
           ns.setEmail(rs.getString("email"));
           ns.setPassword(rs.getString("password"));
           ns.setUsername(rs.getString("username"));
           ns.setPhoneNo(rs.getString("phone"));
           ns.setUTAID(rs.getString("utaid"));
  //         ns.setLicence(rs.getString(""));
	//		 ns.setDOB(rs.getString("));
           ns.setFullName(rs.getString("name"));
			//ns.setAge(rs.getString("Age"));
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
		return ns;
		
	}
	public  int insertuser(user newuser) {
		// TODO Auto-generated method stub
		int status =0;
		System.out.println("IN DAO");
		
		try
		{   Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/test","root","");
		
			
			 ps=con.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?,?,?)");
			 System.out.println(newuser.getUsername());
			 System.out.println(newuser.getPassword());
			 System.out.println(newuser.getFullName());
			 System.out.println(newuser.getRole());
			 System.out.println(newuser.getLicence());
			 System.out.println(newuser.getAddress());
			 System.out.println(newuser.getUTAID());
			 System.out.println(newuser.getEmail());
			 System.out.println(newuser.getPhoneNo());
			 System.out.println(newuser.getAutoClub());
			// System.out.println(newuser.getAge());
		     ps.setString(1,newuser.getUsername());
		     ps.setString(2, newuser.getRole());
		     ps.setString(3,newuser.getFullName());
		     ps.setString(4, newuser.getEmail());
		     ps.setString(5,newuser.getPhoneNo() );
		     ps.setString(6, newuser.getAddress());
		     ps.setString(7, newuser.getUTAID());
		     ps.setString(8, newuser.getPassword());
		     ps.setString(9, "NO");
		     ps.setString(10, newuser.getAutoClub());
            // ps.setString(11, newuser.getAge());
		     status=ps.executeUpdate();
		     con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return status;
	}
	public static void main(String[] args) {
		
   }
	
}