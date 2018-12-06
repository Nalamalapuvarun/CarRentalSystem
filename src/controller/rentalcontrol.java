 package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.UserDAO;
import model.UserErrormsgs;
import model.user;

/**
 * Servlet implementation class rentalcontrol
 */
@WebServlet("/rentalcontrol")
public class rentalcontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public static String g_uname ;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rentalcontrol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub=request.getParameter("submit");
		System.out.println(sub);
		HttpSession session = request.getSession();
		//System.out.println(sub);
		if(sub.equalsIgnoreCase("login"))
		{   String Role;
		
			String username = request.getParameter("user_name");
			String password = request.getParameter("password");
			System.out.println(username + "    " + password+"   ");
			user usr = new user();	
			usr.setPassword(request.getParameter("password"));
			usr.setUsername(username);
			UserErrormsgs ui = new UserErrormsgs();
			usr.Checkuser(usr, ui);
			System.out.println(username + "    " + password+"   ");
		    int status = 0 ;
			UserDAO AuthUser = new UserDAO();
			status = AuthUser.authentecateUser(username, password);
			Role=AuthUser.role;
			
			System.out.println("The role is " + Role);
			System.out.println(ui.getErrorMsg());
			if (ui.getErrorMsg().equals("")){
				System.out.println("The Pass");
				//request.getRequestDispatcher("error.jsp").forward(request, response);
				 if( Role.equals("user")){
					System.out.println("The Authentication Pass");
					g_uname = username ;
					session.setAttribute("username", username);
					session.setAttribute("UN", username);
					request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
					
				 }
				 else if( Role.equals("manager"))
				{
					System.out.println("The Authentication Pass");
					g_uname = username ;
					session.setAttribute("username", username);
					session.setAttribute("UN", username);
					request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
					
				}
				else
				{
					System.out.println("The Authentication Pass");
					g_uname = username ;
					session.setAttribute("username", username);
					session.setAttribute("UN", username);
					request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
				 
				}
			}
			
			
			else
			{
				 request.setAttribute("emsgs", ui);
				 request.getRequestDispatcher("index.jsp").forward(request, response);
				
				
			}
		
		}
		else if(sub.equalsIgnoreCase("Register"))
		{   System.out.println("In Register");
			user newuser = new user();
			newuser.setFullName(request.getParameter("name"));
			newuser.setPassword(request.getParameter("password"));
		    newuser.setUsername(request.getParameter("user_name"));
		    newuser.setRole(request.getParameter("select"));
		    newuser.setAddress(request.getParameter("addr"));
		    newuser.setEmail(request.getParameter("Emai"));
		    newuser.setLicence(request.getParameter("license"));
		    newuser.setPhoneNo(request.getParameter("phno"));
		    newuser.setUTAID(request.getParameter("uta_id"));
		    newuser.setAutoClub(request.getParameter("auto_club"));
		   // newuser.setAge(request.getParameter("age"));
		    

		    UserErrormsgs u = new UserErrormsgs();
            newuser.validateUser(newuser, u);
            System.out.println("awesome");
            System.out.println(u.getUtaidError());
              if(u.getErrorMsg().equals(""))
			{UserDAO InsertUser = new UserDAO();
			System.out.println("trying to insert");
			int status =InsertUser.insertuser(newuser);
			System.out.println(status);
		
			request.getRequestDispatcher("index.jsp").forward(request, response);
		    
			}
            else {
          	  request.setAttribute("errorMsgs",u);
          	  request.setAttribute("nname", newuser);
          	  
          	  request.getRequestDispatcher("Registration.jsp").forward(request, response);
                
            }
		}
		else if(sub.equalsIgnoreCase("logout")) {
			session.invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(sub.equalsIgnoreCase("editprofile")) {
		    String username =  (String) session.getAttribute("UN");
			System.out.println("Useruser"  + username);
			UserDAO ud = new UserDAO();
			user user = ud.getUserInfo(username);
			System.out.println(user.getUsername());
			request.setAttribute("uname", user.getUsername());
			System.out.println(user.getFullName());
			request.setAttribute("fname", user.getFullName());
			request.setAttribute("email1", user.getEmail());
			request.setAttribute("fno", user.getPhoneNo());
			request.setAttribute("add", user.getAddress());
			request.getRequestDispatcher("UpdateProfile2.jsp").forward(request, response);
			
		}
		else if(sub.equalsIgnoreCase("editprofileM")) {
		    String username =  (String) session.getAttribute("UN");
			System.out.println("Useruser"  + username);
			UserDAO ud = new UserDAO();
			user user = ud.getUserInfo(username);
			System.out.println(user.getUsername());
			request.setAttribute("uname", user.getUsername());
			System.out.println(user.getFullName());
			request.setAttribute("fname", user.getFullName());
			request.setAttribute("email1", user.getEmail());
			request.setAttribute("fno", user.getPhoneNo());
			request.setAttribute("add", user.getAddress());
			request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
			
		}
		else if(sub.equalsIgnoreCase("editprofileA")) {
		    String username =  (String) session.getAttribute("UN");
			System.out.println("Useruser"  + username);
			UserDAO ud = new UserDAO();
			user user = ud.getUserInfo(username);
			System.out.println(user.getUsername());
			request.setAttribute("uname", user.getUsername());
			System.out.println(user.getFullName());
			request.setAttribute("fname", user.getFullName());
			request.setAttribute("email1", user.getEmail());
			request.setAttribute("fno", user.getPhoneNo());
			request.setAttribute("add", user.getAddress());
			request.getRequestDispatcher("UpdateProfile3.jsp").forward(request, response);
			
		}
		else if(sub.equalsIgnoreCase("UserProfileUpdate")) {
		    String username =  request.getParameter("username");
			System.out.println("Useruser"  + username);
			UserDAO ud = new UserDAO();
			user user = ud.getUserInfo(username);
			System.out.println(user.getUsername());
			request.setAttribute("uname", user.getUsername());
			System.out.println(user.getFullName());
			request.setAttribute("fname", user.getFullName());
			request.setAttribute("email1", user.getEmail());
			request.setAttribute("fno", user.getPhoneNo());
			request.setAttribute("add", user.getAddress());
			request.getRequestDispatcher("EditUserProfile.jsp").forward(request, response);
			
		}
			
	}

}
