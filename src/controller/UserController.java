package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import data.CancelReservationDAO;
import data.ManagerDAO;
import data.UpdateDao;
import data.UserDAO;

import model.ManagerModel;
import model.UpdateProfileModel;
import model.update_errormsgs;
import model.user;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sub=request.getParameter("submit");
		if(sub.equalsIgnoreCase("UpdateProfile")) {

			String username = request.getParameter("user_name");
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
			request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
			}
			else{
				System.out.println("*** ERROR MSG "+uperr.getU_nameError());
				request.setAttribute("uname", username);
				request.setAttribute("fname", name);
				request.setAttribute("email1", email);
				request.setAttribute("fno", phone);
				request.setAttribute("add", addr);
				request.setAttribute("emsgs", uperr);
				System.out.println("the error msg in current password is"+uperr.getU_conpasswordError());
				
				request.getRequestDispatcher("UpdateProfile2.jsp").forward(request, response);
				
			}
			
			//System.out.println(username + " " + email + " " + phone + " addr" + " " + curpassword + " " + conpassword);
			//ManagerDAO update=new ManagerDAO();
			//update.UpdateManager(name, email, phone, addr, newpassword, username);
			//request.setAttribute("Message", "PROFILE UPDATED SUCCESSFULLY !!!");
			//request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
			
		}
		
		else if(sub.equalsIgnoreCase("ViewMyReservation")) {
			ManagerDAO user=new ManagerDAO();
			String startdate = request.getParameter("startdate");
			String enddate = request.getParameter("enddate");
			System.out.println(startdate+ " " + enddate + " " );
			ArrayList<ManagerModel> mm =    user.ViewAllCarsRented(startdate, enddate);
			response.setContentType("text/html");
            
		      int count = 1 ;
		      PrintWriter out = response.getWriter();
		      out.println("<head>");
		      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\" media=\"screen\" />");
		      out.println("</head>");
		      out.println("<body>");
		      out.println("<img src=\"car4.png\" alt=\"car img\" height=\"100\" width=\"100\">");
		      out.println("<form name=\"Loginform\" action=\"UserHomePage.jsp\" method=\"post\" style=\"width: 300px;\">");
		      out.println("<input type=\"submit\"  name = \"submit\" value = \"logout\" />");
		      out.println("</form>");
		      out.println("<h1> List Of Reservations  <h1>");
		      out.println("<table>");
		      out.println("<tr> <td> Index </td> <td> CAR NAME </td><td> ReservationID </td><td> Start Time </td> <td> Start Date </td><td> END Time </td><td> END DATE </td> </tr>");
		      for (ManagerModel a : mm){
		    	  out.println();
		    	  out.println("<tr> <td> " + count + "</td><td> " + a.getCarName() + " </td><td> " +a.getReservationid() + " </td><td>" +a.getStartTime() + " </td> <td> " + a.getstartdate() + " </td><td> " +a.getEndTime() + " </td><td> " +a.getenddate() + " </td> </tr>");
                  count ++ ;
		      
		      }
		      out.println("</table></body>");
			
		}
		else if(sub.equalsIgnoreCase("CancelReservation")) {
			String reservationid = request.getParameter("confirmationid");
			System.out.println(reservationid+ " ");
			ManagerDAO result=new ManagerDAO();
			result.delete(reservationid);
			request.setAttribute("Message", "Reservation cancled for Reservation ID " + reservationid);
			request.getRequestDispatcher("UserHomePage.jsp").forward(request, response);
		}
		
	}

}