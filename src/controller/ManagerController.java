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



import data.ManagerDAO;
import model.AddCarModel;
import model.ManagerModel;
import model.UpdateProfileModel;
import model.addcar_errormsgs;
import model.update_errormsgs;


/**
 * Servlet implementation class ManagerController
 */
@WebServlet("/ManagerController")
public class ManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerController() {
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
		// TODO Auto-generated method stub
				String sub=request.getParameter("submit");
				System.out.println(sub);
				ManagerDAO user=new ManagerDAO();
				if(sub.equalsIgnoreCase("ViewAllCarsRented")) {
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
			      out.println("<h1> List Of Reservations  <h1>");
			      out.println("<table>");
			      out.println("<tr> <td> Index </td> <td> CAR NAME </td><td> ReservationID </td><td> Start Time </td> <td> Start Date </td><td> END Time </td><td> END DATE </td> </tr>");
			      for (ManagerModel a : mm){
			    	  
			    	  out.println("<tr> <td> " + count + "</td><td> " + a.getCarName() + " </td><td> " +a.getReservationid() + " </td><td>" +a.getStartTime() + " </td> <td> " + a.getstartdate() + " </td><td> " +a.getEndTime() + " </td><td> " +a.getenddate() + " </td> </tr>");
	                  count ++ ;
			      
			      }
			      out.println("</table></body>");
				
			}  
				if(sub.equalsIgnoreCase("UpdateProfile")) {

					String username = request.getParameter("username");
					System.out.println(username + " **********");
					String name=request.getParameter("name");
					String email=request.getParameter("email");
					String phone=request.getParameter("phone");
					String addr=request.getParameter("addr");
					String curpassword=request.getParameter("curpassword");
					String newpassword=request.getParameter("newpassword");
					String conpassword=request.getParameter("conpassword");
					//System.out.println(username + " " + email + " " + phone + " addr" + " " + curpassword + " " + conpassword);
					//ManagerDAO update=new ManagerDAO();
					//update.UpdateManager(name, email, phone, addr, newpassword, username);
					//request.setAttribute("Message", "Profile Updates");
					//request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
					UpdateProfileModel upm = new UpdateProfileModel(username, name, email, phone, addr, curpassword, newpassword, conpassword);
					System.out.println("**** IN MANAGER CONTROLLER ****");
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
						
						request.getRequestDispatcher("UpdateProfile.jsp").forward(request, response);
						
					}
					
				}
				
				
				else if(sub.equalsIgnoreCase("ViewDetails")) {
					String reservationid = request.getParameter("confirmationid");
					System.out.println(reservationid+ " ");
					ManagerDAO result=new ManagerDAO();
					ArrayList<ManagerModel>  mm =     result.ViewSpecificRental(reservationid);
					response.setContentType("text/html");
					 int count = 1 ;
				     
					 PrintWriter out = response.getWriter();
				      out.println("<head>");
				      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"test.css\" media=\"screen\" />");
				      out.println("</head>");
				      out.println("<body>");
				      out.println("<img src=\"car4.png\" alt=\"car img\" height=\"100\" width=\"100\">");
				      out.println("<h1> List Of Reservations  <h1>");
				      out.println("<table>");
				      out.println("<tr> <td> Index </td> <td> CAR NAME </td><td> ReservationID </td><td> Start Time </td> <td> Start Date </td><td> END Time </td><td> END DATE </td> </tr>");
				      for (ManagerModel a : mm){
				    	  
				    	  out.println("<tr> <td> " + count + "</td><td> " + a.getCarName() + " </td><td> " +a.getReservationid() + " </td><td>" +a.getStartTime() + " </td> <td> " + a.getstartdate() + " </td><td> " +a.getEndTime() + " </td><td> " +a.getenddate() + " </td> </tr>");
		                  count ++ ;
				      
				      }
				      out.println("</table></body>");
				}
				else if(sub.equalsIgnoreCase("AddCar")) {
					String CarName=request.getParameter("CarName");
					String Capacity=request.getParameter("Capacity");
					String WeekDay=request.getParameter("WeekDay");
					String WeekEnd=request.getParameter("WeekEnd");
					String Week=request.getParameter("Week");
					String Gps=request.getParameter("Gps");
					String OnStar=request.getParameter("OnStar");
					String SiriusXM=request.getParameter("SiriusXM");
					AddCarModel acm = new AddCarModel(CarName, Capacity, WeekDay, WeekEnd, Week, Gps, OnStar, SiriusXM);
					addcar_errormsgs em = new addcar_errormsgs();
					acm.validateAddCarModel(acm, em);
					System.out.println(em.getA_errorMsg());
					if(em.getA_errorMsg().equals("")){
						ManagerDAO add=new ManagerDAO();
						add.AddCar(CarName,Capacity,WeekDay,WeekEnd,Week,Gps,OnStar,SiriusXM);
						request.setAttribute("Message", "CAR ADDED SUCCESSFULLY  !!!");
						request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
					}else{
						request.setAttribute("emsgs", em);
						request.setAttribute("carname", CarName);
						request.setAttribute("capacity", Capacity);
						request.setAttribute("gps", Gps);
						request.setAttribute("onstar", OnStar);
						request.setAttribute("xm", SiriusXM);
						request.setAttribute("WD", WeekDay);
						request.setAttribute("WE", WeekEnd);
						request.setAttribute("ww", Week);
						request.getRequestDispatcher("AddCar.jsp").forward(request, response);
					}
				
				}
				else if(sub.equalsIgnoreCase("DeleteRental")) {
				String reservationid = request.getParameter("confirmationid");
				System.out.println(reservationid+ " ");
				ManagerDAO result=new ManagerDAO();
				result.delete(reservationid);
				request.setAttribute("Message", "RENTAL DELETION SUCCESSFULLY FOR RENTAL ID " + reservationid);
				request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
				}
				
				else if(sub.equalsIgnoreCase("UpdateProfile")) {
						HttpSession session = request.getSession();
						String username=request.getParameter("username");
						session.setAttribute("username",username);
						String name=request.getParameter("name");
						String email=request.getParameter("email");
						String phone=request.getParameter("phone");
						String addr=request.getParameter("addr");
					//	String curpassword=request.getParameter("curpassword");
						String newpassword=request.getParameter("newpassword");
					//	String conpassword11=request.getParameter("conpassword");
						//System.out.println(session.getAttribute("username"));
						ManagerDAO update=new ManagerDAO();
						update.UpdateManager(name, email, phone, addr, newpassword, username);
						request.getRequestDispatcher("ManagerHomePage.jsp").forward(request, response);
						session.invalidate();
					
				}
				
	}

}