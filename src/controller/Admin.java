package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import data.ManagerDAO;
import data.UserDAO;
import model.AdminModel;
import model.UpdateProfileModel;
import model.revoke_errormsgs;
import model.update_errormsgs;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin() {
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
		
		if(sub.equalsIgnoreCase("revoke")){
			System.out.println("The to be revoked user is " + request.getParameter("username"));
			UserDAO user = new UserDAO();
			int status = user.revoke(request.getParameter("username"));
			revoke_errormsgs em = new revoke_errormsgs();
			AdminModel am = new AdminModel(request.getParameter("username"));
			am.validateAdminModel(am, em);
			if(em.getR_errorMsg().equals("")){
				System.out.println("**** revoke 111*****" + em.getR_usernameError());
				System.out.println("**** revoke 111222*****" + em.getR_errorMsg());
				System.out.println(status);
				request.setAttribute("Message", request.getParameter("username") +  "  IS BLACKLISTED");
				request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
			}else{
				System.out.println("**** revoke *****" + em.getR_usernameError());
				request.setAttribute("emsgs", em);
				request.getRequestDispatcher("RevokeRenter.jsp").forward(request, response);
			}
		}
		else if(sub.equalsIgnoreCase("editrole")){
			System.out.println("The to be revoked user is " + request.getParameter("username"));
			UserDAO user = new UserDAO();
			int status = user.editrole(request.getParameter("username"),request.getParameter("role"));
			System.out.println(status);
			request.setAttribute("Message", request.getParameter("username") +  "'s role is changed to " + request.getParameter("role"));
			request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
			
			
			
		}
		if(sub.equalsIgnoreCase("Update")) {

			String username = request.getParameter("username");
			System.out.println(username + " **********");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String addr=request.getParameter("addr");
			String curpassword=request.getParameter("curpassword");
			String newpassword=request.getParameter("newpassword");
			String conpassword=request.getParameter("conpassword");
			UpdateProfileModel upm = new UpdateProfileModel(username, name, email, phone, addr, curpassword, newpassword, conpassword);
			System.out.println("**** IN ADMIN CONTROLLER ****");
			update_errormsgs uperr = new update_errormsgs();
			upm.validateUpdateProfile(upm, uperr);
			if(uperr.getU_errorMsg().equals("")){
				System.out.println("*** ERROR MSG NO MESSAGE "+uperr.getU_nameError());
			System.out.println(username + " " + email + " " + phone + " addr" + " " + curpassword + " " + conpassword);
			ManagerDAO update=new ManagerDAO();
			update.UpdateManager(name, email, phone, addr, newpassword, username);
			request.setAttribute("Message", "Profile Updates");
			request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
			}
			else{
				System.out.println("*** ERROR MSG "+uperr.getU_nameError());
				request.setAttribute("uname", username);
				request.setAttribute("fname", name);
				request.setAttribute("email1", email);
				request.setAttribute("fno", phone);
				request.setAttribute("add", addr);
				request.setAttribute("emsgs", uperr);
				
				request.getRequestDispatcher("UpdateProfile3.jsp").forward(request, response);
				
			}
		}
		if(sub.equalsIgnoreCase("UpdateUserProfile")) {

			String username = request.getParameter("user_name");
			System.out.println(username + " **********");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
			String addr=request.getParameter("addr");
//			String curpassword=request.getParameter("curpassword");
//			String newpassword=request.getParameter("newpassword");
//			String conpassword=request.getParameter("conpassword");
			System.out.println(username + " " + email + " " + phone + " addr");
			ManagerDAO update=new ManagerDAO();
			update.UpdateUserFromManager(name, email, phone, addr, username);
			request.setAttribute("Message", "User Profile Updates");
			request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
			
		}
		else{}
//		else if(sub.equalsIgnoreCase("Update")){
//			HttpSession session = request.getSession();
//			String username=request.getParameter("username");
//			session.setAttribute("username",username);
//			String name=request.getParameter("name");
//			String email=request.getParameter("email");
//			String phone=request.getParameter("phone");
//			String addr=request.getParameter("addr");
//			String curpassword=request.getParameter("curpassword");
//			String newpassword=request.getParameter("newpassword");
//			String conpassword=request.getParameter("conpassword");
//			//System.out.println(session.getAttribute("username"));
//			ManagerDAO update=new ManagerDAO();
//			update.UpdateManager(name, email, phone, addr, newpassword, username);
//			request.getRequestDispatcher("AdminHomePage.jsp").forward(request, response);
//			session.invalidate();
//		
//		}
	}

}